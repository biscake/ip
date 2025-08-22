
import java.util.List;

public class AddTodoCommand extends AddTaskCommand {
    private final String rest;

    public AddTodoCommand(String rest) {
        this.rest = rest;
    }

    @Override
    public void execute(List<Task> taskList) {
        if (rest.isBlank()) {
            throw new IllegalArgumentException("Description of a todo cannot be empty.");
        }

        Task task = new ToDo(rest);
        super.addTask(task, taskList);
    }
}
