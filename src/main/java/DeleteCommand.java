
import java.util.List;

public class DeleteCommand extends Command {
    private final String rest;

    public DeleteCommand(String rest) {
        this.rest = rest;
    }
    
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
