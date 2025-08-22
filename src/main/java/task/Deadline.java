package task;

public class Deadline extends Task {
    private final String by;

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
}
