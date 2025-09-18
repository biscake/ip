package sylvie;

import java.nio.file.Path;
import java.nio.file.Paths;

import sylvie.command.Command;
import sylvie.command.parser.CommandParser;
import sylvie.exception.IllegalDataException;
import sylvie.exception.StorageException;
import sylvie.exception.SylvieException;
import sylvie.task.TaskList;

/**
 * Main class for the Sylvie chatbot application.
 */
public class Sylvie {
    private final TaskList taskList;

    /**
     * Initializes Sylvie with the specified storage file.
     *
     * @param fileName Name of the file to store data
     */
    public Sylvie(String fileName) {
        Path savePath = Paths.get("data", fileName);
        taskList = new TaskList(savePath);
        try {
            taskList.loadFromStorage();
        } catch (StorageException | IllegalDataException e) {
            // Proceed with an empty task list if loading fails
        }
    }

    /**
     * Returns a greeting message.
     *
     * @return Greeting message
     */
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
