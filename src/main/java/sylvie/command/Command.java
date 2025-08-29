package sylvie.command;

import sylvie.exception.InvalidArgumentException;
import sylvie.task.TaskList;

public abstract class Command {
    abstract public void execute(TaskList taskList) throws InvalidArgumentException;

    /**
     * @return Returns whether should the command exit the chatbot
     */
    public boolean isExit() {
        return false;
    }
}
