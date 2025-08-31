package sylvie.command;

import sylvie.exception.InvalidArgumentException;
import sylvie.task.Task;
import sylvie.task.TaskList;
import sylvie.ui.Textbox;

public class MarkDoneCommand extends Command {
    private final String rest;

    /**
     * Creates a mark done command.
     * 
     * @param rest Rest of the user's input after "mark" command
     */
    public MarkDoneCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Marks the task specified by a ID as done.
     * 
     * @param taskList List of task
     */
    @Override
    public void execute(TaskList taskList) throws InvalidArgumentException {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            if (index < 0 || index >= taskList.size()) {
                throw new InvalidArgumentException("Invalid ID");
            }
            
            Task task = taskList.get(index);
            taskList.markTaskDone(index);
            new Textbox(String.format("Okay! I've marked this task as done:\n%s", task)).print();
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
