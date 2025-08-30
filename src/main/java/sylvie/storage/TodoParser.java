package sylvie.storage;

import sylvie.exception.IllegalDataException;
import sylvie.exception.InvalidArgumentException;
import sylvie.task.Task;
import sylvie.task.ToDo;

public class TodoParser extends TaskParser {
    @Override
    public Task parse(String input) throws IllegalDataException {
        try {
            return new ToDo(input.trim());
        } catch (InvalidArgumentException e) {
            throw new IllegalDataException("Failed to load todo data.");
        }
    }
}
