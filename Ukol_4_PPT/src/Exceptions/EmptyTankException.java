package Exceptions;

public class EmptyTankException extends RuntimeException {
    public EmptyTankException(String message) {
        super(message);
    }
}
