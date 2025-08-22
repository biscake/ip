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
}
