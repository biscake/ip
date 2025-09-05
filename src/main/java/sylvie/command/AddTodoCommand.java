package sylvie.command;

import sylvie.exception.InvalidArgumentException;
import sylvie.task.Task;
import sylvie.task.TaskList;
import sylvie.task.ToDo;

/**
 * Command to add a Todo task to the task list.
 */
public class AddTodoCommand extends AddTaskCommand {
    private final String rest;

    /**
     * Creates a command that adds a Todo task.
     *
     * @param rest the string after the "todo" commmand word, representing the description
     */
    public AddTodoCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Adds a Todo task to the task list.
     *
     * @throws InvalidArgumentException if description is blank
     */
    @Override
    public String execute(TaskList taskList) throws InvalidArgumentException {
        if (rest.isBlank()) {
            throw new InvalidArgumentException("Description of a todo cannot be empty.");
        }

        Task task = new ToDo(rest);
        return super.addTask(task, taskList);
    }
}
