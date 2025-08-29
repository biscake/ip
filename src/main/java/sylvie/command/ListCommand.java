package sylvie.command;

import sylvie.task.TaskList;
import sylvie.ui.Textbox;

public class ListCommand extends Command {
    /**
     * Prints a list of all current tasks
     */
    @Override
    public void execute(TaskList taskList) {
        if (taskList.isEmpty()) {
            new Textbox("The list is currently empty.").print();
            return;
        }

        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");

        for (int i = 0; i < taskList.size(); i++) {
            String index = String.format("%d. ", i + 1);
            sb.append(index).append(taskList.get(i)).append("\n");
        }

        new Textbox(sb.toString()).print();
    }
}
