package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.QuadraticFunctionsProblemSelection;

import java.math.BigDecimal;

public class QuadraticProblem extends Generator {

    private boolean realsOnly = false;

    public QuadraticProblem() {
        super();
        selectionList = new QuadraticFunctionsProblemSelection();
    }

    @Override
    public String getEquation() {
        return "\\(" + util.cleanEquation( util.removeDoubleSigns( equation ) ) + "\\)";
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( util.removeDoubleSigns( answer ) );
    }

    @Override
    public boolean hasSwitch() {
        return true;
    }

    @Override
    public String getSwitchLabel() {
        return "Reals Only";
    }

    @Override
    public void switchListener( boolean checked ) {
        realsOnly = checked;
    }

    @Override
    public void generate() {
        switch ( ( QuadraticFunctionsProblemSelection.Equation ) type ) {
            case ALL_METHODS:
                allMethods();
                break;
            case QUADRATIC_FORMULA:
                quadraticFormula();
                break;
            case COMPLETING_THE_SQUARE:
                completingTheSquare();
                break;
            case SQUARE_ROOTS:
                squareRoots();
                break;
            case FACTORING_OUT_GCF:
                factoringOutGcf();
                break;
            case FACTORING_TRINOMIALS_A_1:
                factoringTrinomialsA1();
                break;
            case FACTORING_TRINOMIALS_A_NOT_1:
                factoringTrinomialsANot1();
                break;
            default:
                // Nothing
        }
    }

