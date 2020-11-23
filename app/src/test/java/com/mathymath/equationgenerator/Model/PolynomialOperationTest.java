package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PolynomialOperationSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PolynomialOperationTest {

    @Mock
    Util util = new Util();

    PolynomialOperation polynomialOperation = new PolynomialOperation();

    private void setUtilMock( Util utilSpy ) {
        polynomialOperation.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        polynomialOperation.generate();

        assertEquals( equation, polynomialOperation.getEquation() );
        assertEquals( answer, polynomialOperation.getAnswer() );
    }

    private void testAddingSubtracting( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn(
            -5,
                3,
                4,
                -8,
                -6,
                9,
                10,
                -10
        );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.ADDING_SUBTRACTING );
    }

    @Test
    public void testAddingSubtractingCase0() {
        testAddingSubtracting( 0 );
        testMethod( "\\((-5x^2 + 3x +4) + (-8x^2 -6x + 9)\\)", "\\(-13x^2 -3x  + 13\\)" );
    }

    @Test
    public void testAddingSubtractingCase1() {
        testAddingSubtracting( 1 );
        testMethod( "\\((-5x^2 + 3x +4) - (-8x^2 -6x + 9)\\)", "\\(3x^2 + 9x  -5\\)" );
    }

    private void testMultiplying( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn(
                -5,
                3,
                4,
                -8
        );

        when( utilSpy.randomInt( 2, 9 ) ).thenReturn(
            2,
                3,
                4,
                5
        );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.MULTIPLYING );
    }

    @Test
    public void testMultiplyingCase0() {
        testMultiplying( 0 );
        testMethod( "\\((-5x^2)(3x^3)\\)", "\\(-15x^{5}\\)" );
    }

    @Test
    public void testMultiplyingCase1() {
        testMultiplying( 1 );
        testMethod( "\\((-5x^2)(3x^3 + 4x^4)\\)", "\\(-15x^{5} -20x^{6}\\)" );
    }

    @Test
    public void testMultiplyingCase2() {
        testMultiplying( 2 );
        testMethod( "\\((-5x^2)(3x^3 + 4x^4 -8x^5)\\)", "\\(-15x^{5} -20x^{6} + 40x^{7}\\)" );
    }

    @Test
    public void testMultiplyingCase3() {
        testMultiplying( 3 );
        testMethod( "\\((-5x + 3)(4x -8)\\)", "\\(-20x^2 + 52x  -24\\)" );
    }

    private void testDividing( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn(
                -5,
                -6,
                3,
                8
        );

        when( utilSpy.randomInt( 2, 9 ) ).thenReturn(
                3,
                4,
                5,
                6
        );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );

        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.DIVIDING );
    }

    @Test
    public void testDividingCase0() {
        testDividing( 0 );
        testMethod( "\\((30x^{7} -15x^{8} -40x^{9})÷(-5x^3)\\)", "\\(-6x^4 + 3x^5 + 8x^6\\)" );
    }

    @Test
    public void testDividingCase1() {
        testDividing( 1 );
        testMethod( "\\(\\begin{align}\\frac{30x^{7} -15x^{8} -40x^{9}}{-5x^3}\\end{align}\\)", "\\(-6x^4 + 3x^5 + 8x^6\\)" );
    }

    private void factoringOutGcf( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 20 ) ).thenReturn(
                14,
                2,
                3
        );

        when( utilSpy.randomInt( 2, 9 ) ).thenReturn(
                3,
                4,
                5,
                6
        );

        when( utilSpy.randomInt( 1, 9 ) ).thenReturn( 7, 8 );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );

        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.FACTORING_OUT_GCF );
    }

    @Test
    public void testFactoringOutGcfCase0() {
        factoringOutGcf( 0 );
        testMethod( "\\(14x^3 + 2x^4\\)", "\\(2x^3(7 + x)\\)" );
    }

    @Test
    public void testFactoringOutGcfCase1() {
        factoringOutGcf( 1 );
        testMethod( "\\(14x^3 + 2x^4 + 3x^7\\)", "\\(x^3(14 + 2x + 3x^4)\\)" );
    }

    @Test
    public void testFactoringOutGcfCase2() {
        factoringOutGcf( 2 );
        testMethod( "\\(14x^3y^5 + 2x^4y^6 + 3x^7y^8\\)", "\\(x^3y^5(14 + 2x^y + 3x^4y^3)\\)" );
    }

    @Test
    public void testFactoringTrinomialsA1() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -5, 8 );
        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.FACTORING_TRINOMIALS_A_1 );

        testMethod( "\\(x^2 + 3x  -40\\)", "\\((x -5)(x + 8)\\)" );
    }

    @Test
    public void testFactoringTrinomialsANot1() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -5, 8 );
        when( utilSpy.nonZeroRandomInt( 2, 5 ) ).thenReturn( 2, 4 );
        setUtilMock( utilSpy );
        polynomialOperation.setType( PolynomialOperationSelection.Equation.FACTORING_TRINOMIALS_A_NOT_1 );

        testMethod( "\\(8x^2 -4x  -40\\)", "\\((2x -5)(4x + 8)\\leftarrow\\) Factored Completely<br>\\(4(2x -5)(x + 2)\\)" );
    }
}
