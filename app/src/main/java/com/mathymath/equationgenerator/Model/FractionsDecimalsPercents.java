package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.FractionsDecimalsPercentsSelection;

import java.math.BigDecimal;

public class FractionsDecimalsPercents extends Generator {

    private final BigDecimal oneHundred = new BigDecimal( "100" );

    public FractionsDecimalsPercents() {
        super();
        selectionList = new FractionsDecimalsPercentsSelection();
    }

    @Override
    public String getEquation() {
        return util.removeTrailingZero( util.roundValue( util.removeDoubleSigns( equation ), 4 ) );
    }

    @Override
    public String getAnswer() {
        return util.removeTrailingZero( util.roundValue( util.removeDoubleSigns( answer ), 4 ) );
    }

    @Override
    public void generate() {
        switch ( ( FractionsDecimalsPercentsSelection.Equation ) type ) {
            case FRACTION:
                fraction();
                break;
            case DECIMAL:
                decimal();
                break;
            case PERCENT:
                percent();
                break;
            default:
                // Nothing
        }
    }

    private void fraction() {
        int a = util.randomInt( 1, 25 );
        int b = util.randomInt( 1, 25 );
        Double c = (a / 1.0) / (b / 1.0);
        String number = c.toString().split("\\.")[0];
        String decimal = c.toString().split("\\.")[1];

        equation = "\\(\\frac{" + a + "}{" + b + "}\\)";
        answer = "\\(\\frac{" + a + "}{" + b + "}";

        String simplifiedFraction = util.simplifyFraction( a, b );

        if ( !simplifiedFraction.equals("\\frac{" + a + "}{" + b + "}") && "0".equals(decimal) ) {
            answer += "=" + simplifiedFraction;
        }

        if ( decimal.length() > 4 ) {
            String roundedNum = number + "." + decimal.substring( 0, 4 );
            BigDecimal percent = new BigDecimal( roundedNum ).multiply( oneHundred );

            answer += "\\approx" + roundedNum;
            answer += "\\approx" + percent + "\\%";
        } else {
            answer += "=" + c;
            answer += "=" + c * 100 + "\\%";
        }
        answer += "\\)";
    }

    private void decimal() {
        BigDecimal decimal = util.randomDecimal( new BigDecimal( "0.01" ), new BigDecimal( "3" ), util.randomInt( 2, 4 ) );
        BigDecimal percent = decimal.multiply( oneHundred );

        String decimalString = decimal + "";

        int decimalPlaces = (decimalString).split("\\.")[1].length();

        int denominator = (int) Math.pow(10, decimalPlaces);
        Double numerator = Double.parseDouble( decimalString.replace( ".", "" ) );

        String fraction = "\\frac{" + numerator.intValue() + "}{" + denominator + "}";
        String simplifyFraction = util.simplifyFraction( numerator.intValue(), denominator );

        equation = "\\(" + decimal + "\\)";
        answer = "\\(" + decimal;

        if (!simplifyFraction.equals(fraction)) {
            answer += "=" + fraction;
        }

        answer += "=" + simplifyFraction + "=" + percent + "\\%\\)";
    }

    private void percent() {
        int decimalPlaces = util.randomInt( 2, 4 );
        BigDecimal decimal = util.randomDecimal( new BigDecimal( "0.01" ), new BigDecimal( "3" ), decimalPlaces );
        BigDecimal percent = decimal.multiply( oneHundred );

        String fraction = "\\frac{" + percent + "}{" + 100 + "}";

        equation = "\\(" + percent + "\\%\\)";
        answer = "\\(" + percent + "\\%=" + fraction + "=" + decimal + "\\)";
    }
}
