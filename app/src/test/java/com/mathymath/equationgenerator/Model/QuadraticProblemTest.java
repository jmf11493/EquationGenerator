package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.QuadraticFunctionsProblemSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class QuadraticProblemTest {

    @Mock
    Util util = new Util();

    QuadraticProblem quadraticProblem = new QuadraticProblem();

    private void setUtilMock( Util utilSpy ) {
        quadraticProblem.util = utilSpy;
    }

    private void testMethod(String equation, String answer) {
        quadraticProblem.generate();
        assertEquals( equation, quadraticProblem.getEquation() );
        assertEquals( answer, quadraticProblem.getAnswer() );
    }

    private void testQuadraticFormula(int a, int b, int c) {
        Util utilSpy = Mockito.spy( util );

        // Set a,b and c
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( a );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( b );
        when( utilSpy.nonZeroRandomInt( -15, 15 ) ).thenReturn( c );

        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.QUADRATIC_FORMULA );
    }

    // 7 for a -6 for b and 15 for c

    @Test
    public void testQuadraticFormulaRealsOnlyDoubleRoot() {
        // Set reals only
        quadraticProblem.switchListener( true );
        testQuadraticFormula( 5, 10, 5 );
        testMethod( "\\(5x^2 + 10x + 5 = 0\\)", "\\(\\Big\\{-1\\Big\\}\\)" );
    }

    @Test
    public void testQuadraticFormulaNonRealsComplex() {
        quadraticProblem.switchListener( false );
        testQuadraticFormula( 7, -6, 15 );
        testMethod( "\\(7x^2 -6x + 15 = 0\\)", "\\(\\Big\\{\\frac{3}{7} \\pm \\frac{4\\sqrt{6}}{7}i\\Big\\}\\)" );
    }

    @Test
    public void testQuadraticFormulaPerfectRootNotImaginary() {
        quadraticProblem.switchListener( true );
        testQuadraticFormula( 1, 2, -15 );
        testMethod( "\\(1x^2 + 2x -15 = 0\\)", "\\(\\Big\\{-14, -5\\Big\\}\\)" );
    }

    @Test
    public void testQuadraticFormulaPerfectRootImaginary() {
        quadraticProblem.switchListener( false );

        testQuadraticFormula( 1, 4, 5 );
        testMethod( "\\(1x^2 + 4x + 5 = 0\\)", "\\(\\Big\\{-2\\pm 1i\\Big\\}\\)" );
    }

    private void testCompletingTheSquare(int h, int b) {
        Util utilSpy = Mockito.spy( util );

        // Set h and b
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( h, b );
        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.COMPLETING_THE_SQUARE );
    }

    @Test
    public void testCompletingTheSquareRealsComplex() {
        quadraticProblem.switchListener( true );
        testCompletingTheSquare( 3, -3 );
        testMethod( "\\(x^2 + 6x -3 = 0\\)", "\\((x + 3)^2 -12= 0 \\leftarrow\\) Vertex Form. Vertex is \\((-3, -12)\\)<br>\\(\\Big\\{ -3 \\pm 2\\sqrt{3}\\Big\\}\\)" );
    }

    @Test
    public void testCompletingTheSquareNonRealsImaginary() {
        quadraticProblem.switchListener( false );
        testCompletingTheSquare( 3, 18 );
        testMethod( "\\(x^2 + 6x + 18 = 0\\)", "\\((x + 3)^2 + 9= 0 \\leftarrow\\) Vertex Form. Vertex is \\((-3, 9)\\)<br>\\(\\Big\\{ -3 \\pm 3i\\Big\\}\\)" );
    }

    @Test
    public void testCompletingTheSquareNonRealsNegSqrt() {
        quadraticProblem.switchListener( false );
        testCompletingTheSquare( 2, -5 );
        testMethod( "\\(x^2 + 4x -5 = 0\\)", "\\((x + 2)^2 -9= 0 \\leftarrow\\) Vertex Form. Vertex is \\((-2, -9)\\)<br>\\(\\Big\\{ 1, -5\\Big\\}\\)" );
    }

    @Test
    public void testCompletingTheSquareNonRealsNegSqrt0() {
        quadraticProblem.switchListener( false );
        testCompletingTheSquare( 2, 4 );
        testMethod( "\\(x^2 + 4x + 4 = 0\\)", "\\((x + 2)^2 + 0= 0 \\leftarrow\\) Vertex Form. Vertex is \\((-2, 0)\\)<br>\\(\\Big\\{ -2\\Big\\}\\)" );
    }

    private void testSquareRoots( int case1, int case2 ) {
        Util utilSpy = Mockito.spy( util );

        // Set a and c
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 7, 8 );
        when( utilSpy.randomInt( -10, -2 ) ).thenReturn( -3 );

        // Set d
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -7 );

        // Set case 1
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( case1 );

        // Set case 2
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( case2 );

        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.SQUARE_ROOTS );
    }

    @Test
    public void testSquareRootsCase0Case0() {
        testSquareRoots( 0, 0 );
        testMethod( "\\(8x^2 = 392\\)", "\\(\\Big\\{-7, 7\\Big\\}\\)" );
    }

    @Test
    public void testSquareRootsCase1Case0() {
        testSquareRoots( 1, 0 );
        testMethod( "\\(-3x^2 = -147\\)", "\\(\\Big\\{-7, 7\\Big\\}\\)" );
    }

    @Test
    public void testSquareRootsCase0Case1() {
        testSquareRoots( 0, 1 );
        testMethod( "\\(x^2 -7 = 42\\)", "\\(\\Big\\{-7, 7\\Big\\}\\)" );
    }

    @Test
    public void testSquareRootsCase1Case2() {
        testSquareRoots( 0, 2 );
        testMethod( "\\(8x^2 -7 = 385\\)", "\\(\\Big\\{-7, 7\\Big\\}\\)" );
    }

    @Test
    public void testSquareRootsCase0Case2() {
        testSquareRoots( 0, 2 );
        testMethod( "\\(8x^2 -7 = 385\\)", "\\(\\Big\\{-7, 7\\Big\\}\\)" );
    }

    @Test
    public void testFactoringOutGcf() {
        Util utilSpy = Mockito.spy( util );

        // Set c and c
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 9 );
        when( utilSpy.randomInt(2, 7 ) ).thenReturn( 2 );

        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_OUT_GCF );

        testMethod( "\\(18x^2 + 9x = 0\\)", "\\(9x(2x + 1) = 0\\) <br> \\( \\Big\\{0, -\\frac{1}{2} \\Big\\}\\)" );
    }

    private void testFactoringTrinomialsA1( int b, int d ) {
        Util utilSpy = Mockito.spy( util );

        // Set b and d
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( b, d );

        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_TRINOMIALS_A_1 );
    }

    @Test
    public void testFactoringTrinomialsA1BCancelsD() {
        testFactoringTrinomialsA1( -7, 7 );
        testMethod( "\\(x^2 -49 = 0\\)", "\\((x -7)(x + 7) = 0\\) <br> \\( \\Big\\{7, -7 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsA1BEqualsD() {
        testFactoringTrinomialsA1( 2, 2 );
        testMethod( "\\(x^2 + 4x  + 4 = 0\\)", "\\((x + 2)(x + 2) = 0\\) <br> \\( \\Big\\{-2 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsA1BNotEqualD() {
        testFactoringTrinomialsA1( -7, -2 );
        testMethod( "\\(x^2 -9x  + 14 = 0\\)", "\\((x -7)(x -2) = 0\\) <br> \\( \\Big\\{7, 2 \\Big\\}\\)" );
    }

    private void testFactoringTrinomialsANot1( int a, int b, int c, int d ) {
        Util utilSpy = Mockito.spy( util );

        // Set a, b, c, and d
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( a, c );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( b, d );

        setUtilMock( utilSpy );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.FACTORING_TRINOMIALS_A_NOT_1 );
    }

    @Test
    public void testFactoringTrinomialsANot1DoubleRoot() {
        testFactoringTrinomialsANot1( 3, -3, 5, 8 );
        testMethod("\\(15x^2 + 9x  -24 = 0\\)", "\\((3x -3)(5x + 8) = 0\\)<br>\\(3(x -1)(5x + 8)= 0 \\leftarrow\\) Factored Completely<br>\\(\\Big\\{1, -1 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsANot1NotDoubleRoot() {
        testFactoringTrinomialsANot1( 3, -2, 5, 8 );
        testMethod("\\(15x^2 + 14x  -16 = 0\\)", "\\((3x -2)(5x + 8) = 0\\)<br>\\(\\Big\\{-\\frac{2}{3}, -1 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsANot1NegDDivideCNotFraction() {
        testFactoringTrinomialsANot1( 3, -2, 4, 8 );
        testMethod("\\(12x^2 + 16x  -16 = 0\\)", "\\((3x -2)(4x + 8) = 0\\)<br>\\(4(3x -2)(x + 2)= 0 \\leftarrow\\) Factored Completely<br>\\(\\Big\\{-\\frac{2}{3}, -2 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsANot1FEquals1() {
        testFactoringTrinomialsANot1( 2, 2, 5, 8 );
        testMethod("\\(10x^2 + 26x  + 16 = 0\\)", "\\((2x + 2)(5x + 8) = 0\\)<br>\\(2(x + 1)(5x + 8)= 0 \\leftarrow\\) Factored Completely<br>\\(\\Big\\{-1, -1 \\Big\\}\\)" );
    }

    @Test
    public void testFactoringTrinomialsANot1GEquals1() {
        testFactoringTrinomialsANot1( 1, 1, 5, 8 );
        testMethod("\\(5x^2 + 13x  + 8 = 0\\)", "\\((x + 1)(5x + 8) = 0\\)<br>\\(\\Big\\{-1, -1 \\Big\\}\\)" );
    }

    private void testAllMethods( int caseNumber ) {
        Util utilSpy = Mockito.spy( util );

        // Set a, b, c, and d
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( caseNumber );
        quadraticProblem.setType( QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase0() {
        testAllMethods( 0 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase1() {
        testAllMethods( 1 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase2() {
        testAllMethods( 2 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase3() {
        testAllMethods( 3 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase4() {
        testAllMethods( 4 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

    @Test
    public void testAllMethodsCase5() {
        testAllMethods( 5 );
        quadraticProblem.generate();
        assertTrue( quadraticProblem.type == QuadraticFunctionsProblemSelection.Equation.ALL_METHODS );
    }

}
