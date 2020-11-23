package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class SequenceProblemSelection extends SelectionList {

    public enum Equation implements EquationType {
        RECURSIVE_TO_EXPLICIT,
        EXPLICIT_TO_RECURSIVE,
        SEQUENCE_TO_EXPLICIT
    }

    public SequenceProblemSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Recursive to Explicit", Equation.RECURSIVE_TO_EXPLICIT);
        selectionMap.put("Explicit to Recursive", Equation.EXPLICIT_TO_RECURSIVE);
        selectionMap.put("Sequence to Explicit", Equation.SEQUENCE_TO_EXPLICIT);

        return selectionMap;
    }
}
