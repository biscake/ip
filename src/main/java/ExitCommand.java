
import java.util.List;

public class ExitCommand extends Command {
    @Override
    public void execute(List<Task> taskList) {
        String text = "Bye bye! Hope to see you again soon!";
        new Textbox(text).print();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
