package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SystemOfEquationsSelection;

public class SystemOfEquations extends Generator {

    private boolean oneSolution = false;

    public SystemOfEquations() {
        super();
        selectionList = new SystemOfEquationsSelection();
    }

    @Override
    public String getEquation() {
        return "\\(" + util.cleanEquation(util.removeDoubleSigns(equation)) + "\\)";
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation(answer);
    }

    @Override
    public boolean hasSwitch() {
        return true;
    }

    @Override
    public String getSwitchLabel() {
        return "Always One Solution";
    }

    @Override
    public void switchListener(boolean checked) {
        oneSolution = checked;
    }

    @Override
    public void generate() {
        switch ((SystemOfEquationsSelection.Equation) type) {
            case ELIMINATION:
                elimination();
                break;
            case GRAPHING:
                graphing();
                break;
            case SUBSTITUTION:
                substitution();
                break;
            case ALL:
                all();
                break;
            default:
                // Nothing
        }
    }

    private void elimination() {
        int a, b, c, d, e, f, y, x, sf;

        x = util.randomInt(-10, 10);
        y = util.randomInt(-10, 10);

        int end = 7;

        if (!oneSolution) {
            end = 11;
        }

        switch (util.randomInt(0, end)) {
            case 0:
            case 1:
            case 2:
            case 3:
                a = util.randomInt(2, 5);
                do {
                    d = util.randomInt(2, 5);
                } while (d == a);
                b = util.nonZeroRandomInt(-3, 3);
                do {
                    sf = util.nonZeroRandomInt(-5, 5);
                } while (sf * a == d);
                e = sf * b;
                c = a * x + b * y;
                f = d * x + e * y;
                answer = "\\((" + x + ", " + y + ")\\)";
                equation = a + "x + " + b + "y = " + c + "\\\\" + d + "x + " + e + "y = " + f;
                break;

            case 4:
            case 5:
            case 6:
            case 7:
                a = util.randomInt(2, 5);
                do {
                    d = util.randomInt(2, 5);
                } while (d == a);
                b = util.nonZeroRandomInt(-3, 3);
                do {
                    sf = util.nonZeroRandomInt(-5, 5);
                } while (sf * a == d);
                e = sf * b;
                c = a * x + b * y;
                f = d * x + e * y;
                answer = "\\((" + x + ", " + y + ")\\)";
                equation = a + "x = " + c + " + " + -1 * b + "y\\\\" + d + "x + " + e + "y = " + f;
                break;

            // infinite solutions
            case 8:
                a = util.nonZeroRandomInt(-10, 10);
                b = util.nonZeroRandomInt(-10, 10);
                c = util.nonZeroRandomInt(-10, 10);
                sf = util.randomInt(-5, -1);
                d = a * sf;
                e = b * sf;
                f = c * sf;
                answer = "\\(\\infty\\) solutions, equivalent lines";
                equation = a + "x = " + c + " + " + -1 * b + "y\\\\" + d + "x + " + e + "y = " + f;
                break;

            // infinite solutions
            case 9:
                a = util.nonZeroRandomInt(-10, 10);
                b = util.nonZeroRandomInt(-10, 10);
                c = util.nonZeroRandomInt(-10, 10);
                sf = util.randomInt(-5, -1);
                d = a * sf;
                e = b * sf;
                f = c * sf;
                answer = "\\(\\infty\\) solutions, equivalent lines";
                equation = a + "x + " + b + "y = " + c + "\\\\" + d + "x + " + e + "y = " + f;
                break;

            // no solutions
            case 10:
                a = util.nonZeroRandomInt(-10, 10);
                b = util.nonZeroRandomInt(-10, 10);
                c = util.nonZeroRandomInt(-10, 10);
                sf = util.randomInt(-5, -1);
                d = a * sf;
                e = b * sf;
                do {
                    f = util.nonZeroRandomInt(-20, 20);
                } while (f == c * sf);
                answer = "No solutions, parallel lines";
                equation = a + "x + " + b + "y = " + c + "\\\\" + d + "x + " + e + "y = " + f;
                break;

            // no solutions
            case 11:
                a = util.nonZeroRandomInt(-10, 10);
                b = util.nonZeroRandomInt(-10, 10);
                c = util.nonZeroRandomInt(-10, 10);
                sf = util.randomInt(-5, -1);
                d = a * sf;
                e = b * sf;
                do {
                    f = util.nonZeroRandomInt(-20, 20);
                } while (f == c * sf);
                answer = "No solutions, parallel lines";
                equation = a + "x = " + c + " + " + -1 * b + "y\\\\" + d + "x + " + e + "y = " + f;
                break;
            default:
                // Nothing
        }
    }

