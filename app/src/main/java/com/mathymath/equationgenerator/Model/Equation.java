package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.EquationSelection;

import java.math.BigDecimal;

public class Equation extends Generator {

    private final BigDecimal ten = new BigDecimal( "10" );

    public Equation() {
        super();
        selectionList = new EquationSelection();
    }

    @Override
    public String getEquation() {
        return "\\(" + util.cleanEquation( util.removeDoubleSigns( equation ) ) + "\\)";
    }

    @Override
    public String getAnswer() {
        return "\\(" + util.cleanEquation( answer ) + "\\)";
    }

    @Override
    public boolean hasSwitch() {
        return true;
    }

    @Override
    public String getSwitchLabel() {
        return "Rationals";
    }

    @Override
    public void switchListener( boolean checked ) {
        super.util.setRational( checked );
    }

    @Override
    public void generate() {
        switch ( ( EquationSelection.Equation ) type ) {
            case ONE_STEP:
                oneStepEquation();
                break;
            case TWO_STEP:
                twoStepEquation();
                break;
            case TWO_STEP_DISTRIBUTING:
                twoStepDistributing();
                break;
            case COMBINING_LIKE_TERMS:
                combiningLikeTerms();
                break;
            case VARIABLES_BOTH_SIDES:
                variablesOnBothSides();
                break;
            case VARIABLES_BOTH_SIDES_COMBINING:
                variablesOnBothSidesWithCombining();
                break;
            case VARIABLES_BOTH_SIDES_DISTRIBUTIVE:
                variablesOnBothSidesWithDistributing();
                break;
            case DIFFICULT_MULTI_STEP_EQUATION:
                difficultMultStep();
                break;
            case VARIABLES_BOTH_SIDES_DISTRIBUTIVE_FRACTION:
                variablesOnBothSidesWithDistributingFractions();
                break;
            case VARIABLES_BOTH_SIDES_DISTRIBUTIVE_COMBINING:
                variablesOnBothSidesWithDistributingCombining();
                break;
            default:
                // Nothing
        }
    }

