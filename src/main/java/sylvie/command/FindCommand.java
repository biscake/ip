package sylvie.command;

import java.util.List;

import sylvie.task.Task;
import sylvie.task.TaskList;
import sylvie.ui.Textbox;

/**
 * Command to find task with the specified keyword in the task list.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Creates a Find command to find task from Task list.
     *
     * @param keyword keyword to find task with
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Find task with keyword from the task list.
     *
     * @param taskList List of Task
     */
    @Override
    public void execute(TaskList taskList) {
        List<Task> filtered = taskList.find(keyword);

        if (filtered.isEmpty()) {
            new Textbox("There are no task with the keyword: " + keyword).print();
            return;
        }

        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");

        for (int i = 0; i < filtered.size(); i++) {
            String index = String.format("%d. ", i + 1);
            sb.append(index).append(filtered.get(i)).append("\n");
        }

        new Textbox(sb.toString()).print();
    }
}
