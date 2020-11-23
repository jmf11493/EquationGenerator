package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class StatisticsProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        MEAN_MED_MODE_RANGE,
        MEAN_MAD,
        MIN_Q1_MED_Q3_MAX
    }

    public StatisticsProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Mean, Median, Mode, Range", Equation.MEAN_MED_MODE_RANGE);
        selectionMap.put("Mean and MAD", Equation.MEAN_MAD);
        selectionMap.put("Min, Q1, Median, Q3, Max", Equation.MIN_Q1_MED_Q3_MAX);

        return selectionMap;
    }
}
