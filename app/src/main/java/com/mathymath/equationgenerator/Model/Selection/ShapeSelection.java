package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class ShapeSelection extends SelectionList {

    public enum Equation implements EquationType {
        ANGLES,
        TRIANGLES,
        CIRCLES,
        VOLUME_OF_PRISMS,
        SURFACE_AREA
    }

    public ShapeSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap<String, EquationType> createMap() {
        LinkedHashMap<String, EquationType> selectionMap = new LinkedHashMap<>();

        selectionMap.put("Angles", Equation.ANGLES);
        selectionMap.put("Triangles", Equation.TRIANGLES);
        selectionMap.put("Circles", Equation.CIRCLES);
        selectionMap.put("Volume of Prisms", Equation.VOLUME_OF_PRISMS);
        selectionMap.put("Surface Area", Equation.SURFACE_AREA);

        return selectionMap;
    }
}
