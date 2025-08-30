package sylvie.storage;

import sylvie.exception.IllegalDataException;
import sylvie.exception.InvalidArgumentException;
import sylvie.task.Deadline;
import sylvie.task.Task;

public class DeadlineParser extends TaskParser {
    @Override
    public Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\^");
        String description = parts.length > 0 ? parts[0].trim() : "";
        String deadline = parts.length > 1 ? parts[1].trim() : "";

        try {
            return new Deadline(description, deadline);
        } catch (InvalidArgumentException e) {
            throw new IllegalDataException("Failed to load deadline data");
        }
    }
}
