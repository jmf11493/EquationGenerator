package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ProportionalReasoningSelection;
import com.mathymath.equationgenerator.Util.Util;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class ProportionalReasoningTest {

    @Mock
    Util util = new Util();

    ProportionalReasoning proportionalReasoning = new ProportionalReasoning();

    private void setUtilMock( Util utilSpy ) {
        proportionalReasoning.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        proportionalReasoning.generate();

        assertEquals( equation, proportionalReasoning.getEquation() );
        assertEquals( answer, proportionalReasoning.getAnswer() );
    }

    private void testSolvingProportions( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        // Set a
        when( utilSpy.randomInt( 2, 15 ) ).thenReturn( 7 );
        // Set b
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 3 );
        // Set c
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "8" ), 1 ) ).thenReturn( new BigDecimal( "6" ) );

        // Set the case number
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNum );

        setUtilMock( utilSpy );
        proportionalReasoning.setType( ProportionalReasoningSelection.Equation.SOLVING_PROPORTIONS );
    }

    @Test
    public void testSolvingProportionsCase0() {
        testSolvingProportions( 0 );
        testMethod( "\\(\\frac{x}{10}=\\frac{42}{60}\\)", "\\(x = 7\\)" );
    }

    @Test
    public void testSolvingProportionsCase1() {
        testSolvingProportions( 1 );
        testMethod( "\\(\\frac{7}{x}=\\frac{42}{60}\\)", "\\(x = 10\\)" );
    }

    @Test
    public void testSolvingProportionsCase2() {
        testSolvingProportions( 2 );
        testMethod( "\\(\\frac{7}{10}=\\frac{x}{60}\\)", "\\(x = 42\\)" );
    }

    @Test
    public void testSolvingProportionsCase3() {
        testSolvingProportions( 3 );
        testMethod( "\\(\\frac{7}{10}=\\frac{42}{x}\\)", "\\(x = 60\\)" );
    }

    private void testWritingSolvingProportions( int caseNum ) {
        Util utilSpy = Mockito.spy( util );

        Map< String, String > returnMap = new HashMap<>();
        returnMap.put( "problem", "Suppose \\(6\\) video games cost $\\(260.76\\). If a purchase of video games cost $\\(434.6\\), how many video games were purchased?" );
        returnMap.put( "answer", "-2" );

        // Set a
        when( utilSpy.randomInt( 80, 120 ) ).thenReturn( 101 );
        // Set b
        when( utilSpy.randomInt( 4, 9 ) ).thenReturn( 3 );
        // Set c
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 7 );

        // Set the case number
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNum );

        doReturn( returnMap ).when( utilSpy ).generateProportionalWordProblem( Mockito.any( WordProblem.class ) );

        setUtilMock( utilSpy );
        proportionalReasoning.setType( ProportionalReasoningSelection.Equation.WRITING_SOLVING_PROPORTIONS );
    }

    @Test
    public void testWritingSolvingProportionsCase0() {
        testWritingSolvingProportions( 0 );
        testMethod( "Suppose an airplane travels \\(303\\) miles in \\(3\\) hours. At this rate, how far could the airplane fly in \\(10\\) hours?", "\\(1010\\) miles" );
    }

    @Test
    public void testWritingSolvingProportionsCase1() {
        testWritingSolvingProportions( 1 );
        testMethod( "Suppose \\(6\\) video games cost $\\(260.76\\). If a purchase of video games cost $\\(434.6\\), how many video games were purchased?", "-2" );
    }
}
