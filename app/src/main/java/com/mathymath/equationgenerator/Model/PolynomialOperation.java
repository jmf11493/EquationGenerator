package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PolynomialOperationSelection;

public class PolynomialOperation extends Generator {

    private int a, b, c, d, e, f, g, h, i, j, k, l;

    public PolynomialOperation() {
        super();
        selectionList = new PolynomialOperationSelection();
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
        switch ( ( PolynomialOperationSelection.Equation ) type ) {
            case ADDING_SUBTRACTING:
                addingSubtraction();
                break;
            case MULTIPLYING:
                multiplying();
                break;
            case DIVIDING:
                dividing();
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

    private void addingSubtraction() {
        a = util.nonZeroRandomInt( -10, 10 );
        b = util.nonZeroRandomInt( -10, 10 );
        c = util.nonZeroRandomInt( -10, 10 );
        d = util.nonZeroRandomInt( -10, 10 );
        e = util.nonZeroRandomInt( -10, 10 );
        f = util.nonZeroRandomInt( -10, 10 );
        g = util.nonZeroRandomInt( -10, 10 );
        h = util.nonZeroRandomInt( -10, 10 );

        switch ( util.randomInt( 0, 1 ) ) {
            // adding trinomials
            case 0:
                equation = "(" + a + "x^2 + " + b + "x +" + c + ") + (" + d + "x^2 + " + e + "x + " + f + ")";
                answer = "";

                if ( ( a + d ) != 0 ) {
                    answer = a + d + "x^2";
                }
                if ( ( b + e ) != 0 ) {
                    answer += answer.equals( "" ) ? "" : " + ";
                    answer += ( b + e ) + "x ";
                }
                if ( ( c + f ) != 0 ) {
                    answer += answer.equals( "" ) ? "" : " + ";
                    answer += ( c + f );
                }
                if ( answer == "" ) {
                    answer = "0";
                }
                break;

            // subtracting trinomials
            case 1:
                equation = "(" + a + "x^2 + " + b + "x +" + c + ") - (" + d + "x^2 + " + e + "x + " + f + ")";
                answer = "";

                if ( ( a - d ) != 0 ) {
                    answer = a - d + "x^2";
                }
                if ( ( b - e ) != 0 ) {
                    answer += answer.equals( "" ) ? "" : " + ";
                    answer += ( b - e ) + "x ";
                }
                if ( ( c - f ) != 0 ) {
                    answer += answer.equals( "" ) ? "" : " + ";
                    answer += ( c - f );
                }
                if ( answer == "" ) {
                    answer = "0";
                }
                break;

            default:
                // Nothing
        }
    }

    private void multiplying() {
        a = util.nonZeroRandomInt( -10, 10 );
        b = util.nonZeroRandomInt( -10, 10 );
        c = util.nonZeroRandomInt( -10, 10 );
        d = util.nonZeroRandomInt( -10, 10 );
        e = util.randomInt( 2, 9 );

        do {
            f = util.randomInt( 2, 9 );
        } while ( e == f );
        do {
            g = util.randomInt( 2, 9 );
        } while ( g == f || g == e );
        do {
            h = util.randomInt( 2, 9 );
        } while ( h == g || h == e || h == f );

        switch ( util.randomInt( 0, 3 ) ) {

            // 1 x 1
            case 0:
                equation = "(" + a + "x^" + e + ")(" + b + "x^" + f + ")";
                answer = a * b + "x^{" + ( e + f ) + "}";
                break;
            // 1 x 2
            case 1:
                equation = "(" + a + "x^" + e + ")(" + b + "x^" + f + " + " + c + "x^" + g + ")";
                answer = a * b + "x^{" + ( e + f ) + "} + " + a * c + "x^{" + ( e + g ) + "}";
                break;
            // 1 x 3
            case 2:
                equation = "(" + a + "x^" + e + ")(" + b + "x^" + f + " + " + c + "x^" + g + " + " + d + "x^" + h + ")";
                answer = a * b + "x^{" + ( e + f ) + "} + " + a * c + "x^{" + ( e + g ) + "} + " + a * d + "x^{" + ( e + h ) + "}";
                break;
            // 2 x 2
            case 3:
                equation = "(" + a + "x + " + b + ")";
                equation += "(" + c + "x + " + d + ")";

                e = b * c + d * a;
                answer = a * c + "x^2 + " + e + "x  + " + b * d;
                break;
            default:
                // Nothing
        }
    }

    private void dividing() {
        switch ( util.randomInt( 0, 1 ) ) {

            case 0:
                a = util.nonZeroRandomInt( -10, 10 );
                b = util.nonZeroRandomInt( -10, 10 );
                c = util.nonZeroRandomInt( -10, 10 );
                d = util.nonZeroRandomInt( -10, 10 );
                e = util.randomInt( 2, 9 );
                do {
                    f = util.randomInt( 2, 9 );
                } while ( e == f );
                do {
                    g = util.randomInt( 2, 9 );
                } while ( g == f || g == e );
                do {
                    h = util.randomInt( 2, 9 );
                } while ( h == g || h == e || h == f );

                equation = "(" + a * b + "x^{" + ( e + f ) + "} + " + a * c + "x^{" + ( e + g ) + "} + " + a * d + "x^{" + ( e + h ) + "})÷(" + a + "x^" + e + ")";
                answer = b + "x^" + f + " + " + c + "x^" + g + " + " + d + "x^" + h;

                break;

            case 1:
                a = util.nonZeroRandomInt( -10, 10 );
                b = util.nonZeroRandomInt( -10, 10 );
                c = util.nonZeroRandomInt( -10, 10 );
                d = util.nonZeroRandomInt( -10, 10 );
                e = util.randomInt( 2, 9 );
                do {
                    f = util.randomInt( 2, 9 );
                } while ( e == f );
                do {
                    g = util.randomInt( 2, 9 );
                } while ( g == f || g == e );
                do {
                    h = util.randomInt( 2, 9 );
                } while ( h == g || h == e || h == f );

                equation = "\\begin{align}\\frac{" + a * b + "x^{" + ( e + f ) + "} + " + a * c + "x^{" + ( e + g ) + "} + " + a * d + "x^{" + ( e + h ) + "}}{" + a + "x^" + e + "}\\end{align}";
                answer = b + "x^" + f + " + " + c + "x^" + g + " + " + d + "x^" + h;
            default:
                // Nothing
        }
    }

    private void factoringOutGcf() {
        answer = "";
        switch ( util.randomInt( 0, 2 ) ) {
            // binomial
            case 0:
                a = util.randomInt( 2, 20 );
                b = util.randomInt( 2, 20 );
                c = util.gcd( a, b );
                d = util.randomInt( 2, 9 );
                do {
                    e = util.randomInt( 2, 9 );
                } while ( d == e );
                f = Math.min( d, e );

                equation = a + "x^" + d + " + " + b + "x^" + e;
                if ( c != 1 ) {
                    answer += c;
                }
                answer += "x^" + f + "(" + a / c;
                if ( ( d - f ) != 0 ) {
                    answer += "x^" + ( d - f );
                }
                answer += " + " + ( b / c );
                if ( ( e - f ) != 0 ) {
                    answer += "x^" + ( e - f );
                }
                answer += ")";

                break;
            // trinomial all x
            case 1:
                a = util.randomInt( 2, 20 );
                b = util.randomInt( 2, 20 );
                c = util.randomInt( 2, 20 );
                d = util.gcd( a, util.gcd( b, c ) );

                e = util.randomInt( 2, 9 );
                do {
                    f = util.randomInt( 2, 9 );
                } while ( e == f );
                do {
                    g = util.randomInt( 1, 9 );
                } while ( g == f || g == e );
                h = Math.min( e, Math.min( f, g ) );

                equation = a + "x^" + e + " + " + b + "x^" + f + " + " + c + "x^" + g;
                if ( d != 1 ) {
                    answer += d;
                }
                answer += "x^" + h + "(" + a / d;
                if ( ( e - h ) != 0 ) {
                    answer += "x^" + ( e - h );
                }
                answer += " + " + ( b / d );
                if ( ( f - h ) != 0 ) {
                    answer += "x^" + ( f - h );
                }
                answer += " + " + ( c / d );
                if ( ( g - h ) != 0 ) {
                    answer += "x^" + ( g - h );
                }
                answer += ")";

                break;
            // trinomial x and y
            case 2:
                a = util.randomInt( 2, 20 );
                b = util.randomInt( 2, 20 );
                c = util.randomInt( 2, 20 );
                d = util.gcd( a, util.gcd( b, c ) );

                e = util.randomInt( 2, 9 );
                do {
                    f = util.randomInt( 2, 9 );
                } while ( e == f );
                do {
                    g = util.randomInt( 1, 9 );
                } while ( g == f || g == e );
                h = Math.min( e, Math.min( f, g ) );

                i = util.randomInt( 2, 9 );
                do {
                    j = util.randomInt( 2, 9 );
                } while ( i == j );
                do {
                    k = util.randomInt( 1, 9 );
                } while ( k == i || k == j );
                l = Math.min( i, Math.min( j, k ) );

                equation = a + "x^" + e + "y^" + i + " + " + b + "x^" + f + "y^" + j + " + " + c + "x^" + g + "y^" + k;
                if ( d != 1 ) {
                    answer += d;
                }
                answer += "x^" + h + "y^" + l + "(" + a / d;
                if ( ( e - h ) != 0 ) {
                    answer += "x^" + ( e - h );
                }
                if ( ( i - l ) != 0 ) {
                    answer += "y^" + ( i - l );
                }
                answer += " + " + ( b / d );
                if ( ( f - h ) != 0 ) {
                    answer += "x^" + ( f - h );
                }
                if ( ( j - l ) != 0 ) {
                    answer += "y^" + ( j - l );
                }
                answer += " + " + ( c / d );
                if ( ( g - h ) != 0 ) {
                    answer += "x^" + ( g - h );
                }
                if ( ( k - l ) != 0 ) {
                    answer += "y^" + ( k - l );
                }
                answer += ")";

                break;
            default:
                // Nothing
        }
    }

    private void factoringTrinomialsA1() {
        b = util.nonZeroRandomInt( -10, 10 );
        d = util.nonZeroRandomInt( -10, 10 );

        answer = "(x + " + b + ")(x + " + d + ")";

        equation = "x^2";
        e = b + d;
        if ( e != 0 ) {
            equation += " + " + e + "x ";
        }
        equation += " + " + b * d;
    }

    private void factoringTrinomialsANot1() {
        a = util.nonZeroRandomInt( 2, 5 );
        b = util.nonZeroRandomInt( -10, 10 );
        c = util.nonZeroRandomInt( 2, 5 );
        d = util.nonZeroRandomInt( -10, 10 );

        String answer1 = "(" + a + "x + " + b + ")(" + c + "x + " + d + ")";
        String answer2 = "";

        f = util.gcd( a, b );
        g = util.gcd( c, d );

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

            answer2 = "\\leftarrow\\) Factored Completely<br>\\(" + answer2;
        }

        equation = a * c + "x^2";
        e = b * c + d * a;

        if ( e != 0 ) {
            equation += " + " + e + "x ";
        }

        equation += " + " + b * d;

        answer = answer1 + "" + answer2;
    }
}
