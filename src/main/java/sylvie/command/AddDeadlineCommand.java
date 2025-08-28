package sylvie.command;
import java.util.List;
import sylvie.exception.InvalidArgumentException;
import sylvie.task.Deadline;
import sylvie.task.Task;

public class AddDeadlineCommand extends AddTaskCommand {
    private final String rest;

    /**
     * Creates a command that adds a Deadline task
     * 
     * @param rest the string after the "deadline" commmand word, representing
     *             the description, and by (/by) deadline of the Deadline Task
     */
    public AddDeadlineCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Adds a Deadline task to the task list
     * 
     * @param taskList List of Task
     * @throws InvalidArgumentException if description is blank or missing /by or
     *         by is blank
     */
    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        int byIndex = rest.indexOf("/by");

        if (byIndex != -1) {
            String description = rest.substring(0, byIndex).trim();
            if (description.isBlank()) {
                throw new InvalidArgumentException("Description of a deadline cannot be empty.");
            }

            String by = rest.substring(byIndex + 3).trim();
            if (by.isBlank()) {
                throw new InvalidArgumentException("Deadline (/by) cannot be empty.");
            }

            Task task = new Deadline(description, by);
            super.addTask(task, taskList);
        } else {
            throw new InvalidArgumentException("By (/by) required for deadline.");
        }
    }
}
