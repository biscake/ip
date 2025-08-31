package sylvie.task;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import sylvie.exception.IllegalDataException;
import sylvie.storage.Storage;
import sylvie.storage.parser.Parser;
import sylvie.ui.Textbox;

public class TaskList {
    private final List<Task> TASKLIST = new ArrayList<>();
    private final Storage Storage;

    /**
     * Creates a TaskList object that manages a list of Task.
     * 
     * @param path Path to the storage file
     */
    public TaskList(Path path) {
        this.Storage = new Storage(path);
    }

    public Task get(int idx) {
        return this.TASKLIST.get(idx);
    }

    /**
     * Adds a task to the task list and saves it to storage.
     * @param task the task to be added
     */
    public void add(Task task) {
        this.TASKLIST.add(task);
        Storage.add(task);
    }

    /**
     * Deletes a task from the task list and removes it from storage.
     * @param idx the index of the task to be deleted
     * @return the deleted task
     */
    public Task delete(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.remove(task);
        this.TASKLIST.remove(idx);

        return task;
    }

    /**
     * Loads tasks from storage into the task list.
     */
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

    /**
     * Returns the number of tasks in the task list.
     * 
     * @return the number of tasks in the task list
     */
    public int size() {
        return this.TASKLIST.size();
    }

    /**
     * Checks if the task list is empty.
     * 
     * @return true if the task list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.TASKLIST.isEmpty();
    }

    /**
     * Marks a task as done and updates the storage file.
     * 
     * @param idx the index of the task to be marked as done
     */
    public void markTaskDone(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.updateDoneStatus(task, true);
        task.markDone();
    }

    /**
     * Marks a task as not done and updates the storage file.
     * 
     * @param idx the index of the task to be marked as not done
     */
    public void markTaskNotDone(int idx) {
        Task task = TASKLIST.get(idx);
        Storage.updateDoneStatus(task, false);
        task.markNotDone();
    }
}
