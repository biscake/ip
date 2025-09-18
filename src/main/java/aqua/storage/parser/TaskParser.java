package aqua.storage.parser;

import aqua.exception.IllegalDataException;
import aqua.task.Task;

/**
 * Abstract class for parsing task data from strings.
 */
public abstract class TaskParser {
    public abstract Task parse(String input) throws IllegalDataException;
}
