package by.bsu.jtc.figures;

import java.util.ArrayList;

import by.bsu.jtc.figures.exceptions.NotEnoughArguments;

/**
 * Parses command line arguments and extracts options from it
 * @author alexander
 */
public class CommandLineOptionsProvider extends FigureOptionsProvider {
    private final String TYPE_PREFIX = "--type=";
    private final String SEPARATOR_SIGN = "=";

    private String figure;
    private ArrayList<Double> numbers = new ArrayList<Double>();

    /**
     * Construct an object by parsing specified command line arguments
     * @param args Command line arguments
     * @throws NotEnoughArguments if no figure name is specified in arguments
     */
    CommandLineOptionsProvider(String[] args) throws NotEnoughArguments {
        for (String s : args) {
            if (s.startsWith(TYPE_PREFIX)) {
                figure = s.substring(TYPE_PREFIX.length());
            } else {
                numbers.add(Double.parseDouble(s.substring(s.lastIndexOf(SEPARATOR_SIGN) + 1)));
            }
        }

        if (figure == null || figure.isEmpty()) {
            throw new NotEnoughArguments("Figure is not specified");
        }
    }

    /**
     * It guaranties that it never returns empty string or null
     * @return Figure name specified in command line
     */
    @Override
    public String getFigure() {
        return figure;
    }

    @Override
    public double[] getNumbers(int count) throws NotEnoughArguments {
        if (count > numbers.size()) {
            throw new NotEnoughArguments(numbers.size() + " numbers specified but "
                    + count + " needed");
        }
        double[] array = new double[count];

        for (int i = 0; i < count; i++) {
            array[i] = numbers.get(i).doubleValue();
        }

        return array;
    }

}
