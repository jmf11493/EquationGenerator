package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class SimilarFiguresSelection extends SelectionList {

    public enum Equation implements EquationType {
        DETERMINE_SCALE_FACTOR,
        CONVERT_SCALE_FACTOR,
        USE_SCALE_FACTOR,
    }

    public SimilarFiguresSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Determine the scale factor", Equation.DETERMINE_SCALE_FACTOR);
        selectionMap.put("Converting the scale factor", Equation.CONVERT_SCALE_FACTOR);
        selectionMap.put("Using the scale factor", Equation.USE_SCALE_FACTOR);

        return selectionMap;
    }
}
