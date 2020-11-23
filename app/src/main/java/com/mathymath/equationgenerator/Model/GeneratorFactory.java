package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.MainViewSelection;

public class GeneratorFactory {

    public GeneratorFactory() {}

    public static Generator getGenerator(MainViewSelection.Equation selection) {
        Generator generator = null;

        switch (selection) {
            case EQUATION:
                generator = new Equation();
                break;
            case EXPRESSIONS:
                generator = new Expressions();
                break;
            case EXPONENTIAL_PROBLEM:
                generator = new ExponentialProblem();
                break;
            case FRACTIONS_DECIMALS_PERCENTS:
                generator = new FractionsDecimalsPercents();
                break;
            case FUNCTION_FEATURES_PROBLEM:
                generator = new FunctionFeatures();
                break;
            case INTEGER_OPERATIONS_PROBLEM:
                generator = new IntegerOperationProblem();
                break;
            case LINEAR_PROBLEM:
                generator = new LinearProblem();
                break;
            case PERCENTS:
                generator = new Percents();
                break;
            case PROBABILITY:
                generator = new Probability();
                break;
            case PROPORTIONAL_REASONING:
                generator = new ProportionalReasoning();
                break;
            case POLYNOMIAL_PROBLEM:
                generator = new PolynomialOperation();
                break;
            case PYTHAGOREAN_TRIPLE:
                generator = new PythagoreanTheoremProblem();
                break;
            case QUADRATIC_EQUATIONS:
                generator = new QuadraticProblem();
                break;
            case SEQUENCES_PROBLEM:
                generator = new SequencesProblem();
                break;
            case SHAPES:
                generator = new Shapes();
                break;
            case STATISTICS_PROBLEM:
                generator = new StatisticsProblem();
                break;
            case SYSTEMS_OF_EQUATIONS:
                generator = new SystemOfEquations();
                break;
            case SIMILAR_FIGURES:
                generator = new SimilarFigures();
                break;
            case VOLUME:
                generator = new Volume();
                break;
            default:
                // Nothing
                // TODO Throw Error
        }

        return generator;
    }
}
