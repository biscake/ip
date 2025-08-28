package sylvie.storage;

import sylvie.exception.IllegalDataException;
import sylvie.task.Event;
import sylvie.task.Task;

public class EventParser extends TaskParser {
    @Override
    public Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\^");
        String description = parts.length > 0 ? parts[0].trim() : "";
        String from = parts.length > 1 ? parts[1].trim() : "";
        String to = parts.length > 2 ? parts[2].trim() : "";

        if (description.isBlank() || from.isBlank() || to.isBlank()) {
            throw new IllegalDataException("Failed to load event data");
        }
        
        return new Event(description, from, to);
    }
}