package sylvie.task;

import sylvie.exception.InvalidArgumentException;

public class ToDo extends Task {
    /**
     * Creates a Todo task.
     * 
     * @param description Description of the task
     */
    public ToDo(String description) throws InvalidArgumentException {
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
