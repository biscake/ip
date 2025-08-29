package sylvie.task;

public class Deadline extends Task {
    final String by;

    /**
     * Create a Deadline Task 
     * 
     * @param description description of task
     * @param by deadline of the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        String s = String.format("[D]%s (by: %s)", super.toString(), this.by);
        return s;
    }

    @Override
    public String toStorageString() {
        String s = String.format("D | %d | %s ^ %s", super.isDone ? 1 : 0, super.description, this.by);
        return s;
    }
}
