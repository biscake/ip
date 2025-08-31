package sylvie.exception;

/**
 * Exception thrown when illegal data is encountered.
 */
public class IllegalDataException extends SylvieException {
    /**
     * Constructor for IllegalDataException
     *
     * @param message
     */
    public IllegalDataException(String message) {
        super(message);
    }
}
