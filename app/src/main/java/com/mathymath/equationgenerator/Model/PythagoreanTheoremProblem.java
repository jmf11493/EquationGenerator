package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PythagoreanTheoremSelection;

import java.util.Map;

public class PythagoreanTheoremProblem extends Generator {

    private int a, b, c, d, e, f, g, h;

    public PythagoreanTheoremProblem() {
        super();
        selectionList = new PythagoreanTheoremSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation(util.removeDoubleSigns(equation));
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation(util.removeDoubleSigns(answer));
    }

    @Override
    public void generate() {
        g = util.randomInt(2, 6);
        h = util.randomInt(1, 5) + g;

        c = (h * h) + (g * g);
        a = (h * h) - (g * g);
        b = 2 * h * g;

        switch ((PythagoreanTheoremSelection.Equation) type) {
            case DETERMINE_MISSING_LENGTHS:
                missingLengths();
                break;
            case IS_RIGHT_TRIANGLE:
                rightTriangle();
                break;
            default:
                // Nothing
        }
    }

    private void missingLengths() {
        switch (util.randomInt(0, 1)) {
            case 0:
                equation = "Given a right triangle with legs \\(a = " + a + "\\) and \\(b = " + b + "\\), determine the length of the hypotenuse, \\(c\\)";
                answer = "\\(c = " + c + "\\)";
                break;
            case 1:
                equation = "Given a right triangle with leg \\(a = " + a + "\\) and hypotenuse, \\(c = " + c + "\\), find the length of the leg \\(b\\)";
                answer = "\\(b = " + b + "\\)";
                break;
            default:
                // Nothing
        }
    }

    private void rightTriangle() {
        switch (util.randomInt(0, 6)) {
            case 0:
            case 1:
            case 2:
            case 3:
                answer = "Yes, since \\(" + a + "^2 + " + b + "^2 = " + c + "^2\\)";
                break;
            case 4:
                a = a + util.nonZeroRandomInt(-4, 4);
                answer = "No, since \\(" + a + "^2 + " + b + "^2 \\neq " + c + "^2\\)";
                break;
            case 5:
                b = b + util.nonZeroRandomInt(-4, 4);
                answer = "No, since \\(" + a + "^2 + " + b + "^2 \\neq " + c + "^2\\)";
                break;
            case 6:
                c = c + util.nonZeroRandomInt(1, 5);
                answer = "No, since \\(" + a + "^2 + " + b + "^2 \\neq " + c + "^2\\)";
                break;
            default:
                // Nothing
        }

        String lengths = "";

        switch (util.randomInt(0, 5)) {
            case 0:
                lengths = a + ", " + b + "\\), and \\(" + c;
                break;
            case 1:
                lengths = a + ", " + c + "\\), and \\(" + b;
                break;
            case 2:
                lengths = b + ", " + a + "\\), and \\(" + c;
                break;
            case 3:
                lengths = b + ", " + c + "\\), and \\(" + a;
                break;
            case 4:
                lengths = c + ", " + a + "\\), and \\(" + b;
                break;
            case 5:
                lengths = c + ", " + b + "\\), and \\(" + a;
                break;
            default:
                // Nothing
        }

        equation = "Given a triangle with lengths \\(" + lengths + "\\), is this a right triangle?";
    }
}
