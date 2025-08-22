import java.util.List;

public class MarkDoneCommand extends Command {
    private final String rest;

    public MarkDoneCommand(String rest) {
        this.rest = rest;
    }

    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        try {
            int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
            Task task = taskList.get(index);
            task.markDone();
            new Textbox(String.format("Okay! I've marked this task as done:\n%s", task)).print();
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Invalid ID");
        }
    }
}
