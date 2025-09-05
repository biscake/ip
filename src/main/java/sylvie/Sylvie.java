package sylvie;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import sylvie.command.Command;
import sylvie.command.parser.CommandParser;
import sylvie.exception.SylvieException;
import sylvie.task.TaskList;
import sylvie.ui.Textbox;

/**
 * Main class for the Sylvie chatbot application.
 */
public class Sylvie {
    private final TaskList taskList;

    public Sylvie(String fileName) {
        Path savePath = Paths.get("data", fileName);
        taskList = new TaskList(savePath);
        taskList.loadFromStorage();
    }

    public static String greet() {
        return "Hello! I'm Sylvie\nWhat can I do for you?";
    }

    private void listen() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    String line = scanner.nextLine();

                    Command command = CommandParser.parse(line);
                    String response = command.execute(taskList);
                    new Textbox(response).print();

                    if (command.isExit()) {
                        break;
                    }
                } catch (SylvieException e) {
                    new Textbox(e.getMessage()).print();
                }
            }
        }
    }

    public String getResponse(String input) {
        try {
            Command command = CommandParser.parse(input);
            return command.execute(taskList);
        } catch (SylvieException e) {
            return "Sorry I don't quite understand what you mean";
        }
    }
}
