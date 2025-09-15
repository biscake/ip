package sylvie.command;

import sylvie.task.Task;
import sylvie.task.TaskList;

/**
 * Abstract command to add a task to the task list.
 */
public abstract class AddTaskCommand extends Command {
    /**
     * Adds the task to the list of Task and prints task added message.
     *
     * @param task Task to be added
     * @param taskList List that the task should be added to
     */
    public String addTask(Task task, TaskList taskList) {
        String s = String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.", task,
                taskList.size() + 1);
        taskList.add(task);
        return s;
    }
}
