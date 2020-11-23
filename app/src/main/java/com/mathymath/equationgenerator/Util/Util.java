package com.mathymath.equationgenerator.Util;

import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblemFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util implements Serializable {

    private boolean rational = true;

    private int decimalPlaces = 3;

    public Util() {

    }

    public void setRational( boolean rational ) {
        this.rational = rational;
    }

    public String removeDoubleSigns( String equation ) {
        equation = equation.replace( "-+", "-" );
        equation = equation.replace( "+-", "-" );
        equation = equation.replace( "- +", "-" );
        equation = equation.replace( "+ -", "-" );
        equation = equation.replace( "- -", "+" );
        equation = equation.replace( "--", "+" );
        equation = equation.replace( "++", "+" );
        equation = equation.replace( "+ +", "+" );

        return equation;
    }

    public String removePowersOfOne( String equation ) {
        Matcher matcher = Pattern.compile( "(\\^1)([^\\d])" ).matcher( equation );

        while ( matcher.find() ) {
            equation = equation.replace( matcher.group( 1 ) + matcher.group( 2 ), matcher.group( 2 ) );
        }

        return equation;
    }

    public String removeLeadingZero( String equation ) {
        boolean addPrefix = false;
        boolean addSuffix = false;

        if (equation.startsWith( "\\(" )) {
            equation = equation.substring( 2, equation.length() );
            addPrefix = true;
        }

        if (equation.endsWith( "\\)" )) {
            equation = equation.substring(0, equation.length() - 2);
            addSuffix = true;
        }

        if ( !"0".equals( equation.trim() ) ) {
            Matcher matcher = Pattern.compile( "(?:^0\\s*[^\\s\\d+-]*)|(?:[+-]\\s*0(?:\\s*[^\\s\\d+-]*)|$)" ).matcher( equation );

            while ( matcher.find() ) {
                String match = matcher.group();

                equation = equation.replace( match, "" );
            }
        }

        // replace double spaces with single space
        if ( equation.contains("  ") ) {
            equation = equation.replace( "  ", " " );
        }

        // remove starting +
        if (equation.trim().startsWith( "+" )) {
            equation = equation.replaceFirst( "\\+", "" );
        }

        // remove leading and trailing spaces
        equation = equation.trim();

        if (addPrefix) {
            equation = "\\(" + equation;
        }

        if (addSuffix) {
            equation += "\\)";
        }

        return equation;
    }

    public String removeTrailingZero( String equation ) {
        // Verify the answer has a number
        Matcher matcher = Pattern.compile( ".*\\d+.*" ).matcher( equation );

        if ( matcher.find() ) {
            // Remove 1 in front of variables
            matcher = Pattern.compile( "([^\\d])(\\d)([xyabc])" ).matcher( equation );

            while ( matcher.find() ) {
                String match = matcher.group( 2 );

                if ( Integer.parseInt( match ) == 1 ) {
                    String find = matcher.group( 1 ) + match + matcher.group( 3 );
                    String replace = matcher.group( 1 ) + matcher.group( 3 );

                    equation = equation.replace( find, replace );
                }
            }

            // Remove powers of one
            equation = removePowersOfOne( equation );

            // Trim trailing 0's
            // probably could just remove the 0 that is infront of anything that isn't a number
            equation = equation.replaceAll( "([0-9]+\\.[0-9]*?)(0+)([^\\d]|$){1}", "$1$3" );
            equation = equation.replaceAll( "([0-9]+)(\\.)([^0-9]|$)", "$1$3" );
        }

        return equation;
    }

    public String cleanEquation( String equation ) {
        return removeTrailingZero( roundValue( equation ) );
    }

    public String roundValue( String input ) {
        return roundValue( input, null );
    }

    /**
     * Rounds all decimals in the string to the specified
     * number of decimal places, or the default which is 3
     *
     * @param input
     * @param decimalPlaces
     * @return
     */
    public String roundValue( String input, Integer decimalPlaces ) {
        this.decimalPlaces = ( decimalPlaces != null && decimalPlaces > -1 ) ? decimalPlaces : this.decimalPlaces;

        String roundedInput = input;
        Matcher matcher = Pattern.compile( "(\\d*?\\.\\d+)" ).matcher( input );

        while ( matcher.find() ) {
            String match = matcher.group( 1 );
            String number = match;

            BigDecimal roundNumber = new BigDecimal( number );

            number = roundNumber.setScale( this.decimalPlaces, RoundingMode.HALF_UP ).toString();
            roundedInput = roundedInput.replace( match, number );
        }

        return roundedInput;
    }

    public Integer nonZeroRandomInt( int min, int max ) {

        Integer random = randomInt( min, max );

        while ( random == 0 ) {
            random = randomInt( min, max );
        }

        return random;
    }

    public BigDecimal nonZeroRandom( int min, int max ) {

        BigDecimal random = random( min, max );

        while ( random.compareTo( BigDecimal.ZERO ) == 0 ) {
            random = random( min, max );
        }

        return random;
    }

    public Integer randomInt( int min, int max ) {
        return ( int ) Math.floor( Math.random() * ( max - min + 1 ) ) + min;
    }

    public BigDecimal random( int min, int max ) {
        BigDecimal random;

        if ( rational ) {
            // TODO make decimal places a field and not a magic number
            random = randomDecimal( new BigDecimal(min) , new BigDecimal(max), 1 );
        } else {
            random = new BigDecimal(Math.floor( Math.random() * ( max - min + 1 ) ) + min );
        }

        return random;
    }

    public BigDecimal randomDecimal( BigDecimal min, BigDecimal max, int decimalPlaces ) {
        BigDecimal random = max.subtract( min ).multiply( new BigDecimal( Math.random() + "" ) ).add(min);
        // TODO make 10 a field and not a magic number
        BigDecimal power = new BigDecimal( Math.pow( 10, decimalPlaces ) + "" );

        return new BigDecimal( Math.floor( random.multiply( power ).doubleValue() ) + "" ).divide( power, decimalPlaces, BigDecimal.ROUND_HALF_UP );
    }

    public String generateBase( boolean isNegative ) {
        String base = "";

        switch ( randomInt( 0, 4 ) ) {
            case 0:
                base = "x";
                break;
            case 1:
                base = "y";
                break;
            case 2:
                base = randomInt( 2, 10 ) + "";
                break;
            case 3:
                if ( isNegative ) {
                    base = "(" + randomInt( -10, -2 ) + ")";
                } else {
                    base = randomInt( 2, 10 ) + "";
                }
                break;
            case 4:
                base = "z";
                break;
            default:
                // Nothing
        }

        return base;
    }

    public String convertToStandard( BigDecimal a, int b, int decimalPlaces ) {
        String output = "";
        String aString = a + "";
        String zeros =  "";

        if ( Math.abs(b) >= decimalPlaces ) {
            for ( int i = 0; i < Math.abs(b) - decimalPlaces; i++ ) {
                zeros += "0";
            }

            if ( b < 0 ) {
                output += "0." + zeros + aString.replace( ".", "" );
            } else {
                output += aString.replace( ".", "" ) + zeros;
            }
        } else if ( b == 0) {
            output += a;
        } else {
            int decimalIndex = aString.indexOf( "." );
            String removeDecimal = aString.replace(".", "");

            decimalIndex += b;
            output += removeDecimal.substring( 0, decimalIndex ) + "." + removeDecimal.substring(decimalIndex, removeDecimal.length());
        }

        return output;
    }

    public boolean stringEquals( String num1, String num2 ) {
        Integer intNum1 = null;
        Integer intNum2 = null;

        try {
            intNum1 = Integer.parseInt( num1 );
        } catch ( Exception e ) {
            // Variable
        }

        try {
            intNum2 = Integer.parseInt( num2 );
        } catch ( Exception e ) {
            // Variable
        }

        if ( ( intNum1 == null ) && ( intNum2 == null ) ) {
            return num1.equals( num2 );
        } else if ( ( intNum1 != null ) && ( intNum2 != null ) ) {
            return intNum1 == intNum2;
        }

        return false;
    }

    public int gcd( int x, int y ) {
        x = Math.abs( x );
        y = Math.abs( y );

        while ( y > 0 ) {
            int t = y;
            y = x % y;
            x = t;
        }

        return x;
    }

    // TODO move to FunctionFeatures class
    public Map< String, String > generateFunction() {
        String func = "";
        String parent = "";
        String trans = "";
        String domain = "";
        String range = "";
        String inc = "";
        String dec = "";

        // reflection over x-axis
        int refl = 0;
        switch ( randomInt( 0, 1 ) ) {

            case 0:
                refl = 1;
                trans += "Reflection over the \\(x\\)-axis;<br>";
                func += "-";
                break;
            case 1:
                refl = 0;
                break;
            default:
                // Nothing
        }

        String verticalStretch;
        switch ( randomInt( 0, 1 ) ) {
            case 0:
                verticalStretch = nonZeroRandomInt( 2, 6 ) + "";
                trans += " Vertical stretch times " + verticalStretch + ";<br>";
                func += verticalStretch;
                break;
            case 1:
                break;
            default:
                // Nothing
        }

        int horizontalTransformation = 0;
        switch ( randomInt( 0, 1 ) ) {
            case 0:
                horizontalTransformation = nonZeroRandomInt( -5, 5 );
                trans += " Horizontal shift ";

                if ( horizontalTransformation > 0 ) {
                    trans += "left ";
                } else {
                    trans += "right ";
                }

                trans += Math.abs( horizontalTransformation ) + " units;<br>";
                break;
            case 1:
                horizontalTransformation = 0;
                break;
            default:
                // Nothing
        }

        int verticalTransformation = 0;
        switch ( randomInt( 0, 1 ) ) {

            case 0:
                verticalTransformation = nonZeroRandomInt( -5, 5 );
                trans += " Vertical shift ";

                if ( verticalTransformation > 0 ) {
                    trans += "up ";
                } else {
                    trans += "down ";
                }

                trans += Math.abs( verticalTransformation ) + " units;<br>";
                break;

            case 1:
                verticalTransformation = 0;
                break;
            default:
                // Nothing
        }

        switch ( randomInt( 0, 4 ) ) {

            case 0: // abs value
                parent = "|x|";

                if ( horizontalTransformation != 0 ) {
                    func += "|x + " + horizontalTransformation + "|";

                    if ( refl == 0 ) {
                        inc = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                        dec = "(-\\infty ," + ( -1 * horizontalTransformation ) + ")";
                    } else {
                        dec = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                        inc = "(-\\infty ," + ( -1 * horizontalTransformation ) + ")";
                    }
                } else {
                    func += "|x|";
                    if ( refl == 0 ) {
                        inc = "(0, \\infty)";
                        dec = "(-\\infty ,0)";
                    } else {
                        dec = "(0, \\infty)";
                        inc = "(-\\infty ,0)";
                    }
                }

                domain = "(-\\infty , \\infty)";

                if ( verticalTransformation != 0 ) {
                    func += " + " + verticalTransformation;
                }

                if ( refl == 0 ) {
                    range = "[" + verticalTransformation + ", \\infty)";
                } else {
                    range = "(-\\infty , " + verticalTransformation + "]";
                }
                break;

            case 1: // quadratic
                parent = "x^2";

                if ( horizontalTransformation != 0 ) {
                    func += "(x + " + horizontalTransformation + ")^2";

                    if ( refl == 0 ) {
                        inc = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                        dec = "(-\\infty ," + ( -1 * horizontalTransformation ) + ")";
                    } else {
                        dec = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                        inc = "(-\\infty ," + ( -1 * horizontalTransformation ) + ")";
                    }
                } else {
                    func += "x^2";
                    if ( refl == 0 ) {
                        inc = "(0, \\infty)";
                        dec = "(-\\infty ,0)";
                    } else {
                        dec = "(0, \\infty)";
                        inc = "(-\\infty ,0)";
                    }
                }

                domain = "(-\\infty , \\infty)";

                if ( verticalTransformation != 0 ) {
                    func += " + " + verticalTransformation;
                }

                if ( refl == 0 ) {

                    range = "[" + verticalTransformation + ", \\infty)";

                } else {
                    range = "(-\\infty , " + verticalTransformation + "]";
                }

                break; // end quadratic

            case 2: // cubic
                parent = "x^3";
                if ( horizontalTransformation != 0 ) {
                    func += "(x + " + horizontalTransformation + ")^3";
                } else {
                    func += "x^3";
                }

                if ( refl == 0 ) {
                    inc = "(-\\infty , \\infty)";
                    dec = "\\)Never\\(";
                } else {
                    dec = "(-\\infty , \\infty)";
                    inc = "\\)Never\\(";
                }

                domain = "(-\\infty , \\infty)";

                if ( verticalTransformation != 0 ) {
                    func += " + " + verticalTransformation;
                }

                range = "(-\\infty , \\infty)";
                break;
            case 3: // square root
                parent = "\\sqrt{x}";

                if ( horizontalTransformation != 0 ) {
                    func += "\\sqrt{x + " + horizontalTransformation + "}";

                } else {
                    func += "\\sqrt{x}";
                }

                if ( refl == 0 ) {
                    inc = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                    dec = "\\)Never\\(";
                } else {
                    dec = "(" + ( -1 * horizontalTransformation ) + ", \\infty)";
                    inc = "\\)Never\\(";
                }

                domain = "[" + ( -1 * horizontalTransformation ) + " , \\infty)";

                if ( verticalTransformation != 0 ) {
                    func += " + " + verticalTransformation;
                }

                if ( refl == 0 ) {
                    range = "[" + verticalTransformation + ", \\infty)";
                } else {
                    range = "(-\\infty , " + verticalTransformation + "]";
                }
                break;
            case 4: // cubed root
                parent = "\\sqrt[3]{x}";

                if ( horizontalTransformation != 0 ) {
                    func += "\\sqrt[3]{x + " + horizontalTransformation + "}";
                } else {
                    func += "\\sqrt[3]{x}";
                }

                if ( refl == 0 ) {
                    inc = "(-\\infty , \\infty)";
                    dec = "\\)Never\\(";
                } else {
                    dec = "(-\\infty , \\infty)";
                    inc = "\\)Never\\(";
                }

                domain = "(-\\infty , \\infty)";

                if ( verticalTransformation != 0 ) {
                    func += " + " + verticalTransformation;
                }

                range = "(-\\infty , \\infty)";
                break;
            default:
                // Nothing
        }

        Map< String, String > functionMap = new HashMap();

        if ( "".equals( trans ) ) {
            trans = "None";
        }

        functionMap.put( "functionPrinted", removeDoubleSigns( func ) );
        functionMap.put( "parent", parent );
        functionMap.put( "domain", domain );
        functionMap.put( "range", range );
        functionMap.put( "increasing", inc );
        functionMap.put( "decreasing", dec );
        functionMap.put( "transforms", trans );

        return functionMap;
    }

    // TODO move the FunctionFeatures class
    public Map< String, String > generateForEval() {
        int x1 = randomInt( -10, 10 );
        int x2 = randomInt( 1, 10 ) + x1;
        int answer1 = 0;
        int answer2 = 0;
        int num1 = nonZeroRandomInt( -5, 5 );
        int num2 = nonZeroRandomInt( -5, 5 );
        int num3 = nonZeroRandomInt( -5, 5 );
        int num4 = nonZeroRandomInt( -5, 5 );

        String function = "";

        switch ( randomInt( 0, 3 ) ) {
            case 0:
                function = num1 + "x^2 + " + num2 + "x + " + num3;
                answer1 = ( int ) ( num1 * Math.pow( x1, 2 ) + num2 * x1 + num3 );
                answer2 = ( int ) ( num1 * Math.pow( x2, 2 ) + num2 * x2 + num3 );

                break;

            case 1:
                function = num4 + "x^3 + " + num1 + "x^2 + " + num2 + "x + " + num3;
                answer1 = ( int ) ( num4 * Math.pow( x1, 3 ) + num1 * Math.pow( x1, 2 ) + num2 * x1 + num3 );
                answer2 = ( int ) ( num4 * Math.pow( x2, 3 ) + num1 * Math.pow( x2, 2 ) + num2 * x2 + num3 );

                break;

            case 2:
                function = num1 + "|x| + " + num2;
                answer1 = num1 * Math.abs( x1 ) + num2;
                answer2 = num1 * Math.abs( x2 ) + num2;

                break;

            case 3:
                function = num1 + "|x + " + num3 + "| + " + num2;
                answer1 = num1 * Math.abs( x1 + num3 ) + num2;
                answer2 = num1 * Math.abs( x2 + num3 ) + num2;

                break;
            default:
                // Nothing

        }
        Map< String, String > output = new HashMap<>();

        output.put( "input1", "" + x1 );
        output.put( "input2", "" + x2 );
        // takes care of weird rounding errors
        output.put( "functionPrinted", removeDoubleSigns( function ) );
        output.put( "answer1", "" + Math.round( answer1 * 100000 ) / 100000 );
        output.put( "answer2", "" + Math.round( answer2 * 100000 ) / 100000 );

        return output;

    }

    public String simplifyFraction( int numerator, int denominator ) {
        // format the negative better so that it isn't in a fraction
        String simplifiedFraction;
        String neg = "";

        if ( ( numerator / denominator ) < 0 ) {
            numerator = Math.abs( numerator );
            denominator = Math.abs( denominator );
            neg = "-";

        }
        // if integer, return integer
        if ( ( numerator % denominator ) == 0 ) {
            simplifiedFraction = neg + numerator / denominator;
        } else {
            // otherwise, return fraction in simplest form
            int g = gcd( numerator, denominator );
            simplifiedFraction = neg + "\\frac{" + ( numerator / g ) + "}{" + ( denominator / g ) + "}";
        }

        return simplifiedFraction;
    }

    public String simplifyComplexFraction( String num, Integer denom ) {
        String simplifiedFraction;
        // format the i better, at the end to the right of all fractions
        String imaginary = "";
        if ( num.contains( "i" ) ) {
            num = num.split( "i" )[ 0 ];
            imaginary = "i";
        }

        // format the negative better so that it isn't in a fraction
        String neg = "";
        if ( num.contains( "-" ) || denom < 0 ) {
            num = num.replace( "-", "" );
            denom = Math.abs( denom );
            neg = "-";
        }

        BigDecimal denominator = new BigDecimal( denom.toString() );

        // no sqrt in numerator
        if ( !num.contains( "sqrt" ) ) {
            // if integer, return integer
            BigDecimal numerator = new BigDecimal( num );

            if ( numerator.remainder( denominator ).compareTo( BigDecimal.ZERO ) == 0 ) {
                simplifiedFraction = neg + numerator.divide( denominator, 200, BigDecimal.ROUND_HALF_UP ) + imaginary;
            } else {
                // otherwise, return fraction in simplest form
                Integer g = gcd( numerator.intValue(), denom );
                simplifiedFraction = neg + "\\frac{" + ( numerator.divide( new BigDecimal( g.toString() ), 200, BigDecimal.ROUND_HALF_UP ) ) + "}{" + ( denom / g ) + "}" + imaginary;
            }
        } else {
            // includes square root
            // grab the number in front of the square root
            String numb = num.split( "\\\\sqrt" )[ 0 ];
            String output = "";

            if ( !"".equals( numb ) ) {
                BigDecimal number = new BigDecimal( numb );
                Integer g = 1;

                // if integer TODO I think this function only works if the number in front of the sqrt is an integer
                if ( number.remainder( BigDecimal.ONE ).compareTo( BigDecimal.ZERO ) == 0 ) {
                    g = gcd( number.intValue(), denom );
                    if ( number.divide( new BigDecimal( g.toString() ), 200, BigDecimal.ROUND_HALF_UP ).compareTo( BigDecimal.ONE ) != 0 ) {
                        output += number.divide( new BigDecimal( g.toString() ), 200, BigDecimal.ROUND_HALF_UP );
                    }
                }

                if ( number.remainder( denominator ).compareTo( BigDecimal.ZERO ) == 0 ) {
                    output += "\\sqrt{" + num.split( "\\\\sqrt\\{" )[ 1 ];
                } else {
                    output = "\\frac{" + output + "\\sqrt{" + num.split( "\\\\sqrt\\{" )[ 1 ] + "}{" + ( denom / g ) + "}";
                }
            } else {
                output = "\\frac{" + output + "\\sqrt{" + num.split( "\\\\sqrt\\{" )[ 1 ] + "}{" + ( denom ) + "}";
            }
            simplifiedFraction = neg + output + imaginary;
        }

        return simplifiedFraction;
    }

    public String simplifyRadical( BigDecimal radicand ) {
        BigDecimal isqr = new BigDecimal( Math.floor( Math.sqrt( Math.abs( radicand.doubleValue() ) ) ) + "" );
        BigDecimal isqr2 = isqr.pow( 2 );
        BigDecimal inside = radicand;
        String front = "";
        String simplifiedRadical;

        while ( isqr2.compareTo( BigDecimal.ONE ) == 1 ) {

            if ( inside.remainder( isqr2 ).compareTo( BigDecimal.ZERO ) == 0 ) {
                front = isqr + "";
                inside = inside.divide( isqr2 );
                break;
            }

            isqr = isqr.subtract( BigDecimal.ONE );
            isqr2 = isqr.pow( 2 );
        }

        if ( radicand.compareTo( BigDecimal.ZERO ) < 0 ) {
            simplifiedRadical = front + "\\sqrt{" + inside.negate() + "}i";
        } else {
            simplifiedRadical = front + "\\sqrt{" + inside + "}";
        }

        return simplifiedRadical;
    }

    public Map< String, String > generateProportionalWordProblem(WordProblem wordProblem) {
        String single = wordProblem.getSingularPhrase();
        String plural = wordProblem.getPluralPhrase();
        BigDecimal price = wordProblem.getUnits();
        Integer num = wordProblem.getMultiplicity();
        BigDecimal cost = price.multiply( new BigDecimal( num.toString() ) );
        String problem = "Suppose \\(" + num + "\\) " + plural + " cost $\\(" + cost + "\\).";
        String answer = "";

        Integer newNum;
        BigDecimal newCost;

        // generate format of problem
        switch ( randomInt( 0, 2 ) ) {
            case 0:
                // cost of one unit
                problem += " What is the cost of one " + single + "?";
                answer = "$\\(" + price + "\\)";
                break;
            case 1:
                // cost of x units

                // num of new units
                newNum = randomInt( 1, 5 ) + num;
                // cost of new amount
                newCost = new BigDecimal( newNum.toString() ).multiply( new BigDecimal( price.toString() ) );
                problem += " What is the cost of \\(" + newNum + "\\) " + plural + "?";
                answer = "$\\(" + newCost + "\\)";
                break;
            case 2:
                // given cost, determine number of units

                // num of new pounds
                newNum = randomInt( 1, 5 ) + num;
                // cost of new amount
                newCost = new BigDecimal( newNum.toString() ).multiply( new BigDecimal( price.toString() ) );
                problem += " If a purchase of " + plural + " cost $\\(" + newCost + "\\), how many " + plural + " were purchased?";
                answer = "\\(" + newNum + "\\) " + plural;
                break;
            default:
                // Nothing
        }

        Map< String, String > retMap = new HashMap<>();
        retMap.put( "problem", problem );
        retMap.put( "answer", answer );

        return retMap;
    }

}
