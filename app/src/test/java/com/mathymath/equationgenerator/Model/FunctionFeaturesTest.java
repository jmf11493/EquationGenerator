package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.FunctionFeaturesSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FunctionFeaturesTest {

    @Mock
    Util util = new Util();

    FunctionFeatures functionFeatures = new FunctionFeatures();

    private void setUtilMock( Util utilSpy ) {
        functionFeatures.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        Util utilSpy = Mockito.spy( util );
        testMethod( equation, answer, utilSpy );
    }

    private void testMethod( String equation, String answer, Util utilSpy ) {
        Map<String, String> functionMap = new HashMap<>();
        functionMap.put("functionPrinted", "");
        functionMap.put("parent", "");
        functionMap.put("domain", "");
        functionMap.put("range", "");
        functionMap.put("increasing", "");
        functionMap.put("decreasing", "");
        functionMap.put("transforms", "");

        Map<String, String> evalMap = new HashMap<>();
        evalMap.put("input1", "5");
        evalMap.put("input2", "2");
        evalMap.put("functionPrinted", "-4|x| -3");
        evalMap.put("answer1", "1");
        evalMap.put("answer2", "2");

        when( utilSpy.generateFunction() ).thenReturn( functionMap );
        when( utilSpy.generateForEval() ).thenReturn( evalMap );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn(
                -5,
                -4,
                -3,
                -2,
                2,
                3,
                4,
                5
        );

        setUtilMock( utilSpy );
        functionFeatures.generate();

        assertEquals( equation, functionFeatures.getEquation() );
        assertEquals( answer, functionFeatures.getAnswer() );
    }

    private Util testIsFunction( int caseNum ) {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 6 ) ).thenReturn( caseNum );

        functionFeatures.setType( FunctionFeaturesSelection.Equation.IS_FUNCTION );
        return utilSpy;
    }

    @Test
    public void testIsFunctionCase0() {
        testMethod( "\\(\\{(-5,-4), (-4,-3), (5,-3), (2,3), (4,-2), (-3,-4), (-2,5)\\}\\)", "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).", testIsFunction( 0 ) );
    }

    @Test
    public void testIsFunctionCase1() {
        testMethod( "\\(\\{(-5,-4), (-2,2), (5,-3), (2,3), (4,-2), (-3,-4), (3,5)\\}\\)", "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).", testIsFunction( 1 ) );
    }

    @Test
    public void testIsFunctionCase2() {
        testMethod( "\\(\\{(-5,-4), (5,-5), (-2,-3), (2,3), (4,-2), (-3,-4), (3,5)\\}\\)", "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).", testIsFunction( 2 ) );
    }

    @Test
    public void testIsFunctionCase3() {
        testMethod( "\\(\\{(-5,-4), (-2,2), (-4,-3), (2,3), (4,-2), (-3,-4), (3,5)\\}\\)", "Yes, this is a function since each input, \\(x\\), has only 1 output, \\(y\\).", testIsFunction( 3 ) );
    }

    @Test
    public void testIsFunctionCase4() {
        testMethod( "\\(\\{(-5,-4), (-2,2), (5,-3), (2,3), (-5,-2), (-3,-4), (3,5)\\}\\)", "No, this is not a function since the input of \\(-5\\) repeats with different outputs", testIsFunction( 4 ) );
    }

    @Test
    public void testIsFunctionCase5() {
        testMethod( "\\(\\{(-2,-4), (-2,2), (-5,-3), (2,3), (4,-2), (-3,-4), (-5,5)\\}\\)", "No, this is not a function since the input of \\(-5\\) repeats with different outputs", testIsFunction( 5 ) );
    }

    @Test
    public void testIsFunctionCase6() {
        testMethod( "\\(\\{(-4,-4), (-2,2), (-5,-3), (2,3), (4,-2), (-5,-4), (3,5)\\}\\)", "No, this is not a function since the input of \\(-5\\) repeats with different outputs", testIsFunction( 6 ) );
    }

    @Test
    public void testEvaluatingFunctionValues() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.EVALUATING_FUNCTION_VALUES );
        testMethod( "Evaluate \\(f(x) = -4|x| -3\\) at \\(x = 5\\)", "\\(f(5) = 1\\)" );
    }

    @Test
    public void testDomainRange() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.DOMAIN_RANGE );
        testMethod( "Determine the domain and range for the function \\(g(x) = \\)", "Domain: \\(\\), Range: \\(\\)" );
    }

    @Test
    public void testIncreasingDecreasing() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.INCREASING_DECREASING );
        testMethod( "Determine the increasing and decreasing intervals for the function \\(g(x) = \\)", "Increasing: \\(\\), Decreasing: \\(\\)" );
    }

    @Test
    public void testTransformations() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.TRANSFORMATIONS );
        testMethod( "Determine the parent function and transformations for the function <br>\\(g(x) = \\)", "Parent function: \\(f(x)=\\)<br>Transformations: " );
    }

    @Test
    public void testRateOfChange() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.RATE_OF_CHANGE );
        testMethod( "Determine the rate of change of \\(f(x) = -4|x| -3\\) over the interval \\(5\\leq x \\leq 2\\)", "\\(f(5) = 1\\), \\(f(2) = 2\\)<br>Rate of Change = \\(\\frac{2 - 1}{2 - 5}=\\frac{1}{-3} = \\frac{1}{-3}\\)" );
    }

    @Test
    public void testAllFeatures() {
        functionFeatures.setType( FunctionFeaturesSelection.Equation.ALL_FEATURES );
        testMethod( "Determine the parent function, transformations, domain, range, and increasing and decreasing intervals for the function \\(g(x) = \\)", "Parent function: \\(f(x)=\\)<br>Transformations: <br>Domain: \\(\\)<br>Range: \\(\\)<br>Increasing: \\(\\)<br>Decreasing: \\(\\)" );
    }
}
