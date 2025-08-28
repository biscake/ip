package sylvie.storage;

import sylvie.exception.IllegalDataException;
import sylvie.task.Deadline;
import sylvie.task.Task;

public class DeadlineParser extends TaskParser {
    @Override
    public Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\^");
        String description = parts.length > 0 ? parts[0].trim() : "";
        String deadline = parts.length > 1 ? parts[1].trim() : "";

        if (description.isBlank() || deadline.isBlank()) {
            throw new IllegalDataException("Failed to load deadline data");
        }

        return new Deadline(description, deadline);
    }
}
