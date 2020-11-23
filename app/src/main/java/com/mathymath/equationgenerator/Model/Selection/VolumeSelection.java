package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class VolumeSelection extends SelectionList {

    public enum Equation implements EquationType {
        FINDING_VOLUME,
        WORKING_BACKWARDS
    }

    public VolumeSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Finding Volume", Equation.FINDING_VOLUME);
        selectionMap.put("Working Backwards", Equation.WORKING_BACKWARDS);

        return selectionMap;
    }
}
