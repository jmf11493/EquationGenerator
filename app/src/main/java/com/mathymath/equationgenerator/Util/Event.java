package com.mathymath.equationgenerator.Util;

public class Event {
    private String name;

    private String description;

    private final String[] possibleOutcomes;

    private final int probability;

    private final String outcome;

    public Event( String name, String description, String[] possibleOutcomes ) {
        this.name = name;
        this.description = description;
        this.outcome = null;
        this.possibleOutcomes = possibleOutcomes;
        this.probability = 0;
    }

    public Event( String name, String description, String outcome, int probability ) {
        this.name = name;
        this.description = description;
        this.possibleOutcomes = null;
        this.outcome = outcome;
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String[] getPossibleOutcomes() {
        return possibleOutcomes;
    }

    public int getProbability() {
        return probability;
    }

    public String getOutcome() {
        return outcome;
    }
}
