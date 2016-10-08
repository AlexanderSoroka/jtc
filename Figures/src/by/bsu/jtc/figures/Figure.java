package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.InvalidArgumentValue;
import by.bsu.jtc.figures.exceptions.NotEnoughArguments;

/**
 * Represents geometric figure with some visible size that
 * can be described by occupied area and some perimeter
 * @author alexander
 */
public abstract class Figure {
    /**
     * @todo: improve comment
     */
    public static abstract class Builder {
        /**
         * Check if specific builder can build figure with the specified options
         * @param options Options which specify figure
         * @return true if the builder is responsible to build the requested figure,
         *         false otherwise
         * @throws NotEnoughArguments if specific builder is responsible to build the figure
         *         but there are not enough parameters to build it
         * @throws InvalidArgumentValue if one argument has invalid value
         */
        public abstract boolean canBuild(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue;

        /**
         * Builds specific figure based on some parameters
         * @param options Options which specify figure
         * @return Created figure
         * @throws NotEnoughArguments if specific builder is responsible to build the figure
         *         but there are not enough parameters to build it
         * @throws InvalidArgumentValue if one argument has invalid value
         */
        public abstract Figure build(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue;
    }

    /**
     * @return Figure area
     */
    public abstract double getArea();

    /**
     * @return Figure perimeter
     */
    public abstract double getPerimeter();

    /**
     * Force concrete figures to override this
     * @return Human-readable figure name
     */
    @Override
    public abstract String toString();
}
