package sylvie.task;

import sylvie.exception.InvalidArgumentException;

/**
 * Abstract class representing a Task with a description and completion status.
 */
public abstract class Task {
    /**
     * Priority levels for tasks.
     */
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH,
    }

    protected String description;
    protected boolean isDone;
    protected Priority priority;

    /**
     * Create a Task
     *
     * @param description description of the task
     */
    public Task(String description) throws InvalidArgumentException {
        if (description.isBlank()) {
            throw new InvalidArgumentException("Description cannot be empty");
        }

        this.description = description;
        this.isDone = false;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isDone ? "[X]" : "[ ]").append(" ")
                .append(this.description).append(" ")
                .append(this.priority == null ? "" : String.format("(Priority: %s)", this.priority));
        return sb.toString();
    }

    /**
     * Returns the string representation of the task to be stored in the storage file.
     *
     * @return
     */
    public abstract String toStorageString();
}
