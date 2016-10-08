package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.NotEnoughArguments;

/**
 * Provides options to build a figure such as figure type its sides and so on
 * @author alexander
 */
public abstract class FigureOptionsProvider {

    /**
     * @return Human readable figure name
     */
    public abstract String getFigure();

    /**
     * @param count How many numbers are needed
     * @return First "count" numbers as double array
     * @throws NotEnoughArguments If there are less numbers then count
     */
    public abstract double[] getNumbers(int count) throws NotEnoughArguments ;
}