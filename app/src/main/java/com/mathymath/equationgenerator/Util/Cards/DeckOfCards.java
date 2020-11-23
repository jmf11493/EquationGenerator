package com.mathymath.equationgenerator.Util.Cards;

import com.mathymath.equationgenerator.Util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckOfCards {

    public DeckOfCards() {
        initializeDeck();
    }

    private Util util = new Util();

    private final String[] suitUnicode = {
            "\u2660", // Spade
            "\u2666", // Diamond
            "\u2663", // Club
            "\u2665"  // Heart
    };

    private final String[] cards = {
            "A",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K"
    };

    private final int cardsInSuit = cards.length;

    private final int numberOfSuits = suitUnicode.length;

    private final int deckSize = numberOfSuits * cardsInSuit;

    private String[] deck = new String[deckSize];

    public enum Suits {
        SPADE,
        DIAMOND,
        CLUB,
        HEART
    }

    private Map< Suits, String > symbol = new HashMap<Suits, String>(){
        {
            put(Suits.SPADE, suitUnicode[ 0 ]);
            put(Suits.DIAMOND, suitUnicode[ 1 ]);
            put(Suits.CLUB, suitUnicode[ 2 ]);
            put(Suits.HEART, suitUnicode[ 3 ]);
        }
    };

    private void initializeDeck() {
        ArrayList<String> deck = new ArrayList<>();

        for ( String card : cards) {
            for ( String suit : suitUnicode ) {
                deck.add( card + suit );
            }
        }

        this.deck = deck.toArray(this.deck);
    }

    private Suits getRandomSuit() {
        Suits suit = null;
        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                suit = Suits.SPADE;
                break;
            case 1:
                suit = Suits.DIAMOND;
                break;
            case 2:
                suit = Suits.CLUB;
                break;
            case 3:
                suit = Suits.HEART;
                break;
            default:
                // TODO throw exception
        }

        return suit;
    }

    public String[] getDeck() {
        return deck;
    }

    public Card getRandomCard() {
        Suits suit = getRandomSuit();
        String marking = cards[ util.randomInt( 0, cardsInSuit - 1 ) ];
        String graphic = symbol.get( suit );

        return new Card(suit, graphic, marking);
    }

    public int getCardsInSuit() {
        return cardsInSuit;
    }

    public int getNumberOfSuits() {
        return numberOfSuits;
    }

    public int getDeckSize() {
        return deckSize;
    }
}
