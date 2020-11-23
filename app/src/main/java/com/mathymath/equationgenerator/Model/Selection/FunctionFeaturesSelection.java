package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class FunctionFeaturesSelection extends SelectionList {

    public enum Equation implements EquationType {
        IS_FUNCTION,
        EVALUATING_FUNCTION_VALUES,
        DOMAIN_RANGE,
        INCREASING_DECREASING,
        TRANSFORMATIONS,
        RATE_OF_CHANGE,
        ALL_FEATURES
    }

    public FunctionFeaturesSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Is it a function?", Equation.IS_FUNCTION);
        selectionMap.put("Evaluating Function Values", Equation.EVALUATING_FUNCTION_VALUES);
        selectionMap.put("Domain and Range", Equation.DOMAIN_RANGE);
        selectionMap.put("Increasing and Decreasing", Equation.INCREASING_DECREASING);
        selectionMap.put("Transformations", Equation.TRANSFORMATIONS);
        selectionMap.put("Rate of Change", Equation.RATE_OF_CHANGE);
        selectionMap.put("All Features", Equation.ALL_FEATURES);

        return selectionMap;
    }
}
