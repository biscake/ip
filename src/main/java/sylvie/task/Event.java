package sylvie.task;
public class Event extends Task {
    final String from;
    final String to;

    /**
     * Create a Event task 
     * 
     * @param description description of the task
     * @param from Start time of the event
     * @param to End time of the event
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        String s = String.format("[E]%s (from: %s, to: %s)", super.toString(), from, to);
        return s;
    }

    @Override
    public String toStorageString() {
        String s = String.format("E | %d | %s ^ %s ^ %s", super.isDone ? 1 : 0, super.description, this.from, this.to);
        return s;
    }
}
