package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ExpressionsSelection;

public class Expressions extends Generator {

    public Expressions() {
        super();
        selectionList = new ExpressionsSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation( util.removeDoubleSigns( equation ) );
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( util.removeDoubleSigns( util.removeLeadingZero( answer ) ) );
    }

    @Override
    public void generate() {
        switch ( ( ExpressionsSelection.Equation ) type ) {
            case TRANSLATING_WORDS:
                translatingWords();
                break;
            case EVALUATING_EXPRESSIONS:
                evaluatingExpressions();
                break;
            case COMBINING_LIKE_TERMS:
                combiningLikeTerms();
                break;
            case DISTRIBUTING:
                distributing();
                break;
            case DISTRIBUTING_AND_COMBINING:
                distributingAndCombining();
                break;
            case FACTORING:
                factoring();
                break;
            default:
                // Nothing
        }
    }

    private void translatingWords() {
        String a = util.generateBase( false );
        String b, c;
        int d;

        do {
            b = util.generateBase( false );
        } while ( b.equals( a ) );
        do {
            c = util.generateBase( false );
        } while ( c.equals( b ) || c.equals( a ) );

        switch ( util.randomInt( 0, 19 ) ) {
            case 0:
                // sum 1
                equation = "The sum of \\(" + a + "\\) and \\(" + b + "\\)";
                answer = "\\(" + a + " + " + b + "\\)";
                break;
            case 1:
                // sum 2
                equation = "\\(" + a + "\\) plus \\(" + b + "\\)";
                answer = "\\(" + a + " + " + b + "\\)";
                break;
            case 2:
                // sum 3
                equation = "\\(" + a + "\\) more than \\(" + b + "\\)";
                answer = "\\(" + a + " + " + b + "\\)";
                break;
            case 3:
                // sum 4
                equation = "\\(" + a + "\\) increased by \\(" + b + "\\)";
                answer = "\\(" + a + " + " + b + "\\)";
                break;
            case 4:
                // difference 1
                equation = "\\(" + a + "\\) decreased by \\(" + b + "\\)";
                answer = "\\(" + a + " - " + b + "\\)";
                break;
            case 5:
                // difference 2
                equation = "\\(" + a + "\\) less than \\(" + b + "\\)";
                answer = "\\(" + b + " - " + a + "\\)";
                break;
            case 6:
                // difference 3
                equation = "\\(" + a + "\\) subtracted from \\(" + b + "\\)";
                answer = "\\(" + b + " - " + a + "\\)";
                break;
            case 7:
                // product 1
                equation = "The product of \\(" + a + "\\) and \\(" + b + "\\)";
                answer = "\\(" + a + " \\cdot " + b + "\\)";
                break;
            case 8:
                // product 2
                equation = "\\(" + a + "\\) times \\(" + b + "\\)";
                answer = "\\(" + a + " \\cdot " + b + "\\)";
                break;
            case 9:
                // product 3
                equation = "Double \\(" + a + "\\)";
                answer = "\\(2 \\cdot " + a + "\\)";
                break;
            case 10:
                // product 4
                equation = "Triple \\(" + a + "\\)";
                answer = "\\(3 \\cdot " + a + "\\)";
                break;
            case 11:
                // quotient 1
                equation = "The quotient of \\(" + a + "\\) and \\(" + b + "\\)";
                answer = "\\(" + a + " \\div " + b + "= \\frac{" + a + "}{" + b + "}\\)";
                break;
            case 12:
                // quotient 2
                equation = "\\(" + a + "\\) divided by \\(" + b + "\\)";
                answer = "\\(" + a + " \\div " + b + "= \\frac{" + a + "}{" + b + "}\\)";
                break;
            case 13:
                // quotient 3
                equation = "The ratio of \\(" + a + "\\) to \\(" + b + "\\)";
                answer = "\\(\\frac{" + a + "}{" + b + "}\\)";
                break;
            case 14:
                // mixed 1
                equation = "\\(" + a + "\\) less than \\(" + b + "\\) times \\(" + c + "\\)";
                answer = "\\(" + b + " \\cdot " + c + " - " + a + "\\)";
                break;
            case 15:
                // mixed 2
                equation = "\\(" + a + "\\) increased by \\(" + b + "\\) times \\(" + c + "\\)";
                answer = "\\(" + a + " + " + b + " \\cdot " + c + "\\)";
                break;
            case 16:
                // mixed 3
                equation = "\\(" + a + "\\) times the sum of \\(" + b + "\\) and \\(" + c + "\\)";
                answer = "\\(" + a + " \\cdot (" + b + " + " + c + ")\\)";
                break;
            case 17:
                // mixed 4
                equation = "The difference of \\(" + a + "\\) and the sum of \\(" + b + "\\) and \\(" + c + "\\)";
                answer = "\\(" + a + " - (" + b + " + " + c + ")\\)";
                break;
            case 18:
                // mixed 4
                d = util.randomInt( 2, 10 );
                equation = "The difference of \\(" + a + "\\) and \\(" + d + "\\) times the sum of \\(" + b + "\\) and \\(" + c + "\\)";
                answer = "\\(" + a + " - " + d + "(" + b + " + " + c + ")\\)";
                break;
            case 19:
                // squared
                equation = "\\(" + a + "\\) squared";
                answer = "\\(" + a + "^{2}\\)";
                break;
            default:
                // Nothing
        }
    }

