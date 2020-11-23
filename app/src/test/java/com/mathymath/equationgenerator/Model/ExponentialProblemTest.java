package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ExponentialProblemSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExponentialProblemTest {

    @Mock
    Util util = new Util();

    ExponentialProblem exponentialProblem = new ExponentialProblem();

    private final BigDecimal oneOne = new BigDecimal( "1.1" );

    private final BigDecimal nineNine = new BigDecimal( "9.9" );

    private void setUtilMock( Util utilSpy ) {
        exponentialProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        exponentialProblem.generate();

        assertEquals( equation, exponentialProblem.getEquation() );
        assertEquals( answer, exponentialProblem.getAnswer() );
    }

    private Util getBaseUtilMock() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.generateBase( true ) ).thenReturn( "x", "y", "3" );
        when( utilSpy.nonZeroRandomInt( -7, 7 ) ).thenReturn( -6, -5, -4, -4, 3, 5 );

        return utilSpy;
    }

    private void testExponentsMultiplying( int caseNum ) {
        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( 2, 6 ) ).thenReturn( 2, 4 );
        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.EXPONENT_MULTIPLYING );
    }

    @Test
    public void testExponentsMultiplyingCase0() {
        testExponentsMultiplying( 0 );
        testMethod( "\\(x^{-4} \\cdot x^{3}\\)", "\\(x^{-1}= \\frac{1}{x^{1}}\\)" );
    }

    @Test
    public void testExponentsMultiplyingCase1() {
        testExponentsMultiplying( 1 );
        testMethod( "\\(x^{-4} \\cdot x^{3}\\)", "\\(x^{-1}= \\frac{1}{x^{1}}\\)" );
    }

    @Test
    public void testExponentsMultiplyingCase2() {
        testExponentsMultiplying( 2 );
        testMethod( "\\(x^{-4} \\cdot x^{3}\\)", "\\(x^{-1}= \\frac{1}{x^{1}}\\)" );
    }

    @Test
    public void testExponentsMultiplyingCase3() {
        testExponentsMultiplying( 3 );
        testMethod( "\\(x^{-4} \\cdot x^{3}\\)", "\\(x^{-1}= \\frac{1}{x^{1}}\\)" );
    }

    @Test
    public void testExponentsMultiplyingCase4() {
        testExponentsMultiplying( 4 );
        testMethod( "\\(2x^{-6}y^{-5}z^{-4} \\cdot 4x^{-4}y^{3}z^{5}\\)", "\\(8x^{-10} \\cdot y^{-2} \\cdot z^{1}= \\frac{8z^{1}}{x^{10}y^{2}}\\)" );
    }

    private void testExponentsDividing( int caseNum ) {
        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.EXPONENT_DIVIDING );
    }

    @Test
    public void testExponentsDividingCase0() {
        testExponentsDividing( 0 );
        testMethod( "\\(\\frac{x^{-4}}{x^{3}}\\)", "\\(x^{-7}= \\frac{1}{x^{7}}\\)" );
    }

    @Test
    public void testExponentsDividingCase1() {
        testExponentsDividing( 1 );
        testMethod( "\\(\\frac{x^{-4}}{x^{3}}\\)", "\\(x^{-7}= \\frac{1}{x^{7}}\\)" );
    }

    @Test
    public void testExponentsDividingCase2() {
        testExponentsDividing( 2 );
        testMethod( "\\(\\frac{x^{-4}}{x^{3}}\\)", "\\(x^{-7}= \\frac{1}{x^{7}}\\)" );
    }

    private void testExponentsPower( int caseNum ) {
        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.EXPONENT_POWER );
    }

    @Test
    public void testExponentsPowerCase0() {
        testExponentsPower( 0 );
        testMethod( "\\((3^{-4})^{3}\\)", "\\(3^{-12}= \\frac{1}{3^{12}}\\)" );
    }

    @Test
    public void testExponentsPowerCase1() {
        testExponentsPower( 1 );
        testMethod( "\\((y^{-4}3^{-4})^{3}\\)", "\\(y^{-12}3^{-12}= \\frac{1}{y^{12}3^{12}}\\)" );
    }

    @Test
    public void testExponentsPowerCase2() {
        testExponentsPower( 2 );
        testMethod( "\\((x^{-5}y^{-4}3^{-4})^{3}\\)", "\\(x^{-15}y^{-12}3^{-12}= \\frac{1}{x^{15}y^{12}3^{12}}\\)" );
    }

    private void testExponentsMultiStep( int caseNum ) {
        Util utilSpy = getBaseUtilMock();

        when( utilSpy.generateBase( false ) ).thenReturn( "x" );
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 4 );
        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.EXPONENT_MULTI_STEP );
    }

    @Test
    public void testExponentsMultiStepCase0() {
        testExponentsMultiStep( 0 );
        testMethod( "\\(\\frac{(x^{-4})^{4}}{x^{3}}\\)", "\\(x^{-19}= \\frac{1}{x^{19}}\\)" );
    }

    @Test
    public void testExponentsMultiStepCase1() {
        testExponentsMultiStep( 1 );
        testMethod( "\\(\\frac{(x^{-4})^{4}}{x^{3}}\\)", "\\(x^{-19}= \\frac{1}{x^{19}}\\)" );
    }

    @Test
    public void testExponentsMultiStepCase2() {
        testExponentsMultiStep( 2 );
        testMethod( "\\(\\frac{(x^{-4})^{4}}{x^{3}}\\)", "\\(x^{-19}= \\frac{1}{x^{19}}\\)" );
    }

    private void testExponentsScientificNotationConverting( int caseNum ) {
        final int decimalPlaces = 2;

        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -8, 8 ) ).thenReturn( new BigDecimal( "-5" ) );
        when( utilSpy.randomInt( 1, 3 ) ).thenReturn( decimalPlaces );
        when( utilSpy.randomDecimal( oneOne, nineNine, decimalPlaces ) ).thenReturn( new BigDecimal( "7.86" ) );

        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.SCI_NOTATION_CONVERTING );
    }

    @Test
    public void testExponentsScientificNotationConvertingCase0() {
        testExponentsScientificNotationConverting( 0 );
        testMethod( "Convert \\(0.000786\\) to scientific notation", "\\(7.86\\times 10^{-5}\\)" );
    }

    @Test
    public void testExponentsScientificNotationConvertingCase1() {
        testExponentsScientificNotationConverting( 1 );
        testMethod( "Convert \\(7.86\\times 10^{-5}\\) to standard form", "\\(0.000786\\)" );
    }

    private void testScientificNotationAddingSubtracting( int caseNum ) {
        final int decimalPlaces = 1;

        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( 1, 2 ) ).thenReturn( decimalPlaces );
        when( utilSpy.randomInt( 2, 5) ).thenReturn( 3 );
        when( utilSpy.randomInt( -5, -2) ).thenReturn( -4 );
        when( utilSpy.randomDecimal( oneOne, nineNine, decimalPlaces ) ).thenReturn( new BigDecimal( "7.8" ), new BigDecimal( "5.4" ) );

        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.SCI_NOTATION_ADDING_SUBTRACTING );
    }

    @Test
    public void testExponentsScientificNotationAddingSubtractingCase0() {
        testScientificNotationAddingSubtracting( 0 );
        testMethod( "\\(7.8\\times 10^{3} + 5.4\\times 10^{3}\\)", "\\(1.32\\times 10^{4}\\)" );
    }

    @Test
    public void testExponentsScientificNotationAddingSubtractingCase1() {
        testScientificNotationAddingSubtracting( 1 );
        testMethod( "\\((6.18\\times 10^{-3}) - (7.8\\times 10^{-4})\\)", "\\(5.4\\times 10^{-3}\\)" );
    }

    private void testScientificNotationMultiplyingDividing( int caseNum ) {
        final int decimalPlaces = 0;

        Util utilSpy = getBaseUtilMock();

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( decimalPlaces, caseNum );
        when( utilSpy.randomDecimal( oneOne, nineNine, decimalPlaces ) ).thenReturn( new BigDecimal( "7" ), new BigDecimal( "5" ) );

        setUtilMock( utilSpy );

        exponentialProblem.setType( ExponentialProblemSelection.Equation.SCI_NOTATION_MULTIPLYING_DIVIDING );
    }

    @Test
    public void testScientificNotationMultiplyingDividingCase0() {
        testScientificNotationMultiplyingDividing( 0 );
        testMethod( "\\((7 \\times 10^{-6}) \\cdot (5 \\times 10^{-5})\\)", "\\(3.5 \\times 10^{-10}\\)" );
    }

    @Test
    public void testScientificNotationMultiplyingDividingCase1() {
        testScientificNotationMultiplyingDividing( 1 );
        testMethod( "\\(\\frac{3.5 \\times 10^{-10}}{7 \\times 10^{-6}}\\)", "\\(5 \\times 10^{-5}\\)" );
    }
}
