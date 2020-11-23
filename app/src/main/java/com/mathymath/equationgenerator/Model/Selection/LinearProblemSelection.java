package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class LinearProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        TWO_POINTS_SLOPE,
        TWO_POINTS_EQUATION,
        TABLE_FIND_SLOPE,
        TABLE_WRITE_EQUATION,
        REWRITE_SLOPE_INTERCEPT,
        FIND_SLOPE_Y_INTERCEPT,
    }

    public LinearProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Given two points, find slope", Equation.TWO_POINTS_SLOPE);
        selectionMap.put("Given two points, write equation", Equation.TWO_POINTS_EQUATION);
        selectionMap.put("Given table, find slope", Equation.TABLE_FIND_SLOPE);
        selectionMap.put("Given table, write equation", Equation.TABLE_WRITE_EQUATION);
        selectionMap.put("Rewrite in slope-intercept form", Equation.REWRITE_SLOPE_INTERCEPT);
        selectionMap.put("Find slope and y-intercept of an equation", Equation.FIND_SLOPE_Y_INTERCEPT);

        return selectionMap;
    }
}
