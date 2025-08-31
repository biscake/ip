package sylvie.exception;

/**
 * Base exception class for Sylvie-related exceptions.
 */
public class SylvieException extends Exception {
    /**
     * Constructor for SylvieException
     *
     * @param message
     */
    public SylvieException(String message) {
        super(message);
    }
}
