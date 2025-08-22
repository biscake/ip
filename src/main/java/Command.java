
import java.util.List;

public abstract class Command {
    abstract public void execute(List<Task> taskList);

    public boolean isExit() {
        return false;
    }
}
