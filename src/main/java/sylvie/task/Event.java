package sylvie.task;

import java.time.temporal.Temporal;

import sylvie.exception.InvalidArgumentException;
import sylvie.time.Date;

public class Event extends Task {
    Temporal from;
    Temporal to;

    /**
     * Creates an Event task.
     * 
     * @param description description of the task
     * @param from Start time of the event
     * @param to End time of the event
     */
    public Event(String description, String from, String to) throws InvalidArgumentException {
        super(description);

        if (from.isBlank()) {
            throw new InvalidArgumentException("Start date (/from) cannot be empty");
        }

        if (to.isBlank()) {
            throw new InvalidArgumentException("End date (/to) cannot be empty");
        }

        try {
            this.from = Date.parse(from);
            this.to = Date.parse(to);
        } catch (InvalidArgumentException e) {
            throw new InvalidArgumentException("Invalid deadline format (yyyy-MM-dd HHmm)");
        }
    }

    @Override
    public String toString() {
        String fromString = " ", toString = "";
        try {
            fromString = Date.toDateString(from);
            toString = Date.toDateString(to);
        } catch (InvalidArgumentException e) {
        }

        String s = String.format("[E]%s (from: %s, to: %s)", super.toString(), fromString, toString);
        return s;
    }

    @Override
    public String toStorageString() {
        String s = String.format("E | %d | %s ^ %s ^ %s", super.isDone ? 1 : 0, super.description, this.from, this.to);
        return s;
    }
}
