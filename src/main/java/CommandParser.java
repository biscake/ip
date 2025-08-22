public class CommandParser {
    public static Command parse(String input) {
            String[] parts = input.split("\\s+", 2);
            String command = parts.length > 0 ? parts[0].toLowerCase() : "";
            String rest = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "todo":
                    return new AddTodoCommand(rest);
                case "deadline":
                    return new AddDeadlineCommand(rest);
                case "event":
                    return new AddEventCommand(rest);
                case "mark":
                    return new MarkDoneCommand(rest);
                case "unmark":
                    return new MarkNotDoneCommand(rest);
                case "list":
                    return new ListCommand();
                case "delete":
                    return new DeleteCommand(rest);
                case "bye":
                    return new ExitCommand();
                default:
                    throw new IllegalArgumentException("Sorry! I don't understand what you mean.");
            }
    }
}
