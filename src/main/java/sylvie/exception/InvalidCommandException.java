package sylvie.exception;

/**
 * Exception thrown when an invalid command is encountered.
 */
public class InvalidCommandException extends SylvieException {
    /**
     * Constructor for InvalidCommandException
     *
     * @param message
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
