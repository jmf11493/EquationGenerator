package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class PercentsSelection extends SelectionList {

    public enum Equation implements EquationType {
        PERCENT_OF_A_NUMBER,
        DETERMINING_PERCENTS,
        PERCENT_CHANGE,
        TOTAL_ORIGINAL
    }

    public PercentsSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put( "Determine the Part", Equation.PERCENT_OF_A_NUMBER );
        selectionMap.put( "Determine the Percent", Equation.DETERMINING_PERCENTS );
        selectionMap.put( "Determine the Total", Equation.TOTAL_ORIGINAL );
        selectionMap.put( "Percent Change", Equation.PERCENT_CHANGE );
        return selectionMap;
    }
}
