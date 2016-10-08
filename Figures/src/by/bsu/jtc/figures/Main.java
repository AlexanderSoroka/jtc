package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.InvalidArgumentValue;
import by.bsu.jtc.figures.exceptions.NotEnoughArguments;
import by.bsu.jtc.figures.exceptions.UnknownFigure;

/**
 * Contains application entry point
 */
public class Main {
    private final static int GENERIC_ERROR = 1;

    /**
     * Creates specified figure and prints to stdout it area and perimeter.
     * If arguments are not valid print application usage method
     *
     * @param args - command line arguments, if arguments are
     */
    public static void main(String[] args) {
        try {
            FigureOptionsProvider options = new CommandLineOptionsProvider(args);
            Figure figure = (new FigureBuilder()).add(new Triangle.Builder())
                                                 .add(new Rectangle.Builder()).build(options);

            System.out.println("Figure: " + figure.toString());
            System.out.println("Area = " + figure.getArea());
            System.out.println("Perimeter = " + figure.getPerimeter());
        } catch (InvalidArgumentValue e) {
            System.err.println("Invalid argument: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        } catch (NotEnoughArguments e) {
            System.err.println("There are missed options/arguments: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        } catch (UnknownFigure e) {
            System.err.println("There is no builder associated with figure: " + e.getFigureName());
            System.exit(GENERIC_ERROR);
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
