package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;
import com.mathymath.equationgenerator.Model.UI.CardComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainViewSelection extends SelectionList {

    public enum Equation implements EquationType {
        EQUATION,
        EXPONENTIAL_PROBLEM,
        EXPRESSIONS,
        FRACTIONS_DECIMALS_PERCENTS,
        FUNCTION_FEATURES_PROBLEM,
        INTEGER_OPERATIONS_PROBLEM,
        LINEAR_PROBLEM,
        PERCENTS,
        POLYNOMIAL_PROBLEM,
        PROBABILITY,
        PROPORTIONAL_REASONING,
        PYTHAGOREAN_TRIPLE,
        QUADRATIC_EQUATIONS,
        SEQUENCES_PROBLEM,
        SHAPES,
        STATISTICS_PROBLEM,
        SYSTEMS_OF_EQUATIONS,
        SIMILAR_FIGURES,
        VOLUME
    }

    private ArrayList<CardComponent> cardComponents = new ArrayList<>();

    public MainViewSelection() {
        createSelection();
    }

    @Override
    public LinkedHashMap< String, EquationType > createMap() {
        createSelection();

        LinkedHashMap< String, EquationType > selectionMap = new LinkedHashMap<>();

        for (CardComponent component : getCardComponents()) {
            selectionMap.put(component.getName(), component.getType());
        }

        return selectionMap;
    }

    private void createSelection() {

        cardComponents.add( new CardComponent( "Fraction, Decimal, and Percent Conversions", "6th and 7th grade", "convert, other, forms", Equation.FRACTIONS_DECIMALS_PERCENTS ) );

        cardComponents.add( new CardComponent( "Equations", "Math 7, Pre-Algebra, Algebra I", "equations, types, random, values", Equation.EQUATION ) );

        // Math 7
        cardComponents.add( new CardComponent( "2D and 3D Shapes", "Math 7", "angles, triangles, circles, volume, surface, area", Equation.SHAPES ) );
        cardComponents.add( new CardComponent( "Expressions", "Math 7", "translating, evaluating, simplifying, distributing, factoring, expressions", Equation.EXPRESSIONS ) );
        cardComponents.add( new CardComponent( "Integer Operations", "Math 7", "operations, integer, order of", Equation.INTEGER_OPERATIONS_PROBLEM ) );
        cardComponents.add( new CardComponent( "Percents", "Math 7", "percents, change, word, problems", Equation.PERCENTS ) );
        cardComponents.add( new CardComponent( "Probability", "Math 7", "theoretical, experimental, compound, probability", Equation.PROBABILITY ) );
        cardComponents.add( new CardComponent( "Proportional Reasoning", "Math 7", "proportions, proportional reasoning, word, problems", Equation.PROPORTIONAL_REASONING ) );
        cardComponents.add( new CardComponent( "Statistics", "Math 7", "mean, median, mode, range, five number summary, IQR, interquartile, range", Equation.STATISTICS_PROBLEM ) );
        cardComponents.add( new CardComponent( "Similar Figures", "Math 7", "scale, factor, shapes", Equation.SIMILAR_FIGURES ) );

        // Pre Algebra
        cardComponents.add( new CardComponent( "Linear", "Pre-Algebra", "linear, relationships", Equation.LINEAR_PROBLEM ) );
        cardComponents.add( new CardComponent( "Volume of 3D Shapes", "Pre-Algebra", "cylinders, cones, spheres, hemispheres", Equation.VOLUME ) );
        cardComponents.add( new CardComponent( "Exponents and Scientific Notation", "Pre-Algebra, Algebra I", "laws of exponents, scientific, notation", Equation.EXPONENTIAL_PROBLEM ) );
        cardComponents.add( new CardComponent( "Pythagorean Theorem", "Pre-Algebra, Algebra I", "right, triangles", Equation.PYTHAGOREAN_TRIPLE ) );
        cardComponents.add( new CardComponent( "Systems of Equations", "Pre-Algebra, Algebra I", "linear, equations, algebraic, solution", Equation.SYSTEMS_OF_EQUATIONS ) );

        // Algebra
        cardComponents.add( new CardComponent( "Arithmetic and Geometric Sequences", "Algebra I", "explicit, recursive", Equation.SEQUENCES_PROBLEM ) );
        cardComponents.add( new CardComponent( "Function Features", "Algebra I", "operations, integer, values, order of", Equation.FUNCTION_FEATURES_PROBLEM ) );
        cardComponents.add( new CardComponent( "Polynomial Operations", "Algebra I", "addition, subtraction, multiplying, factoring, polynomial", Equation.POLYNOMIAL_PROBLEM ) );
        cardComponents.add( new CardComponent( "Quadratic Equations", "Algebra I", "quadratic, equations", Equation.QUADRATIC_EQUATIONS ) );

    }

    public CardComponent[] getCardComponents() {
        CardComponent[] retCardComponents = new CardComponent[ cardComponents.size() ];
        retCardComponents = cardComponents.toArray( retCardComponents );

        return retCardComponents;
    }
}