    private void allMethods() {
        switch ( util.randomInt( 0, 5 ) ) {
            case 0:
                setType( QuadraticFunctionsProblemSelection.Equation.QUADRATIC_FORMULA );
                break;
            case 1:
                setType( QuadraticFunctionsProblemSelection.Equation.COMPLETING_THE_SQUARE );
                break;
            case 2:
                setType( QuadraticFunctionsProblemSelection.Equation.SQUARE_ROOTS );
                break;
            case 3:
                setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_OUT_GCF );
                break;
            case 4:
                setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_TRINOMIALS_A_1 );
                break;
            case 5:
                setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_TRINOMIALS_A_NOT_1 );
                break;
            default:
                // Nothing
        }

        generate();
        // Set the type back to All Methods
        setType( QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    private void quadraticFormula() {
        Integer a, b, c;
        BigDecimal d;

        if ( realsOnly ) {
            do {
                a = util.randomInt( 2, 10 );
                b = util.nonZeroRandomInt( -10, 10 );
                c = util.nonZeroRandomInt( -15, 15 );
                Integer fourAC = 4 * a * c;
                d = new BigDecimal( b.toString() ).pow( 2 ).subtract( new BigDecimal( fourAC.toString() ) );
            } while ( d.compareTo( BigDecimal.ZERO ) < 0 );
        } else {
            a = util.randomInt( 2, 10 );
            b = util.nonZeroRandomInt( -10, 10 );
            c = util.nonZeroRandomInt( -15, 15 );
            Integer fourAC = 4 * a * c;
            d = new BigDecimal( b.toString() ).pow( 2 ).subtract( new BigDecimal( fourAC.toString() ) );
        }

        equation = a + "x^2 + " + b + "x + " + c + " = 0";

        boolean imaginary = d.compareTo( BigDecimal.ZERO ) < 0;
        boolean complex = new BigDecimal( Math.sqrt( d.abs().doubleValue() ) + "" ).remainder( new BigDecimal( "1" ) ).compareTo( BigDecimal.ZERO ) != 0;

        // double-root
        if ( d.compareTo( BigDecimal.ZERO ) == 0 ) {
            answer = "\\(\\Big\\{" + ( -b / ( 2 * a ) ) + "\\Big\\}\\)";
        } else if ( complex ) {
            // not a perfect square root
            answer = "\\(\\Big\\{" + util.simplifyComplexFraction( "" + -b, 2 * a ) + " \\pm " + util.simplifyComplexFraction( util.simplifyRadical( d ), 2 * a ) + "\\Big\\}\\)";
        } else {
            // perfect square root
            if ( !imaginary ) {
                BigDecimal sqrtD = new BigDecimal( Math.sqrt( d.doubleValue() ) + "" );
                BigDecimal bMinusSqrt = new BigDecimal( b.toString() ).negate().subtract( sqrtD );
                // real
                answer = "\\(\\Big\\{" + util.simplifyComplexFraction( "" + -b + sqrtD, 2 * a ) + ", " + util.simplifyComplexFraction( "" + bMinusSqrt, 2 * a ) + "\\Big\\}\\)";
            } else {
                // imaginary
                BigDecimal sqrtD = new BigDecimal( Math.sqrt( d.abs().doubleValue() ) + "" );
                int imag = sqrtD.intValue();
                answer = "\\(\\Big\\{" + util.simplifyComplexFraction( "" + -b, 2 * a ) + "\\pm " + util.simplifyComplexFraction( "" + imag, 2 * a ) + "i\\Big\\}\\)";
            }
        }
    }

    private void completingTheSquare() {
        Integer h, a, b, k;

        if ( realsOnly ) {
            do {
                h = util.nonZeroRandomInt( -10, 10 );
                a = h * 2;
                b = util.nonZeroRandomInt( -10, 10 );
                k = ( b - ( h * h ) );
            } while ( k > 0 );
        } else {
            h = util.nonZeroRandomInt( -10, 10 );
            a = h * 2;
            b = util.nonZeroRandomInt( -10, 10 );
            k = ( b - ( h * h ) );
        }

        equation = "x^2 + " + a + "x + " + b + " = 0";

        answer = "\\((x + " + h + ")^2 + " + k + "= 0 \\leftarrow\\) Vertex Form. Vertex is \\((" + ( -h ) + ", " + k + ")\\)<br>\\(\\Big\\{ ";

        if ( !( Math.sqrt( -k ) % 1 == 0 ) && !( Math.sqrt( k ) % 1 == 0 ) ) {
            answer += ( -h ) + " \\pm " + util.simplifyRadical( new BigDecimal( k.toString() ).negate() );
        } else {
            if ( ( Math.sqrt( -k ) ) % 1 == 0 ) {
                if ( k != 0 ) {
                    answer += ( ( -h ) + Math.sqrt( -k ) ) + ", " + ( ( -h ) - Math.sqrt( -k ) ) + "";
                } else {
                    answer += ( -h ) + "";
                }
            } else {
                answer += ( -h ) + " \\pm " + Math.sqrt( k ) + "i";
            }
        }
        answer += "\\Big\\}\\)";
    }

    private void squareRoots() {
        Integer a = util.nonZeroRandomInt( 2, 10 );
        Integer b = a * -1;
        Integer c = 0;
        Integer d = util.nonZeroRandomInt( -10, 10 );
        Integer e = a * a;

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                c = util.randomInt( 2, 10 );
                break;
            case 1:
                c = util.randomInt( -10, -2 );
                break;
            default:
                // Nothing
        }

        switch ( util.randomInt( 0, 2 ) ) {
            // c * x^2 = square*c
            case 0:
                equation = c + "x^2 = " + ( e * c );
                break;

            // x^2 + d = square + d
            case 1:
                equation = "x^2 + " + d + " = " + ( e + d );
                break;

            // c * x^2 + d = (square *c)+d
            case 2:
                equation = c + "x^2 + " + d + " = " + ( ( e * c ) + d );
                break;
            default:
                // Nothing
        }

        answer = "\\(\\Big\\{" + b + ", " + a + "\\Big\\}\\)";
    }

    private void factoringOutGcf() {
        int b = util.randomInt( 2, 10 );
        int c = util.randomInt( 2, 7 );
        int a = b * c;

        int d = util.gcd( a, b );

        equation = a + "x^2 + " + b + "x = 0";
        answer = "\\(" + d + "x(" + ( a / d ) + "x + " + ( b / d ) + ") = 0\\) <br> \\( \\Big\\{0, -\\frac{" + ( b / d ) + "}{" + ( a / d ) + "} \\Big\\}\\)";
    }

    private void factoringTrinomialsA1() {
        int b = util.nonZeroRandomInt( -10, 10 );
        int d = util.nonZeroRandomInt( -10, 10 );
        int e = b + d;

        equation = "x^2";

        if ( e != 0 ) {
            equation += " + " + e + "x ";
        }
        equation += " + " + b * d + " = 0";

        answer = "\\((x + " + b + ")(x + " + d + ") = 0\\) <br> \\( \\Big\\{" + -1 * b;
        if ( b != d ) {
            answer += ", " + -1 * d;
        }
        answer += " \\Big\\}\\)";
    }

    private void factoringTrinomialsANot1() {
        Integer a = util.nonZeroRandomInt( 2, 5 );
        Integer b = util.nonZeroRandomInt( -10, 10 );
        Integer c = util.nonZeroRandomInt( 2, 5 );
        Integer d = util.nonZeroRandomInt( -10, 10 );
        Integer e = b * c + d * a;

        String root1 = "";
        String root2 = "";

        equation = a * c + "x^2";

        if ( e != 0 ) {
            equation += " + " + e + "x ";
        }
        equation += " + " + b * d + " = 0";

        String answer1 = "\\((" + a + "x + " + b + ")(" + c + "x + " + d + ") = 0\\)";
        String answer2 = "";

        Integer f = util.gcd( a, b );
        Integer g = util.gcd( c, d );

        if ( ( g * f ) != 1 ) {

            answer2 = g * f + "";

            if ( f == 1 ) {
                answer2 += "(" + a + "x + " + b + ")";
            } else {
                answer2 += "(" + a / f + "x + " + b / f + ")";
            }

            if ( g == 1 ) {
                answer2 += "(" + c + "x + " + d + ")";
            } else {
                answer2 += "(" + c / g + "x + " + d / g + ")";
            }

            answer2 = "<br>\\(" + answer2 + "= 0 \\leftarrow\\) Factored Completely";

        }

        if ( ( -b.doubleValue() / a.doubleValue() ) % 1 == 0 ) {
            root1 = -b / a + "";
        } else {
            if ( ( b.doubleValue() / a.doubleValue() ) < 0 ) {
                root1 = "-";
            }
            root1 += "\\frac{" + Math.abs( b / f ) + "}{" + Math.abs( a / f ) + "}";
        }

        if ( ( -d / c ) % 1 == 0 ) {
            root2 = -d / c + "";
        } else {
            if ( ( -d / c ) < 0 ) {
                root2 = "-";
            }
            root2 += "\\frac{" + Math.abs( d / g ) + "}{" + Math.abs( c / g ) + "}";
        }

        answer = answer1 + answer2 + "<br>\\(\\Big\\{" + root1;

        if ( root2 != root1 ) {
            answer += ", " + root2;
        }
        answer += " \\Big\\}\\)";
    }
}
