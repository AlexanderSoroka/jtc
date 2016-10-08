package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.InvalidArgumentValue;
import by.bsu.jtc.figures.exceptions.NotEnoughArguments;

/**
 * Represents generic rectangle
 * @author alexander
 */
public class Rectangle extends Figure {
    private static final String NAME = "rectangle";
    private static final int SIDES_COUNT = 2;

    private double[] sides = new double[SIDES_COUNT];

    /**
     * Rectangle builder performs options validation & create new Rectangle instance
     * @author alexander
     */
    public static class Builder extends Figure.Builder {
        @Override
        public boolean canBuild(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue {
            if (!options.getFigure().equals(Rectangle.NAME)) {
                return false;
            }

            double sides[] = options.getNumbers(Rectangle.SIDES_COUNT);
            for (double d : sides) {
                if (d < Math.ulp(d)) {
                    throw new InvalidArgumentValue("Value " + d + "  is less then or equal to 0");
                }

                if (!Double.isFinite(d)) {
                    throw new InvalidArgumentValue("One of sides is specified by infinite value");
                }
            }

            if (!Double.isFinite(sides[0] + sides[1]) || !Double.isFinite(sides[0] * sides[1])) {
                throw new InvalidArgumentValue("Sides are too big");
            }

            return true;
        }

        @Override
        public Figure build(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue {
            canBuild(options);
            return new Rectangle(options.getNumbers(Rectangle.SIDES_COUNT));
        }
    }

    /**
     * Initialize rectangle with specified sides
     * @param sides Rectangle sides
     */
    private Rectangle(double[] sides) {
        this.sides = sides;
    }

    @Override
    public double getArea() {
        return sides[0] * sides[1];
    }

    @Override
    public double getPerimeter() {
        return 2 * (sides[0] + sides[1]);
    }

    @Override
    public String toString() {
        return NAME;
    }
}
