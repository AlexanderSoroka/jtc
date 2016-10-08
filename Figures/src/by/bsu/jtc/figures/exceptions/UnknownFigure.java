package by.bsu.jtc.figures.exceptions;

/**
 * Indicates that there is no registered builder for concrete figure
 * @author alexander
 */
public class UnknownFigure extends Throwable {
    private String figureName;

    /**
     * Constructs exception with specified figure name
     * @param figureName Figure name that is not associated with any builders
     */
    public UnknownFigure(String figureName) {
        this.figureName = figureName;
    }

    public String getFigureName() {
        return figureName;
    }
}
