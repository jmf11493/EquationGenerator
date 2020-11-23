package com.mathymath.equationgenerator.Util.WordProblem;

import java.math.BigDecimal;

public class WordProblem {

    private final String singularPhrase;

    private final String pluralPhrase;

    private final BigDecimal units;

    private final Integer multiplicity;

    public WordProblem(
            String singularPhrase,
            String pluralPhrase,
            BigDecimal units,
            Integer multiplicity
    ) {
        this.singularPhrase = singularPhrase;
        this.pluralPhrase = pluralPhrase;
        this.units = units;
        this.multiplicity = multiplicity;
    }

    public String getSingularPhrase() {
        return singularPhrase;
    }

    public String getPluralPhrase() {
        return pluralPhrase;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public Integer getMultiplicity() {
        return multiplicity;
    }
}
