package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class PythagoreanTheoremSelection extends SelectionList {

    public enum Equation implements EquationType {
        DETERMINE_MISSING_LENGTHS,
        IS_RIGHT_TRIANGLE
    }

    public PythagoreanTheoremSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Determine Missing Lengths", Equation.DETERMINE_MISSING_LENGTHS);
        selectionMap.put("Is it a Right Triangle?", Equation.IS_RIGHT_TRIANGLE);

        return selectionMap;
    }
}
