package sylvie.task;

import java.time.temporal.Temporal;

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

        try {
            this.by = Date.parse(by);
        } catch (InvalidArgumentException e) {
            throw new InvalidArgumentException("Invalid deadline format");
        }
    }

    @Override
    public String toString() {
        String deadlineString;
        try {
            deadlineString = Date.toDateString(by);
        } catch (InvalidArgumentException e) {
            deadlineString = "";
        }

        String s = String.format("[D]%s (by: %s)", super.toString(), deadlineString);
        return s;
    }

    @Override
    public String toStorageString() {
        String s = String.format("D | %d | %s ^ %s", super.isDone ? 1 : 0, super.description, this.by);
        return s;
    }
}
