package sylvie.task;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import sylvie.exception.IllegalDataException;
import sylvie.storage.Storage;
import sylvie.storage.parser.Parser;
import sylvie.ui.Textbox;

/**
 * Manages a list of tasks and handles loading and saving to storage.
 */
public class TaskList {
    private final List<Task> taskList = new ArrayList<>();
    private final Storage storage;

    /**
     * Creates a TaskList object that manages a list of Task.
     *
     * @param path Path to the storage file
     */
    public TaskList(Path path) {
        this.storage = new Storage(path);
    }

    public Task get(int idx) {
        return this.taskList.get(idx);
    }

    /**
     * Adds a task to the task list and saves it to storage.
     * @param task the task to be added
     */
    public void add(Task task) {
        int oldSize = this.taskList.size();
        this.taskList.add(task);
        assert taskList.size() == oldSize + 1 : "TaskList size should increase by 1 after add";
        storage.add(task);
    }

    /**
     * Deletes a task from the task list and removes it from storage.
     * @param idx the index of the task to be deleted
     * @return the deleted task
     */
    public Task delete(int idx) {
        int oldSize = taskList.size();
        Task task = taskList.get(idx);
        storage.remove(task);
        this.taskList.remove(idx);
        assert taskList.size() == oldSize - 1 : "TaskList size should decrease by 1 after delete";

        return task;
    }

    /**
     * Loads tasks from storage into the task list.
     */
    public void loadFromStorage() {
        List<String> lines;
        try {
            lines = storage.load();
            for (String line : lines) {
                try {
                    Task task = Parser.parse(line);
                    if (task == null) {
                        continue;
                    }

                    taskList.add(task);
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
        return this.taskList.size();
    }

    /**
     * Checks if the task list is empty.
     *
     * @return true if the task list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    /**
     * Marks a task as done and updates the storage file.
     *
     * @param idx the index of the task to be marked as done
     */
    public void markTaskDone(int idx) {
        Task task = taskList.get(idx);
        storage.updateDoneStatus(task, true);
        task.markDone();
        assert task.isDone : "Task should be marked as done";
    }

    /**
     * Marks a task as not done and updates the storage file.
     *
     * @param idx the index of the task to be marked as not done
     */
    public void markTaskNotDone(int idx) {
        Task task = taskList.get(idx);
        storage.updateDoneStatus(task, false);
        task.markNotDone();
        assert !task.isDone : "Task should be marked as not done";
    }

    /**
     * Returns a list of task with the specified keyword.
     * @param keyword the keyword to find task
     * @return list of filtered task
     */
    public List<Task> find(String keyword) {
        List<Task> filtered = new ArrayList<>();

        for (Task task : taskList) {
            if (task.getDescription().contains(keyword)) {
                filtered.add(task);
            }
        }

        return filtered;
    }
}
