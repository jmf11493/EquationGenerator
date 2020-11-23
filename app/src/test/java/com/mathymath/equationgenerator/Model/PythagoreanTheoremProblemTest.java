package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.PythagoreanTheoremSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PythagoreanTheoremProblemTest {

    @Mock
    Util util = new Util();

    PythagoreanTheoremProblem pythagoreanTheoremProblem = new PythagoreanTheoremProblem();

    private void setUtilMock( Util utilSpy ) {
        pythagoreanTheoremProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer, Util utilSpy ) {
        // Set g and h
        when(utilSpy.randomInt( 2, 6 )).thenReturn( 4 );
        when(utilSpy.randomInt( 1, 5 )).thenReturn( 2 );

        // Set the mocked util
        setUtilMock( utilSpy );

        pythagoreanTheoremProblem.generate();

        assertEquals( equation, pythagoreanTheoremProblem.getEquation() );
        assertEquals( answer, pythagoreanTheoremProblem.getAnswer() );
    }

    private Util testMissingLengths( int caseNumber ) {
        Util utilSpy = Mockito.spy( util );

        when(utilSpy.randomInt( 0, 1 )).thenReturn( caseNumber );

        pythagoreanTheoremProblem.setType( PythagoreanTheoremSelection.Equation.DETERMINE_MISSING_LENGTHS );

        return utilSpy;
    }

    @Test
    public void testMissingLengthsCase0() {
        testMethod( "Given a right triangle with legs \\(a = 20\\) and \\(b = 48\\), determine the length of the hypotenuse, \\(c\\)", "\\(c = 52\\)", testMissingLengths( 0 ) );
    }

    @Test
    public void testMissingLengthsCase1() {
        testMethod( "Given a right triangle with leg \\(a = 20\\) and hypotenuse, \\(c = 52\\), find the length of the leg \\(b\\)", "\\(b = 48\\)", testMissingLengths( 1 ) );
    }

    private Util testRightTriangles( int rightTriangleCase, int lengthCase ) {
        Util utilSpy = Mockito.spy( util );

        when(utilSpy.randomInt( 0, 6 )).thenReturn( rightTriangleCase );
        when(utilSpy.randomInt( 0, 5 )).thenReturn( lengthCase );
        when(utilSpy.nonZeroRandomInt( -4, 4 )).thenReturn( -2 );
        when(utilSpy.nonZeroRandomInt( 1, 5 )).thenReturn( 3 );

        pythagoreanTheoremProblem.setType( PythagoreanTheoremSelection.Equation.IS_RIGHT_TRIANGLE );

        return utilSpy;
    }

    @Test
    public void testRightTrianglesRightTriangleCase0LengthCase0() {
        testMethod( "Given a triangle with lengths \\(20, 48\\), and \\(52\\), is this a right triangle?", "Yes, since \\(20^2 + 48^2 = 52^2\\)", testRightTriangles(0, 0) );
    }

    @Test
    public void testRightTrianglesRightTriangleCase4LengthCase1() {
        testMethod( "Given a triangle with lengths \\(18, 52\\), and \\(48\\), is this a right triangle?", "No, since \\(18^2 + 48^2 \\neq 52^2\\)", testRightTriangles(4, 1) );
    }

    @Test
    public void testRightTrianglesRightTriangleCase5LengthCase2() {
        testMethod( "Given a triangle with lengths \\(46, 20\\), and \\(52\\), is this a right triangle?", "No, since \\(20^2 + 46^2 \\neq 52^2\\)", testRightTriangles(5, 2) );
    }

    @Test
    public void testRightTrianglesRightTriangleCase6LengthCase3() {
        testMethod( "Given a triangle with lengths \\(48, 55\\), and \\(20\\), is this a right triangle?", "No, since \\(20^2 + 48^2 \\neq 55^2\\)", testRightTriangles(6, 3) );
    }

    @Test
    public void testRightTrianglesRightTriangleCase0LengthCase4() {
        testMethod( "Given a triangle with lengths \\(52, 20\\), and \\(48\\), is this a right triangle?", "Yes, since \\(20^2 + 48^2 = 52^2\\)", testRightTriangles(0, 4) );
    }

    @Test
    public void testRightTrianglesRightTriangleCase1LengthCase5() {
        testMethod( "Given a triangle with lengths \\(52, 48\\), and \\(20\\), is this a right triangle?", "Yes, since \\(20^2 + 48^2 = 52^2\\)", testRightTriangles(1, 5) );
    }
}
