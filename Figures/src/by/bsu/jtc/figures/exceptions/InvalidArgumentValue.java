package by.bsu.jtc.figures.exceptions;

/**
 * It's thrown if invalid argument value is detected
 * @author alexander
 */
public class InvalidArgumentValue extends Throwable {
    /**
     * Trivial constructor just setups exception message
     * @param message What exactly went wrong
     */
    public InvalidArgumentValue(String message) {
        super(message);
    }
}
