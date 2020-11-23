package com.mathymath.equationgenerator.Util.Cards;

public class Card {

    private final DeckOfCards.Suits suit;

    private final String symbol;

    private final String marking;

    private final String name;

    public Card(DeckOfCards.Suits suit, String symbol, String marking) {
        this.suit = suit;
        this.symbol = symbol;
        this.marking = marking;

        name = setName( marking );
    }

    private String setName(String marking) {
        String name;

        switch (marking) {
            case "A":
                name = "Ace";
                break;
            case "J":
                name = "Jack";
                break;
            case "Q":
                name = "Queen";
                break;
            case "K":
                name = "King";
                break;
            default:
                name = marking;
        }

        return name;
    }

    public String getName() {
        return name;
    }

    public String getMarking() {
        return marking;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSuit() {
        return getSuit( false );
    }

    public String getFullName() {
        return marking + symbol;
    }

    public String getSuit( boolean isPlural ) {
        String name = "";

        switch ( suit ) {
            case SPADE:
                name = isPlural ? "Spades" : "Spade";
                break;
            case DIAMOND:
                name = isPlural ? "Diamonds" : "Diamond";
                break;
            case CLUB:
                name = isPlural ? "Clubs" : "Club";
                break;
            case HEART:
                name = isPlural ? "Hearts" : "Heart";
                break;
            default:
                // TODO throw exception
        }

        return name;
    }
}
