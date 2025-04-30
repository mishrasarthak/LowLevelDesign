package exceptions;

public class IncompleteSubTasksException extends RuntimeException {
    public IncompleteSubTasksException(String message) {
        super(message);
    }
}
