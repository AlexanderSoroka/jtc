package by.bsu.jtc.figures.exceptions;

/**
 * It's thrown when user doesn't give us all required arguments
 * @author alexander
 */
public class NotEnoughArguments extends Throwable {
    /**
     * Trivial constructor initializes exception message
     * @param message Exception message
     */
    public NotEnoughArguments(String message) {
        super(message);
    }
}
