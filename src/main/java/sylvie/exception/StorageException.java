package sylvie.exception;

public class StorageException extends SylvieException {
    public StorageException() {
        super("Failed to save data.");
    }
}
