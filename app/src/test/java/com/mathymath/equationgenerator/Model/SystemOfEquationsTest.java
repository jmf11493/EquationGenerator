package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SystemOfEquationsSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SystemOfEquationsTest {

    @Mock
    Util util = new Util();

    SystemOfEquations systemOfEquations = new SystemOfEquations();

    private void setUtilMock( Util utilSpy ) {
        systemOfEquations.util = utilSpy;
    }

    @Test
    public void testEliminationCase3() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 0 );
        // Set a and d
        when( utilSpy.randomInt( 2, 5 ))
                .thenReturn( 2 )
                .thenReturn( 4 );

        // Set b
        when( utilSpy.nonZeroRandomInt( -3, 3 )).thenReturn( -2 );

        // Set sf
        when( utilSpy.nonZeroRandomInt( -5, 5 )).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(2x -2y = -14\\\\4x -6y = -36\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 4)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testEliminationCase7() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 4 );
        // Set a and d
        when( utilSpy.randomInt( 2, 5 ))
                .thenReturn( 2 )
                .thenReturn( 4 );

        // Set b
        when( utilSpy.nonZeroRandomInt( -3, 3 )).thenReturn( -2 );

        // Set sf
        when( utilSpy.nonZeroRandomInt( -5, 5 )).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(2x = -14 + 2y\\\\4x -6y = -36\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 4)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testEliminationCase8() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 8 );
        // Set a, b, and c
        when( utilSpy.nonZeroRandomInt( -10, 10 ))
                .thenReturn( -2 )
                .thenReturn( -4 )
                .thenReturn( 7 );

        // Set sf
        when( utilSpy.randomInt( -5, -1 )).thenReturn( -2 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(-2x = 7 + 4y\\\\4x + 8y = -14\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testEliminationCase9() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 8 );
        // Set a, b, and c
        when( utilSpy.nonZeroRandomInt( -10, 10 ))
                .thenReturn( -2 )
                .thenReturn( -4 )
                .thenReturn( 7 );

        // Set sf
        when( utilSpy.randomInt( -5, -1 )).thenReturn( -2 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(-2x = 7 + 4y\\\\4x + 8y = -14\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testEliminationCase10() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 8 );
        // Set a, b, and c
        when( utilSpy.nonZeroRandomInt( -10, 10 ))
                .thenReturn( -2 )
                .thenReturn( -4 )
                .thenReturn( 7 );

        // Set sf
        when( utilSpy.randomInt( -5, -1 )).thenReturn( -2 );

        // Set f
        when( utilSpy.nonZeroRandomInt( -20, 20 )).thenReturn( 15 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(-2x = 7 + 4y\\\\4x + 8y = -14\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testEliminationCase11() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 4 );

        // Set case
        when( utilSpy.randomInt( 0, 11 )).thenReturn( 8 );
        // Set a, b, and c
        when( utilSpy.nonZeroRandomInt( -10, 10 ))
                .thenReturn( -2 )
                .thenReturn( -4 )
                .thenReturn( 7 );

        // Set sf
        when( utilSpy.randomInt( -5, -1 )).thenReturn( -2 );

        // Set f
        when( utilSpy.nonZeroRandomInt( -20, 20 )).thenReturn( 15 );

        setUtilMock( utilSpy );

        // Set method to elimination
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.ELIMINATION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(-2x = 7 + 4y\\\\4x + 8y = -14\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testGraphingCase0() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, y, and c
        when( utilSpy.nonZeroRandomInt( -5, 5 ) )
                .thenReturn( -3 )
                .thenReturn( 1 )
                .thenReturn( 3 );

        // Set b
        when( utilSpy.randomInt( -6, 6 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 7 )).thenReturn( 0 );

        setUtilMock( utilSpy );

        // Set method to graphing
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.GRAPHING );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(y = \\frac{-1}{-3}x + 2\\\\y = 3x + 10\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 1)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testGraphingCase5() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, y, and c
        when( utilSpy.nonZeroRandomInt( -5, 5 ) )
                .thenReturn( -3 )
                .thenReturn( 1 )
                .thenReturn( 3 );

        // Set b
        when( utilSpy.randomInt( -6, 6 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 7 )).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to graphing
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.GRAPHING );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(-3y + x = -6\\\\y = 3x + 10\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 1)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testGraphingCase6() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, y, b, and c
        when( utilSpy.nonZeroRandomInt( -5, 5 ) )
                .thenReturn( -3 )
                .thenReturn( 1 )
                .thenReturn( 2 )
                .thenReturn( 3 );

        // Set a
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 7 )).thenReturn( 6 );

        setUtilMock( utilSpy );

        // Set method to graphing
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.GRAPHING );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(2y + 4x = 6\\\\y = -2x + 3\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testGraphingCase7() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, y, b, and c
        when( utilSpy.nonZeroRandomInt( -5, 5 ) )
                .thenReturn( -3 )
                .thenReturn( 1 )
                .thenReturn( 2 )
                .thenReturn( 3 );

        // Set a
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set f
        when( utilSpy.nonZeroRandomInt( -10, 10 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 7 )).thenReturn( 7 );

        setUtilMock( utilSpy );

        // Set method to graphing
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.GRAPHING );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(2y + 4x = 6\\\\y = -2x + 2\\)", systemOfEquations.getEquation() );
        assertEquals( "No solutions, parallel lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase0() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set a
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set b
        when( utilSpy.randomInt( -3, -1 )).thenReturn( -2 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 0 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(2x -2y = -8\\\\x = 2y + 7\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 1)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase3() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set a
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set b
        when( utilSpy.randomInt( -3, -1 )).thenReturn( -2 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 2 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(x = 2y -5\\\\2x -2y = -8\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, 1)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase6() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set a, b, and c
        when( utilSpy.nonZeroRandomInt( -8, 8 ))
                .thenReturn( 2 )
                .thenReturn( -5 )
                .thenReturn( 6 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 6 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(y = 2x -5\\\\y = 6x + 7\\)", systemOfEquations.getEquation() );
        assertEquals( "\\((-3, -11)\\)", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase9() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 3 );

        // Set b
        when( utilSpy.randomInt( -3, -1 )).thenReturn( -1 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 9 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(3x -y = -10\\\\y = 3x + 10\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase10() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 3 );

        // Set a
        when( utilSpy.nonZeroRandomInt( -5, 5 )).thenReturn( 2 );

        // Set e
        when( utilSpy.nonZeroRandomInt( -10, 10 )).thenReturn( -5 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 10 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(x = 3y -5\\\\2x -6y = -10\\)", systemOfEquations.getEquation() );
        assertEquals( "\\(\\infty\\) solutions, equivalent lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase11() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 3 );

        // Set b
        when( utilSpy.randomInt( -3, -1 )).thenReturn( -2 );

        // Set e
        when( utilSpy.nonZeroRandomInt( -20, 20 )).thenReturn( 18 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 11 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(6x -2y = -20\\\\y = 3x + 18\\)", systemOfEquations.getEquation() );
        assertEquals( "No solutions, parallel lines", systemOfEquations.getAnswer() );
    }

    @Test
    public void testSubstitutionCase12() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set x, and y
        when( utilSpy.randomInt( -10, 10 ) )
                .thenReturn( -3 )
                .thenReturn( 1 );

        // Set d
        when( utilSpy.randomInt( 2, 5 )).thenReturn( 3 );

        // Set a
        when( utilSpy.nonZeroRandomInt( -5, 5 )).thenReturn( -2 );

        // Set e
        when( utilSpy.nonZeroRandomInt( -10, 10 )).thenReturn( 5 );

        // Set c
        when( utilSpy.nonZeroRandomInt( -20, 20 )).thenReturn( 5 );

        // Set case
        when( utilSpy.randomInt( 0, 12 )).thenReturn( 12 );

        setUtilMock( utilSpy );

        // Set method to substitution
        systemOfEquations.setType( SystemOfEquationsSelection.Equation.SUBSTITUTION );
        // Set one solution to false
        systemOfEquations.switchListener( false );
        systemOfEquations.generate();

        assertEquals( "\\(x = 3y + 5\\\\-2x + 6y = 5\\)", systemOfEquations.getEquation() );
        assertEquals( "No solutions, parallel lines", systemOfEquations.getAnswer() );
    }
}
