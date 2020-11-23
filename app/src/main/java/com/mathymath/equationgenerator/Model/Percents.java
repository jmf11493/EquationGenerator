package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PercentsSelection;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblemFactory;

import java.math.BigDecimal;
import java.util.Map;

public class Percents extends Generator {

    private WordProblemFactory wordProblemFactory;

    private final BigDecimal oneHundred = new BigDecimal( "100" );

    private final BigDecimal twoHundred = new BigDecimal( "200" );

    private final String[] surveySubject = {
            "basketball",
            "soccer",
            "dance",
            "video games",
            "singing",
            "playing an instrument",
            "football",
            "watching TV",
            "cheerleading",
            "baseball"
    };

    public Percents() {
        super();
        selectionList = new PercentsSelection();
        wordProblemFactory = new WordProblemFactory();
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
        switch ( ( PercentsSelection.Equation ) type ) {
            case PERCENT_OF_A_NUMBER:
                percentOfANumber();
                break;
            case DETERMINING_PERCENTS:
                determiningPercents();
                break;
            case PERCENT_CHANGE:
                percentChange();
                break;
            case TOTAL_ORIGINAL:
                totalOriginal();
                break;
            default:
                // Nothing
        }
    }

    private void percentOfANumber() {
        BigDecimal a, b, c, d, e, f;
        WordProblem wordProblem;
        String name;
        BigDecimal price;
        BigDecimal three = new BigDecimal( "3" );

        switch ( util.randomInt( 0, 4 ) ) {
            case 0:
                // Simple - find x % of a number
                a = util.randomDecimal( three, twoHundred, 1 );
                b = new BigDecimal( util.randomInt( 10, 300 ).toString() );
                // answer
                c = a.multiply( b ).divide( oneHundred );

                equation = "Find \\(" + a + "\\%\\) of \\(" + b + "\\)";
                answer = "\\(" + c + "\\)";

                break;
            case 1:
                // Number is % of x, what is x?
                a = util.randomDecimal( three, twoHundred, 1 );
                b = new BigDecimal( util.randomInt( 10, 300 ).toString() );
                c = a.multiply( b ).divide( oneHundred );

                equation = "\\(" + c + "\\) is \\(" + a + "\\%\\) of what number?";
                answer = "\\(" + b + "\\)";

                break;
            case 2:
                // Tax word equation - find total cost
                wordProblem = wordProblemFactory.getRandomPercentsWordProblem();
                name = wordProblem.getSingularPhrase();
                price = new BigDecimal( wordProblem.getUnits().toString() );

                d = util.randomDecimal( new BigDecimal( "4" ), new BigDecimal( "10" ), 1 );
                e = price.add( d.divide( oneHundred ).multiply( price ) );

                equation = "A " + name + " costs $\\(" + price + "\\) before tax. If a \\(" + d + "\\%\\) tax is applied, what is the final cost?";
                equation += "<br><br>Round to the nearest cent.";
                answer = util.roundValue( "$\\(" + e + "\\)", 2 );

                break;
            case 3:
                // Discount word equation - find total cost
                wordProblem = wordProblemFactory.getRandomPercentsWordProblem();
                name = wordProblem.getSingularPhrase();
                price = new BigDecimal( wordProblem.getUnits().toString() );

                d = new BigDecimal( util.randomInt( 5, 40 ).toString() );
                e = BigDecimal.ONE.subtract( d.divide( oneHundred ) ).multiply( price );

                equation = "A " + name + " originally costs $\\(" + price + "\\). If a \\(" + d + "\\%\\) discount is applied, what is the new price?";
                equation += "<br><br>Round to the nearest cent.";
                answer = util.roundValue( "$\\(" + e + "\\)", 2 );

                break;
            case 4:
                // Discount and tax word equation - find total cost
                wordProblem = wordProblemFactory.getRandomPercentsWordProblem();
                name = wordProblem.getSingularPhrase();
                price = new BigDecimal( wordProblem.getUnits().toString() );

                d = new BigDecimal( util.randomInt( 5, 40 ).toString() );
                e = util.randomDecimal( new BigDecimal( "4" ), new BigDecimal( "10" ), 1 );
                BigDecimal ePlus = BigDecimal.ONE.add( e.divide( oneHundred ) );
                f = BigDecimal.ONE.subtract( d.divide( oneHundred ) ).multiply( price ).multiply( ePlus );

                equation = "A " + name + " originally costs $\\(" + price + "\\). If a \\(" + d + "\\%\\) discount is applied and then a \\(" + e + "\\%\\) tax, what is the final price?";
                equation += "<br><br>Only round the final answer to the nearest cent.";
                answer = util.roundValue( "$\\(" + f + "\\)", 2 );

                break;
            default:
                // Nothing
        }
    }

    private void determiningPercents() {
        BigDecimal a, b, c, d;

        switch ( util.randomInt( 0, 2 ) ) {
            case 0:
                // Using part/whole to find percent

                // percent
                a = util.randomDecimal( BigDecimal.ONE, new BigDecimal( "99" ), 1 );
                // whole
                b = new BigDecimal( util.randomInt( 10, 300 ).toString() );
                // part
                c = a.multiply( b ).divide( oneHundred );

                equation = "If the part is \\(" + c + "\\) and the whole is \\(" + b + "\\), what is the percent?";
                answer = "\\(" + a + "\\%\\)";

                break;
            case 1:
                // What percent of number1 is number2?

                // percent
                a = util.randomDecimal( new BigDecimal( "3" ), twoHundred, 1 );
                // whole
                b = new BigDecimal( util.randomInt( 10, 300 ).toString() );
                // part
                c = a.multiply( b ).divide( oneHundred );

                equation = "What percent of \\(" + b + "\\) is \\(" + c + "\\)?";
                answer = "\\(" + a + "\\%\\)";

                break;
            case 2:
                // Word Problem - What percent of x is y?

                // selected
                String subject = surveySubject[ util.randomInt( 0, surveySubject.length - 1 ) ];
                // total, want a multiple of 100 to avoid decimals since % has no decimal places
                b = new BigDecimal( util.randomInt( 10, 4000 ).toString() ).multiply( oneHundred );
                // percent
                c = new BigDecimal( util.randomInt( 2, 85 ).toString() );
                // num selected
                d = c.divide( oneHundred ).multiply( b );

                equation = "In a survey of \\(" + b + "\\) middle school students, \\(" + d + "\\) chose " + subject + " as their favorite hobby.  What percent of those surveyed chose " + subject + "?";
                answer = "\\(" + c + "\\%\\)";

                break;
            default:
                // Nothing
        }
    }

