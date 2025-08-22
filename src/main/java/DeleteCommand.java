
import java.util.List;

public class DeleteCommand extends Command {
    private final String rest;

    /**
     * Create a Delete command that deletes a task from Task list
     * 
     * @param rest Rest of the user's input after the "delete" command
     */
    public DeleteCommand(String rest) {
        this.rest = rest;
    }
    
    /**
     * Deletes a task from the task list
     * 
     * @param taskList List of Task
     * @throws InvalidArgumentException if ID of task to be deleted is invalid
     */
    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            if (index < 0 || index >= taskList.size()) {
                throw new InvalidArgumentException("Invalid ID");
            }

            Task task = taskList.remove(index);
            new Textbox(String
                    .format("Noted. I've removed this task:\n  %s\nNow you have %d tasks in the list.", task,
                            taskList.size())
                ).print();
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
