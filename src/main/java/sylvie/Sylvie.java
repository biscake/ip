package sylvie;

import java.nio.file.Path;
import java.nio.file.Paths;

import sylvie.command.Command;
import sylvie.command.parser.CommandParser;
import sylvie.exception.SylvieException;
import sylvie.task.TaskList;

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

    public String getResponse(String input) {
        try {
            Command command = CommandParser.parse(input);
            return command.execute(taskList);
        } catch (SylvieException e) {
            return e.getMessage();
        }
    }
}
