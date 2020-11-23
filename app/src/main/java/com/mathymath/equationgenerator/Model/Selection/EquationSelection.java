package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class EquationSelection extends SelectionList {

    public enum Equation implements EquationType {
        ONE_STEP,
        TWO_STEP,
        TWO_STEP_DISTRIBUTING,
        COMBINING_LIKE_TERMS,
        VARIABLES_BOTH_SIDES,
        VARIABLES_BOTH_SIDES_COMBINING,
        VARIABLES_BOTH_SIDES_DISTRIBUTIVE,
        DIFFICULT_MULTI_STEP_EQUATION,
        VARIABLES_BOTH_SIDES_DISTRIBUTIVE_FRACTION,
        VARIABLES_BOTH_SIDES_DISTRIBUTIVE_COMBINING
    }

    public EquationSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("One-Step", Equation.ONE_STEP);
        selectionMap.put("Two-Step", Equation.TWO_STEP);
        selectionMap.put("Two-Step with Distributing", Equation.TWO_STEP_DISTRIBUTING);
        selectionMap.put("Combining Like Terms", Equation.COMBINING_LIKE_TERMS);
        selectionMap.put("Variables on Both Sides", Equation.VARIABLES_BOTH_SIDES);
        selectionMap.put("Variables on Both Sides with Combining", Equation.VARIABLES_BOTH_SIDES_COMBINING);
        selectionMap.put("Variables on Both Sides with Distributing", Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE);
        selectionMap.put("Difficult Mult-Step Equation", Equation.DIFFICULT_MULTI_STEP_EQUATION);
        selectionMap.put("Variables on Both Sides with Distributing and Fractions", Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE_FRACTION);
        selectionMap.put("Variables on Both Sides with Distributing and Combining", Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE_COMBINING);

        return selectionMap;
    }
}
