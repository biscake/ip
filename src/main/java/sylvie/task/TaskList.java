package sylvie.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sylvie.exception.IllegalDataException;
import sylvie.storage.Storage;
import sylvie.storage.parser.Parser;
import sylvie.ui.Textbox;

public class TaskList {
    private final List<Task> TASKLIST = new ArrayList<>();

    public Task get(int idx) {
        return this.TASKLIST.get(idx);
    }

    public void add(Task task) {
        this.TASKLIST.add(task);
        Storage.add(task);
    }

    public Task delete(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.remove(task);
        this.TASKLIST.remove(idx);

        return task;
    }

    public void loadFromStorage() {
        List<String> lines;
        try {
            lines = Storage.load();
            for (String line : lines) {
                try {
                    Task task = Parser.parse(line);
                    if (task == null) {
                        continue;
                    }

                    TASKLIST.add(task);
                } catch (IllegalDataException e) {
                    new Textbox(e.getMessage()).print();
                }
            }
        } catch (IOException e) {
            new Textbox(e.getMessage()).print();
        }
    }

    public int size() {
        return this.TASKLIST.size();
    }

    public boolean isEmpty() {
        return this.TASKLIST.isEmpty();
    }

    public void markTaskDone(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.updateDoneStatus(task, true);
        task.markDone();
    }

    public void markTaskNotDone(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.updateDoneStatus(task, false);
        task.markNotDone();
    }
}
