package sylvie.command;
import java.util.List;

import sylvie.exception.InvalidArgumentException;
import sylvie.task.Event;
import sylvie.task.Task;

public class AddEventCommand extends AddTaskCommand {
    private final String rest;

    /**
     * Creates a command that adds a Event task
     * 
     * @param rest the string after the "event" commmand word, representing
     *             the description, from (/from) and to (/to) of the event Task
     */
    public AddEventCommand(String rest) {
        this.rest = rest;
    }

    /**
     * Adds a Event task to the task list
     * 
     * @param taskList List of Task
     * @throws InvalidArgumentException if description is blank, missing /from or /to,
     *         blank /from or /to
     */
    @Override
    public void execute(List<Task> taskList) throws InvalidArgumentException {
        int fromIndex = rest.indexOf("/from");
        int toIndex = rest.indexOf("/to");

        if (fromIndex != -1 && toIndex != -1) {
            String description = rest.substring(0, Math.min(fromIndex, toIndex)).trim();
            String from, to;

            if (description.isBlank()) {
                throw new InvalidArgumentException("Description of an event cannot be empty.");
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
            throw new InvalidArgumentException("From (/from) and To (/to) required for event");
        }
    }
}
