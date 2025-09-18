package aqua.storage.parser;

import aqua.exception.IllegalDataException;
import aqua.exception.InvalidArgumentException;
import aqua.task.Event;
import aqua.task.Task;

/**
 * Parses input strings to create Event tasks.
 */
public class EventParser extends TaskParser {
    /**
     * Parses a string input to create an Event task.
     * The input format is expected to be "description ^ from ^ to".
     *
     * @param input the string input containing the task details
     * @return an Event task created from the input details
     * @throws IllegalDataException if the input data is invalid
     */
    @Override
    public Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\^");
        String description = parts.length > 0 ? parts[0].trim() : "";
        String from = parts.length > 1 ? parts[1].trim() : "";
        String to = parts.length > 2 ? parts[2].trim() : "";
        String priority = parts.length > 2 ? parts[2].trim() : "";

        try {
            if (priority.isBlank()) {
                return new Event(description, from, to);
            } else {
                return new Event(description, from, to, priority);
            }
        } catch (InvalidArgumentException e) {
            throw new IllegalDataException("Failed to load event data");
        }
    }
}