    private void graphing() {
        int a, b, c, d, e, f, y, x;

        String aStr;
        String equation1;
        String equation2;

        x = util.nonZeroRandomInt(-5, 5);
        y = util.nonZeroRandomInt(-5, 5);

        int end = 5;

        if (!oneSolution) {
            end = 7;
        }

        switch (util.randomInt(0, end)) {
            // both y = form
            case 0:
            case 1:
            case 2:
                do {
                    c = util.nonZeroRandomInt(-5, 5);
                    d = y - (c * x);
                } while (d >= 11 || d <= -11);
                do {
                    b = util.randomInt(-6, 6);
                } while (y == b || d == b || b == (y - c * x));
                aStr = util.simplifyFraction(y - b, x);

                equation2 = "y = " + c + "x";
                if (d != 0) {
                    equation2 += " + " + d;
                }

                equation1 = "y = " + aStr + "x";
                if (b != 0) {
                    equation1 += " + " + b;
                }

                answer = "\\((" + x + ", " + y + ")\\)";
                equation = equation1 + "\\\\" + equation2;
                break;

            // solve for y first
            case 3:
            case 4:
            case 5:
                do {
                    c = util.nonZeroRandomInt(-5, 5);
                    d = y - (c * x);
                } while (d >= 11 || d <= -11);
                do {
                    b = util.randomInt(-6, 6);
                } while (y == b || d == b || b == (y - c * x));
                a = b - y;
                e = x * b;

                equation2 = "y = " + c + "x";
                if (d != 0) {
                    equation2 += " + " + d;
                }

                answer = "\\((" + x + ", " + y + ")\\)";
                equation = x + "y + " + a + "x = " + e + "\\\\" + equation2;
                break;

            // infinite solutions
            case 6:
                a = util.randomInt(2, 5);
                b = a * util.nonZeroRandomInt(-5, 5);
                c = a * util.nonZeroRandomInt(-5, 5);
                e = -1 * b / a;
                equation = a + "y + " + b + "x = " + c + "\\\\y = " + e + "x + " + (c / a);
                answer = "\\(\\infty\\) solutions, equivalent lines";
                break;

            // no solutions
            case 7:
                a = util.randomInt(2, 5);
                b = a * util.nonZeroRandomInt(-5, 5);
                c = a * util.nonZeroRandomInt(-5, 5);
                e = -1 * b / a;
                do {
                    f = util.nonZeroRandomInt(-10, 10);
                } while (f == (c / a));
                equation = a + "y + " + b + "x = " + c + "\\\\y = " + e + "x + " + f;
                answer = "No solutions, parallel lines";
                break;
        }
    }

    private void substitution() {
        int a, b, c, d, e, y, x;

        x = util.randomInt(-10, 10);
        y = util.randomInt(-10, 10);

        int end = 8;

        if (!oneSolution) {
            end = 12;
        }

        switch (util.randomInt(0, end)) {
            case 0:
            case 1:
            case 2:
                a = util.randomInt(2, 5);
                b = util.randomInt(-3, -1);

                do {
                    d = util.randomInt(2, 5);
                } while (-1 * a == d * b);

                c = a * x + b * y;
                e = y - (d * x);

                answer = "\\((" + x + ", " + y + ")\\)";
                equation = a + "x + " + b + "y = " + c + "\\\\x = " + d + "y + " + e;
                break;
            case 3:
            case 4:
            case 5:
                a = util.randomInt(2, 5);
                b = util.randomInt(-3, -1);

                do {
                    d = util.randomInt(2, 5);
                } while (-1 * a == d * b);

                c = a * x + b * y;
                e = x - (d * y);

                answer = "\\((" + x + ", " + y + ")\\)";
                equation = "x = " + d + "y + " + e + "\\\\" + a + "x + " + b + "y = " + c;
                break;
            case 6:
            case 7:
            case 8:
                a = util.nonZeroRandomInt(-8, 8);
                b = util.nonZeroRandomInt(-8, 8);

                do {
                    c = util.nonZeroRandomInt(-8, 8);
                } while (c == a);

                y = a * x + b;
                d = (y) - (c * x);

                answer = "\\((" + x + ", " + y + ")\\)";
                equation = "y = " + a + "x + " + b + "\\\\" + "y = " + c + "x + " + d;
                break;

            // infinite solutions
            case 9:
                d = util.randomInt(2, 5);
                b = util.randomInt(-3, -1);
                a = -1 * d * b;
                c = a * x + b * y;
                e = y - (d * x);

                answer = "\\(\\infty\\) solutions, equivalent lines";
                equation = a + "x + " + b + "y = " + c + "\\\\y = " + d + "x + " + e;
                break;

            // infinite solutions
            case 10:
                d = util.randomInt(2, 5);
                a = util.nonZeroRandomInt(-5, 5);
                b = -1 * d * a;
                e = util.nonZeroRandomInt(-10, 10);
                c = e * a;
                answer = "\\(\\infty\\) solutions, equivalent lines";
                equation = "x = " + d + "y + " + e + "\\\\" + a + "x + " + b + "y = " + c;
                break;

            // no solutions
            case 11:
                d = util.randomInt(2, 5);
                b = util.randomInt(-3, -1);
                a = -1 * d * b;
                c = a * x + b * y;
                do {
                    e = util.nonZeroRandomInt(-20, 20);
                } while (e == y - (d * x));
                answer = "No solutions, parallel lines";
                equation = a + "x + " + b + "y = " + c + "\\\\y = " + d + "x + " + e;
                break;

            // no solutions
            case 12:
                d = util.randomInt(2, 5);
                a = util.nonZeroRandomInt(-5, 5);
                b = -1 * d * a;
                e = util.nonZeroRandomInt(-10, 10);
                do {
                    c = util.nonZeroRandomInt(-20, 20);
                } while (c == e * a);
                answer = "No solutions, parallel lines";
                equation = "x = " + d + "y + " + e + "\\\\" + a + "x + " + b + "y = " + c;
                break;

            default:
                // Nothing
        }
    }

    private void all() {
        switch (util.randomInt(0, 2)) {
            case 0:
                setType(SystemOfEquationsSelection.Equation.ELIMINATION);
                break;
            case 1:
                setType(SystemOfEquationsSelection.Equation.GRAPHING);
                break;
            case 2:
                setType(SystemOfEquationsSelection.Equation.SUBSTITUTION);
                break;
            default:
                // Nothing
        }

        generate();
        // Set the type back to All
        setType(SystemOfEquationsSelection.Equation.ALL);
    }
}
