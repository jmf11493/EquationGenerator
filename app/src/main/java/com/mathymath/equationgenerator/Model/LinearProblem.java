package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.LinearProblemSelection;

public class LinearProblem extends Generator {

    public LinearProblem() {
        super();
        selectionList = new LinearProblemSelection();
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
        switch ( ( LinearProblemSelection.Equation ) type ) {
            case TWO_POINTS_SLOPE:
                slopeBetweenPoints();
                break;
            case TWO_POINTS_EQUATION:
                twoPointsEquation();
                break;
            case REWRITE_SLOPE_INTERCEPT:
                rewriteSlopeIntercept();
                break;
            case FIND_SLOPE_Y_INTERCEPT:
                findSlopeYIntercept();
                break;
            case TABLE_FIND_SLOPE:
                givenTableFindSlope();
                break;
            case TABLE_WRITE_EQUATION:
                givenTableWriteEquation();
                break;
            default:
                // Nothing
        }
    }

    private void slopeBetweenPoints() {
        Integer x1 = util.randomInt( -10, 10 );
        Integer y1 = util.randomInt( -10, 100 );
        Integer a = util.randomInt( 2, 5 );
        Integer slope = util.nonZeroRandomInt( -20, 20 );
        Integer b = a * slope;
        Integer x2 = a + x1;
        Integer y2 = b + y1;

        equation = "Find the slope between the points \\((" + x1 + ", " + y1 + ")\\) and \\((" + x2 + ", " + y2 + ")\\)";
        answer = "Slope \\(= " + slope + "\\)";
    }

    private void twoPointsEquation() {
        Integer x1 = util.randomInt( 1, 5 );
        Integer y1 = util.randomInt( -10, 10 );
        Integer a = util.randomInt( 2, 5 );
        Integer slope = util.nonZeroRandomInt( -5, 5 );
        Integer b = a * slope;
        Integer x2 = a + x1;
        Integer y2 = b + y1;
        Integer yint = y1 - slope * x1;

        equation = "Find the equation of the line that goes through the points \\((" + x1 + ", " + y1 + ")\\) and \\((" + x2 + ", " + y2 + ")\\)";
        answer = "\\(y = " + slope + "x + " + yint + "\\)";
    }

    private void rewriteSlopeIntercept() {
        Integer a = util.randomInt( 2, 5 );
        Integer b = a * util.nonZeroRandomInt( -5, 5 );
        Integer c = a * util.nonZeroRandomInt( -5, 5 );

        equation = "Write the equation \\(" + a + "y + " + b + "x = " + c + "\\) in slope-intercept \\(y = mx + b\\) form.";
        answer = "\\(y = " + -1 * b / a + "x + " + c / a + "\\)";
    }

    private void findSlopeYIntercept() {
        Integer a = util.randomInt( 2, 5 );
        Integer b = a * util.nonZeroRandomInt( -5, 5 );
        Integer c = a * util.nonZeroRandomInt( -5, 5 );

        equation = "Determine the slope and \\(y\\)-intercept of the equation \\(" + a + "y + " + b + "x = " + c + "\\)";
        answer = "\\(y = " + -1 * b / a + "x + " + c / a + "\\)";
        answer += "<br>Slope \\(= " + -1 * b / a + "\\)<br>\\(y\\)-intercept \\(= " + c / a + "\\)";
    }

    private void givenTableFindSlope() {
        Integer x1 = util.randomInt( 1, 5 );
        Integer y1 = util.randomInt( -10, 10 );
        Integer slope = util.nonZeroRandomInt( -9, 9 );

        equation = "Find the slope of the linear relationship below";
        equation += generateTableEntries(x1, y1, slope);

        answer = "Slope \\(= " + slope + "\\)";
    }

    private void givenTableWriteEquation() {
        Integer x1 = util.randomInt( 0, 5 );
        Integer y1 = util.randomInt( -10, 10 );
        Integer slope = util.nonZeroRandomInt( -9, 9 );
        Integer yint = y1 - slope * x1;

        equation = "Find the equation of the line for the linear relationship below";
        equation += generateTableEntries(x1, y1, slope);

        answer = "\\(y = " + slope + "x + " + yint + "\\)";
    }

    private String generateTableEntries(Integer x1, Integer y1, Integer slope) {
        String table = "";
        String xstring = "<td>" + x1 + "</td>";
        String ystring = "<td>" + y1 + "</td>";

        table += "<table border='1'>";
        table += "<tr><td>\\(x\\)</td>";

        // scale factor so that the x's don't always count by 1
        int scale = util.randomInt( 1, 4 );
        int randomEntries = util.randomInt( 8, 14 );

        for ( int i = 1; i < randomEntries; i++ ) {

            xstring += "<td>" + ( i * scale + x1 ) + "</td>";
            ystring += "<td>" + ( i * scale * slope + y1 ) + "</td>";

        }

        table += xstring + "</tr><tr><td>\\(y\\)</td>" + ystring + "</tr>";
        table += "</table>";

        return table;
    }
}
