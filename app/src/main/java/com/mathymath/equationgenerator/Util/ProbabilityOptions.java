package com.mathymath.equationgenerator.Util;

import com.mathymath.equationgenerator.Util.Cards.Card;
import com.mathymath.equationgenerator.Util.Cards.DeckOfCards;

public class ProbabilityOptions {

    public ProbabilityOptions() {
    }

    private Util util = new Util();

    public Event getRandomTheoreticalOption() {
        Event[] events = new Event[ 5 ];

        Die die = new Die();
        String[] rolls = die.getRollSentence();

        Event event = new Event(
                die.getNSidedDie(),
                die.getDescription(),
                rolls[util.randomInt( 0, rolls.length - 1)],
                die.getDieSides()
        );

        events[ 0 ] = event;

        event = new Event(
                "Coin",
                "flip a coin",
                util.randomInt( 0, 1 ) == 0 ? "get heads" : "get tails",
                2
        );

        events[ 1 ] = event;

        DeckOfCards deck = new DeckOfCards();
        Card card = deck.getRandomCard();

        event = new Event(
                "Card",
                "pick a random card",
                "get the " + card.getFullName(),
                deck.getDeckSize()
        );

        events[ 2 ] = event;

        card = deck.getRandomCard();

        event = new Event(
                "Card",
                "pick a random card",
                "get a " + card.getSuit(),
                deck.getNumberOfSuits()
        );

        events[ 3 ] = event;

        card = deck.getRandomCard();
        String cardName = card.getName().equals( "Ace" ) ? "an " + card.getName() : "a " + card.getName();

        event = new Event(
                "Card",
                "pick a random card",
                "get " + cardName,
                deck.getCardsInSuit()
        );

        events[ 4 ] = event;

        return events[ util.randomInt( 0, 4 ) ];
    }

    public Event getRandomExperimentalOptions() {
        Event[] events = new Event[ 3 ];

        Die die = new Die();

        Event event = new Event(
                die.getNSidedDie(),
                die.getDescription(),
                die.getRolls()
        );

        events[ 0 ] = event;

        event = new Event(
                "Coin",
                "flip a coin",
                new String[]{ "H", "T" }
        );

        events[ 1 ] = event;

        DeckOfCards deck = new DeckOfCards();

        event = new Event(
                "Card",
                "pick a random card",
                deck.getDeck()
        );

        events[ 2 ] = event;

        return events[ util.randomInt( 0, 2 ) ];
    }
}
