package com.mathymath.equationgenerator.Util;

import java.util.ArrayList;

public class Die {

    private final int defaultDie = 6;

    private final int sides;

    private ArrayList<String> rolls = new ArrayList<>();
    private ArrayList<String> rollSentence = new ArrayList<>();

    public Die() {
        sides = defaultDie;
        initializeRolls();
    }

    public Die(Integer numberOfSides) {
        if (numberOfSides != null && numberOfSides > 0) {
            sides = numberOfSides;
        } else {
            sides = defaultDie;
        }

        initializeRolls();
    }

    private void initializeRolls() {
        for (int i = 0; i < sides; i++) {
            int number = 1 + i;
            rolls.add("" + number);
            rollSentence.add( "roll a " + number );
        }
    }

    public int getDieSides() {
        return sides;
    }

    public String getNSidedDie() {
        return sides + "-Sided Die";
    }

    public String getDescription() {
        return "roll a " + sides + "-sided die";
    }

    public String[] getRolls() {
        String[] rollArr = new String[rolls.size()];
        rollArr = rolls.toArray(rollArr);

        return rollArr;
    }

    public String[] getRollSentence() {
        String[] rollArr = new String[rollSentence.size()];
        rollArr = rollSentence.toArray(rollArr);

        return rollArr;
    }
}