    private void evaluatingExpressions() {
        String exp = "";
        String situation = "";

        Integer ans;
        Integer a = util.nonZeroRandomInt( -10, 10 );
        Integer b = util.nonZeroRandomInt( -10, 10 );
        Integer c = util.randomInt( 2, 5 );
        Integer d;

        switch ( util.randomInt( 0, 3 ) ) {

            case 0:
                exp = "\\(x^2 + y\\cdot z\\)";
                ans = ( ( c * c ) + a * b );
                situation = "\\(x = " + c + ", y = " + a + ", \\) and \\(z = " + b + "\\)";
                answer = "\\(" + ans + "\\)";
                break;

            case 1:
                exp = "\\((x + y)\\cdot z\\)";
                ans = ( ( c + a ) * b );
                situation = "\\(x = " + c + ", y = " + a + ", \\) and \\(z = " + b + "\\)";
                answer = "\\(" + ans + "\\)";
                break;

            case 2:
                d = util.randomInt( 2, 9 );
                exp = "\\(" + d + "(x + y) + z\\)";
                ans = ( d * ( c + a ) + b );
                situation = "\\(x = " + c + ", y = " + a + ", \\) and \\(z = " + b + "\\)";
                answer = "\\(" + ans + "\\)";
                break;

            case 3:
                d = util.randomInt( 2, 9 );
                exp = "\\(x \\cdot y + " + d + "z\\)";
                ans = ( c * a + d * b );
                situation = "\\(x = " + c + ", y = " + a + ", \\) and \\(z = " + b + "\\)";
                answer = "\\(" + ans + "\\)";
                break;

        }
        equation = "Evaluate " + exp + " when " + situation;
    }

    private void combiningLikeTerms() {
        // constants/coefficients
        int a = util.nonZeroRandomInt( -10, 10 );
        int b = util.nonZeroRandomInt( -10, 10 );
        int c = util.nonZeroRandomInt( -10, 10 );
        int d = util.nonZeroRandomInt( -10, 10 );
        int e = util.nonZeroRandomInt( -10, 10 );
        int f = util.nonZeroRandomInt( -10, 10 );

        switch ( util.randomInt( 0, 10 ) ) {
            case 0:
                equation = a + " + " + d + "x + " + b + " + " + f + "x";
                answer = ( a + b ) + " + " + ( d + f ) + "x";
                break;
            case 1:
                equation = a + " + " + d + "y + " + b + " + " + f + "y";
                answer = ( a + b ) + " + " + ( d + f ) + "y";
                break;
            case 2:
                equation = a + "z + " + d + "y + " + b + "z + " + f + "y";
                answer = ( a + b ) + "z + " + ( d + f ) + "y";
                break;
            case 3:
                equation = a + "x^2 + " + d + "y + " + b + "x^2 + " + f + "y";
                answer = ( a + b ) + "x^2 + " + ( d + f ) + "y";
                break;
            case 4:
                equation = a + "x^2 + " + d + "x + " + b + "x^2 + " + f + "x";
                answer = ( a + b ) + "x^2 + " + ( d + f ) + "x";
                break;
            case 5:
                equation = a + "x + " + d + "y + " + b + "x + " + f;
                answer = ( a + b ) + "x + " + d + "y + " + f;
                break;
            case 6:
                equation = a + "x + " + d + "x^2 + " + b + "x + " + f;
                answer = ( a + b ) + "x + " + d + "x^2 + " + f;
                break;
            case 7:
                equation = a + "x + " + d + " + " + b + "y + " + f + "x + " + e + " + " + c + "y";
                answer = ( a + f ) + "x + " + ( b + c ) + "y + " + ( d + e );
                break;
            case 8:
                equation = a + "x + " + d + " + " + b + "x + " + f + "y + " + e + "x + " + c + "y";
                answer = ( a + b + e ) + "x + " + ( f + c ) + "y + " + d;
                break;
            case 9:
                equation = a + " + " + d + "y + " + b + "x + " + f + "y + " + e + "x + " + c + "y";
                answer = ( b + e ) + "x + " + ( d + f + c ) + "y + " + a;
                break;
            case 10:
                equation = a + " + " + d + "y + " + b + "x + " + e + " + " + f + "y + " + c;
                answer = b + "x + " + ( d + f ) + "y + " + ( a + c + e );
                break;
            default:
                // Nothing
        }
        equation = "Simplify: \\(" + equation + "\\)";
        answer = "\\(" + answer + "\\)";
    }

