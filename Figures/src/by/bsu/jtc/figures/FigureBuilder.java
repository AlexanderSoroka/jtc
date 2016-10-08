package by.bsu.jtc.figures;

import by.bsu.jtc.figures.exceptions.InvalidArgumentValue;
import by.bsu.jtc.figures.exceptions.NotEnoughArguments;
import by.bsu.jtc.figures.exceptions.UnknownFigure;

import java.util.ArrayList;

/**
 * Implements chain of responsibilities. Chain contains concrete figure builders
 * and responsibility of every builder is to build only one concrete figure
 */
public class FigureBuilder {
    private ArrayList<Figure.Builder> builders = new ArrayList<>();

    /**
     * Add concrete builder to the builders chain
     * @param builder Concrete builder is being added to chain
     * @return this
     */
    public FigureBuilder add(Figure.Builder builder) {
        builders.add(builder);
        return this;
    }

    /**
     * Actually perform build of figure
     * @param option Figure options
     * @throws InvalidArgumentValue If argument specified but has invalid value
     * @throws NotEnoughArguments If there are not enough arguments to build specified figure
     * @throws UnknownFigure If figure specified but there is no associated builder that can build this figure
     */
    public Figure build(FigureOptionsProvider option) throws InvalidArgumentValue,
            NotEnoughArguments, UnknownFigure {
        for (Figure.Builder builder : builders) {
            if (builder.canBuild(option)) {
                return builder.build(option);
            }
        }

        throw new UnknownFigure(option.getFigure());
    }
}
