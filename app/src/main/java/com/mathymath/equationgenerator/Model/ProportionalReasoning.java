package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ProportionalReasoningSelection;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblemFactory;

import java.math.BigDecimal;
import java.util.Map;

public class ProportionalReasoning extends Generator {

    private WordProblemFactory wordProblemFactory;

    public ProportionalReasoning() {
        super();
        selectionList = new ProportionalReasoningSelection();
        wordProblemFactory = new WordProblemFactory();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation( util.removeDoubleSigns( equation ) );
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( answer );
    }

    @Override
    public void generate() {
        switch ( ( ProportionalReasoningSelection.Equation ) type ) {
            case SOLVING_PROPORTIONS:
                solvingProportions();
                break;
            case WRITING_SOLVING_PROPORTIONS:
                writingSolvingProportions();
                break;
            default:
                // Nothing
        }
    }

    private void solvingProportions() {
        Integer a = util.randomInt( 2, 15 );
        Integer b = util.randomInt( 2, 10 ) + a;

        // scale factor
        BigDecimal c = util.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "8" ), 1 );

        BigDecimal d = c.multiply( new BigDecimal( a.toString() ) );
        BigDecimal e = c.multiply( new BigDecimal( b.toString() ) );

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                // answer is a
                equation = "\\(\\frac{x}{" + b + "}=\\frac{" + d + "}{" + e + "}\\)";
                answer = "\\(x = " + a + "\\)";
                break;
            case 1:
                // answer is b
                equation = "\\(\\frac{" + a + "}{x}=\\frac{" + d + "}{" + e + "}\\)";
                answer = "\\(x = " + b + "\\)";
                break;
            case 2:
                // answer is d
                equation = "\\(\\frac{" + a + "}{" + b + "}=\\frac{x}{" + e + "}\\)";
                answer = "\\(x = " + d + "\\)";
                break;
            case 3:
                // answer is e
                equation = "\\(\\frac{" + a + "}{" + b + "}=\\frac{" + d + "}{x}\\)";
                answer = "\\(x = " + e + "\\)";
                break;
            default:
                // Nothing
        }
    }

    private void writingSolvingProportions() {
        switch ( util.randomInt( 0, 1 ) ) {

            // airplane
            case 0:
                // speed
                Integer a = util.randomInt( 80, 120 );
                // time 1
                Integer b = util.randomInt( 4, 9 );
                // distance 1
                Integer c = a * b;
                // time 2
                Integer d = util.randomInt( 2, 10 ) + b;
                // distance 2
                Integer e = a * d;
                equation = "Suppose an airplane travels \\(" + c + "\\) miles in \\(" + b + "\\) hours. At this rate, how far could the airplane fly in \\(" + d + "\\) hours?";
                answer = "\\(" + e + "\\) miles";
                break;

            // word problems involving money
            case 1:
                Map< String, String > wordProblem = util.generateProportionalWordProblem( wordProblemFactory.getRandomProportionalWordProblem() );
                equation = wordProblem.get( "problem" );
                answer = wordProblem.get( "answer" );
                break;
            default:
                // Nothing
        }
    }

}
