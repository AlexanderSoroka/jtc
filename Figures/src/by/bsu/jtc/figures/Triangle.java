package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.InvalidArgumentValue;
import by.bsu.jtc.figures.exceptions.NotEnoughArguments;

/**
 * Represents generic triangle
 * @author alexander
 */
public class Triangle extends Figure {
    private static final String NAME = "triangle";
    private static final int SIDES_COUNT = 3;

    private double[] sides = new double[SIDES_COUNT];

    /**
     * Triangle builder performs options validation & create new Triangle instance
     * @author alexander
     */
    public static class Builder extends Figure.Builder {
        @Override
        public boolean canBuild(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue {
            if (!options.getFigure().equals(Triangle.NAME)) {
                return false;
            }

            double sides[] = options.getNumbers(Triangle.SIDES_COUNT);
            for (double d : sides) {
                if (d < Math.ulp(d)) {
                    throw new InvalidArgumentValue("Value " + d + "  is less then or equal to 0");
                }

                if (!Double.isFinite(d)) {
                    throw new InvalidArgumentValue("One of sides is specified by infinite value");
                }
            }

            if (!Double.isFinite(sides[0] + sides[1]) || !Double.isFinite(sides[0] + sides[1] + sides[2])) {
                throw new InvalidArgumentValue("Sides summ is too big");
            }

            // @todo: check if triangle exists

            return true;
        }

        @Override
        public Figure build(FigureOptionsProvider options) throws NotEnoughArguments, InvalidArgumentValue {
            canBuild(options);
            return new Triangle(options.getNumbers(Triangle.SIDES_COUNT));
        }
    }

    /**
     * Initialize triangle with specified sides. It supposed that at least 3 sides are specified
     * @param sides Triangle sides
     */
    private Triangle(double[] sides) {
        this.sides = sides;
    }

    @Override
    public double getArea() {
        double halfPerimeter = 0.5 * (sides[0] + sides[1] + sides[2]);
        return Math.sqrt(halfPerimeter * (halfPerimeter - sides[0])
                                       * (halfPerimeter - sides[1])
                                       * (halfPerimeter - sides[2]));
    }

    @Override
    public double getPerimeter() {
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public String toString() {
        return NAME;
    }
}
