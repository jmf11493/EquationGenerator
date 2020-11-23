package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.FunctionFeaturesSelection;

import java.util.Map;

public class FunctionFeatures extends Generator {

    private int a, b, c, d, e, f, g, h;

    public FunctionFeatures() {
        super();
        selectionList = new FunctionFeaturesSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation(util.removeDoubleSigns(equation));
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation(answer);
    }

    @Override
    public void generate() {
        a = util.randomInt(-10, 10);
        do {
            b = util.randomInt(-10, 10);
        } while (a == b);
        do {
            c = util.randomInt(-10, 10);
        } while (a == c || b == c);
        do {
            d = util.randomInt(-10, 10);
        } while (a == d || b == d || c == d);
        do {
            e = util.randomInt(-10, 10);
        } while (a == e || b == e || c == e || d == e);
        do {
            f = util.randomInt(-10, 10);
        } while (a == f || b == f || c == f || d == f || e == f);
        do {
            g = util.randomInt(-10, 10);
        } while (a == g || b == g || c == g || d == g || e == g || f == g);
        do {
            h = util.randomInt(-10, 10);
        } while (a == h || b == h || c == h || d == h || e == h || f == h || g == h);

        switch ((FunctionFeaturesSelection.Equation) type) {
            case IS_FUNCTION:
                isFunction();
                break;
            case EVALUATING_FUNCTION_VALUES:
                evaluatingFunctionValues();
                break;
            case DOMAIN_RANGE:
                domainRange();
                break;
            case INCREASING_DECREASING:
                increasingDecreasing();
                break;
            case TRANSFORMATIONS:
                transformations();
                break;
            case RATE_OF_CHANGE:
                rateOfChange();
                break;
            case ALL_FEATURES:
                allFeatures();
                break;
            default:
                // Nothing
        }
    }

    private void isFunction() {
        switch (util.randomInt(0, 6)) {
            // yes
            case 0:
                equation = "\\(\\{(" + a + "," + b + "), (" + b + "," + c + "), (" + h + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + c + "," + b + "), (" + d + "," + h + ")\\}\\)";
                answer = "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).";
                break;
            case 1:
                equation = "\\(\\{(" + a + "," + b + "), (" + d + "," + e + "), (" + h + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + c + "," + b + "), (" + f + "," + h + ")\\}\\)";
                answer = "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).";
                break;
            case 2:
                equation = "\\(\\{(" + a + "," + b + "), (" + h + "," + a + "), (" + d + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + c + "," + b + "), (" + f + "," + h + ")\\}\\)";
                answer = "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).";
                break;
            case 3:
                equation = "\\(\\{(" + a + "," + b + "), (" + d + "," + e + "), (" + b + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + c + "," + b + "), (" + f + "," + h + ")\\}\\)";
                answer = "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).";
                break;

            // no
            case 4:
                equation = "\\(\\{(" + a + "," + b + "), (" + d + "," + e + "), (" + h + "," + c + "), (" + e + "," + f + "), (" + a + "," + d + "), (" + c + "," + b + "), (" + f + "," + h + ")\\}\\)";
                answer = "No, this is not a function since the input of \\(" + a + "\\) repeats with different outputs";
                break;
            case 5:
                equation = "\\(\\{(" + d + "," + b + "), (" + d + "," + e + "), (" + a + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + c + "," + b + "), (" + a + "," + h + ")\\}\\)";
                answer = "No, this is not a function since the input of \\(" + a + "\\) repeats with different outputs";
                break;
            case 6:
                equation = "\\(\\{(" + b + "," + b + "), (" + d + "," + e + "), (" + a + "," + c + "), (" + e + "," + f + "), (" + g + "," + d + "), (" + a + "," + b + "), (" + f + "," + h + ")\\}\\)";
                answer = "No, this is not a function since the input of \\(" + a + "\\) repeats with different outputs";
                break;
            default:
                // Nothing
        }
    }

    private void evaluatingFunctionValues() {
        Map<String, String> function = util.generateForEval();
        equation = "Evaluate \\(f(x) = " + function.get("functionPrinted") + "\\) at \\(x = " + function.get("input1") + "\\)";
        answer = "\\(f(" + function.get("input1") + ") = " + function.get("answer1") +"\\)";
    }

    private void domainRange() {
        Map<String, String> function = util.generateFunction();
        equation = "Determine the domain and range for the function ";
        equation += "\\(g(x) = " + function.get("functionPrinted") + "\\)";
        answer = "Domain: \\(" + function.get("domain") + "\\), Range: \\(" + function.get("range") + "\\)";
    }

    private void increasingDecreasing() {
        Map<String, String> function = util.generateFunction();
        equation = "Determine the increasing and decreasing intervals for the function ";
        equation += "\\(g(x) = " + function.get("functionPrinted") + "\\)";
        answer = "Increasing: \\(" + function.get("increasing") + "\\), Decreasing: \\(" + function.get("decreasing") + "\\)";
    }

    private void transformations() {
        Map<String, String> function = util.generateFunction();
        equation = "Determine the parent function and transformations for the function <br>";
        equation += "\\(g(x) = " + function.get("functionPrinted") + "\\)";
        answer = "Parent function: \\(f(x)=" + function.get("parent") + "\\)";
        answer += "<br>Transformations: " + function.get("transforms");
    }

    private void rateOfChange() {
        Map<String, String> function = util.generateForEval();
        equation = "Determine the rate of change of \\(f(x) = " + function.get("functionPrinted") + "\\) over the interval \\(" + function.get("input1") + "\\leq x \\leq " + function.get("input2") + "\\)";
        answer = "\\(f(" + function.get("input1") + ") = " + function.get("answer1") + "\\), ";
        answer += "\\(f(" + function.get("input2") + ") = " + function.get("answer2") + "\\)";
        answer += "<br>Rate of Change = \\(\\frac{" + function.get("answer2") + " - " + function.get("answer1") + "}{" + function.get("input2") + " - " + function.get("input1") + "}=\\frac{" + (Integer.parseInt(function.get("answer2")) - Integer.parseInt(function.get("answer1"))) + "}{" + (Integer.parseInt(function.get("input2")) - Integer.parseInt(function.get("input1"))) + "} = ";
        answer += util.simplifyFraction((Integer.parseInt(function.get("answer2")) - Integer.parseInt(function.get("answer1"))), (Integer.parseInt(function.get("input2")) - Integer.parseInt(function.get("input1")))) + "\\)";
    }

    private void allFeatures() {
        Map< String, String > function = util.generateFunction();
        equation = "Determine the parent function, transformations, domain, range, and increasing and decreasing intervals for the function ";
        equation += "\\(g(x) = " + function.get( "functionPrinted" ) + "\\)";
        answer = "Parent function: \\(f(x)=" + function.get( "parent" ) + "\\)";
        answer += "<br>Transformations: " + function.get( "transforms" );
        answer += "<br>Domain: \\(" + function.get( "domain" ) + "\\)<br>Range: \\(" + function.get( "range" ) + "\\)";
        answer += "<br>Increasing: \\(" + function.get( "increasing" ) + "\\)<br>Decreasing: \\(" + function.get( "decreasing" ) + "\\)";
    }
}
