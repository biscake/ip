package sylvie.command;

import sylvie.task.TaskList;
import sylvie.ui.Textbox;

/**
 * Command to exit the Sylvie application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by displaying a goodbye message.
     *
     * @param taskList List of Task (not used in this command)
     */
    @Override
    public void execute(TaskList taskList) {
        String text = "Bye bye! Hope to see you again soon!";
        new Textbox(text).print();
    }

    /**
     * @return True. Command will exit chatbot
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
