import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import sylvie.command.Command;
import sylvie.command.CommandParser;
import sylvie.exception.IllegalDataException;
import sylvie.exception.SylvieException;
import sylvie.storage.Parser;
import sylvie.storage.Storage;
import sylvie.task.TaskList;
import sylvie.ui.Textbox;

public class Sylvie {
    private static TaskList taskList = new TaskList();

    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        List<String> lines;
        try {
            lines = storage.load();
            for (String line : lines) {
                taskList.add(Parser.parse(line));
            }
        } catch (IOException e) {
            System.out.println("io");
            taskList = new TaskList();
        } catch (IllegalDataException e) {
            new Textbox(e.getMessage()).print();
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            greet();
            
            while (true) {
                try {
                    String line = scanner.nextLine();
                    
                    Command command = CommandParser.parse(line);
                    command.execute(taskList.get());

                    if (command.isExit()) {
                        break;
                    }
                } catch (SylvieException e) {
                    new Textbox(e.getMessage()).print();
                }
            }
        }
    }
}
