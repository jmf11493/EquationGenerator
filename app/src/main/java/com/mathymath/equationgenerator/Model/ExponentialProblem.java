package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ExponentialProblemSelection;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ExponentialProblem extends Generator {

    private String a, b, c;

    private int d, e, f, g, h, i, totalTop, totalBottom, total;

    private String top, bottom;

    private final BigDecimal ten = new BigDecimal( "10" );

    private final BigDecimal oneOne = new BigDecimal( "1.1" );

    private final BigDecimal nineNine = new BigDecimal( "9.9" );

    public ExponentialProblem() {
        super();
        selectionList = new ExponentialProblemSelection();
    }

    @Override
    public String getEquation() {
        return util.removeTrailingZero(util.removeDoubleSigns(equation));
    }

    @Override
    public String getAnswer() {
        return "\\(" + util.removeTrailingZero(answer) + "\\)";
    }

    @Override
    public void generate() {
        a = util.generateBase(true);
        do {
            b = util.generateBase(true);
        } while (util.stringEquals(b, a));
        do {
            c = util.generateBase(true);
        } while (util.stringEquals(b, c) || util.stringEquals(c, a));

        // create the exponents
        d = util.nonZeroRandomInt(-7, 7);
        e = util.nonZeroRandomInt(-7, 7);
        f = util.nonZeroRandomInt(-7, 7);
        g = util.nonZeroRandomInt(-7, 7);
        h = util.nonZeroRandomInt(-7, 7);
        i = util.nonZeroRandomInt(-7, 7);

        switch ((ExponentialProblemSelection.Equation) type) {
            case EXPONENT_MULTIPLYING:
                exponentsMultiplying();
                break;
            case EXPONENT_DIVIDING:
                exponentsDividing();
                break;
            case EXPONENT_POWER:
                exponentsPower();
                break;
            case EXPONENT_MULTI_STEP:
                exponentsMultiStep();
                break;
            case SCI_NOTATION_CONVERTING:
                sciNotationConverting();
                break;
            case SCI_NOTATION_ADDING_SUBTRACTING:
                sciNotationAddingSubtracting();
                break;
            case SCI_NOTATION_MULTIPLYING_DIVIDING:
                sciNotationMultiplyingDividing();
                break;
            default:
                // Nothing
        }
    }

    private void exponentsMultiplying() {
        switch (util.randomInt(0, 4)) {
            case 4:
                int a = util.randomInt(2, 6);
                int b = util.randomInt(2, 6);

                boolean simple = false;

                String answer1 = "" + (a * b);
                String answer2 = "";

                equation = a + "x^{" + d + "}y^{" + e + "}z^{" + f + "} \\cdot " + b + "x^{" + g + "}y^{" + h + "}z^{" + i + "}";
                answer = (a * b) + "x^{" + (d + g) + "} \\cdot y^{" + (e + h) + "} \\cdot z^{" + (f + i) + "}";

                if ((d + g) < 0) {
                    simple = true;
                    answer2 += "x^{" + (-1 * (d + g)) + "}";
                } else {
                    answer1 += "x^{" + (d + g) + "}";
                }

                if ((e + h) < 0) {
                    simple = true;
                    answer2 += "y^{" + (-1 * (e + h)) + "}";
                } else {
                    answer1 += "y^{" + (e + h) + "}";
                }

                if ((f + i) < 0) {
                    simple = true;
                    answer2 += "z^{" + (-1 * (f + i)) + "}";
                } else {
                    answer1 += "z^{" + (f + i) + "}";
                }

                if (simple) {
                    if (answer1 == "") {
                        answer1 = "1";
                    }
                    answer += "= \\frac{" + answer1 + "}{" + answer2 + "}";
                }
                break;
            case 3:
                equation = this.a + "^{" + d + "} \\cdot ";
                total = d;
            case 2:
                equation = this.a + "^{" + e + "} \\cdot ";
                total = e;
            case 1:
                equation = this.a + "^{" + f + "} \\cdot ";
                total = f;
            case 0:
                equation = this.a + "^{" + g + "} \\cdot " + this.a + "^{" + h + "}";
                total = g + h;
                answer = this.a + "^{" + total + "}";

                if (total == 0) {
                    answer += "= 1";
                }

                if (total < 0) {
                    answer += "= \\frac{1}{" + this.a + "^{" + (-1 * total) + "}}";
                }

                break;
            default:
                // Nothing
        }

        equation = "\\(" + equation + "\\)";
    }

    private void exponentsDividing() {
        top = "";
        bottom = "";
        totalTop = 0;
        totalBottom = 0;

        switch (util.randomInt(0, 2)) {
            case 2:
                top += a + "^{" + d + "} \\cdot ";
                totalTop += d;
            case 1:
                top = a + "^{" + e + "} \\cdot ";
                bottom = a + "^{" + f + "} \\cdot ";
                totalTop = e;
                totalBottom = f;
            case 0:
                top = a + "^{" + g + "}";
                bottom = a + "^{" + h + "}";
                totalTop = g;
                totalBottom = h;

                equation = "\\frac{" + top + "}{" + bottom + "}";

                total = totalTop - totalBottom;
                answer = a + "^{" + total + "}";

                if (total == 0) {
                    answer += "= 1";
                }

                if (total < 0) {
                    answer += "= \\frac{1}{" + a + "^{" + (-1 * total) + "}}";
                }

                break;
            default:
                // Nothing
        }

        equation = "\\(" + equation + "\\)";
    }

    private void exponentsPower() {
        boolean negative = false;

        equation = "";
        answer = "";
        String answer1 = "";
        String answer2 = "";

        switch (util.randomInt(0, 2)) {

            case 2:
                equation += a + "^{" + e + "}";
                answer += a + "^{" + (e * h) + "}";

                if ((e * h) < 0) {
                    negative = true;
                    answer2 += a + "^{" + (-1 * e * h) + "}";
                } else {
                    answer1 += a + "^{" + (e * h) + "}";
                }

            case 1:
                equation += b + "^{" + f + "}";
                answer += b + "^{" + (f * h) + "}";
                if ((f * h) < 0) {
                    negative = true;
                    answer2 += b + "^{" + (-1 * f * h) + "}";
                } else {
                    answer1 += b + "^{" + (f * h) + "}";
                }

            case 0:
                equation += c + "^{" + g + "}";
                answer += c + "^{" + (g * h) + "}";

                if ((g * h) < 0) {
                    negative = true;
                    answer2 += c + "^{" + (-1 * g * h) + "}";
                } else {
                    answer1 += c + "^{" + (g * h) + "}";
                }

                if (negative) {
                    if (answer1 == "") {
                        answer1 = "1";
                    }
                    answer += "= \\frac{" + answer1 + "}{" + answer2 + "}";
                }

                equation = "(" + equation + ")^{" + h + "}";

                break;
            default:
                // Nothing
        }

        equation = "\\(" + equation + "\\)";
    }

    private void exponentsMultiStep() {
        a = util.generateBase(false);
        top = "";
        bottom = "";
        totalTop = 0;
        totalBottom = 0;

        switch (util.randomInt(0, 2)) {

            case 2:
                top = a + "^{" + d + "} \\cdot ";
                totalTop = d;

            case 1:
                top = a + "^{" + e + "} \\cdot ";
                bottom = a + "^{" + f + "} \\cdot ";
                totalTop = e;
                totalBottom = f;

            case 0:
                top = a + "^{" + g + "}";
                bottom = a + "^{" + h + "}";
                totalTop = g;
                totalBottom = h;

                int power = util.randomInt(2, 5);
                top = "(" + top + ")^{" + power + "}";
                equation = "\\frac{" + top + "}{" + bottom + "}";

                total = (totalTop * power) - totalBottom;
                answer = a + "^{" + total + "}";
                if (total == 0) {
                    answer += "= 1";
                }
                if (total < 0) {
                    answer += "= \\frac{1}{" + a + "^{" + (-1 * total) + "}}";
                }

                break;
            default:
                // Nothing
        }

        equation = "\\(" + equation + "\\)";
    }

    private void sciNotationConverting() {
        int b = util.nonZeroRandom(-8, 8).intValue();
        int c = util.randomInt(1, 3);

        BigDecimal a = util.randomDecimal(oneOne, nineNine, c);

        switch (util.randomInt(0, 1)) {
            // convert to scientific notation
            case 0:
                equation = "Convert \\(" + util.convertToStandard(a, b, c) + "\\) to scientific notation";
                answer = a + "\\times 10^{" + b + "}";
                break;

            // convert from scientific notation
            case 1:
                equation = "Convert \\(" + a + "\\times 10^{" + b + "}\\) to standard form";
                answer = "" + util.convertToStandard(a, b, c) + "";
                break;
            default:
                // Nothing
        }
    }

    private void sciNotationAddingSubtracting() {
        Integer h = util.randomInt(1, 2);
        BigDecimal a = util.randomDecimal(oneOne, nineNine, h);
        BigDecimal b = util.randomDecimal(oneOne, nineNine, h);

        Integer c = 0;
        Integer d = 0;

        switch (util.randomInt(0, 1)) {

            // both large
            case 0:
                d = util.randomInt(2, 5);
                c = d + util.randomInt(0, 1);
                break;

            // both small
            case 1:
                d = util.randomInt(-5, -2);
                c = d + util.randomInt(0, 1);
                break;
            default:
                // Nothing
        }

        BigDecimal sum;
        Integer pow = c;

        if (c > d) {
            sum = new BigDecimal( c.toString() ).subtract( new BigDecimal( d.toString() ) ).multiply( ten ).multiply( b ).add( a ).divide( ten );
        } else {
            sum = a.add( b );
        }

        if (sum.compareTo( ten ) >= 0) {
            sum = sum.divide( ten );
            pow++;
        }

        switch (util.randomInt(0, 1)) {
            // adding
            case 0:
                equation = "\\(" + a + "\\times 10^{" + d + "} + " + b + "\\times 10^{" + c + "}\\)";
                answer = sum + "\\times 10^{" + pow + "}";
                break;

            // subtracting
            case 1:
                equation = "\\((" + sum + "\\times 10^{" + pow + "}) - (" + a + "\\times 10^{" + d + "})\\)";
                answer = b + "\\times 10^{" + c + "}";
                break;
            default:
                // Nothing
        }
    }

    private void sciNotationMultiplyingDividing() {
        int h = util.randomInt(0, 1);
        BigDecimal a = util.randomDecimal(oneOne, nineNine, 0);
        BigDecimal b = util.randomDecimal(oneOne, nineNine, h);
        BigDecimal c;

        switch (util.randomInt(0, 1)) {
            // multiplying
            case 0:
                equation = "\\((" + a + " \\times 10^{" + d + "}) \\cdot (" + b + " \\times 10^{" + e + "})\\)";
                c = a.multiply( b );
                f = d + e;
                if (c.compareTo( ten ) > 0) {
                    c = c.divide( ten );
                    f += 1;
                }
                answer = c + " \\times 10^{" + f + "}";
                break;

            // dividing
            case 1:
                c = a.multiply( b );
                f = d + e;

                if (c.compareTo( ten ) > 0) {
                    c = c.divide( ten );
                    f += 1;
                }
                equation = "\\(\\frac{" + c + " \\times 10^{" + f + "}}{" + a + " \\times 10^{" + d + "}}\\)";
                answer = b + " \\times 10^{" + e + "}";
                break;
            default:
                // Nothing
        }
    }
}
