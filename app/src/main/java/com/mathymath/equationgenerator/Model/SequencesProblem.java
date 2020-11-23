package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SequenceProblemSelection;
import com.mathymath.equationgenerator.Model.Selection.SequenceTypeSelection;

import java.util.Map;

public class SequencesProblem extends Generator {

    private SequenceTypeSelection sequenceTypeSelection = new SequenceTypeSelection();

    private EquationType sequenceType;

    public SequencesProblem() {
        super();
        selectionList = new SequenceProblemSelection();
    }

    @Override
    public String getEquation() {
        return "\\(" + util.cleanEquation( util.removeDoubleSigns( equation ) ) + "\\)";
    }

    @Override
    public String getAnswer() {
        return "\\(" + util.cleanEquation( util.removeDoubleSigns( answer ) ) + "\\)";
    }

    @Override
    public void generate() {
        switch ( ( SequenceProblemSelection.Equation ) type ) {
            case RECURSIVE_TO_EXPLICIT:
                recursiveToExplicit();
                break;
            case EXPLICIT_TO_RECURSIVE:
                explicitToRecursive();
                break;
            case SEQUENCE_TO_EXPLICIT:
                sequenceToExplicit();
                break;
            default:
                // Nothing
        }
    }

    private void recursiveToExplicit() {
        int change, initial, a1;

        switch ( ( SequenceTypeSelection.Equation ) sequenceType ) {
            case ARITHMETIC:
                change = util.nonZeroRandomInt( -10, 10 );
                initial = util.nonZeroRandomInt( -20, 20 );
                a1 = initial + change;

                switch ( util.randomInt( 0, 3 ) ) {
                    // an notation + 1
                    case 0:
                        equation = "a_{n+1} = a_n +" + change + " , a_1 = " + a1;
                        answer = "a_n = " + a1 + " + " + change + "(n-1)~~or~~ a_n = " + change + "n + " + initial;
                        break;
                    // f(x) notation + 1
                    case 1:
                        equation = "f(x+1) = f(x) +" + change + " , f(1) = " + a1;
                        answer = "f(x) = " + a1 + " + " + change + "(x-1)~~or~~ f(x) = " + change + "x + " + initial;
                        break;
                    // an notation - 1
                    case 2:
                        equation = "a_{n} = a_{n-1} +" + change + " , a_1 = " + a1;
                        answer = "a_n = " + a1 + " + " + change + "(n-1)~~or~~ a_n = " + change + "n + " + initial;
                        break;
                    // f(x) notation - 1
                    case 3:
                        equation = "f(x) = f(x-1) +" + change + " , f(1) = " + a1;
                        answer = "f(x) = " + a1 + " + " + change + "(x-1)~~or~~ f(x) = " + change + "x + " + initial;
                        break;
                    default:
                        // Nothing
                }
                break;
            case GEOMETRIC:
                change = util.nonZeroRandomInt( -8, 8 );
                initial = util.nonZeroRandomInt( -10, 10 );
                a1 = initial * change;

                switch ( util.randomInt( 0, 3 ) ) {
                    // an notation + 1
                    case 0:
                        equation = "a_{n+1} = a_n ⋅" + change + " , a_1 = " + a1;
                        answer = "a_n = " + a1 + "(" + change + ")^{n-1}~~or~~ a_n = " + initial + "(" + change + ")^n";
                        break;
                    // f(x) notation + 1
                    case 1:
                        equation = "f(x+1) = f(x) ⋅" + change + " , f(1) = " + a1;
                        answer = "f(x) = " + a1 + "(" + change + ")^{x-1}~~or~~ f(x) = " + initial + "(" + change + ")^x";
                        break;
                    // an notation - 1
                    case 2:
                        equation = "a_{n} = a_{n-1} ⋅" + change + " , a_1 = " + a1;
                        answer = "a_n = " + a1 + "(" + change + ")^{n-1}~~or~~ a_n = " + initial + "(" + change + ")^n";
                        break;
                    // f(x) notation - 1
                    case 3:
                        equation = "f(x) = f(x-1) ⋅" + change + " , f(1) = " + a1;
                        answer = "f(x) = " + a1 + "(" + change + ")^{x-1}~~or~~ f(x) = " + initial + "(" + change + ")^x";
                        break;
                    default:
                        // Nothing
                }

                break;
            case BOTH:
                setRandomSequenceType();
                recursiveToExplicit();
                // Change sequence type back
                sequenceType = SequenceTypeSelection.Equation.BOTH;
                break;
            default:
                // Nothing
        }
    }

