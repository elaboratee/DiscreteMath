package exceptions;

public class FileInputException extends Exception {
    public FileInputException() {
    }

    public FileInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileInputException(String string) {
        super(string);
    }

    public FileInputException(Throwable cause) {
        super(cause);
    }
}
