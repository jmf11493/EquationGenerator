package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class QuadraticFunctionsProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        ALL_METHODS,
        QUADRATIC_FORMULA,
        COMPLETING_THE_SQUARE,
        SQUARE_ROOTS,
        FACTORING_OUT_GCF,
        FACTORING_TRINOMIALS_A_1,
        FACTORING_TRINOMIALS_A_NOT_1
    }

    public QuadraticFunctionsProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Factoring out the GCF", Equation.FACTORING_OUT_GCF);
        selectionMap.put("Factoring Trinomials A = 1", Equation.FACTORING_TRINOMIALS_A_1);
        selectionMap.put("Factoring Trinomials A not 1", Equation.FACTORING_TRINOMIALS_A_NOT_1);
        selectionMap.put("Square Roots", Equation.SQUARE_ROOTS);
        selectionMap.put("Completing the Square", Equation.COMPLETING_THE_SQUARE);
        selectionMap.put("Quadratic Formula", Equation.QUADRATIC_FORMULA);
        selectionMap.put("All Methods", Equation.ALL_METHODS);

        return selectionMap;
    }
}
