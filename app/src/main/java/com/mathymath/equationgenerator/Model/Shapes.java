package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ShapeSelection;

import java.math.BigDecimal;

public class Shapes extends Generator {

    private final BigDecimal pi = new BigDecimal( Math.PI + "" );

    public Shapes() {
        super();
        selectionList = new ShapeSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation( util.removeDoubleSigns( equation ) );
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( util.removeDoubleSigns( answer ) );
    }

    @Override
    public void generate() {
        switch ( ( ShapeSelection.Equation ) type ) {
            case ANGLES:
                angles();
                break;
            case CIRCLES:
                circles();
                break;
            case TRIANGLES:
                triangles();
                break;
            case VOLUME_OF_PRISMS:
                volumeOfPrisms();
                break;
            case SURFACE_AREA:
                surfaceArea();
                break;
            default:
                // Nothing
        }
    }

    private void angles() {
        int a, b;

        switch ( util.randomInt( 0, 7 ) ) {
            // straight angle
            case 0:
                equation = "What is the measure of a straight angle?";
                answer = "\\(180^{\\circ}\\)";
                break;

            // right angle
            case 1:
                equation = "What is the measure of a right angle?";
                answer = "\\(90^{\\circ}\\)";
                break;

            // acute angle
            case 2:
                equation = "What is the name of an angle that is less than \\(90^{\\circ}\\)?";
                answer = "Acute angle";
                break;

            // obtuse angle
            case 3:
                equation = "What is the name of an angle that is more than \\(90^{\\circ}\\) and less than \\(180^{\\circ}\\)?";
                answer = "Obtuse angle";
                break;

            // complementary
            case 4:
                equation = "What do we call two angles that add to \\(90^{\\circ}\\)?";
                answer = "Complementary angles";
                break;

            // supplementary
            case 5:
                equation = "What do we call two angles that add to \\(180^{\\circ}\\)?";
                answer = "Supplementary angles";
                break;

            // complement
            case 6:
                a = util.randomInt( 2, 85 );
                b = 90 - a;
                equation = "What is the complement to a \\(" + a + "^{\\circ}\\) angle?";
                answer = "\\(" + b + "^{\\circ}\\)";
                break;

            // supplement
            case 7:
                a = util.randomInt( 2, 85 );
                b = 180 - a;
                equation = "What is the supplement to a \\(" + a + "^{\\circ}\\) angle?";
                answer = "\\(" + b + "^{\\circ}\\)";
                break;
            default:
                // Nothing
        }
    }

    private void triangles() {
        int a, b, c = 0;

        switch ( util.randomInt( 0, 2 ) ) {

            // angles 1
            case 0:
                a = util.randomInt( 2, 85 );
                b = util.randomInt( 5, 150 - a );
                c = 180 - b - a;
                equation = "If two angles of a triangle are \\(" + a + "^{\\circ}\\) and \\(" + b + "^{\\circ}\\), what is the measure of the third angle?";
                answer = "\\(" + c + "^{\\circ}\\)";
                break;

            // angles 2
            case 1:
                a = util.randomInt( 2, 85 );
                b = util.randomInt( 5, 150 - a );
                switch ( util.randomInt( 0, 1 ) ) {
                    // Yes
                    case 0:
                        c = 180 - b - a;
                        answer = "Yes, since \\(" + a + "^{\\circ} + " + b + "^{\\circ} + " + c + "^{\\circ} = 180^{\\circ}\\)";
                        break;

                    // No
                    case 1:
                        c = 180 - b - a + util.randomInt( 3, 8 );
                        answer = "No, since \\(" + a + "^{\\circ} + " + b + "^{\\circ} + " + c + "^{\\circ} \\neq 180^{\\circ}\\)";
                        break;
                }
                equation = "Can a triangle have angles of \\(" + a + "^{\\circ}\\), \\(" + b + "^{\\circ}\\), and \\(" + c + "^{\\circ}\\)?";
                break;

            // sides
            case 2:
                a = util.randomInt( 5, 10 );
                b = util.randomInt( 5, 10 );

                switch ( util.randomInt( 0, 1 ) ) {

                    // Yes
                    case 0:
                        c = a + b - util.randomInt( 1, 4 );
                        equation = "Can a triangle have side length of \\(" + a + ", " + b + ",\\) and \\(" + c + "\\)?";
                        answer = "Yes, since \\(" + a + " + " + b + " > " + c + "\\)";
                        break;
                    // No
                    case 1:
                        c = a + b + util.randomInt( 0, 5 );
                        equation = "Can a triangle have side length of \\(" + a + ", " + b + ",\\) and \\(" + c + "\\)?";
                        answer = "No, since \\(" + a + " + " + b + " \\) is not more than \\( " + c + "\\)";
                        break;
                }
                break;
            default:
                // Nothing
        }
    }

