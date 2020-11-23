package com.mathymath.equationgenerator.Util.WordProblem;

import com.mathymath.equationgenerator.Util.Util;

import java.math.BigDecimal;

public class WordProblemFactory {

    private Util util = new Util();

    public WordProblemFactory() {}

    public WordProblem getRandomProportionalWordProblem() {
        int selector = util.randomInt( 0, 7 );

        WordProblem wordProblem = null;

        switch( selector ) {
            case 0:
                wordProblem = new WordProblem(
              "pound of ham",
                "pounds of ham",
                            util.randomDecimal( BigDecimal.ONE, new BigDecimal( "3" ), 2 ),
                            util.randomInt( 2, 5 )
                        );
                break;
            case 1:
                wordProblem = new WordProblem(
                        "cantaloupe",
                        "cantaloupes",
                        util.randomDecimal( BigDecimal.ONE, new BigDecimal( "3" ),  2),
                        util.randomInt( 2, 10 )
                );
                break;
            case 2:
                wordProblem = new WordProblem(
                        "package of blueberries",
                        "packages of blueberries",
                        util.randomDecimal( new BigDecimal( "3" ), new BigDecimal( "4.5" ), 2 ),
                        util.randomInt( 2, 8 )
                );
                break;
            case 3:
                wordProblem = new WordProblem(
                        "kiwi fruit",
                        "kiwi fruits",
                        util.randomDecimal( new BigDecimal( "0.25" ), new BigDecimal( "1.5" ), 2 ),
                        util.randomInt( 2, 10 )
                );
                break;
            case 4:
                wordProblem = new WordProblem(
                        "orange",
                        "oranges",
                        util.randomDecimal( new BigDecimal( "0.35" ), BigDecimal.ONE, 2 ),
                        util.randomInt( 2, 10 )
                );
                break;
            case 5:
                wordProblem = new WordProblem(
                        "slice of pizza",
                        "slices of pizza",
                        util.randomDecimal( BigDecimal.ONE , new BigDecimal( "2.99" ), 2 ),
                        util.randomInt( 2, 10 )
                );
                break;
            case 6:
                wordProblem = new WordProblem(
                        "soda",
                        "sodas",
                        util.randomDecimal( new BigDecimal( "0.75" ), new BigDecimal( "1.25" ), 2 ),
                        util.randomInt( 2, 10 )
                );
                break;
            case 7:
                wordProblem = new WordProblem(
                        "video game",
                        "video games",
                        util.randomDecimal( new BigDecimal( "25" ), new BigDecimal( "60" ), 2 ),
                        util.randomInt( 2, 6 )
                );
                break;
            default:
                // Nothing
                // TODO throw error
        }

        return wordProblem;
    }

    public WordProblem getRandomPercentsWordProblem() {
        int selector = util.randomInt( 0, 7 );

        WordProblem wordProblem = null;

        switch( selector ) {
            case 0:
                wordProblem = new WordProblem(
                        "TV",
                        "TVs",
                        util.randomDecimal( new BigDecimal( "400" ), new BigDecimal( "999" ), 2 ),
                        null );
                break;
            case 1:
                wordProblem = new WordProblem(
                        "game system",
                        "game systems",
                        util.randomDecimal( new BigDecimal( "200" ), new BigDecimal( "500" ), 2 ),
                        null );
                break;
            case 2:
                wordProblem = new WordProblem(
                        "movie ticket",
                        "movie tickets",
                        util.randomDecimal( new BigDecimal( "9" ), new BigDecimal( "15" ), 2 ),
                        null );
                break;
            case 3:
                wordProblem = new WordProblem(
                        "concert ticket",
                        "concert tickets",
                        util.randomDecimal( new BigDecimal( "40" ), new BigDecimal( "150" ), 2 ),
                        null );
                break;
            case 4:
                wordProblem = new WordProblem(
                        "DVD",
                        "DVDs",
                        util.randomDecimal( new BigDecimal( "10" ), new BigDecimal( "25" ), 2 ),
                        null );
                break;
            case 5:
                wordProblem = new WordProblem(
                        "computer",
                        "computers",
                        util.randomDecimal( new BigDecimal( "500" ), new BigDecimal( "1500" ), 2 ),
                        null );
                break;
            case 6:
                wordProblem = new WordProblem(
                        "tablet",
                        "tablets",
                        util.randomDecimal( new BigDecimal( "250" ), new BigDecimal( "900" ), 2 ),
                        null );
                break;
            default:
                // Nothing
                // TODO throw error
        }

        return wordProblem;
    }
}
