package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PercentsSelection;
import com.mathymath.equationgenerator.Util.Util;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblemFactory;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class PercentsTest {

    @Mock
    Util util = new Util();

    @Mock
    WordProblemFactory wordProblemFactory = new WordProblemFactory();

    Percents percents = new Percents();

    private final BigDecimal three = new BigDecimal( "3" );

    private final BigDecimal twoHundred = new BigDecimal( "200" );

    private final BigDecimal threeHundred = new BigDecimal( "300" );

    private final BigDecimal four = new BigDecimal( "4" );

    private final BigDecimal ten = new BigDecimal( "10" );

    private final BigDecimal ninetynine = new BigDecimal( "99" );

    private void setUtilMock( Util utilSpy ) {
        percents.util = utilSpy;
    }

    private void setWordProblemFactoryMock( WordProblemFactory wordProblemFactorySpy ) {
        percents.setWordProblemFactory( wordProblemFactorySpy );
    }

    private void testMethod(String equation, String answer) {
        percents.generate();
        assertEquals( equation, percents.getEquation() );
        assertEquals( answer, percents.getAnswer() );
    }

    private void testPercentsOfANumber( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomDecimal( three, twoHundred, 1  ) ).thenReturn( new BigDecimal( "56.1" ) );
        when( utilSpy.randomInt( 10, 300 ) ).thenReturn( 150 );
        when( utilSpy.randomDecimal( four, ten, 1 ) ).thenReturn( new BigDecimal( "5.2" ) );
        when( utilSpy.randomInt( 5, 40 ) ).thenReturn( 35 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( caseNum );

        WordProblem wordProblem = new WordProblem(
                "pound of ham",
                "pounds of ham",
                new BigDecimal( "2.22" ),
                3
        );

        WordProblemFactory wordProblemFactorySpy = Mockito.spy( wordProblemFactory );

        doReturn( wordProblem ).when( wordProblemFactorySpy ).getRandomPercentsWordProblem();

        setUtilMock( utilSpy );
        setWordProblemFactoryMock( wordProblemFactorySpy );
        percents.setType( PercentsSelection.Equation.PERCENT_OF_A_NUMBER );
    }

    @Test
    public void testPercentsOfANumberCase0() {
        testPercentsOfANumber( 0 );
        testMethod( "Find \\(56.1\\%\\) of \\(150\\)", "\\(84.15\\)" );
    }

    @Test
    public void testPercentsOfANumberCase1() {
        testPercentsOfANumber( 1 );
        testMethod( "\\(84.15\\) is \\(56.1\\%\\) of what number?", "\\(150\\)" );
    }

    @Test
    public void testPercentsOfANumberCase2() {
        testPercentsOfANumber( 2 );
        testMethod( "A pound of ham costs $\\(2.22\\) before tax. If a \\(5.2\\%\\) tax is applied, what is the final cost?<br><br>Round to the nearest cent.", "$\\(2.34\\)" );
    }

    @Test
    public void testPercentsOfANumberCase3() {
        testPercentsOfANumber( 3 );
        testMethod( "A pound of ham originally costs $\\(2.22\\). If a \\(35\\%\\) discount is applied, what is the new price?<br><br>Round to the nearest cent.", "$\\(1.44\\)" );
    }

    @Test
    public void testPercentsOfANumberCase4() {
        testPercentsOfANumber( 4 );
        testMethod( "A pound of ham originally costs $\\(2.22\\). If a \\(35\\%\\) discount is applied and then a \\(5.2\\%\\) tax, what is the final price?<br><br>Only round the final answer to the nearest cent.", "$\\(1.52\\)" );
    }

    private void testDeterminingPercents( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.randomDecimal( BigDecimal.ONE, ninetynine, 1 ) ).thenReturn( new BigDecimal( "33.4" ) );
        when( utilSpy.randomInt( 10, 300 ) ).thenReturn( 64 );
        when( utilSpy.randomDecimal( three, twoHundred, 1 ) ).thenReturn( new BigDecimal( "72.1" ) );
        when( utilSpy.randomInt( 0, percents.getSurveySubject().length - 1 ) ).thenReturn( 0 );
        when( utilSpy.randomInt( 10, 4000 ) ).thenReturn( 13 );
        when( utilSpy.randomInt( 2, 85 ) ).thenReturn( 24 );

        setUtilMock( utilSpy );
        percents.setType( PercentsSelection.Equation.DETERMINING_PERCENTS );
    }

    @Test
    public void testDeterminingPercentsCase0() {
        testDeterminingPercents( 0 );
        testMethod( "If the part is \\(21.376\\) and the whole is \\(64\\), what is the percent?", "\\(33.4\\%\\)" );
    }

    @Test
    public void testDeterminingPercentsCase1() {
        testDeterminingPercents( 1 );
        testMethod( "What percent of \\(64\\) is \\(46.144\\)?", "\\(72.1\\%\\)" );
    }

    @Test
    public void testDeterminingPercentsCase2() {
        testDeterminingPercents( 2 );
        testMethod( "In a survey of \\(1300\\) middle school students, \\(312\\) chose basketball as their favorite hobby.  What percent of those surveyed chose basketball?", "\\(24\\%\\)" );
    }

    private void testPercentChange( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNum );
        when( utilSpy.randomDecimal( three, threeHundred, 1 ) ).thenReturn( new BigDecimal( "223.4" ) );
        when( utilSpy.randomInt( 10, 300 ) ).thenReturn( 24 );
        when( utilSpy.randomDecimal( new BigDecimal( "0.03" ), three, 2 ) ).thenReturn( new BigDecimal( "1.56" ) );
        when( utilSpy.randomInt( 4, 15 ) ).thenReturn( 7 );

        WordProblem wordProblem = new WordProblem(
                "pound of ham",
                "pounds of ham",
                new BigDecimal( "2.22" ),
                3
        );

        WordProblemFactory wordProblemFactorySpy = Mockito.spy( wordProblemFactory );

        doReturn( wordProblem ).when( wordProblemFactorySpy ).getRandomPercentsWordProblem();

        setUtilMock( utilSpy );
        setWordProblemFactoryMock( wordProblemFactorySpy );
        percents.setType( PercentsSelection.Equation.PERCENT_CHANGE );
    }

    @Test
    public void testPercentChangeCase0() {
        testPercentChange( 0 );
        testMethod( "What is the percent change from \\(24\\) to \\(53.616\\)?", "\\(123.4\\%\\) increase" );
    }

    @Test
    public void testPercentChangeCase1() {
        testPercentChange( 1 );
        testMethod( "What is the percent change from \\(x\\) to \\(1.56x\\)?", "\\(56\\%\\) increase" );
    }

    @Test
    public void testPercentChangeCase2() {
        testPercentChange( 2 );
        testMethod( "A pound of ham costs $\\(2.22\\) before tax. If the pound of ham is $\\(2.375\\) after tax, what percent of tax was applied?", "\\(7\\%\\)" );
    }

    private void testDetermineTotalOriginal( int caseNum, int option ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum, option );
        when( utilSpy.random( 3, 200 ) ).thenReturn( new BigDecimal( "123.4" ) );
        when( utilSpy.random( 4, 10 ) ).thenReturn( new BigDecimal( "7.6" ) );
        when( utilSpy.randomInt( 10, 300 ) ).thenReturn( 24 );

        WordProblem wordProblem = new WordProblem(
                "pound of ham",
                "pounds of ham",
                new BigDecimal( "2.22" ),
                3
        );

        WordProblemFactory wordProblemFactorySpy = Mockito.spy( wordProblemFactory );

        doReturn( wordProblem ).when( wordProblemFactorySpy ).getRandomPercentsWordProblem();

        setUtilMock( utilSpy );
        setWordProblemFactoryMock( wordProblemFactorySpy );
        percents.setType( PercentsSelection.Equation.TOTAL_ORIGINAL );
    }

    @Test
    public void testDetermineTotalOriginalCase0Anwser() {
        testDetermineTotalOriginal( 0, 0 );
        testMethod( "\\(123.4\\%\\) of what number is \\(29.616\\)?", "\\(24\\)" );
    }

    @Test
    public void testDetermineTotalOriginalCase0Percent() {
        testDetermineTotalOriginal( 0,1 );
        testMethod( "\\(29.616\\) is \\(123.4\\%\\) of what number?", "\\(24\\)" );
    }

    @Test
    public void testDetermineTotalOriginalCase1Tax() {
        testDetermineTotalOriginal( 1, 0 );
        testMethod( "A pound of ham is purchased with a \\(7.6\\%\\) tax applied and the total cost is $\\(2.389\\) rounded to the nearest cent.<br><br>Determine the original cost.", "$\\(2.22\\)" );
    }

    @Test
    public void testDetermineTotalOriginalCase1Discount() {
        testDetermineTotalOriginal( 1, 1 );
        testMethod( "A pound of ham is purchased with a discount of \\(7.6\\%\\) and the discounted cost is $\\(2.051\\) rounded to the nearest cent.<br><br>Determine the original cost", "$\\(2.22\\)" );
    }

}
