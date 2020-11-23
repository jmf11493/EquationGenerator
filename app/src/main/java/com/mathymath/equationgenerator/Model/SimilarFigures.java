package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SimilarFiguresSelection;

import java.math.BigDecimal;

public class SimilarFigures extends Generator {

    private final BigDecimal two = new BigDecimal( "2" );

    private final BigDecimal ten = new BigDecimal( "10" );

    private final BigDecimal oneHundred = new BigDecimal( "100" );

    public SimilarFigures() {
        super();
        selectionList = new SimilarFiguresSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation( util.removeDoubleSigns( equation ) );
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( answer );
    }

    @Override
    public void generate() {
        switch ( ( SimilarFiguresSelection.Equation ) type ) {
            case DETERMINE_SCALE_FACTOR:
                determineScaleFactor();
                break;
            case CONVERT_SCALE_FACTOR:
                convertScaleFactor();
                break;
            case USE_SCALE_FACTOR:
                useScaleFactor();
                break;
            default:
                // Nothing
        }
    }

    private void determineScaleFactor() {
        int sf = util.randomInt( 2, 10 );
        answer = "Scale factor \\(= " + sf + "\\)";

        switch ( util.randomInt( 0, 4 ) ) {
            // Using corresponding points, determine the scale factor
            case 0:
                int a = util.randomInt( -10, 10 );
                int b = util.randomInt( -10, 10 );
                int c = a * sf;
                int d = b * sf;
                equation = "A scale factor is applied to coordinate point \\((" + a + ", " + b + ")\\) to become the new point \\((" + c + ", " + d + ")\\). What is the scale factor?";
                break;
            // Using corresponding side lengths, determine the scale factor
            case 1:
                a = util.randomInt( 2, 20 );
                b = sf * a;
                equation = "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If \\(AB\\) corresponds to \\(DE\\), \\(AB=" + a + "\\), and \\(DE=" + b + "\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ";
                break;
            // Using corresponding perimeters, determine the scale factor
            case 2:
                a = util.randomInt( 15, 100 );
                b = sf * a;
                equation = "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the perimeter of \\(ABC\\) is \\(" + a + "\\) and the perimeter of \\(DEF\\) is \\(" + b + "\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ";
                break;
            // Using corresponding areas, determine the scale factor
            case 3:
                a = util.randomInt( 15, 50 );
                b = sf * sf * a;
                equation = "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the area of \\(ABC\\) is \\(" + a + "\\) and the area of \\(DEF\\) is \\(" + b + "\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ";
                break;
            // Using scale factor from A to B, find scale factor from B to A
            case 4:
                equation = "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the scale factor from \\(DEF\\) to \\(ABC\\) is \\(\\frac{1}{" + sf + "}\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ";
                break;
            default:
                // Nothing
        }
    }

    private void convertScaleFactor() {
        BigDecimal sf = util.randomDecimal( two, ten, 1 );
        // percent
        BigDecimal a = sf.multiply( oneHundred );
        // rule
        String b = "\\((" + sf + "x, " + sf + "y)\\)";

        switch ( util.randomInt( 0, 2 ) ) {
            // Decimal to rule and percent
            case 0:
                equation = "The scale factor from shape \\(A\\) to shape \\(B\\) is \\(" + sf + "\\). What is this written as a percent and as a coordinate rule?";
                answer = "Percent = \\(" + a + "\\%\\), Rule = " + b;
                break;
            // Rule to decimal and percent
            case 1:
                equation = "The scale factor from shape \\(A\\) to shape \\(B\\) is \\(" + a + "\\%\\). What is this written as a decimal and as a coordinate rule?";
                answer = "Decimal = \\(" + sf + "\\), Rule = " + b;
                break;
            // Percent to decimal and rule
            case 2:
                equation = "The rule from shape \\(A\\) to shape \\(B\\) is " + b + ". What is the scale factor written as a decimal and as a percent?";
                answer = "Decimal = \\(" + sf + "\\), Percent = \\(" + a + "\\%\\)";
                break;
            default:
                // Nothing
        }
    }

    private void useScaleFactor() {
        BigDecimal sf = util.randomDecimal( two, ten, 1 );
        // percent
        BigDecimal a = sf.multiply( oneHundred );
        // rule
        String b = "\\((" + sf + "x, " + sf + "y)\\)";
        Integer c, d;
        BigDecimal e, f;

        equation = "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>";
        // determine the format of the scale factor
        switch ( util.randomInt( 0, 2 ) ) {
            // scale factor is a decimal
            case 0:
                equation += "The scale factor from \\(ABC\\) to \\(DEF\\) is \\(" + sf + "\\).";
                break;
            // scale factor is a percent
            case 1:
                equation += "The scale factor from \\(ABC\\) to \\(DEF\\) is \\(" + a + "\\%\\).";
                break;
            // scale factor is given as a rule
            case 2:
                equation += "The rule from \\(ABC\\) to \\(DEF\\) is " + b + ".";
                break;
            default:
                // Nothing
        }

        // determine the affected parts
        switch ( util.randomInt( 0, 4 ) ) {
            // coordinates (*sf)
            case 0:
                c = util.randomInt( -10, 10 );
                d = util.randomInt( -10, 10 );
                e = sf.multiply( new BigDecimal( c.toString() ) );
                f = sf.multiply( new BigDecimal( d.toString() ) );

                equation += " If \\(A = (" + c + ", " + d + ")\\) corresponds to \\(D\\), what are the coordinates of \\(D\\)?";
                answer = "\\(D = (" + e + ", " + f + ")\\)";
                break;
            // side lengths (*sf)
            case 1:
                c = util.randomInt( 2, 15 );
                f = sf.multiply( new BigDecimal( c.toString() ) );

                equation += " If \\(AB = " + c + "\\) and \\(AB\\) corresponds to \\(DE\\), what is the length of \\(DE\\)?";
                answer = "\\(DE = " + f + "\\)";
                break;
            // perimeters (*sf)
            case 2:
                c = util.randomInt( 10, 50 );
                f = sf.multiply( new BigDecimal( c.toString() ) );

                equation += " If the perimeter of \\(ABC\\) is \\(" + c + "\\), what is the perimeter of \\(DEF\\)?";
                answer = "The perimeter of \\(DEF\\) is \\(" + f + "\\)";
                break;
            // areas (*sf*sf)
            case 3:
                c = util.randomInt( 10, 50 );
                f = sf.multiply( sf ).multiply( new BigDecimal( c.toString() ) );

                equation += " If the area of \\(ABC\\) is \\(" + c + "\\), what is the area of \\(DEF\\)?";
                answer = "The area of \\(DEF\\) is \\(" + f + "\\)";
                break;
            // angles (unchanged)
            case 4:
                c = util.randomInt( 10, 100 );
                equation += " If angle \\(A = " + c + "^{\\circ}\\) and angle \\(A\\) corresponds to angle \\(D\\), what is the measure of angle \\(D\\)?";
                answer = "Angle \\(D = " + c + "^{\\circ}\\)";
                break;
            default:
                // Nothing
        }
    }
}
