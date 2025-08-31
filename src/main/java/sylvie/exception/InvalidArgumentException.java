package sylvie.exception;

/**
 * Exception thrown when an invalid argument is provided to a method or function.
 */
public class InvalidArgumentException extends SylvieException {
    /**
     * Constructor for InvalidArgumentException
     *
     * @param message
     */
    public InvalidArgumentException(String message) {
        super(message);
    }
}
