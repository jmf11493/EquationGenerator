package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class ExponentialProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        EXPONENT_MULTIPLYING,
        EXPONENT_DIVIDING,
        EXPONENT_POWER,
        EXPONENT_MULTI_STEP,
        SCI_NOTATION_CONVERTING,
        SCI_NOTATION_ADDING_SUBTRACTING,
        SCI_NOTATION_MULTIPLYING_DIVIDING
    }

    public ExponentialProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Exponents: Multiplying", Equation.EXPONENT_MULTIPLYING);
        selectionMap.put("Exponents: Dividing", Equation.EXPONENT_DIVIDING);
        selectionMap.put("Power to a Power", Equation.EXPONENT_POWER);
        selectionMap.put("Exponents: Multi-Step", Equation.EXPONENT_MULTI_STEP);
        selectionMap.put("Sci Notation: Converting", Equation.SCI_NOTATION_CONVERTING);
        selectionMap.put("Sci Notation: Adding & Subtracting", Equation.SCI_NOTATION_ADDING_SUBTRACTING);
        selectionMap.put("Sci Notation: Multiplying & Dividing", Equation.SCI_NOTATION_MULTIPLYING_DIVIDING);

        return selectionMap;
    }
}
