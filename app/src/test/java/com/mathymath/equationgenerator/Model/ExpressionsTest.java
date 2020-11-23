package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ExpressionsSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ExpressionsTest {

    @Mock
    Util util = new Util();

    Expressions expressions = new Expressions();

    private void setUtilMock( Util utilSpy ) {
        expressions.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        expressions.generate();

        assertEquals( equation, expressions.getEquation() );
        assertEquals( answer, expressions.getAnswer() );
    }

    private void testTranslatingWords( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.generateBase( false ) ).thenReturn( "x", "y", "3" );
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 5 );
        when( utilSpy.randomInt( 0, 19 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.TRANSLATING_WORDS );
    }
    
    @Test
    public void testTranslatingWordsCase0() {
        testTranslatingWords( 0 );
        testMethod( "The sum of \\(x\\) and \\(y\\)", "\\(x + y\\)" );
    }

    @Test
    public void testTranslatingWordsCase1() {
        testTranslatingWords( 1 );
        testMethod( "\\(x\\) plus \\(y\\)", "\\(x + y\\)" );
    }

    @Test
    public void testTranslatingWordsCase2() {
        testTranslatingWords( 2 );
        testMethod( "\\(x\\) more than \\(y\\)", "\\(x + y\\)" );
    }

    @Test
    public void testTranslatingWordsCase3() {
        testTranslatingWords( 3 );
        testMethod( "\\(x\\) increased by \\(y\\)", "\\(x + y\\)" );
    }

    @Test
    public void testTranslatingWordsCase4() {
        testTranslatingWords( 4 );
        testMethod( "\\(x\\) decreased by \\(y\\)", "\\(x - y\\)" );
    }

    @Test
    public void testTranslatingWordsCase5() {
        testTranslatingWords( 5 );
        testMethod( "\\(x\\) less than \\(y\\)", "\\(y - x\\)" );
    }

    @Test
    public void testTranslatingWordsCase6() {
        testTranslatingWords( 6 );
        testMethod( "\\(x\\) subtracted from \\(y\\)", "\\(y - x\\)" );
    }

    @Test
    public void testTranslatingWordsCase7() {
        testTranslatingWords( 7 );
        testMethod( "The product of \\(x\\) and \\(y\\)", "\\(x \\cdot y\\)" );
    }

    @Test
    public void testTranslatingWordsCase8() {
        testTranslatingWords( 8 );
        testMethod( "\\(x\\) times \\(y\\)", "\\(x \\cdot y\\)" );
    }

    @Test
    public void testTranslatingWordsCase9() {
        testTranslatingWords( 9 );
        testMethod( "Double \\(x\\)", "\\(2 \\cdot x\\)" );
    }

    @Test
    public void testTranslatingWordsCase10() {
        testTranslatingWords( 10 );
        testMethod( "Triple \\(x\\)", "\\(3 \\cdot x\\)" );
    }

    @Test
    public void testTranslatingWordsCase11() {
        testTranslatingWords( 11 );
        testMethod( "The quotient of \\(x\\) and \\(y\\)", "\\(x \\div y= \\frac{x}{y}\\)" );
    }

    @Test
    public void testTranslatingWordsCase12() {
        testTranslatingWords( 12 );
        testMethod( "\\(x\\) divided by \\(y\\)", "\\(x \\div y= \\frac{x}{y}\\)" );
    }

    @Test
    public void testTranslatingWordsCase13() {
        testTranslatingWords( 13 );
        testMethod( "The ratio of \\(x\\) to \\(y\\)", "\\(\\frac{x}{y}\\)" );
    }

    @Test
    public void testTranslatingWordsCase14() {
        testTranslatingWords( 14 );
        testMethod( "\\(x\\) less than \\(y\\) times \\(3\\)", "\\(y \\cdot 3 - x\\)" );
    }

    @Test
    public void testTranslatingWordsCase15() {
        testTranslatingWords( 15 );
        testMethod( "\\(x\\) increased by \\(y\\) times \\(3\\)", "\\(x + y \\cdot 3\\)" );
    }
    
    @Test
    public void testTranslatingWordsCase16() {
        testTranslatingWords( 16 );
        testMethod( "\\(x\\) times the sum of \\(y\\) and \\(3\\)", "\\(x \\cdot (y + 3)\\)" );
    }

    @Test
    public void testTranslatingWordsCase17() {
        testTranslatingWords( 17 );
        testMethod( "The difference of \\(x\\) and the sum of \\(y\\) and \\(3\\)", "\\(x - (y + 3)\\)" );
    }

    @Test
    public void testTranslatingWordsCase18() {
        testTranslatingWords( 18 );
        testMethod( "The difference of \\(x\\) and \\(5\\) times the sum of \\(y\\) and \\(3\\)", "\\(x - 5(y + 3)\\)" );
    }

    @Test
    public void testTranslatingWordsCase19() {
        testTranslatingWords( 19 );
        testMethod( "\\(x\\) squared", "\\(x^{2}\\)" );
    }

    private void testEvaluatingExpressions( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -4, 5 );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 4 );
        when( utilSpy.randomInt( 2, 9 ) ).thenReturn( 5 );
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.EVALUATING_EXPRESSIONS );
    }

    @Test
    public void testEvaluatingExpressionsCase0() {
        testEvaluatingExpressions( 0 );
        testMethod( "Evaluate \\(x^2 + y\\cdot z\\) when \\(x = 4, y = -4, \\) and \\(z = 5\\)", "\\(-4\\)" );
    }

    @Test
    public void testEvaluatingExpressionsCase1() {
        testEvaluatingExpressions( 1 );
        testMethod( "Evaluate \\((x + y)\\cdot z\\) when \\(x = 4, y = -4, \\) and \\(z = 5\\)", "\\(0\\)" );
    }

    @Test
    public void testEvaluatingExpressionsCase2() {
        testEvaluatingExpressions( 2 );
        testMethod( "Evaluate \\(5(x + y) + z\\) when \\(x = 4, y = -4, \\) and \\(z = 5\\)", "\\(5\\)" );
    }

    @Test
    public void testEvaluatingExpressionsCase3() {
        testEvaluatingExpressions( 3 );
        testMethod( "Evaluate \\(x \\cdot y + 5z\\) when \\(x = 4, y = -4, \\) and \\(z = 5\\)", "\\(9\\)" );
    }

    private void testCombiningLikeTerms( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -4, 5, 6, -3, -2, 4 );
        when( utilSpy.randomInt( 0, 10 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.COMBINING_LIKE_TERMS );
    }

    @Test
    public void testCombiningLikeTermsCase0() {
        testCombiningLikeTerms( 0 );
        testMethod( "Simplify: \\(-4 -3x + 5 + 4x\\)", "\\(1 + x\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase1() {
        testCombiningLikeTerms( 1 );
        testMethod( "Simplify: \\(-4 -3y + 5 + 4y\\)", "\\(1 + y\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase2() {
        testCombiningLikeTerms( 2 );
        testMethod( "Simplify: \\(-4z -3y + 5z + 4y\\)", "\\(1z + y\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase3() {
        testCombiningLikeTerms( 3 );
        testMethod( "Simplify: \\(-4x^2 -3y + 5x^2 + 4y\\)", "\\(x^2 + y\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase4() {
        testCombiningLikeTerms( 4 );
        testMethod( "Simplify: \\(-4x^2 -3x + 5x^2 + 4x\\)", "\\(x^2 + x\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase5() {
        testCombiningLikeTerms( 5 );
        testMethod( "Simplify: \\(-4x -3y + 5x + 4\\)", "\\(x -3y + 4\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase6() {
        testCombiningLikeTerms( 6 );
        testMethod( "Simplify: \\(-4x -3x^2 + 5x + 4\\)", "\\(x -3x^2 + 4\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase7() {
        testCombiningLikeTerms( 7 );
        testMethod( "Simplify: \\(-4x -3 + 5y + 4x -2 + 6y\\)", "\\(11y -5\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase8() {
        testCombiningLikeTerms( 8 );
        testMethod( "Simplify: \\(-4x -3 + 5x + 4y -2x + 6y\\)", "\\(-x + 10y -3\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase9() {
        testCombiningLikeTerms( 3 );
        testMethod( "Simplify: \\(-4x^2 -3y + 5x^2 + 4y\\)", "\\(x^2 + y\\)" );
    }

    @Test
    public void testCombiningLikeTermsCase10() {
        testCombiningLikeTerms( 10 );
        testMethod( "Simplify: \\(-4 -3y + 5x -2 + 4y + 6\\)", "\\(5x + y\\)" );
    }

    private void testDistributing( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -7, 6, 3 );
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.DISTRIBUTING );
    }

    @Test
    public void testDistributingCase0() {
        testDistributing( 0 );
        testMethod( "Distribute: \\(-7(6x + 3)\\)", "\\(-42x -21\\)" );
    }

    @Test
    public void testDistributingCase1() {
        testDistributing( 1 );
        testMethod( "Distribute: \\(x(6x + 3)\\)", "\\(6x^2 + 3x\\)" );
    }

    @Test
    public void testDistributingCase2() {
        testDistributing( 2 );
        testMethod( "Distribute: \\(-7x(6x + 3)\\)", "\\(-42x^2 -21x\\)" );
    }

    @Test
    public void testDistributingCase3() {
        testDistributing( 3 );
        testMethod( "Distribute: \\(-7(6x + 3+ y)\\)", "\\(-42x -21 -7y\\)" );
    }

    private void testDistributingAndCombining( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( -7, -8, -4, 4, 5, 6 );
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.DISTRIBUTING_AND_COMBINING );
    }

    @Test
    public void testDistributingAndCombiningCase0() {
        testDistributingAndCombining( 0 );
        testMethod( "Distribute and Simplify: \\(-7(-8x -4) + 4\\)", "\\(56x + 32\\)" );
    }

    @Test
    public void testDistributingAndCombiningCase1() {
        testDistributingAndCombining( 1 );
        testMethod( "Distribute and Simplify: \\(-7(-8x -4) + 4x\\)", "\\(60x +28\\)" );
    }

    @Test
    public void testDistributingAndCombiningCase2() {
        testDistributingAndCombining( 2 );
        testMethod( "Distribute and Simplify: \\(-7(-8x -4) + 4x + 5\\)", "\\(60x + 33\\)" );
    }

    @Test
    public void testDistributingAndCombiningCase3() {
        testDistributingAndCombining( 3 );
        testMethod( "Distribute and Simplify: \\(-7(-8x -4) + 6(4x + 5)\\)", "\\(80x + 58\\)" );
    }

    private void testFactoring( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 20 ) ).thenReturn( 3, 18 );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( caseNum );
        setUtilMock( utilSpy );

        expressions.setType( ExpressionsSelection.Equation.FACTORING );
    }

    @Test
    public void testFactoringCase0() {
        testFactoring( 0 );
        testMethod( "Factor: \\(3x - 18\\)", "\\(3(x - 6)\\)" );
    }

    @Test
    public void testFactoringCase4() {
        testFactoring( 4 );
        testMethod( "Factor: \\(3x^2 - 18x\\)", "\\(3x(x - 6)\\)" );
    }
}