    private void explicitToRecursive() {
        int change, initial, a1;

        switch ( ( SequenceTypeSelection.Equation ) sequenceType ) {
            case ARITHMETIC:
                change = util.nonZeroRandomInt( -10, 10 );
                initial = util.nonZeroRandomInt( -20, 20 );
                a1 = initial + change;

                switch ( util.randomInt( 0, 3 ) ) {
                    // an notation + 1
                    case 0:
                        answer = "a_{n+1} = a_n +" + change + " , a_1 = " + a1;
                        equation = "a_n = " + a1 + " + " + change + "(n-1)~~or~~ a_n = " + change + "n + " + initial;
                        break;
                    // f(x) notation + 1
                    case 1:
                        answer = "f(x+1) = f(x) +" + change + " , f(1) = " + a1;
                        equation = "f(x) = " + a1 + " + " + change + "(x-1)~~or~~ f(x) = " + change + "x + " + initial;
                        break;
                    // an notation - 1
                    case 2:
                        answer = "a_{n} = a_{n-1} +" + change + " , a_1 = " + a1;
                        equation = "a_n = " + a1 + " + " + change + "(n-1)~~or~~ a_n = " + change + "n + " + initial;
                        break;
                    // f(x) notation - 1
                    case 3:
                        answer = "f(x) = f(x-1) +" + change + " , f(1) = " + a1;
                        equation = "f(x) = " + a1 + " + " + change + "(x-1)~~or~~ f(x) = " + change + "x + " + initial;
                        break;
                }
                break;
            case GEOMETRIC:
                change = util.nonZeroRandomInt( -8, 8 );
                initial = util.nonZeroRandomInt( -10, 10 );
                a1 = initial * change;

                switch ( util.randomInt( 0, 3 ) ) {
                    // an notation + 1
                    case 0:
                        answer = "a_{n+1} = a_n ⋅" + change + " , a_1 = " + a1;
                        equation = "a_n = " + a1 + "(" + change + ")^{n-1}~~or~~ a_n = " + initial + "(" + change + ")^n";
                        break;
                    // f(x) notation + 1
                    case 1:
                        answer = "f(x+1) = f(x) ⋅" + change + " , f(1) = " + a1;
                        equation = "f(x) = " + a1 + "(" + change + ")^{x-1}~~or~~ f(x) = " + initial + "(" + change + ")^x";
                        break;
                    // an notation - 1
                    case 2:
                        answer = "a_{n} = a_{n-1} ⋅" + change + " , a_1 = " + a1;
                        equation = "a_n = " + a1 + "(" + change + ")^{n-1}~~or~~ a_n = " + initial + "(" + change + ")^n";
                        break;
                    // f(x) notation - 1
                    case 3:
                        answer = "f(x) = f(x-1) ⋅" + change + " , f(1) = " + a1;
                        equation = "f(x) = " + a1 + "(" + change + ")^{x-1}~~or~~ f(x) = " + initial + "(" + change + ")^x";
                        break;
                    default:
                        // Nothing
                }
                break;
            case BOTH:
                setRandomSequenceType();
                explicitToRecursive();
                // Change sequence type back
                sequenceType = SequenceTypeSelection.Equation.BOTH;
                break;
            default:
                // Nothing
        }
    }

    private void sequenceToExplicit() {
        int change, initial, a1, a2, a3, a4, a5, a6;

        switch ( ( SequenceTypeSelection.Equation ) sequenceType ) {
            case ARITHMETIC:
                change = util.nonZeroRandomInt( -10, 10 );
                initial = util.nonZeroRandomInt( -20, 20 );
                a1 = initial + change;
                a2 = a1 + change;
                a3 = a2 + change;
                a4 = a3 + change;
                a5 = a4 + change;
                a6 = a5 + change;

                switch ( util.randomInt( 0, 1 ) ) {
                    // an notation + 1
                    case 0:
                        equation = a1 + ", " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ", " + a6;
                        answer = "a_n = " + a1 + " + " + change + "(n-1)~~or~~ a_n = " + change + "n + " + initial;
                        break;
                    // f(x) notation + 1
                    case 1:
                        equation = a1 + ", " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ", " + a6;
                        answer = "f(x) = " + a1 + " + " + change + "(x-1)~~or~~ f(x) = " + change + "x + " + initial;
                        break;
                    default:
                        // Nothing
                }
                break;
            case GEOMETRIC:
                change = util.nonZeroRandomInt( -8, 8 );
                initial = util.nonZeroRandomInt( -10, 10 );
                a1 = initial * change;
                a1 = initial * change;
                a2 = a1 * change;
                a3 = a2 * change;
                a4 = a3 * change;
                a5 = a4 * change;
                a6 = a5 * change;

                switch ( util.randomInt( 0, 1 ) ) {
                    // an notation + 1
                    case 0:
                        equation = a1 + ", " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ", " + a6;
                        answer = "a_n = " + a1 + "(" + change + ")^{n-1}~~or~~ a_n = " + initial + "(" + change + ")^n";
                        break;
                    // f(x) notation + 1
                    case 1:
                        equation = a1 + ", " + a2 + ", " + a3 + ", " + a4 + ", " + a5 + ", " + a6;
                        answer = "f(x) = " + a1 + "(" + change + ")^{x-1}~~or~~ f(x) = " + initial + "(" + change + ")^x";
                        break;
                    default:
                        // Nothing
                }
                break;
            case BOTH:
                setRandomSequenceType();
                sequenceToExplicit();
                // Change sequence type back
                sequenceType = SequenceTypeSelection.Equation.BOTH;
                break;
            default:
                // Nothing
        }
    }

    private void setRandomSequenceType() {
        if ( util.randomInt( 0, 1 ) == 1 ) {
            sequenceType = SequenceTypeSelection.Equation.ARITHMETIC;
        } else {
            sequenceType = SequenceTypeSelection.Equation.GEOMETRIC;
        }
    }

    @Override
    public String getSecondarySpinnerLabel() {
        return "Type of Sequence:";
    }

    @Override
    public boolean hasSecondarySpinner() {
        return true;
    }

    @Override
    public void secondarySpinnerListener( EquationType selection ) {
        sequenceType = selection;
    }

    @Override
    public Map< String, EquationType > getSpinnerMap() {
        return sequenceTypeSelection.getSelectionMap();
    }

    @Override
    public String[] getSecondarySpinnerList() {
        return sequenceTypeSelection.getSelectionList();
    }
}
