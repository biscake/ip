package command;

import exception.InvalidArgumentException;
import java.util.List;
import task.Task;
import task.ToDo;

public class AddTodoCommand extends AddTaskCommand {
    private final String rest;

    /**
     * Creates a command that adds a Todo task
     * 
     * @param rest the string after the "todo" commmand word, representing the description
     */
    public AddTodoCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Adds a Todo task to the task list
     * 
     * @param taskList List of Task
     * @throws InvalidArgumentException if description is blank
     */
    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        if (rest.isBlank()) {
            throw new InvalidArgumentException("Description of a todo cannot be empty.");
        }

        Task task = new ToDo(rest);
        super.addTask(task, taskList);
    }
}
