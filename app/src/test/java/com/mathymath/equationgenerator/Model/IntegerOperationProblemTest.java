package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.IntegerOperationProblemSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IntegerOperationProblemTest {

    @Mock
    Util util = new Util();

    IntegerOperationProblem integerOperationProblem = new IntegerOperationProblem();

    private void setUtilMock( Util utilSpy ) {
        integerOperationProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        integerOperationProblem.generate();

        assertEquals( equation, integerOperationProblem.getEquation() );
        assertEquals( answer, integerOperationProblem.getAnswer() );
    }

    private void testAddingSubtracting( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( -10, -1 ) ).thenReturn( -7 );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 7 );

        setUtilMock( utilSpy );
        integerOperationProblem.setType( IntegerOperationProblemSelection.Equation.ADDING_SUBTRACTING );
    }

    @Test
    public void testAddingSubtractionCase0() {
        testAddingSubtracting( 0 );
        testMethod( "\\(-7 + 7\\)", "\\(0\\)" );
    }

    @Test
    public void testAddingSubtractionCase1() {
        testAddingSubtracting( 1 );
        testMethod( "\\(-7 - 7\\)", "\\(-14\\)" );
    }

    private void testMultiplyingDividing( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( -10, -2 ) ).thenReturn( -7 );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 7 );

        setUtilMock( utilSpy );
        integerOperationProblem.setType( IntegerOperationProblemSelection.Equation.MULTIPLYING_DIVIDING );
    }

    @Test
    public void testMultiplyingDividingCase0() {
        testMultiplyingDividing( 0 );
        testMethod( "\\(-7 \\cdot 7\\)", "\\(-49\\)" );
    }

    @Test
    public void testMultiplyingDividingCase1() {
        testMultiplyingDividing( 1 );
        testMethod( "\\(-49 \\div 7\\)", "\\(-7\\)" );
    }

    private void testOrderOfOperationsEasy( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandomInt( -6, 6 ) ).thenReturn( -2 );

        setUtilMock( utilSpy );
        integerOperationProblem.setType( IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_EASY );
    }

    @Test
    public void testOrderOfOperationsEasyCase0() {
        testOrderOfOperationsEasy( 0 );
        testMethod( "\\(-2 -2 \\times -2 \\times -2\\)", "\\(-10\\)" );
    }

    @Test
    public void testOrderOfOperationsEasyCase1() {
        testOrderOfOperationsEasy( 1 );
        testMethod( "\\(-2 -2 \\times (-2 -2)\\)", "\\(6\\)" );
    }

    @Test
    public void testOrderOfOperationsEasyCase2() {
        testOrderOfOperationsEasy( 2 );
        testMethod( "\\(-2 \\cdot (-2 -2 -2)\\)", "\\(12\\)" );
    }

    @Test
    public void testOrderOfOperationsEasyCase3() {
        testOrderOfOperationsEasy( 3 );
        testMethod( "\\((-2 -2) \\times -2 -2\\)", "\\(6\\)" );
    }

    private void testOrderOfOperationsMedium( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandomInt( -3, 3 ) ).thenReturn( -2 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 5 );
        when( utilSpy.nonZeroRandomInt( -8, 8 ) ).thenReturn( 8 );

        setUtilMock( utilSpy );
        integerOperationProblem.setType( IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_MEDIUM );
    }

    @Test
    public void testOrderOfOperationsMediumCase0() {
        testOrderOfOperationsMedium( 0 );
        testMethod( "\\(4\\div (3 - 5) \\times (-2 + 8)\\)", "\\(-12\\)" );
    }

    @Test
    public void testOrderOfOperationsMediumCase1() {
        testOrderOfOperationsMedium( 1 );
        testMethod( "\\(5\\times (4\\div -2 - 3 + 8)\\)", "\\(15\\)" );
    }

    private void testOrderOfOperationsHard( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandomInt( -3, 3 ) ).thenReturn( -2 );
        when( utilSpy.nonZeroRandomInt( -8, -2 ) ).thenReturn( -8 );
        when( utilSpy.nonZeroRandomInt( -8, 8 ) ).thenReturn( -8 );
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 10 );
        when( utilSpy.randomInt( -10, -2 ) ).thenReturn( 0 );

        setUtilMock( utilSpy );
        integerOperationProblem.setType( IntegerOperationProblemSelection.Equation.ORDER_OF_OPERATIONS_HARD );
    }

    @Test
    public void testOrderOfOperationsHardCase0() {
        testOrderOfOperationsHard( 0 );
        testMethod( "\\((-8)^2 +8\\times [4\\div (-10 +8)]\\times -2\\)", "\\(96\\)" );
    }

    @Test
    public void testOrderOfOperationsHardCase1() {
        testOrderOfOperationsHard( 1 );
        testMethod( "\\(((0) -8 + 10)^2 \\times (4\\div -2)^2\\)", "\\(16\\)" );
    }
}
