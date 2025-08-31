package sylvie.storage.parser;

import sylvie.exception.IllegalDataException;
import sylvie.task.Task;

/**
 * Abstract class for parsing task data from strings.
 */
public abstract class TaskParser {
    public abstract Task parse(String input) throws IllegalDataException;
}