    private void percentChange() {
        BigDecimal a, b, c, d, e;
        switch ( util.randomInt( 0, 2 ) ) {
            case 0:
                // Find the percent change between two numbers, no context (increase/decrease labels)
                do {
                    a = util.randomDecimal( new BigDecimal( "3" ), new BigDecimal( "300" ), 1 );
                }
                while ( a.compareTo( oneHundred ) == 0 );

                // original
                b = new BigDecimal( util.randomInt( 10, 300 ).toString() );
                // new
                c = a.multiply( b ).divide( oneHundred );

                equation = "What is the percent change from \\(" + b + "\\) to \\(" + c + "\\)?";

                if ( a.compareTo( oneHundred ) > 0 ) {
                    // % increase
                    d = a.subtract( oneHundred );
                    answer = "\\(" + d + "\\%\\) increase";

                } else {
                    // % decrease
                    d = oneHundred.subtract( a );
                    answer = "\\(" + d + "\\%\\) decrease";
                }
                break;
            case 1:
                // Percent change with variables
                do {
                    a = util.randomDecimal( new BigDecimal( "0.03" ), new BigDecimal( "3" ), 2 );
                }
                while ( a.compareTo( BigDecimal.ONE ) == 0 );

                equation = "What is the percent change from \\(x\\) to \\(" + a + "x\\)?";

                if ( a.compareTo( BigDecimal.ONE ) > 0 ) {
                    // % increase
                    d = a.subtract( BigDecimal.ONE ).multiply( oneHundred );
                    answer = "\\(" + d + "\\%\\) increase";

                } else {
                    // % decrease
                    d = BigDecimal.ONE.subtract( a ).multiply( oneHundred );
                    answer = "\\(" + d + "\\%\\) decrease";
                }
                break;
            case 2:
                // Percent change word equations
                WordProblem wordProblem = wordProblemFactory.getRandomPercentsWordProblem();
                String name = wordProblem.getSingularPhrase();
                BigDecimal price = new BigDecimal( wordProblem.getUnits().toString() );

                // Tax
                d = new BigDecimal( util.randomInt( 4, 15 ).toString() );
                e = BigDecimal.ONE.add( d.divide( oneHundred ) ).multiply( price );

                equation = "A " + name + " costs $\\(" + price + "\\) before tax. If the " + name + " is $\\(" + e + "\\) after tax, what percent of tax was applied?";
                answer = "\\(" + d + "\\%\\)";

                break;
            default:
                // Nothing
        }
    }

    private void totalOriginal() {

        switch ( util.randomInt( 0, 1 ) ) {
            case 0:
                BigDecimal percent = util.random( 3, 200 );
                BigDecimal number  = new BigDecimal( util.randomInt( 10, 300 ) );
                BigDecimal ans     = percent.multiply( number ).divide( new BigDecimal( "100" ) );

                if ( util.randomInt( 0, 1 ) == 1 ) {
                    equation = "\\(" + ans + "\\) is \\(" + percent + "\\%\\) of what number?";
                } else {
                    equation = "\\(" + percent + "\\%\\) of what number is \\(" + ans + "\\)?";
                }

                answer   = "\\(" + number + "\\)";

                break;
            case 1:
                WordProblem wordProblem = wordProblemFactory.getRandomPercentsWordProblem();

                String unitName = wordProblem.getSingularPhrase();
                wordProblem.getUnits();

                BigDecimal taxDiscount = util.random( 4, 10 );
                BigDecimal cost = wordProblem.getUnits();
                BigDecimal costTaxDiscount;

                switch( util.randomInt( 0, 1 ) ) {
                    case 0:
                        costTaxDiscount = ((taxDiscount.divide( new BigDecimal( "100" ) )).add( BigDecimal.ONE )).multiply( cost );
                        equation = "A " + unitName + " is purchased with a \\(" + taxDiscount + "\\%\\) tax applied and the total cost is $\\(" + costTaxDiscount + "\\) rounded to the nearest cent.";
                        equation += "<br><br>Determine the original cost.";
                        break;
                    case 1:
                        costTaxDiscount = BigDecimal.ONE.subtract((taxDiscount.divide( new BigDecimal( "100" ) ))).multiply( cost );
                        equation = "A " + unitName + " is purchased with a discount of \\(" + taxDiscount + "\\%\\) and the discounted cost is $\\(" + costTaxDiscount + "\\) rounded to the nearest cent.";
                        equation += "<br><br>Determine the original cost";
                        break;
                    default:
                        // Nothing
                }

                answer = "$\\(" + cost + "\\)";

                break;
            default:
                // Nothing
        }
    }

    public void setWordProblemFactory( WordProblemFactory wordProblemFactory ) {
        this.wordProblemFactory = wordProblemFactory;
    }

    public String[] getSurveySubject() {
        return this.surveySubject;
    }
}
