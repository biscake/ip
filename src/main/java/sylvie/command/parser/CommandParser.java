package sylvie.command.parser;

import sylvie.command.AddDeadlineCommand;
import sylvie.command.AddEventCommand;
import sylvie.command.AddTodoCommand;
import sylvie.command.Command;
import sylvie.command.DeleteCommand;
import sylvie.command.ExitCommand;
import sylvie.command.FindCommand;
import sylvie.command.ListCommand;
import sylvie.command.MarkDoneCommand;
import sylvie.command.MarkNotDoneCommand;
import sylvie.exception.InvalidCommandException;

/**
 * Parses user input into commands.
 */
public class CommandParser {
    /**
     * Parses command given a input string.
     *
     * @param input The user's input
     * @return Command specified by the first word of input
     */
    public static Command parse(String input) throws InvalidCommandException {
        String[] parts = input.split("\\s+", 2);
        assert parts.length == 3 : "Input should contains 2 parts";
        String command = parts.length > 0 ? parts[0].toLowerCase() : "";
        String commandArgs = parts.length > 1 ? parts[1] : "";

        switch (command) {
        case "todo" -> {
            return new AddTodoCommand(commandArgs);
        }
        case "deadline" -> {
            return new AddDeadlineCommand(commandArgs);
        }
        case "event" -> {
            return new AddEventCommand(commandArgs);
        }
        case "mark" -> {
            return new MarkDoneCommand(commandArgs);
        }
        case "unmark" -> {
            return new MarkNotDoneCommand(commandArgs);
        }
        case "list" -> {
            return new ListCommand();
        }
        case "delete" -> {
            return new DeleteCommand(commandArgs);
        }
        case "bye" -> {
            return new ExitCommand();
        }
        case "find" -> {
            return new FindCommand(commandArgs);
        }
        default -> throw new InvalidCommandException("Sorry! I don't understand what you mean.");
        }
    }
}
