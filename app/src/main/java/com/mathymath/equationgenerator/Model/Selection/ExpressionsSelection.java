package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class ExpressionsSelection extends SelectionList {

    public enum Equation implements EquationType {
        TRANSLATING_WORDS,
        EVALUATING_EXPRESSIONS,
        COMBINING_LIKE_TERMS,
        DISTRIBUTING,
        DISTRIBUTING_AND_COMBINING,
        FACTORING
    }

    public ExpressionsSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Translating Words to Expressions", Equation.TRANSLATING_WORDS);
        selectionMap.put("Evaluating Expressions", Equation.EVALUATING_EXPRESSIONS);
        selectionMap.put("Combining Like Terms", Equation.COMBINING_LIKE_TERMS);
        selectionMap.put("Distributing", Equation.DISTRIBUTING);
        selectionMap.put("Distributing and Combining", Equation.DISTRIBUTING_AND_COMBINING);
        selectionMap.put("Factoring", Equation.FACTORING);

        return selectionMap;
    }
}
