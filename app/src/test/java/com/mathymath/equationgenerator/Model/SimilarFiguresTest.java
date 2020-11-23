package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.SimilarFiguresSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SimilarFiguresTest {

    @Mock
    Util util = new Util();

    SimilarFigures similarFigures = new SimilarFigures();

    private void setUtilMock( Util utilSpy ) {
        similarFigures.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        similarFigures.generate();
        assertEquals( equation, similarFigures.getEquation() );
        assertEquals( answer, similarFigures.getAnswer() );
    }

    private void testDetermineScaleFactor( int caseNumber ) {
        testDetermineScaleFactor( caseNumber, -10, 10, 4, 9 );
    }

    private void testDetermineScaleFactor( int caseNumber, int min, int max, int val1, int val2 ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set sf
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 7 );

        // Set a and b
        when( utilSpy.randomInt( min, max ) ).thenReturn( val1, val2 );

        // Set test case
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( caseNumber );

        similarFigures.setType( SimilarFiguresSelection.Equation.DETERMINE_SCALE_FACTOR );
        setUtilMock( utilSpy );
    }

    @Test
    public void testDetermineScaleFactorCase0() {
        testDetermineScaleFactor( 0 );
        testMethod( "A scale factor is applied to coordinate point \\((4, 9)\\) to become the new point \\((28, 63)\\). What is the scale factor?", "Scale factor \\(= 7\\)" );
    }

    @Test
    public void testDetermineScaleFactorCase1() {
        testDetermineScaleFactor( 1, 2, 20, 6, 18 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If \\(AB\\) corresponds to \\(DE\\), \\(AB=6\\), and \\(DE=42\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ", "Scale factor \\(= 7\\)" );
    }

    @Test
    public void testDetermineScaleFactorCase2() {
        testDetermineScaleFactor( 2, 15, 100, 30, 77 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the perimeter of \\(ABC\\) is \\(30\\) and the perimeter of \\(DEF\\) is \\(210\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ", "Scale factor \\(= 7\\)" );
    }

    @Test
    public void testDetermineScaleFactorCase3() {
        testDetermineScaleFactor( 3, 15, 50, 16, 48 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the area of \\(ABC\\) is \\(16\\) and the area of \\(DEF\\) is \\(784\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ", "Scale factor \\(= 7\\)" );
    }

    @Test
    public void testDetermineScaleFactorCase4() {
        testDetermineScaleFactor( 4 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\). <br><br>If the scale factor from \\(DEF\\) to \\(ABC\\) is \\(\\frac{1}{7}\\), what is the scale factor from \\(ABC\\) to \\(DEF\\)? ", "Scale factor \\(= 7\\)" );
    }

    private void convertScaleFactor( int caseNumber ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set sf
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), BigDecimal.TEN, 1 ) ).thenReturn( new BigDecimal( "7.3" ) );

        // Set test case
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNumber );

        similarFigures.setType( SimilarFiguresSelection.Equation.CONVERT_SCALE_FACTOR );
        setUtilMock( utilSpy );
    }

    @Test
    public void testConvertScaleFactorCase0() {
        convertScaleFactor( 0 );
        testMethod( "The scale factor from shape \\(A\\) to shape \\(B\\) is \\(7.3\\). What is this written as a percent and as a coordinate rule?", "Percent = \\(730\\%\\), Rule = \\((7.3x, 7.3y)\\)" );
    }

    @Test
    public void testConvertScaleFactorCase1() {
        convertScaleFactor( 1 );
        testMethod( "The scale factor from shape \\(A\\) to shape \\(B\\) is \\(730\\%\\). What is this written as a decimal and as a coordinate rule?", "Decimal = \\(7.3\\), Rule = \\((7.3x, 7.3y)\\)" );
    }

    @Test
    public void testConvertScaleFactorCase2() {
        convertScaleFactor( 2 );
        testMethod( "The rule from shape \\(A\\) to shape \\(B\\) is \\((7.3x, 7.3y)\\). What is the scale factor written as a decimal and as a percent?", "Decimal = \\(7.3\\), Percent = \\(730\\%\\)" );
    }

    private void useScaleFactor( int parts, int format ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set sf
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), BigDecimal.TEN, 1 ) ).thenReturn( new BigDecimal( "7.3" ) );

        // Set format
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( format );

        // Set affected parts
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( parts );

        // Set c and d when format is 0
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -5, 6 );

        // Set c when format is 1
        when( utilSpy.randomInt( 2, 15 ) ).thenReturn( 11 );

        // Set c when format is 2 or 3
        when( utilSpy.randomInt( 10, 50 ) ).thenReturn( 45 );

        // Set c when format is 4
        when( utilSpy.randomInt( 10, 100 ) ).thenReturn( 67 );

        similarFigures.setType( SimilarFiguresSelection.Equation.USE_SCALE_FACTOR );
        setUtilMock( utilSpy );
    }

    @Test
    public void testUseScaleFactorFormat0Parts0() {
        useScaleFactor( 0, 0 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The scale factor from \\(ABC\\) to \\(DEF\\) is \\(7.3\\). If \\(A = (-5, 6)\\) corresponds to \\(D\\), what are the coordinates of \\(D\\)?", "\\(D = (-36.5, 43.8)\\)" );
    }

    @Test
    public void testUseScaleFactorFormat1Parts1() {
        useScaleFactor( 1, 1 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The scale factor from \\(ABC\\) to \\(DEF\\) is \\(730\\%\\). If \\(AB = 11\\) and \\(AB\\) corresponds to \\(DE\\), what is the length of \\(DE\\)?", "\\(DE = 80.3\\)" );
    }

    @Test
    public void testUseScaleFactorFormat2Parts2() {
        useScaleFactor( 2, 2 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The rule from \\(ABC\\) to \\(DEF\\) is \\((7.3x, 7.3y)\\). If the perimeter of \\(ABC\\) is \\(45\\), what is the perimeter of \\(DEF\\)?", "The perimeter of \\(DEF\\) is \\(328.5\\)" );
    }

    @Test
    public void testUseScaleFactorFormat2Parts3() {
        useScaleFactor( 3, 2 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The rule from \\(ABC\\) to \\(DEF\\) is \\((7.3x, 7.3y)\\). If the area of \\(ABC\\) is \\(45\\), what is the area of \\(DEF\\)?", "The area of \\(DEF\\) is \\(2398.05\\)" );
    }

    @Test
    public void testUseScaleFactorFormat1Parts4() {
        useScaleFactor( 4, 1 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The scale factor from \\(ABC\\) to \\(DEF\\) is \\(730\\%\\). If angle \\(A = 67^{\\circ}\\) and angle \\(A\\) corresponds to angle \\(D\\), what is the measure of angle \\(D\\)?", "Angle \\(D = 67^{\\circ}\\)" );
    }

    @Test
    public void testUseScaleFactorFormat0Parts3() {
        useScaleFactor( 3, 0 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The scale factor from \\(ABC\\) to \\(DEF\\) is \\(7.3\\). If the area of \\(ABC\\) is \\(45\\), what is the area of \\(DEF\\)?", "The area of \\(DEF\\) is \\(2398.05\\)" );
    }

    @Test
    public void testUseScaleFactorFormat1Parts2() {
        useScaleFactor( 2, 1 );
        testMethod( "Triangle \\(ABC\\) is similar to triangle \\(DEF\\)<br><br>The scale factor from \\(ABC\\) to \\(DEF\\) is \\(730\\%\\). If the perimeter of \\(ABC\\) is \\(45\\), what is the perimeter of \\(DEF\\)?", "The perimeter of \\(DEF\\) is \\(328.5\\)" );
    }
}
