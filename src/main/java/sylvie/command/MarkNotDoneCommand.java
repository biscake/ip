package sylvie.command;
import sylvie.exception.InvalidArgumentException;
import sylvie.task.Task;
import sylvie.task.TaskList;

/**
 * Command to mark a task as not done.
 */
public class MarkNotDoneCommand extends Command {
    private final String rest;

    /**
     * Creates a mark not done command.
     *
     * @param rest Rest of the user's input after "unmark" command
     */
    public MarkNotDoneCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Marks the task specified by a ID as not done.
     */
    @Override
    public String execute(TaskList taskList) throws InvalidArgumentException {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            if (index < 0 || index >= taskList.size()) {
                throw new InvalidArgumentException("Invalid ID");
            }

            Task task = taskList.get(index);
            taskList.markTaskNotDone(index);
            return String.format("Okay! I've marked this task as not done yet:\n%s", task);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
