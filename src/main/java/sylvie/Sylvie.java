package sylvie;

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

    public void run() {
        TaskList taskList = new TaskList();
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
        try {
            sylvie.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
