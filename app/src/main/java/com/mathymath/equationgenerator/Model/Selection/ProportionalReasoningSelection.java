package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class ProportionalReasoningSelection extends SelectionList {

    public enum Equation implements EquationType {
        SOLVING_PROPORTIONS,
        WRITING_SOLVING_PROPORTIONS
    }

    public ProportionalReasoningSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Solving Proportions", Equation.SOLVING_PROPORTIONS);
        selectionMap.put("Writing and Solving Proportions", Equation.WRITING_SOLVING_PROPORTIONS);

        return selectionMap;
    }
}
