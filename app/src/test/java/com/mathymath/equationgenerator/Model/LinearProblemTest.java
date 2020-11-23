package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.LinearProblemSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LinearProblemTest {

    @Mock
    Util util = new Util();

    LinearProblem linearProblem = new LinearProblem();

    private void setUtilMock( Util utilSpy ) {
        linearProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        linearProblem.generate();

        assertEquals( equation, linearProblem.getEquation() );
        assertEquals( answer, linearProblem.getAnswer() );
    }

    @Test
    public void testSlopeBetweenPoints() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( 7 );
        when( utilSpy.randomInt( -10, 100 ) ).thenReturn( -7 );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 2 );
        when( utilSpy.nonZeroRandomInt( -20, 20 ) ).thenReturn( -20 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.TWO_POINTS_SLOPE );
        testMethod( "Find the slope between the points \\((7, -7)\\) and \\((9, -47)\\)", "Slope \\(= -20\\)" );
    }

    @Test
    public void testTwoPointsEquation() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 1, 5 ) ).thenReturn( 5 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( 0 );
        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 2 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 2 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.TWO_POINTS_EQUATION );
        testMethod( "Find the equation of the line that goes through the points \\((5, 0)\\) and \\((7, 4)\\)", "\\(y = 2x -10\\)" );
    }

    @Test
    public void testRewriteSlopeIntercept() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 5 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 0, 4 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.REWRITE_SLOPE_INTERCEPT );
        testMethod( "Write the equation \\(5y + 0x = 20\\) in slope-intercept \\(y = mx + b\\) form.", "\\(y = 0x + 4\\)" );
    }

    @Test
    public void testFindSlopeYIntercept() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 5 ) ).thenReturn( 5 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 0, 4 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.FIND_SLOPE_Y_INTERCEPT );
        testMethod( "Determine the slope and \\(y\\)-intercept of the equation \\(5y + 0x = 20\\)", "\\(y = 0x + 4\\)<br>Slope \\(= 0\\)<br>\\(y\\)-intercept \\(= 4\\)" );
    }

    @Test
    public void testGivenTableFindSlope() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 1, 5 ) ).thenReturn( 3 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -3 );
        when( utilSpy.nonZeroRandomInt( -9, 9 ) ).thenReturn( 9 );
        when( utilSpy.randomInt( 1, 4 ) ).thenReturn( 2 );
        when( utilSpy.randomInt( 8, 14 ) ).thenReturn( 9 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.TABLE_FIND_SLOPE );
        testMethod( "Find the slope of the linear relationship below<table border='1'><tr><td>\\(x\\)</td><td>3</td><td>5</td><td>7</td><td>9</td><td>11</td><td>13</td><td>15</td><td>17</td><td>19</td></tr><tr><td>\\(y\\)</td><td>-3</td><td>15</td><td>33</td><td>51</td><td>69</td><td>87</td><td>105</td><td>123</td><td>141</td></tr></table>",
                "Slope \\(= 9\\)" );
    }

    @Test
    public void testGivenTableWriteEquation() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 3 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -3 );
        when( utilSpy.nonZeroRandomInt( -9, 9 ) ).thenReturn( 9 );
        when( utilSpy.randomInt( 1, 4 ) ).thenReturn( 2 );
        when( utilSpy.randomInt( 8, 14 ) ).thenReturn( 9 );

        setUtilMock( utilSpy );
        linearProblem.setType( LinearProblemSelection.Equation.TABLE_WRITE_EQUATION );
        testMethod( "Find the equation of the line for the linear relationship below<table border='1'><tr><td>\\(x\\)</td><td>3</td><td>5</td><td>7</td><td>9</td><td>11</td><td>13</td><td>15</td><td>17</td><td>19</td></tr><tr><td>\\(y\\)</td><td>-3</td><td>15</td><td>33</td><td>51</td><td>69</td><td>87</td><td>105</td><td>123</td><td>141</td></tr></table>",
                "\\(y = 9x -30\\)" );
    }
}
