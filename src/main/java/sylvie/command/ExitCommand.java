package sylvie.command;

import sylvie.task.TaskList;
import sylvie.ui.Textbox;

public class ExitCommand extends Command {
    /**
     * Prints exit message
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
