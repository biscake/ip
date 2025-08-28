package sylvie.storage;

import sylvie.exception.IllegalDataException;
import sylvie.task.Task;
import sylvie.task.ToDo;

public class TodoParser extends TaskParser {
    @Override
    public Task parse(String input) throws IllegalDataException {
        if (input.isBlank()) {
            throw new IllegalDataException("Failed to load data of Todo");
        }
        
        return new ToDo(input.trim());
    }
}
