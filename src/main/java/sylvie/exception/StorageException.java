package sylvie.exception;

/**
 * Represents an exception that occurs during storage operations.
 */
public class StorageException extends SylvieException {
    /**
     * Creates a new StorageException with the specified message.
     *
     * @param message
     */
    public StorageException(String message) {
        super(message);
    }
}
