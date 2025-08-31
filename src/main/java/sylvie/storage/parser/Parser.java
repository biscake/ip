package sylvie.storage.parser;

import sylvie.exception.IllegalDataException;
import sylvie.task.Task;

/**
 * Parses task data from strings.
 */
public class Parser {
    /**
     * Parse task given a input string
     *
     * @param input The user's input
     * @return task specified by the input string
     */
    public static Task parse(String input) throws IllegalDataException {
        String[] parts = input.split("\\|");
        String type = parts[0].trim();
        boolean isDone = parts[1].trim().equals("1");
        String rest = parts[2].trim();
        Task task;

        switch (type) {
        case "T" -> {
            task = new TodoParser().parse(rest);
            break;
        }
        case "D" -> {
            task = new DeadlineParser().parse(rest);
            break;
        }
        case "E" -> {
            task = new EventParser().parse(rest);
            break;
        }
        default -> {
            throw new Error("Failed to read data");
        }
        }

        if (isDone) {
            task.markDone();
        }

        return task;
    }
}
