package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class IntegerOperationProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        ADDING_SUBTRACTING,
        MULTIPLYING_DIVIDING,
        ALL_OPERATIONS,
        ORDER_OF_OPERATIONS_EASY,
        ORDER_OF_OPERATIONS_MEDIUM,
        ORDER_OF_OPERATIONS_HARD
    }

    public IntegerOperationProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Adding and Subtracting", Equation.ADDING_SUBTRACTING);
        selectionMap.put("Multiplying and Dividing", Equation.MULTIPLYING_DIVIDING);
        selectionMap.put("All Operations", Equation.ALL_OPERATIONS);
        selectionMap.put("Order of Operations (Easy)", Equation.ORDER_OF_OPERATIONS_EASY);
        selectionMap.put("Order of Operations (Medium)", Equation.ORDER_OF_OPERATIONS_MEDIUM);
        selectionMap.put("Order of Operations (Hard)", Equation.ORDER_OF_OPERATIONS_HARD);

        return selectionMap;
    }
}
