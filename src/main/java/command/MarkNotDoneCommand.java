package command;
import exception.InvalidArgumentException;
import java.util.List;
import task.Task;
import ui.Textbox;

public class MarkNotDoneCommand extends Command {
    private final String rest;

    /**
     * Create a mark not done command
     * 
     * @param rest Rest of the user's input after "unmark" command
     */
    public MarkNotDoneCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Marks the task specified by a ID as not done
     * 
     * @param taskList List of task
     */
    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            if (index < 0 || index >= taskList.size()) {
                throw new InvalidArgumentException("Invalid ID");
            }
            
            Task task = taskList.get(index);
            task.markNotDone();
            new Textbox(String.format("Okay! I've marked this task as not done yet:\n%s", task)).print();
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
