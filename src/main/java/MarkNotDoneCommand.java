import java.util.List;

public class MarkNotDoneCommand extends Command {
    private final String rest;

    public MarkNotDoneCommand(String rest) {
        this.rest = rest;
    }

    @Override
    public void execute(List<Task> taskList) {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            Task task = taskList.get(index);
            task.markNotDone();
            new Textbox(String.format("Okay! I've marked this task as not done yet:\n%s", task)).print();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
