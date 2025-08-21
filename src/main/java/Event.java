public class Event extends Task {
    private final String from;
    private final String to;

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
}
