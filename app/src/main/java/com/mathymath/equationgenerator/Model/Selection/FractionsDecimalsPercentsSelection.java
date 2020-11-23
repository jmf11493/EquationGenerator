package com.mathymath.equationgenerator.Model.Selection;

import com.mathymath.equationgenerator.Model.EquationType;

import java.util.LinkedHashMap;

public class FractionsDecimalsPercentsSelection extends SelectionList {

    public enum Equation implements EquationType {
        FRACTION,
        DECIMAL,
        PERCENT
    }

    public FractionsDecimalsPercentsSelection() {
        // Nothing
    }

    @Override
    public LinkedHashMap< String, EquationType > createMap() {
        LinkedHashMap< String, EquationType > selectionMap = new LinkedHashMap<>();

        selectionMap.put( "Fraction to Decimal & Percent", Equation.FRACTION );
        selectionMap.put( "Decimal to Fraction & Percent", Equation.DECIMAL );
        selectionMap.put( "Percent to Fraction & Decimal", Equation.PERCENT );
        return selectionMap;
    }
}
