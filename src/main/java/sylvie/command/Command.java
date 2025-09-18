package sylvie.command;

import sylvie.exception.InvalidArgumentException;
import sylvie.exception.StorageException;
import sylvie.task.TaskList;

/**
 * Abstract class representing a command in the Sylvie application.
 */
public abstract class Command {
    /**
     * @param taskList List of task
     * @return response message of command
     */
    public abstract String execute(TaskList taskList) throws InvalidArgumentException, StorageException;

    /**
     * Returns if the command is an exit command.
     *
     * @return false as default
     */
    public boolean isExit() {
        return false;
    }
}
