package task;

public class Task {
    private final String description;
    private boolean isDone;

    /**
     * Create a Task
     * 
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as completed
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed
     */
    public void markNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isDone ? "[X]" : "[ ]").append(" ").append(this.description);
        return sb.toString();
    }
}