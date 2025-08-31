package sylvie;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import sylvie.command.Command;
import sylvie.command.parser.CommandParser;
import sylvie.exception.SylvieException;
import sylvie.task.TaskList;
import sylvie.ui.Textbox;

public class Sylvie {
    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    private void run() {
        Path savePath = Paths.get("data", "sylvie.txt");
        TaskList taskList = new TaskList(savePath);
        taskList.loadFromStorage();
        
        try (Scanner scanner = new Scanner(System.in)) {
            greet();

            while (true) {
                try {
                    String line = scanner.nextLine();

                    Command command = CommandParser.parse(line);
                    command.execute(taskList);

                    if (command.isExit()) {
                        break;
                    }
                } catch (SylvieException e) {
                    new Textbox(e.getMessage()).print();
                }
            }
        }
    }

    public static void main(String[] args) {
        Sylvie sylvie = new Sylvie();
        sylvie.run();
        System.exit(0);
    }
}
