package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class PolynomialOperationSelection extends SelectionList {

    public enum Equation implements EquationType {
        ADDING_SUBTRACTING,
        MULTIPLYING,
        DIVIDING,
        FACTORING_OUT_GCF,
        FACTORING_TRINOMIALS_A_1,
        FACTORING_TRINOMIALS_A_NOT_1
    }

    public PolynomialOperationSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Adding and Subtracting", Equation.ADDING_SUBTRACTING);
        selectionMap.put("Multiplying", Equation.MULTIPLYING);
        selectionMap.put("Dividing", Equation.DIVIDING);
        selectionMap.put("Factoring out the GCF", Equation.FACTORING_OUT_GCF);
        selectionMap.put("Factoring Trinomials A = 1", Equation.FACTORING_TRINOMIALS_A_1);
        selectionMap.put("Factoring Trinomials A not 1", Equation.FACTORING_TRINOMIALS_A_NOT_1);

        return selectionMap;
    }
}
