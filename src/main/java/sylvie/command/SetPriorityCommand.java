package sylvie.command;

import sylvie.command.parser.PriorityParser;
import sylvie.exception.InvalidArgumentException;
import sylvie.exception.StorageException;
import sylvie.task.Task;
import sylvie.task.Task.Priority;
import sylvie.task.TaskList;

/**
 * Command to set priority of a task.
 */
public class SetPriorityCommand extends Command {
    private final String commandArgs;

    /**
     * Creates a set task priority command.
     *
     * @param commandArgs Rest of the user's input after "priority" command
     */
    public SetPriorityCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    /**
     * Set priority of task.
     */
    @Override
    public String execute(TaskList taskList) throws InvalidArgumentException, StorageException {
        try {
            String[] parts = commandArgs.split(" ", 2);
            String idxStr = parts[0];
            String priorityStr = parts[1];

            int index = Integer.parseInt(idxStr) - 1; // offset for 0-index
            if (index < 0 || index >= taskList.size()) {
                throw new InvalidArgumentException("Invalid ID");
            }

            Priority priority = PriorityParser.parse(priorityStr);
            Task task = taskList.setPriority(index, priority);

            return String.format("Okay! I've updated priority of this task:\n%s", task);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
