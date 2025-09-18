package sylvie.storage.parser;

import sylvie.exception.IllegalDataException;
import sylvie.exception.InvalidArgumentException;
import sylvie.task.Deadline;
import sylvie.task.Task;
import sylvie.task.ToDo;

/**
 * Parses input strings to create Deadline tasks.
 */
public class DeadlineParser extends TaskParser {
    /**
     * Parses a string input to create a Deadline task.
     * The input format is expected to be "description ^ deadline".
     *
     * @param input the string input containing the task details
     * @return a Deadline task created from the input details
     * @throws IllegalDataException if the input data is invalid
     */
    @Override
    public Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\^");
        String description = parts.length > 0 ? parts[0].trim() : "";
        String deadline = parts.length > 1 ? parts[1].trim() : "";
        String priority = parts.length > 2 ? parts[2].trim() : "";

        try {
            if (priority.isBlank()) {
                return new Deadline(description, deadline);
            } else {
                return new Deadline(description, deadline, priority);
            }
        } catch (InvalidArgumentException e) {
            throw new IllegalDataException("Failed to load deadline data");
        }
    }
}
