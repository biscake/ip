package sylvie.command;

import sylvie.exception.InvalidArgumentException;
import sylvie.task.TaskList;

public abstract class Command {
    abstract public void execute(TaskList taskList) throws InvalidArgumentException;

    /**
     * Returns if the command is an exit command.
     * 
     * @return false as default
     */
    public boolean isExit() {
        return false;
    }
}
