package sylvie.task;

import java.time.temporal.Temporal;

import sylvie.command.parser.PriorityParser;
import sylvie.exception.InvalidArgumentException;
import sylvie.time.Date;

/**
 * Represents a Deadline task with a description and a deadline.
 */
public class Deadline extends Task {
    private Temporal by;

    /**
     * Creates a Deadline Task.
     *
     * @param description description of task
     * @param by deadline of the task
     */
    public Deadline(String description, String by) throws InvalidArgumentException {
        super(description);

        if (by.isBlank()) {
            throw new InvalidArgumentException("Deadline (/by) cannot be empty");
        }

        this.by = Date.parse(by);
    }

    /**
     * Creates a Deadline task with priority.
     *
     * @param description description of task
     * @param by deadline of the task
     * @param priority priority of the task
     */
    public Deadline(String description, String by, String priority) throws InvalidArgumentException {
        this(description, by);
        this.priority = PriorityParser.parse(priority);
    }

    @Override
    public String toString() {
        String deadlineString;
        try {
            deadlineString = Date.toDateString(by);
        } catch (InvalidArgumentException e) {
            deadlineString = "";
        }

        return String.format("[D]%s (by: %s)", super.toString(), deadlineString);
    }

    @Override
    public String toStorageString() {
        int priority = this.priority == null ? -1 : this.priority.ordinal();
        return String.format("D | %d | %d | %s ^ %s", this.isDone ? 1 : 0, priority, this.description, this.by);
    }
}
