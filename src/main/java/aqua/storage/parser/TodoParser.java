package aqua.storage.parser;

import aqua.exception.IllegalDataException;
import aqua.exception.InvalidArgumentException;
import aqua.task.Task;
import aqua.task.ToDo;

/**
 * Parses input strings to create ToDo tasks.
 */
public class TodoParser extends TaskParser {
    /**
     * Parses a string input to create a ToDo task.
     * The input format is expected to be "description".
     *
     * @param input the string input containing the task details
     * @return a ToDo task created from the input details
     * @throws IllegalDataException if the input data is invalid
     */
    @Override
    public Task parse(String input) throws IllegalDataException {
        try {
            String[] parts = input.split("\\^");
            String priority = parts.length > 1 ? parts[1].trim() : "";

            if (priority.isBlank()) {
                return new ToDo(input.trim());
            } else {
                return new ToDo(input.trim(), priority);
            }
        } catch (InvalidArgumentException e) {
            throw new IllegalDataException("Failed to load todo data.");
        }
    }
}
