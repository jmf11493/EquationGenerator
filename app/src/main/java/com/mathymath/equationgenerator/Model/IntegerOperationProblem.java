package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.IntegerOperationProblemSelection;

public class IntegerOperationProblem extends Generator {

    private int a, b, c, d, e, f, g, h;

    public IntegerOperationProblem() {
        super();
        selectionList = new IntegerOperationProblemSelection();
    }

    @Override
    public String getEquation() {
        if ( type == IntegerOperationProblemSelection.Equation.ADDING_SUBTRACTING ) {
            return "\\(" + util.cleanEquation( equation ) + "\\)";
        }

        return "\\(" + util.cleanEquation( util.removeDoubleSigns( equation ) ) + "\\)";
    }

    @Override
    public String getAnswer() {
        return "\\(" + util.cleanEquation( answer ) + "\\)";
    }

    @Override
    public boolean hasSwitch() {
        return false;
    }

    @Override
    public void generate() {
        switch ( ( IntegerOperationProblemSelection.Equation ) type ) {
            case ADDING_SUBTRACTING:
                addingSubtracting();
                break;
            case MULTIPLYING_DIVIDING:
                multiplyingDividing();
                break;
            case ALL_OPERATIONS:
                allOperations();
                break;
            case ORDER_OF_OPERATIONS_EASY:
                orderOfOperationsEasy();
                break;
            case ORDER_OF_OPERATIONS_MEDIUM:
                orderOfOperationsMedium();
                break;
            case ORDER_OF_OPERATIONS_HARD:
                orderOfOperationsHard();
                break;
            default:
                // Nothing
        }
    }

    private void addingSubtracting() {
        a = util.randomInt( -10, -1 );
        b = util.nonZeroRandomInt( -10, 10 );

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                equation = a + " + " + b;
                answer = ( a + b ) + "";
                break;
            case 1:
                equation = a + " - " + b;
                answer = ( a - b ) + "";
                break;
            default:
                // Nothing
        }
    }

    private void multiplyingDividing() {
        a = util.randomInt( -10, -2 );
        do {
            b = util.nonZeroRandomInt( -10, 10 );
        } while ( b == 1 || b == -1 );
        c = a * b;

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                equation = a + " \\cdot " + b;
                answer = c + "";
                break;

            case 1:
                equation = c + " \\div " + b;
                answer = a + "";
                break;
            default:
                // Nothing
        }
    }

    private void allOperations() {
        switch ( util.randomInt( 0, 4 ) ) {
            case 0:
                type = IntegerOperationProblemSelection.Equation.ADDING_SUBTRACTING;
                break;
            case 1:
                type = IntegerOperationProblemSelection.Equation.MULTIPLYING_DIVIDING;
                break;
            case 2:
                type = IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_EASY;
                break;
            case 3:
                type = IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_MEDIUM;
                break;
            case 4:
                type = IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_HARD;
                break;
            default:
                // Nothing
        }

        generate();

        // Set the type back to allOperations
        type = IntegerOperationProblemSelection.Equation.ALL_OPERATIONS;
    }

    private void orderOfOperationsEasy() {
        a = util.nonZeroRandomInt( -6, 6 );
        b = util.nonZeroRandomInt( -6, 6 );
        c = util.nonZeroRandomInt( -6, 6 );
        d = util.nonZeroRandomInt( -6, 6 );

        switch ( util.randomInt( 0, 3 ) ) {

            case 0:
                equation = a + " + " + b + " \\times " + c + " \\times " + d;
                answer = ( a + b * c * d ) + "";
                break;

            case 1:
                equation = a + " + " + b + " \\times (" + c + " + " + d + ")";
                answer = ( a + b * ( c + d ) ) + "";
                break;

            case 2:
                equation = a + " \\cdot (" + b + " + " + c + " + " + d + ")";
                answer = ( a * ( b + c + d ) ) + "";
                break;

            case 3:
                equation = "(" + a + " + " + b + ") \\times " + c + " + " + d;
                answer = ( ( a + b ) * c + d ) + "";
                break;
            default:
                // Nothing
        }
    }

    private void orderOfOperationsMedium() {
        a = util.nonZeroRandomInt( -3, 3 );
        b = util.nonZeroRandomInt( -3, 3 );
        c = util.nonZeroRandomInt( -5, 5 );
        d = c + b;
        e = util.nonZeroRandomInt( -8, 8 );

        int ab = a * b;

        switch ( util.randomInt( 0, 1 ) ) {

            case 0:
                equation = ab + "\\div (" + d + " - " + c + ") \\times (" + a + " + " + e + ")";
                answer = ( ab / ( d - c ) ) * ( a + e ) + "";
                break;

            case 1:
                equation = c + "\\times (" + ab + "\\div " + b + " - " + d + " + " + e + ")";
                answer = c * ( ab / b - d + e ) + "";
                break;
            default:
                // Nothing
        }
    }

    private void orderOfOperationsHard() {
        a = util.nonZeroRandomInt( -3, 3 );
        b = util.nonZeroRandomInt( -3, 3 );
        c = util.nonZeroRandomInt( -8, -2 );
        d = c + b;
        e = util.nonZeroRandomInt( -8, 8 );
        f = util.randomInt( 2, 10 );
        g = util.randomInt( -10, -2 );

        int ab = a * b;

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                equation = "(" + c + ")^2 - " + e + "\\times [" + ab + "\\div (" + d + " - " + c + ")]\\times " + a;
                answer = ( c * c ) - e * ( ab / ( d - c ) ) * a + "";
                break;

            case 1:
                equation = "((" + g + ") + " + e + " + " + f + ")^2 \\times (" + ab + "\\div " + a + ")^2";
                answer = Math.pow( ( g + e + f ), 2 ) * Math.pow( ( ab / a ), 2 ) + "";
                break;
            default:
                // Nothing
        }
    }
}
