package sylvie.task;

import java.time.temporal.Temporal;
import sylvie.exception.InvalidArgumentException;
import sylvie.time.Date;

public class Deadline extends Task {
    Temporal by;

    /**
     * Create a Deadline Task 
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
            throw new InvalidArgumentException("Invalid deadline format (yyyy-MM-dd HHmm)");
        }
    }

    @Override
    public String toString() {
        String deadlineString = "";
        try {
            deadlineString = Date.toDateString(by);
        } catch (InvalidArgumentException e) {
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
