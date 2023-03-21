package logging_system.company.exception;

public class FileMaxSizeReachedException extends Exception {

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