    private void circles() {
        int r = util.randomInt( 2, 9 );
        Integer d = 2 * r;
        Integer b;
        BigDecimal a, c;

        switch ( util.randomInt( 0, 5 ) ) {

            // Finding Area
            case 0:
                b = r * r;
                a = new BigDecimal( b.toString() ).multiply( pi );

                equation = "What is the area of a circle whose ";

                switch ( util.randomInt( 0, 1 ) ) {
                    // give radius
                    case 0:
                        equation += "radius is \\(" + r + "\\) cm?";
                        break;

                    // give diameter
                    case 1:
                        equation += "diameter is \\(" + d + "\\) cm?";
                        break;
                }
                answer = "\\(" + b + "\\pi \\approx " + a + "~cm^{2}\\)";

                break;

            // Using Area (in terms of pi) to find r      
            case 1:
                b = r * r;
                equation = "What is the ";

                switch ( util.randomInt( 0, 1 ) ) {
                    // ask for radius
                    case 0:
                        equation += "radius";
                        answer = "\\(" + r + "~cm\\)";
                        break;

                    // ask for diameter
                    case 1:
                        equation += "diameter";
                        answer = "\\(" + d + "~cm\\)";
                        break;
                }
                equation += " of a circle whose area is \\(" + b + "\\pi ~cm^{2}\\)?";
                break;

            // Finding Circumference
            case 2:
                c = new BigDecimal( d.toString() ).multiply( pi );

                equation = "What is the circumference of a circle whose ";

                switch ( util.randomInt( 0, 1 ) ) {
                    // give radius
                    case 0:
                        equation += "radius is \\(" + r + "\\) cm?";
                        break;

                    // give diameter
                    case 1:
                        equation += "diameter is \\(" + d + "\\) cm?";
                        break;
                }
                answer = "\\(" + d + "\\pi \\approx " + c + "~cm\\)";

                break;

            // Using Circumference (in terms of pi) to find d
            case 3:
                equation = "What is the ";

                switch ( util.randomInt( 0, 1 ) ) {
                    // ask for radius
                    case 0:
                        equation += "radius";
                        answer = "\\(" + r + "~cm\\)";
                        break;

                    // ask for diameter
                    case 1:
                        equation += "diameter";
                        answer = "\\(" + d + "~cm\\)";
                        break;
                }
                equation += " of a circle whose circumference is \\(" + d + "\\pi ~cm\\)?";
                break;

            // Find radius given diameter
            case 4:
                equation = "What is the radius of a circle whose diameter is \\(" + d + "~cm\\)?";
                answer = "\\(" + r + "~cm\\)";
                break;

            // Find diameter given radius
            case 5:
                equation = "What is the diameter of a circle whose radius is \\(" + r + "~cm\\)?";
                answer = "\\(" + d + "~cm\\)";
                break;
        }
    }

    private void volumeOfPrisms() {
        int l, w, h, a, b;
        switch ( util.randomInt( 0, 1 ) ) {
            // Non-rectangular
            case 0:
                h = util.randomInt( 5, 20 );
                b = util.randomInt( 10, 30 );
                a = ( b * h );
                equation = "What is the volume of a prism whose height is \\(" + h + "~cm\\) and whose base area is \\(" + b + "~cm^{2}\\)?";
                answer = "\\(" + a + "~cm^{3}\\)";
                break;

            // Rectangular
            case 1:
                l = util.randomInt( 5, 20 );
                w = util.randomInt( 5, 20 );
                h = util.randomInt( 5, 20 );
                a = ( l * w * h );
                equation = "What is the volume of a rectangular prism whose length is \\(" + l + "~cm\\), width is \\(" + w + "~cm\\), and height is \\(" + h + "~cm\\)?";
                answer = "\\(" + a + "~cm^{3}\\)";
                break;
        }
    }

    private void surfaceArea() {
        int l = util.randomInt( 5, 20 );
        int w = util.randomInt( 5, 20 );
        int h = util.randomInt( 5, 20 );
        int a = ( 2 * l * w + 2 * w * h + 2 * l * h );
        equation = "What is the surface area of a rectangular prism whose length is \\(" + l + "~cm\\), width is \\(" + w + "~cm\\), and height is \\(" + h + "~cm\\)?";
        answer = "\\(" + a + "~cm^{2}\\)";
    }
}
