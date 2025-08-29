package sylvie.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sylvie.exception.IllegalDataException;
import sylvie.storage.Parser;
import sylvie.storage.Storage;
import sylvie.ui.Textbox;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    public Task get(int idx) {
        return this.taskList.get(idx);
    }

    public void add(Task task) {
        this.taskList.add(task);
        Storage.add(task);
    }

    public Task delete(int idx) {
        Task task = taskList.get(idx);
        Storage.remove(task);
        this.taskList.remove(idx);

        return task;
    }

    public void loadFromStorage() {
        List<String> lines;
        try {
            lines = Storage.load();
            for (String line : lines) {
                taskList.add(Parser.parse(line));
            }
        } catch (IOException | IllegalDataException e) {
            new Textbox(e.getMessage()).print();
            this.taskList = new ArrayList<>();
        }
    }

    public int size() {
        return this.taskList.size();
    }

    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    public void markTaskDone(int idx) {
        Task task = taskList.get(idx);
        Storage.updateDoneStatus(task, true);
        task.markDone();
    }

    public void markTaskNotDone(int idx) {
        Task task = taskList.get(idx);
        Storage.updateDoneStatus(task, false);
        task.markNotDone();
    }
}
