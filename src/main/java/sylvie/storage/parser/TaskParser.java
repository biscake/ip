package sylvie.storage.parser;

import sylvie.exception.IllegalDataException;
import sylvie.task.Task;

public abstract class TaskParser {
    abstract public Task parse(String input) throws IllegalDataException;
}
