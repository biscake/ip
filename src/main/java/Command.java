
import java.util.List;

public abstract class Command {
    abstract public void execute(List<Task> taskList) throws InvalidArgumentException;

    /**
     * @return Returns whether should the command exit the chatbot
     */
    public boolean isExit() {
        return false;
    }
}
