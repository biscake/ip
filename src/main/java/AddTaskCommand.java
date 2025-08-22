
import java.util.List;

abstract public class AddTaskCommand extends Command {
    public void addTask(Task task, List<Task> taskList) {
        String s = String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.", task,
                taskList.size() + 1);
        taskList.add(task);
        new Textbox(s).print();
    }
}
