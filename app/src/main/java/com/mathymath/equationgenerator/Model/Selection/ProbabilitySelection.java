package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class ProbabilitySelection extends SelectionList {

    public enum Equation implements EquationType {
        THEORETICAL,
        EXPERIMENTAL,
        THEORETICAL_COMPOUND,
        EXPERIMENTAL_COMPOUND
    }

    public ProbabilitySelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Theoretical", Equation.THEORETICAL);
        selectionMap.put("Experimental", Equation.EXPERIMENTAL);
        selectionMap.put("Theoretical Compound", Equation.THEORETICAL_COMPOUND);
        selectionMap.put("Experimental Compound", Equation.EXPERIMENTAL_COMPOUND);
        return selectionMap;
    }
}
