import java.util.List;

public class AddEventCommand extends AddTaskCommand {
    private final String rest;

    public AddEventCommand(String rest) {
        this.rest = rest;
    }

    @Override
    public void execute(List<Task> taskList) {
        int fromIndex = rest.indexOf("/from");
        int toIndex = rest.indexOf("/to");

        if (fromIndex != -1 && toIndex != -1) {
            String description = rest.substring(0, Math.min(fromIndex, toIndex)).trim();
            String from, to;

            if (description.isBlank()) {
                throw new IllegalArgumentException("Description of an event cannot be empty.");
            }

            if (fromIndex < toIndex) {
                from = rest.substring(fromIndex + 5, toIndex).trim();
                to = rest.substring(toIndex + 3).trim();
            } else {
                from = rest.substring(fromIndex + 5).trim();
                to = rest.substring(toIndex + 3, fromIndex).trim();
            }

            Task task = new Event(description, from, to);
            super.addTask(task, taskList);
        } else {
            throw new IllegalArgumentException("From (/from) and To (/to) required for event");
        }
    }
}