    private void distributing() {
        int a = util.nonZeroRandomInt( -10, 10 );
        int b = util.nonZeroRandomInt( -10, 10 );
        int c = util.nonZeroRandomInt( -10, 10 );

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                // distributing in a number
                equation = a + "(" + b + "x + " + c + ")";
                answer = ( a * b ) + "x + " + ( a * c );
                break;
            case 1:
                // distributing in x
                equation = "x(" + b + "x + " + c + ")";
                answer = b + "x^2 + " + c + "x";
                break;
            case 2:
                // distributing in a number with x
                equation = a + "x(" + b + "x + " + c + ")";
                answer = ( a * b ) + "x^2 + " + ( a * c ) + "x";
                break;
            case 3:
                // distributing in a number over a trinomial
                equation = a + "(" + b + "x + " + c + "+ y)";
                answer = ( a * b ) + "x + " + ( a * c ) + " + " + a + "y";
                break;

        }
        equation = "Distribute: \\(" + equation + "\\)";
        answer = "\\(" + answer + "\\)";
    }

    private void distributingAndCombining() {
        int a = util.nonZeroRandomInt( -10, 10 );
        int b = util.nonZeroRandomInt( -10, 10 );
        int c = util.nonZeroRandomInt( -10, 10 );
        int d = util.nonZeroRandomInt( -10, 10 );
        int f = util.nonZeroRandomInt( -10, 10 );
        int h = util.nonZeroRandomInt( -10, 10 );

        int e, g;

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                // adding a constant outside
                equation = a + "(" + b + "x + " + c + ") + " + d;
                answer = ( a * b ) + "x";
                e = ( a * c ) + d;
                if ( e != 0 ) {
                    answer += " + " + e;
                }
                break;
            // adding a variable outside
            case 1:
                equation = a + "(" + b + "x + " + c + ") + " + d + "x";
                answer = ( a * c ) + "";
                e = ( a * b ) + d;

                if ( e != 0 ) {
                    answer = e + "x +" + answer;
                }
                break;
            // adding a variable and a constant outside
            case 2:
                equation = a + "(" + b + "x + " + c + ") + " + d + "x + " + f;
                e = ( a * b ) + d;
                g = ( a * c ) + f;

                if ( e != 0 ) {
                    answer = e + "x";

                    if ( g != 0 ) {
                        answer += " + " + g;
                    }
                } else {
                    if ( g != 0 ) {
                        answer = g + "";
                    } else {
                        answer = "0";
                    }
                }
                break;
            case 3:
                // two groups of parenthesis
                equation = a + "(" + b + "x + " + c + ") + " + h + "(" + d + "x + " + f + ")";
                e = ( a * b ) + ( d * h );
                g = ( a * c ) + ( f * h );

                if ( e != 0 ) {
                    answer = e + "x";
                    if ( g != 0 ) {
                        answer += " + " + g;
                    }
                } else {
                    if ( g != 0 ) {
                        answer = g + "";
                    } else {
                        answer = "0";
                    }
                }
                break;
            default:
                // Nothing
        }
        equation = "Distribute and Simplify: \\(" + equation + "\\)";
        answer = "\\(" + answer + "\\)";
    }

    private void factoring() {
        int a, b, d, c;

        do {
            a = util.randomInt( 2, 20 );
            b = util.randomInt( 2, 20 );
            c = util.gcd( a, b );
            d = a / c;
        } while ( c == 1 );

        String dString = "" + d;
        if ( d == 1 ) {
            dString = "";
        }

        String sign = "+";
        // do 50-50 add/subtract
        if ( util.randomInt( 0, 1 ) == 0 ) {
            sign = "-";
        }

        switch ( util.randomInt( 0, 4 ) ) {

            // linear
            case 0:
            case 1:
            case 2:
            case 3:
                equation = a + "x " + sign + " " + b;
                answer = c + "(" + dString + "x " + sign + " " + ( b / c ) + ")";
                break;

            // quad
            case 4:
                equation = a + "x^2 " + sign + " " + b + "x";
                answer = c + "x(" + dString + "x " + sign + " " + ( b / c ) + ")";
                break;

        }

        equation = "Factor: \\(" + equation + "\\)";
        answer = "\\(" + answer + "\\)";
    }
}
