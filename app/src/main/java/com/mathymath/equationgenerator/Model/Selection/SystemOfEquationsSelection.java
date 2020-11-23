package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class SystemOfEquationsSelection extends SelectionList {

    public enum Equation implements EquationType {
        ELIMINATION,
        GRAPHING,
        SUBSTITUTION,
        ALL
    }

    public SystemOfEquationsSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Elimination", Equation.ELIMINATION);
        selectionMap.put("Graphing", Equation.GRAPHING);
        selectionMap.put("Substitution", Equation.SUBSTITUTION);
        selectionMap.put("All", Equation.ALL);

        return selectionMap;
    }
}
