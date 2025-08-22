import java.util.List;

public class AddDeadlineCommand extends AddTaskCommand {
    private final String rest;

    public AddDeadlineCommand(String rest) {
        this.rest = rest;
    }

    @Override
    public void execute(List<Task> taskList) {
        int byIndex = rest.indexOf("/by");

        if (byIndex != -1) {
            String description = rest.substring(0, byIndex).trim();
            if (description.isBlank()) {
                throw new IllegalArgumentException("Description of a deadline cannot be empty.");
            }

            String by = rest.substring(byIndex + 3).trim();
            if (by.isBlank()) {
                throw new IllegalArgumentException("Deadline (/by) cannot be empty.");
            }

            Task task = new Deadline(description, by);
            super.addTask(task, taskList);
        } else {
            throw new IllegalArgumentException("By (/by) required for deadline.");
        }
    }
}
