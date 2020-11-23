package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SequenceProblemSelection;
import com.mathymath.equationgenerator.Model.Selection.SequenceTypeSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SequencesProblemTest {

    @Mock
    Util util = new Util();

    final EquationType ARITHMETIC = SequenceTypeSelection.Equation.ARITHMETIC;
    final EquationType GEOMETRIC = SequenceTypeSelection.Equation.GEOMETRIC;

    SequencesProblem sequencesProblem = new SequencesProblem();

    private void setUtilMock( Util utilSpy ) {
        sequencesProblem.util = utilSpy;
    }

    private void testMethod(String equation, String answer) {
        sequencesProblem.generate();
        assertEquals( equation, sequencesProblem.getEquation() );
        assertEquals( answer, sequencesProblem.getAnswer() );
    }

    private void testRecursiveToExplicit( int caseNumber, EquationType sequenceTypeSelection ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set change and initial for arithmetic
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 17 );
        when( utilSpy.nonZeroRandomInt( -20, 20 ) ).thenReturn( -7 );

        // Set change and initial for geometric
        when( utilSpy.nonZeroRandomInt( -8, 8 ) ).thenReturn( -8 );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 10 );

        // Set test case
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNumber );

        sequencesProblem.setType( SequenceProblemSelection.Equation.RECURSIVE_TO_EXPLICIT );
        sequencesProblem.secondarySpinnerListener( sequenceTypeSelection );
        setUtilMock( utilSpy );
    }

   @Test
   public void testRecursiveToExplicitArithmeticCase0() {
        testRecursiveToExplicit( 0, ARITHMETIC );
        testMethod( "\\(a_{n+1} = a_n +10 , a_1 = 3\\)", "\\(a_n = 3 + 10(n-1)~~or~~ a_n = 10n -7\\)" );
   }

    @Test
    public void testRecursiveToExplicitArithmeticCase1() {
        testRecursiveToExplicit( 1, ARITHMETIC );
        testMethod( "\\(f(x+1) = f(x) +10 , f(1) = 3\\)", "\\(f(x) = 3 + 10(x-1)~~or~~ f(x) = 10x -7\\)" );
    }

    @Test
    public void testRecursiveToExplicitArithmeticCase2() {
        testRecursiveToExplicit( 2, ARITHMETIC );
        testMethod( "\\(a_{n} = a_{n-1} +10 , a_1 = 3\\)", "\\(a_n = 3 + 10(n-1)~~or~~ a_n = 10n -7\\)" );
    }

    @Test
    public void testRecursiveToExplicitArithmeticCase3() {
        testRecursiveToExplicit( 3, ARITHMETIC );
        testMethod( "\\(f(x) = f(x-1) +10 , f(1) = 3\\)", "\\(f(x) = 3 + 10(x-1)~~or~~ f(x) = 10x -7\\)" );
    }

    @Test
    public void testRecursiveToExplicitGeometricCase0() {
        testRecursiveToExplicit( 0, GEOMETRIC );
        testMethod( "\\(a_{n+1} = a_n ⋅-8 , a_1 = -80\\)", "\\(a_n = -80(-8)^{n-1}~~or~~ a_n = 10(-8)^n\\)" );
    }

    @Test
    public void testRecursiveToExplicitGeometricCase1() {
        testRecursiveToExplicit( 1, GEOMETRIC );
        testMethod( "\\(f(x+1) = f(x) ⋅-8 , f(1) = -80\\)", "\\(f(x) = -80(-8)^{x-1}~~or~~ f(x) = 10(-8)^x\\)" );
    }

    @Test
    public void testRecursiveToExplicitGeometricCase2() {
        testRecursiveToExplicit( 2, GEOMETRIC );
        testMethod( "\\(a_{n} = a_{n-1} ⋅-8 , a_1 = -80\\)", "\\(a_n = -80(-8)^{n-1}~~or~~ a_n = 10(-8)^n\\)" );
    }

    @Test
    public void testRecursiveToExplicitGeometricCase3() {
        testRecursiveToExplicit( 3, GEOMETRIC );
        testMethod( "\\(f(x) = f(x-1) ⋅-8 , f(1) = -80\\)", "\\(f(x) = -80(-8)^{x-1}~~or~~ f(x) = 10(-8)^x\\)" );
    }

    private void testExplicitToRecursive( int caseNumber, EquationType sequenceTypeSelection ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set change and initial for arithmetic
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 17 );
        when( utilSpy.nonZeroRandomInt( -20, 20 ) ).thenReturn( -7 );

        // Set change and initial for geometric
        when( utilSpy.nonZeroRandomInt( -8, 8 ) ).thenReturn( -8 );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 10 );

        // Set test case
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNumber );

        sequencesProblem.setType( SequenceProblemSelection.Equation.EXPLICIT_TO_RECURSIVE );
        sequencesProblem.secondarySpinnerListener( sequenceTypeSelection );
        setUtilMock( utilSpy );
    }

    @Test
    public void testExplicitToRecursiveArithmeticCase0() {
        testExplicitToRecursive( 0, ARITHMETIC );
        testMethod( "\\(a_n = 3 + 10(n-1)~~or~~ a_n = 10n -7\\)", "\\(a_{n+1} = a_n +10 , a_1 = 3\\)" );
    }

    @Test
    public void testExplicitToRecursiveArithmeticCase1() {
        testExplicitToRecursive( 1, ARITHMETIC );
        testMethod( "\\(f(x) = 3 + 10(x-1)~~or~~ f(x) = 10x -7\\)", "\\(f(x+1) = f(x) +10 , f(1) = 3\\)" );
    }

    @Test
    public void testExplicitToRecursiveArithmeticCase2() {
        testExplicitToRecursive( 2, ARITHMETIC );
        testMethod( "\\(a_n = 3 + 10(n-1)~~or~~ a_n = 10n -7\\)", "\\(a_{n} = a_{n-1} +10 , a_1 = 3\\)" );
    }

    @Test
    public void testExplicitToRecursiveArithmeticCase30() {
        testExplicitToRecursive( 3, ARITHMETIC );
        testMethod( "\\(f(x) = 3 + 10(x-1)~~or~~ f(x) = 10x -7\\)", "\\(f(x) = f(x-1) +10 , f(1) = 3\\)" );
    }

    @Test
    public void testExplicitToRecursiveGeometricCase0() {
        testExplicitToRecursive( 0, GEOMETRIC );
        testMethod( "\\(a_n = -80(-8)^{n-1}~~or~~ a_n = 10(-8)^n\\)", "\\(a_{n+1} = a_n ⋅-8 , a_1 = -80\\)" );
    }

    @Test
    public void testExplicitToRecursiveGeometricCase1() {
        testExplicitToRecursive( 1, GEOMETRIC );
        testMethod( "\\(f(x) = -80(-8)^{x-1}~~or~~ f(x) = 10(-8)^x\\)", "\\(f(x+1) = f(x) ⋅-8 , f(1) = -80\\)" );
    }

    @Test
    public void testExplicitToRecursiveGeometricCase2() {
        testExplicitToRecursive( 2, GEOMETRIC );
        testMethod( "\\(a_n = -80(-8)^{n-1}~~or~~ a_n = 10(-8)^n\\)", "\\(a_{n} = a_{n-1} ⋅-8 , a_1 = -80\\)" );
    }

    @Test
    public void testExplicitToRecursiveGeometricCase3() {
        testExplicitToRecursive( 3, GEOMETRIC );
        testMethod( "\\(f(x) = -80(-8)^{x-1}~~or~~ f(x) = 10(-8)^x\\)", "\\(f(x) = f(x-1) ⋅-8 , f(1) = -80\\)" );
    }

    private void testSequenceToExplicit( int caseNumber, EquationType sequenceTypeSelection) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set change and initial for arithmetic
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 17 );
        when( utilSpy.nonZeroRandomInt( -20, 20 ) ).thenReturn( -7 );

        // Set change and initial for geometric
        when( utilSpy.nonZeroRandomInt( -8, 8 ) ).thenReturn( -8 );
        when( utilSpy.nonZeroRandomInt( -10, 10 ) ).thenReturn( 10 );

        // Set test case
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNumber );

        sequencesProblem.setType( SequenceProblemSelection.Equation.SEQUENCE_TO_EXPLICIT );
        sequencesProblem.secondarySpinnerListener( sequenceTypeSelection );
        setUtilMock( utilSpy );
    }

    @Test
    public void testSequenceToExplicitAritmeticCase0() {
        testSequenceToExplicit( 0, ARITHMETIC );
        testMethod("\\(3, 13, 23, 33, 43, 53\\)", "\\(a_n = 3 + 10(n-1)~~or~~ a_n = 10n -7\\)");
    }

    @Test
    public void testSequenceToExplicitAritmeticCase1() {
        testSequenceToExplicit( 1, ARITHMETIC );
        testMethod("\\(3, 13, 23, 33, 43, 53\\)", "\\(f(x) = 3 + 10(x-1)~~or~~ f(x) = 10x -7\\)");
    }

    @Test
    public void testSequenceToExplicitGeometricCase0() {
        testSequenceToExplicit( 0, GEOMETRIC );
        testMethod("\\(-80, 640, -5120, 40960, -327680, 2621440\\)", "\\(a_n = -80(-8)^{n-1}~~or~~ a_n = 10(-8)^n\\)");
    }

    @Test
    public void testSequenceToExplicitGeometricCase1() {
        testSequenceToExplicit( 1, GEOMETRIC );
        testMethod("\\(-80, 640, -5120, 40960, -327680, 2621440\\)", "\\(f(x) = -80(-8)^{x-1}~~or~~ f(x) = 10(-8)^x\\)");
    }
}
