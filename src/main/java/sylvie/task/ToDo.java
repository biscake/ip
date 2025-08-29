package sylvie.task;
public class ToDo extends Task {
    /**
     * Create a Todo task
     * 
     * @param description Description of the task
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        String s = String.format("[T]%s", super.toString());
        return s;
    }

    @Override
    public String toStorageString() {
        String s = String.format("T | %d | %s", super.isDone ? 1 : 0, super.description);
        return s;
    }
}
