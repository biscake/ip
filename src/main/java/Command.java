
import java.util.List;

public abstract class Command {
    abstract public void execute(List<Task> taskList) throws InvalidArgumentException;

    public boolean isExit() {
        return false;
    }
}