    private void oneStepEquation() {
        BigDecimal x, a, b;
        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                x = util.nonZeroRandom( -10, 10 );
                a = util.nonZeroRandom( -10, 10 );
                b = x.multiply( a );
                equation = a + "x = " + b;
                answer = x + "";
                break;
            case 1:
                x = util.nonZeroRandom( -10, 10 );
                a = util.nonZeroRandom( -10, 10 );
                b = x.add( a );
                equation = a + " + x = " + b;
                answer = x + "";
                break;
            case 2:
                x = util.nonZeroRandom( -10, 10 );
                a = util.nonZeroRandom( -10, 10 );
                b = x.subtract( a );
                equation = "x - " + a + " = " + b;
                answer = x + "";
                break;
            case 3:
                a = util.nonZeroRandom( -10, 10 );
                b = util.nonZeroRandom( -10, 10 );
                x = b.multiply( a );
                equation = "\\frac{x}{" + a + "} = " + b;
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void twoStepEquation() {
        BigDecimal a, b, c, x;
        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                a = util.nonZeroRandom( -10, 10 );
                do {
                    b = util.random( 2, 10 );
                } while ( b.compareTo( a ) == 0 );
                x = util.nonZeroRandom( -10, 10 );
                c = a.multiply( x ).add( b );
                equation = a + "x + " + b + " = " + c;
                answer = x + "";
                break;
            case 1:
                a = util.nonZeroRandom( -10, 10 );
                do {
                    b = util.random( 2, 10 );
                } while ( b.compareTo( a ) == 0 );
                x = util.nonZeroRandom( -10, 10 );
                c = a.multiply( x ).add( b );
                equation = c + " = " + b + " + " + a + "x";
                answer = x + "";
                break;
            case 2:
                a = util.nonZeroRandom( -10, 10 );
                do {
                    b = util.random( 2, 10 );
                } while ( b.compareTo( a ) == 0 );
                x = util.nonZeroRandom( -10, 10 );
                c = a.multiply( x ).add( b );
                equation = c + " = " + b + " + " + a + "x";
                answer = x + "";
                break;
            case 3:
                a = util.random( 2, 10 );
                b = util.nonZeroRandom( -10, 10 );
                do {
                    c = util.nonZeroRandom( -10, 10 );
                } while ( b.compareTo( c ) == 0 );
                x = c.subtract( b ).multiply( a );
                equation = "\\frac{x}{" + a + "} + " + b + " = " + c;
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void twoStepDistributing() {
        BigDecimal a, b, c, d, x;

        switch ( util.randomInt( 0, 2 ) ) {
            case 0:
                do {
                    a = util.nonZeroRandom( -10, 10 );
                } while ( a.compareTo( BigDecimal.ONE ) == 0 );
                do {
                    b = util.random( 2, 15 );
                } while ( b.compareTo( a ) == 0 );
                do {
                    c = util.random( 2, 15 );
                } while ( c.compareTo( b ) == 0  || c.compareTo( a ) == 0 );
                x = util.random( 2, 15 );
                d = c.multiply( x ).add( b ).multiply( a );
                equation = a + "(" + c + "x + " + b + ") = " + d;
                answer = x + "";
                break;
            case 1:
                do {
                    a = util.nonZeroRandom( -10, 10 );
                } while ( a.compareTo( BigDecimal.ONE ) == 0 );
                do {
                    b = util.random( 2, 15 );
                } while ( b.compareTo( a ) == 0 );
                do {
                    c = util.random( 2, 15 );
                } while ( c.compareTo( b ) == 0 || c.compareTo( a ) == 0 );
                x = util.random( 2, 15 );
                d = c.multiply( x ).add( b ).multiply( a );
                equation = d + " = " + a + "(" + c + "x + " + b + ")";
                answer = x + "";
                break;
            case 2:
                do {
                    a = util.nonZeroRandom( -10, 10 );
                } while ( a.compareTo( BigDecimal.ONE ) == 0 );
                do {
                    b = util.random( 2, 15 );
                } while ( b.compareTo( a ) == 0 );
                do {
                    c = util.random( 2, 15 );
                } while ( c.compareTo( b ) == 0 || c.compareTo( a ) == 0 );
                x = util.random( 2, 15 );
                d = c.multiply( x ).add( b ).multiply( a );
                equation = d + " = " + a + "(" + b + "x + " + c + ")";
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void combiningLikeTerms() {
        BigDecimal a, b, c, d, e, x, ax, cx;

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                a = util.random( 2, 15 );
                x = util.nonZeroRandom( -12, 12 );
                b = util.random( 2, 10 );
                // avoids infinite solutions
                do {
                    c = util.random( 2, 10 );
                }
                while ( c.compareTo( a ) == 0 );
                ax = a.multiply( x );
                cx = c.multiply( x );
                d = ax.add( b ).subtract( cx );
                equation = a + "x + " + b + " - " + c + "x = " + d;
                answer = x + "";
                break;

            case 1:
                a = util.random( 2, 15 );
                x = util.nonZeroRandom( -12, 12 );
                b = util.random( 2, 10 );
                // avoids no, infinite solutions
                do {
                    c = util.random( 2, 10 );
                } while ( c.compareTo( a ) == 0 );
                e = util.random( 2, 10 );
                ax = a.multiply( x );
                cx = c.multiply( x );
                d = ax.add( b ).subtract( cx ).add( e );
                equation = a + "x + " + b + " - " + c + "x + " + e + "= " + d;
                answer = x + "";
                break;

            case 2:
                a = util.random( 2, 15 );
                x = util.nonZeroRandom( -12, 12 );
                b = util.random( 2, 10 );
                // avoids no, infinite solutions
                do {
                    c = util.random( 2, 10 );
                } while ( c.compareTo( a ) == 0 );
                ax = a.multiply( x );
                cx = c.multiply( x );
                d = ax.add( b ).subtract( cx );
                equation = d + " = " + a + "x + " + b + " - " + c + "x";
                answer = x + "";
                break;

            case 3:
                a = util.random( 2, 15 );
                x = util.nonZeroRandom( -12, 12 );
                b = util.random( 2, 10 );
                // avoids no, infinite solutions
                do {
                    c = util.random( 2, 10 );
                } while ( c.compareTo( a ) == 0 );
                ax = a.multiply( x );
                cx = c.multiply( x );
                d = ax.add( b ).subtract( cx );
                equation = d + "=" + b + "+" + a + "x - " + c + "x";
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void variablesOnBothSides() {
        BigDecimal a, b, c, d, x, ax, cx;

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                do {
                    c = util.random( 2, 5 );
                    b = util.random( 2, 10 );
                    x = util.nonZeroRandom( -10, 10 );
                    a = util.random( 2, 5 ).add( c );
                    ax = a.multiply( x );
                    cx = c.multiply( x );
                    d = ax.add( b ).subtract( cx );
                } while ( d.compareTo( BigDecimal.ZERO ) == 0 );
                equation = a + "x + " + b + " = " + c + "x + " + d;
                answer = x + "";
                break;
            case 1:
                do {
                    c = util.random( 2, 5 );
                    b = util.random( 2, 10 );
                    x = util.nonZeroRandom( -10, 10 );
                    a = util.random( 2, 5 ).add( c );
                    ax = a.multiply( x );
                    cx = c.multiply( x );
                    d = ax.add( b ).subtract( cx );
                } while ( d.compareTo( BigDecimal.ZERO ) == 0 );
                equation = d + " + " + c + "x = " + a + "x + " + b;
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void variablesOnBothSidesWithCombining() {
        BigDecimal a, b, c, d, e, f, x, ax, bx, cx, ex, part2;

        switch ( util.randomInt( 0, 2 ) ) {
            case 0:
                x = util.nonZeroRandom( -10, 10 );
                a = util.nonZeroRandom( -10, 10 );
                // avoid infinite solutions
                do {
                    b = util.nonZeroRandom( -10, 10 );
                    c = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                } while ( b.compareTo( c.add( e ) ) == 0 );
                d = util.nonZeroRandom( -10, 10 );
                bx = b.multiply( x );
                cx = c.multiply( x );
                ex = e.multiply( x );
                part2 = cx.add( d ).add( ex );
                f = a.add( bx ).subtract( part2 );
                equation = a + " + " + b + "x = " + c + "x + " + d + " + " + e + "x + " + f;
                answer = x + "";
                break;
            case 1:
                x = util.nonZeroRandom( -10, 10 );
                a = util.nonZeroRandom( -10, 10 );
                // avoid infinite solutions
                do {
                    b = util.nonZeroRandom( -10, 10 );
                    c = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                } while ( b.compareTo( c.add( e ) ) == 0 );
                d = util.nonZeroRandom( -10, 10 );
                bx = b.multiply( x );
                cx = c.multiply( x );
                ex = e.multiply( x );
                part2 = cx.add( ex );
                f = a.add( bx ).add( d ).subtract( part2 );
                equation = a + " + " + b + "x +" + d + "= " + c + "x + " + f + " + " + e + "x";
                answer = x + "";
                break;
            case 2:
                x = util.nonZeroRandom( -10, 10 );
                // avoid infinite solutions
                do {
                    a = util.nonZeroRandom( -10, 10 );
                    b = util.nonZeroRandom( -10, 10 );
                    c = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                } while ( a.add( b ).compareTo( c.add( e ) ) == 0 );
                d = util.nonZeroRandom( -10, 10 );
                ax = a.multiply( x );
                bx = b.multiply( x );
                cx = c.multiply( x );
                ex = e.multiply( x );
                part2 = cx.add( ex );
                f = ax.add( bx ).add( d ).subtract( part2 );
                equation = b + "x +" + d + " + " + a + "x = " + c + "x + " + f + " + " + e + "x";
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void variablesOnBothSidesWithDistributing() {
        BigDecimal a, b, c, d, e, x;

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                a = util.random( 2, 5 );
                b = util.random( 2, 10 );
                x = util.nonZeroRandom( -10, 10 );
                // TODO make sure this works
                c = a.multiply( x.add( b ) ).subtract( x );
                equation = a + "(x + " + b + ") = x + " + c;
                answer = x + "";
                break;
            case 1:
                a = util.random( 2, 5 );
                b = util.random( 2, 10 );
                x = util.nonZeroRandom( -10, 10 );
                // TODO make sure this works
                c = a.multiply( x.add( b ) ).subtract( x );
                equation = "x + " + c + " = " + a + "(x + " + b + ")";
                answer = x + "";
                break;
            case 2:
                a = util.random( 2, 5 );
                b = util.random( 2, 10 );
                x = util.nonZeroRandom( -10, 10 );
                // avoid infinite solutions
                do {
                    d = util.nonZeroRandom( -10, 10 );
                } while ( a.multiply( d ).compareTo( BigDecimal.ONE ) == 0 );
                // TODO make sure this works
                c = a.multiply( d.multiply( x ).add( b ) ).subtract( x );
                equation = "x + " + c + " = " + a + "(" + d + "x + " + b + ")";
                answer = x + "";
                break;
            case 3:
                b = util.random( 2, 10 );
                x = util.nonZeroRandom( -10, 10 );
                // avoid infinite solutions
                do {
                    a = util.random( 2, 5 );
                    d = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                } while ( ( a.multiply( d ).compareTo( new BigDecimal( "3" ) ) == 0 ) );
                // TODO make sure this works
                c = a.multiply( d.multiply( x ).add( b ) ).subtract( e.multiply( x ) );
                equation = e + "x + " + c + " = " + a + "(" + d + "x + " + b + ")";
                answer = x + "";
                break;
            default:
                // Nothing
        }
    }

    private void difficultMultStep() {
        BigDecimal a, b, c, d, e, f, g, h, x;

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                // prevents infinite solutions
                do {
                    x = util.nonZeroRandom( -10, 10 );
                    b = util.nonZeroRandom( -10, 10 );
                    c = util.nonZeroRandom( -10, 10 );
                    d = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                    f = util.nonZeroRandom( -10, 10 );
                    g = util.nonZeroRandom( -10, 10 );
                    h = util.nonZeroRandom( -10, 10 );
                    a = e.add( f.multiply( g.multiply( x ).add( h ) ) ).subtract( b.multiply( c.multiply( x ).add( d ) ) );
                    equation = a + " + " + b + "(" + c + "x + " + d + ") = " + e + " + " + f + "(" + g + "x + " + h + ")";
                    answer = x + "";
                } while ( ( b.multiply( c ) ).compareTo( f.multiply( g ) ) == 0 );
                break;
            case 1:
                // prevents infinite solutions
                do {
                    x = util.nonZeroRandom( -10, 10 );
                    a = util.nonZeroRandom( -10, 10 );
                    b = util.nonZeroRandom( -10, 10 );
                    c = util.nonZeroRandom( -10, 10 );
                    d = util.nonZeroRandom( -10, 10 );
                    e = util.nonZeroRandom( -10, 10 );
                    f = util.nonZeroRandom( -10, 10 );
                    g = util.nonZeroRandom( -10, 10 );
                    h = a.multiply( b.multiply( x ).add( c ) ).add( d.multiply( e.multiply( x ).add( f ) ) ).subtract( g.multiply( x ) );
                    equation = a + "(" + b + "x + " + c + ") + " + d + "(" + e + "x + " + f + ") = " + g + "x +" + h;
                    answer = x + "";
                }
                while ( a.multiply( b ).add( d.multiply( e ) ).compareTo( g ) == 0 );
                break;
            default:
                // Nothing
        }
    }

    private void variablesOnBothSidesWithDistributingFractions() {
        Integer aInt = util.randomInt( 2, 10 );
        BigDecimal a = new BigDecimal( aInt.toString() );
        BigDecimal e = new BigDecimal( util.randomInt( 1, aInt - 1 ).toString() );
        BigDecimal b = new BigDecimal( aInt * util.randomInt( 2, 5 ) + "" );
        BigDecimal x = util.nonZeroRandom( -10, 10 );
        BigDecimal c, d;

        // prevents infinite/no solutions
        do {
            c = util.nonZeroRandom( -10, 10 );
        }
        while ( c.compareTo( new BigDecimal( e + "" ) ) == 0 );
        d = e.divide( a ).multiply( a.multiply( x ).add( b ) ).subtract( c.multiply( x ) );
        answer = x + "";

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                equation = util.simplifyFraction( e.intValue(), a.intValue() ) + "(" + a + "x + " + b + ") = " + c + "x + " + d;
                break;
            case 1:
                equation = c + "x + " + d + " = " + util.simplifyFraction( e.intValue(), a.intValue() ) + "(" + a + "x + " + b + ")";
                break;
            case 2:
                equation = d + " + " + c + "x = " + util.simplifyFraction( e.intValue(), a.intValue() ) + "(" + a + "x + " + b + ")";
                break;
            case 3:
                equation = util.simplifyFraction( e.intValue(), a.intValue() ) + "(" + b + " + " + a + "x) = " + d + " + " + c + "x";
                break;
        }
    }

    private void variablesOnBothSidesWithDistributingCombining() {
        BigDecimal a, b, c, d, e, f, x;

        switch ( util.randomInt( 0, 2 ) ) {

            case 0:
                a = util.nonZeroRandom( -10, 10 );
                b = util.random( 2, 15 );
                c = util.random( 2, 15 );
                x = util.random( -8, 8 );
                e = util.random( 2, 10 );
                d = a.multiply( c.multiply( x ).add( b ) ).add( e );
                equation = a + "(" + c + "x + " + b + ") + " + e + "= " + d;
                answer = x + "";
                break;

            case 1:
                a = util.nonZeroRandom( -10, 10 );
                b = util.random( 2, 15 );
                c = util.random( 2, 15 );
                x = util.random( -8, 8 );
                // to prevent infinite solutions
                do {
                    e = util.random( 2, 10 );
                }
                while ( e.compareTo( a.multiply( c ).negate() ) == 0 );
                d = a.multiply( c.multiply( x ).add( b ) ).add( e.multiply( x ) );
                equation = a + "(" + c + "x + " + b + ") + " + e + "x= " + d;
                answer = x + "";
                break;

            case 2:
                a = util.nonZeroRandom( -10, 10 );
                b = util.random( 2, 15 );
                c = util.random( 2, 15 );
                x = util.random( -8, 8 );
                f = util.random( -5, 5 );
                // to prevent infinite solutions
                do {
                    e = util.random( 2, 10 );
                }
                while ( e.compareTo( a.multiply( c ).negate() ) == 0 );
                d = a.multiply( c.multiply( x ).add( b ) ).add( e.multiply( x ) ).add( f );
                equation = a + "(" + c + "x + " + b + ") + " + e + "x + " + f + "= " + d;
                answer = x + "";
                break;

        }
    }
}
