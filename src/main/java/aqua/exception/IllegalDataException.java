package aqua.exception;

/**
 * Exception thrown when illegal data is encountered.
 */
public class IllegalDataException extends AquaException {
    /**
     * Constructor for IllegalDataException
     *
     * @param message
     */
    public IllegalDataException(String message) {
        super(message);
    }
}
