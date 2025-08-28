package sylvie.task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList = new ArrayList<>();

    public List<Task> get() {
        return this.taskList;
    }

    public void add(Task task) {
        this.taskList.add(task);
    }
}
