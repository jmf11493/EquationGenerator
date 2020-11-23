package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.EquationSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EquationTest {

    @Mock
    Util util = new Util();

    private BigDecimal two   = new BigDecimal( "2" );
    private BigDecimal three = new BigDecimal( "3" );
    private BigDecimal four  = new BigDecimal( "4" );
    private BigDecimal five  = new BigDecimal( "5" );
    private BigDecimal six   = new BigDecimal( "6" );
    private BigDecimal seven = new BigDecimal( "7" );
    private BigDecimal eight = new BigDecimal( "8" );

    Equation equationProblem = new Equation();

    private void setUtilMock( Util utilSpy ) {
        equationProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        equationProblem.generate();

        assertEquals( equation, equationProblem.getEquation() );
        assertEquals( answer, equationProblem.getAnswer() );
    }

    private void testOneStepEquation( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four, five, six );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.ONE_STEP );
    }

    @Test
    public void testOneStepEquationCase0() {
        testOneStepEquation( 0 );
        testMethod( "\\(5x = 20\\)", "\\(4\\)" );
    }

    @Test
    public void testOneStepEquationCase1() {
        testOneStepEquation( 1 );
        testMethod( "\\(5 + x = 9\\)", "\\(4\\)" );
    }

    @Test
    public void testOneStepEquationCase2() {
        testOneStepEquation( 2 );
        testMethod( "\\(x - 5 = -1\\)", "\\(4\\)" );
    }

    @Test
    public void testOneStepEquationCase3() {
        testOneStepEquation( 3 );
        testMethod( "\\(\\frac{x}{4} = 5\\)", "\\(20\\)" );
    }

    private void testTwoStepEquation( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four, five);
        when( utilSpy.random( 2, 10 ) ).thenReturn( seven );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.TWO_STEP );
    }

    @Test
    public void testTwoStepEquationCase0() {
        testTwoStepEquation( 0 );
        testMethod( "\\(4x + 7 = 27\\)", "\\(5\\)" );
    }

    @Test
    public void testTwoStepEquationCase1() {
        testTwoStepEquation( 1 );
        testMethod( "\\(27 = 7 + 4x\\)", "\\(5\\)" );
    }

    @Test
    public void testTwoStepEquationCase2() {
        testTwoStepEquation( 2 );
        testMethod( "\\(27 = 7 + 4x\\)", "\\(5\\)" );
    }

    @Test
    public void testTwoStepEquationCase3() {
        testTwoStepEquation( 3 );
        testMethod( "\\(\\frac{x}{7} + 4 = 5\\)", "\\(7\\)" );
    }

    private void testTwoStepDistributing( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four );
        when( utilSpy.random( 2, 15 ) ).thenReturn( five, seven, eight );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.TWO_STEP_DISTRIBUTING );
    }

    @Test
    public void testTwoStepDistributingCase0() {
        testTwoStepDistributing( 0 );
        testMethod( "\\(4(7x + 5) = 244\\)", "\\(8\\)" );
    }

    @Test
    public void testTwoStepDistributingCase1() {
        testTwoStepDistributing( 1 );
        testMethod( "\\(244 = 4(7x + 5)\\)", "\\(8\\)" );
    }

    @Test
    public void testTwoStepDistributingCase2() {
        testTwoStepDistributing( 2 );
        testMethod( "\\(244 = 4(5x + 7)\\)", "\\(8\\)" );
    }

    private void testCombiningLikeTerms( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four );
        when( utilSpy.random( 2, 10 ) ).thenReturn( seven, eight, three );
        when( utilSpy.random( 2, 15 ) ).thenReturn( five );
        when( utilSpy.nonZeroRandom( -12, 12 ) ).thenReturn( two );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.COMBINING_LIKE_TERMS );
    }

    @Test
    public void testCombiningLikeTermsCase0() {
        testCombiningLikeTerms( 0 );
        testMethod( "\\(5x + 7 - 8x = 1\\)", "\\(2\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase1() {
        testCombiningLikeTerms( 1 );
        testMethod( "\\(5x + 7 - 8x + 3= 4\\)", "\\(2\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase2() {
        testCombiningLikeTerms( 2 );
        testMethod( "\\(1 = 5x + 7 - 8x\\)", "\\(2\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase3() {
        testCombiningLikeTerms( 3 );
        testMethod( "\\(1=7+5x - 8x\\)", "\\(2\\)" );
    }

    private void testVariablesOnBothSides( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four );
        when( utilSpy.random( 2, 10 ) ).thenReturn( seven );
        when( utilSpy.random( 2, 5 ) ).thenReturn( five, three );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.VARIABLES_BOTH_SIDES );
    }

    @Test
    public void testVariablesOnBothSidesCase0() {
        testVariablesOnBothSides( 0 );
        testMethod( "\\(8x + 7 = 5x + 19\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesCase1() {
        testVariablesOnBothSides( 1 );
        testMethod( "\\(19 + 5x = 8x + 7\\)", "\\(4\\)" );
    }

    private void testVariablesOnBothSidesWithCombining( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four, five, six, seven, eight, two );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.VARIABLES_BOTH_SIDES_COMBINING );
    }

    @Test
    public void testVariablesOnBothSidesWithCombiningCase0() {
        testVariablesOnBothSidesWithCombining( 0 );
        testMethod( "\\(5 + 6x = 7x + 2 + 8x -33\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithCombiningCase1() {
        testVariablesOnBothSidesWithCombining( 1 );
        testMethod( "\\(5 + 6x +2= 7x -29 + 8x\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithCombiningCase2() {
        testVariablesOnBothSidesWithCombining( 2 );
        testMethod( "\\(6x +2 + 5x = 7x -14 + 8x\\)", "\\(4\\)" );
    }

    private void testVariablesOnBothSidesWithDistributing( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.random( 2, 5 ) ).thenReturn( three );
        when( utilSpy.random( 2, 10 ) ).thenReturn( seven );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( four, five, six );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCase0() {
        testVariablesOnBothSidesWithDistributing( 0 );
        testMethod( "\\(3(x + 7) = x + 29\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCase1() {
        testVariablesOnBothSidesWithDistributing( 1 );
        testMethod( "\\(x + 29 = 3(x + 7)\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCase2() {
        testVariablesOnBothSidesWithDistributing( 2 );
        testMethod( "\\(x + 77 = 3(5x + 7)\\)", "\\(4\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCase3() {
        testVariablesOnBothSidesWithDistributing( 3 );
        testMethod( "\\(6x + 57 = 3(5x + 7)\\)", "\\(4\\)" );
    }

    private void testDifficultMultStep( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn(
                four,
                five,
                six,
                two,
                three,
                six,
                eight,
                seven
        );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.DIFFICULT_MULTI_STEP_EQUATION );
    }

    @Test
    public void testDifficultMultStepCase0() {
        testDifficultMultStep( 0 );
        testMethod( "\\(107 + 5(6x + 2) = 3 + 6(8x + 7)\\)", "\\(4\\)" );
    }

    @Test
    public void testDifficultMultStepCase1() {
        testDifficultMultStep( 1 );
        testMethod( "\\(5(6x + 2) + 3(6x + 8) = 7x +198\\)", "\\(4\\)" );
    }

    private void testVariablesOnBothSidesWithDistributingFractions( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 4 );
        when( utilSpy.randomInt( 1, 3 ) ).thenReturn( 2 );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn(
                seven,
                six
        );
        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE_FRACTION );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingFractionsCase0() {
        testVariablesOnBothSidesWithDistributingFractions( 0 );
        testMethod( "\\(\\frac{1}{2}(4x + 12) = 6x -22\\)", "\\(7\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingFractionsCase1() {
        testVariablesOnBothSidesWithDistributingFractions( 1 );
        testMethod( "\\(6x -22 = \\frac{1}{2}(4x + 12)\\)", "\\(7\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingFractionsCase2() {
        testVariablesOnBothSidesWithDistributingFractions( 2 );
        testMethod( "\\(-22 + 6x = \\frac{1}{2}(4x + 12)\\)", "\\(7\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingFractionsCase3() {
        testVariablesOnBothSidesWithDistributingFractions( 3 );
        testMethod( "\\(\\frac{1}{2}(12 + 4x) = -22 + 6x\\)", "\\(7\\)" );
    }

    private void testVariablesOnBothSidesWithDistributingCombining( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.random( 2, 15 ) ).thenReturn( five, eight );
        when( utilSpy.random( 2, 10 ) ).thenReturn( four );
        when( utilSpy.random( -5, 5 ) ).thenReturn( three );
        when( utilSpy.random( -8, 8 ) ).thenReturn( three );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandom( -10, 10 ) ).thenReturn( seven );

        setUtilMock( utilSpy );

        equationProblem.setType( EquationSelection.Equation.VARIABLES_BOTH_SIDES_DISTRIBUTIVE_COMBINING );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCombiningCase0() {
        testVariablesOnBothSidesWithDistributingCombining( 0 );
        testMethod( "\\(7(8x + 5) + 4= 207\\)", "\\(3\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCombiningCase1() {
        testVariablesOnBothSidesWithDistributingCombining( 1 );
        testMethod( "\\(7(8x + 5) + 4x= 215\\)", "\\(3\\)" );
    }

    @Test
    public void testVariablesOnBothSidesWithDistributingCombiningCase2() {
        testVariablesOnBothSidesWithDistributingCombining( 2 );
        testMethod( "\\(7(8x + 5) + 4x + 3= 218\\)", "\\(3\\)" );
    }
}
