package aqua.command;

import aqua.exception.InvalidArgumentException;
import aqua.exception.StorageException;
import aqua.task.TaskList;

/**
 * Abstract class representing a command in the Aquapplication.
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
