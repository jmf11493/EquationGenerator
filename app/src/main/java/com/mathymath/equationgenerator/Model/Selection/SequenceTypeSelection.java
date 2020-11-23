package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class SequenceTypeSelection extends SelectionList {

    public enum Equation implements EquationType {
        ARITHMETIC,
        GEOMETRIC,
        BOTH
    }

    public SequenceTypeSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Arithmetic", Equation.ARITHMETIC);
        selectionMap.put("Geometric", Equation.GEOMETRIC);
        selectionMap.put("Both", Equation.BOTH);

        return selectionMap;
    }
}
