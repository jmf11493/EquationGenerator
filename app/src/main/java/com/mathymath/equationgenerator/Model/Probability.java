package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ProbabilitySelection;
import com.mathymath.equationgenerator.Util.Cards.Card;
import com.mathymath.equationgenerator.Util.Cards.DeckOfCards;
import com.mathymath.equationgenerator.Util.Event;
import com.mathymath.equationgenerator.Util.ProbabilityOptions;

import java.util.ArrayList;

public class Probability extends Generator {

    public Probability() {
        super();
        selectionList = new ProbabilitySelection();
    }

    private ProbabilityOptions probabilityOptions = new ProbabilityOptions();

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
        switch ( ( ProbabilitySelection.Equation ) type ) {
            case THEORETICAL:
                theoretical();
                break;
            case EXPERIMENTAL:
                experimental();
                break;
            case THEORETICAL_COMPOUND:
                theoreticalCompound();
                break;
            case EXPERIMENTAL_COMPOUND:
                experimentalCompound();
                break;
            default:
                // Nothing
        }
    }

    public void setProbabilityOptions( ProbabilityOptions probabilityOptions ) {
        this.probabilityOptions = probabilityOptions;
    }

    private void theoretical() {
        Event theoreticalOption = probabilityOptions.getRandomTheoreticalOption();
        equation = "Suppose you " + theoreticalOption.getDescription() +
                " what is the theoretical probability that you " +
                theoreticalOption.getOutcome() + "?";
        answer = "\\(\\frac{1}{" + theoreticalOption.getProbability() + "}\\)";
    }

    private void experimental() {
        Event experimentalOption = probabilityOptions.getRandomExperimentalOptions();
        int trials = util.randomInt( 5, 10 );
        String[] outcomes = experimentalOption.getPossibleOutcomes();
        String potentialSelection = getSelectionForEvent( experimentalOption.getName() );
        String selection = potentialSelection.equals( "" ) ? outcomes[ util.randomInt( 0, outcomes.length - 1 ) ] : potentialSelection;
        ArrayList< String > results = new ArrayList();

        equation = "Suppose you " + experimentalOption.getDescription() + " " + trials + " times";
        equation += "Card".equals( experimentalOption.getName() ) ? " with replacement" : "";

        equation += " and the results are shown below.";
        equation += "<br><br><table border='1'>";
        // Row Name
        equation += "<tr><td>" + experimentalOption.getName() + "</td>";

        // Outcomes
        for ( int i = 0; i < trials; i++ ) {
            String outcome = outcomes[ util.randomInt( 0, outcomes.length - 1 ) ];
            equation += "<td>" + outcome + "</td>";

            results.add( outcome );
        }

        equation += "</tr></table>";
        equation += "<br>What is the experimental probability of getting " + selection + "?";

        int count = 0;
        for ( int i = 0; i < results.size(); i++ ) {
            if ( results.get( i ).contains( selection ) ) {
                count++;
            }
        }

        answer = "\\(\\frac{" + count + "}{" + trials + "}";

        if ( count == 0 ) {
            answer += "= 0";
        }

        answer += "\\)";
    }

    private void theoreticalCompound() {
        Event event1 = probabilityOptions.getRandomTheoreticalOption();
        Event event2 = probabilityOptions.getRandomTheoreticalOption();

        if ( event1.getDescription().equals( event2.getDescription() ) ) {
            event2.setDescription( event2.getDescription().replace( " a ", " another " ) );
            event1.setName( event1.getName() + "#1" );
            event2.setName( event2.getName() + "#2" );
        }

        equation = "Suppose you " + event1.getDescription() +
                " and " + event2.getDescription() +
                ", what is the theoretical probability that you "
                + event1.getOutcome() + " for the " + event1.getName() +
                " <b>and</b> " + event2.getOutcome() + " for the " +
                event2.getName();
        answer = "\\(\\frac{1}{" + event1.getProbability() +
                "}\\cdot\\frac{1}{" + event2.getProbability() +
                "}=\\frac{1}{" +
                ( event1.getProbability() * event2.getProbability() )
                + "}\\)";
    }

    private void experimentalCompound() {
        Event event1 = probabilityOptions.getRandomExperimentalOptions();
        Event event2 = probabilityOptions.getRandomExperimentalOptions();

        String[] event1Outcomes = event1.getPossibleOutcomes();
        String[] event2Outcomes = event2.getPossibleOutcomes();

        int numberOfTrials = util.randomInt( 5, 10 );

        ArrayList< String > results1 = new ArrayList();
        ArrayList< String > results2 = new ArrayList();

        if ( event1.getDescription().equals( event2.getDescription() ) ) {
            event2.setDescription( event2.getDescription().replace( " a ", " another " ) );
            event1.setName( event1.getName() + "#1" );
            event2.setName( event2.getName() + "#2" );
        }

        equation = "Suppose you " + event1.getDescription() + " and " + event2.getDescription() + " " + numberOfTrials + " times each";

        if ( "Card".equals( event1.getName() ) || "Card".equals( event2.getName() ) ) {
            equation += "with replacement";
        }

        equation += " and the results are shown below.";
        equation += "<br><br><table border='1'>";

        String row1 = "<tr><td>" + event1.getName() + "</td>";
        String row2 = "<tr><td>" + event2.getName() + "</td>";

        for ( int i = 0; i < numberOfTrials; i++ ) {
            String outcome1 = event1Outcomes[ util.randomInt( 0, event1Outcomes.length - 1 ) ];
            String outcome2 = event2Outcomes[ util.randomInt( 0, event2Outcomes.length - 1 ) ];

            results1.add( outcome1 );
            results2.add( outcome2 );

            row1 += "<td>" + outcome1 + "</td>";
            row2 += "<td>" + outcome2 + "</td>";
        }

        equation += row1 + "</tr>" + row2 + "</tr></table>";


        String potentialSelection1 = getSelectionForEvent( event1.getName() );
        String selection1 = potentialSelection1.equals( "" ) ? event1Outcomes[ util.randomInt( 0, event1Outcomes.length - 1 ) ] : potentialSelection1;
        String potentialSelection2 = getSelectionForEvent( event2.getName() );
        String selection2 = potentialSelection2.equals( "" ) ? event2Outcomes[ util.randomInt( 0, event2Outcomes.length - 1 ) ] : potentialSelection2;

        equation += "<br>What is the experimental probability of getting " + selection1 + " for the " + event1.getName() + " <b>and</b> " + selection2 + " for the " + event2.getName() + "?";

        int count = 0;
        for ( int i = 0; i < results1.size(); i++ ) {
            if ( results1.get( i ).contains( selection1 ) &&
                    results2.get( i ).contains( selection2 ) ) {
                count++;
            }
        }

        answer = "\\(\\frac{" + count + "}{" + numberOfTrials + "}";
        if ( count == 0 ) {
            answer += "= 0";
        }

        answer += "\\)";
    }

    private String getSelectionForEvent( String eventName ) {
        String selection = "";

        if ( "Card".equals( eventName ) ) {
            Card card = new DeckOfCards().getRandomCard();
            switch ( util.randomInt( 0, 2 ) ) {
                case 0:
                    // Random Card
                    break;
                case 1:
                    // Random Suit
                    selection = card.getSymbol();
                    break;
                case 2:
                    // Random Name
                    selection = card.getMarking();
                    break;
                default:
                    // Nothing
            }
        }

        return selection;
    }
}
