package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ShapeSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ShapesTest {

    @Mock
    Util util = new Util();

    Shapes shapes = new Shapes();

    private void setUtilMock( Util utilSpy ) {
        shapes.util = utilSpy;
    }

    private void testMethod(String equation, String answer) {
        shapes.generate();
        assertEquals( equation, shapes.getEquation() );
        assertEquals( answer, shapes.getAnswer() );
    }

    private void testAngles( int caseNumber ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set a
        when( utilSpy.randomInt( 2, 85 ) ).thenReturn( 37 );

        // Set test case
        when( utilSpy.randomInt( 0, 7 ) ).thenReturn( caseNumber );

        shapes.setType( ShapeSelection.Equation.ANGLES );
        setUtilMock( utilSpy );
    }

    @Test
    public void testAnglesCase0() {
        testAngles( 0 );
        testMethod("What is the measure of a straight angle?", "\\(180^{\\circ}\\)");
    }

    @Test
    public void testAnglesCase1() {
        testAngles( 1 );
        testMethod("What is the measure of a right angle?", "\\(90^{\\circ}\\)");
    }

    @Test
    public void testAnglesCase2() {
        testAngles( 2 );
        testMethod("What is the name of an angle that is less than \\(90^{\\circ}\\)?", "Acute angle");
    }

    @Test
    public void testAnglesCase3() {
        testAngles( 3 );
        testMethod("What is the name of an angle that is more than \\(90^{\\circ}\\) and less than \\(180^{\\circ}\\)?", "Obtuse angle");
    }

    @Test
    public void testAnglesCase4() {
        testAngles( 4 );
        testMethod("What do we call two angles that add to \\(90^{\\circ}\\)?", "Complementary angles");
    }

    @Test
    public void testAnglesCase5() {
        testAngles( 5 );
        testMethod("What do we call two angles that add to \\(180^{\\circ}\\)?", "Supplementary angles");
    }

    @Test
    public void testAnglesCase6() {
        testAngles( 6 );
        testMethod("What is the complement to a \\(37^{\\circ}\\) angle?", "\\(53^{\\circ}\\)");
    }

    @Test
    public void testAnglesCase7() {
        testAngles( 7 );
        testMethod("What is the supplement to a \\(37^{\\circ}\\) angle?", "\\(143^{\\circ}\\)");
    }

    private void testTriangles( int caseNumber, Util utilSpy ) {
        //--------- Set spy methods ------------------------

        int angleA = 37;
        // Set a and b case 0 and 1
        when( utilSpy.randomInt( 2, 85 ) ).thenReturn( angleA );
        when( utilSpy.randomInt( 5, 150 - angleA ) ).thenReturn( 84 );

        // Set c case 1 for No
        when( utilSpy.randomInt( 3, 8 ) ).thenReturn( 4 );

        // Set a, b, and c case 2
        when( utilSpy.randomInt( 5, 10 ) ).thenReturn( 8, 5 );
        when( utilSpy.randomInt( 1, 4 ) ).thenReturn( 2 );
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 5 );

        // Set test case
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( caseNumber );

        shapes.setType( ShapeSelection.Equation.TRIANGLES );
        setUtilMock( utilSpy );
    }

    @Test
    public void testTrianglesCase0() {
        Util utilSpy = Mockito.spy( util );
        testTriangles( 0, utilSpy );
        testMethod( "If two angles of a triangle are \\(37^{\\circ}\\) and \\(84^{\\circ}\\), what is the measure of the third angle?", "\\(59^{\\circ}\\)" );
    }

    @Test
    public void testTrianglesCase1SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when ( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testTriangles( 1, utilSpy );
        testMethod( "Can a triangle have angles of \\(37^{\\circ}\\), \\(84^{\\circ}\\), and \\(59^{\\circ}\\)?", "Yes, since \\(37^{\\circ} + 84^{\\circ} + 59^{\\circ} = 180^{\\circ}\\)" );
    }

    @Test
    public void testTrianglesCase1SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when ( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testTriangles( 1, utilSpy );
        testMethod( "Can a triangle have angles of \\(37^{\\circ}\\), \\(84^{\\circ}\\), and \\(63^{\\circ}\\)?", "No, since \\(37^{\\circ} + 84^{\\circ} + 63^{\\circ} \\neq 180^{\\circ}\\)" );
    }

    @Test
    public void testTrianglesCase2SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when ( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testTriangles( 2, utilSpy );
        testMethod( "Can a triangle have side length of \\(8, 5,\\) and \\(11\\)?", "Yes, since \\(8 + 5 > 11\\)" );
    }

    @Test
    public void testTrianglesCase2SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when ( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testTriangles( 2, utilSpy );
        testMethod( "Can a triangle have side length of \\(8, 5,\\) and \\(18\\)?", "No, since \\(8 + 5 \\) is not more than \\( 18\\)" );
    }

    private void testCircles( int caseNumber, Util utilSpy ) {
        // Set the radius
        when( utilSpy.randomInt(  2, 9 ) ).thenReturn( 7 );

        // Set the case number
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( caseNumber );

        shapes.setType( ShapeSelection.Equation.CIRCLES );
        setUtilMock( utilSpy );
    }

    @Test
    public void testCirclesCase0SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testCircles( 0, utilSpy );
        testMethod( "What is the area of a circle whose radius is \\(7\\) cm?", "\\(49\\pi \\approx 153.938~cm^{2}\\)" );
    }

    @Test
    public void testCirclesCase0SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testCircles( 0, utilSpy );
        testMethod( "What is the area of a circle whose diameter is \\(14\\) cm?", "\\(49\\pi \\approx 153.938~cm^{2}\\)" );
    }

    @Test
    public void testCirclesCase1SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testCircles( 1, utilSpy );
        testMethod( "What is the radius of a circle whose area is \\(49\\pi ~cm^{2}\\)?", "\\(7~cm\\)" );
    }

    @Test
    public void testCirclesCase1SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testCircles( 1, utilSpy );
        testMethod( "What is the diameter of a circle whose area is \\(49\\pi ~cm^{2}\\)?", "\\(14~cm\\)" );
    }

    @Test
    public void testCirclesCase2SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testCircles( 2, utilSpy );
        testMethod( "What is the circumference of a circle whose radius is \\(7\\) cm?", "\\(14\\pi \\approx 43.982~cm\\)" );
    }

    @Test
    public void testCirclesCase2SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testCircles( 2, utilSpy );
        testMethod( "What is the circumference of a circle whose diameter is \\(14\\) cm?", "\\(14\\pi \\approx 43.982~cm\\)" );
    }

    @Test
    public void testCirclesCase3SubCase0() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        testCircles( 3, utilSpy );
        testMethod( "What is the radius of a circle whose circumference is \\(14\\pi ~cm\\)?", "\\(7~cm\\)" );
    }

    @Test
    public void testCirclesCase3SubCase1() {
        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        testCircles( 3, utilSpy );
        testMethod( "What is the diameter of a circle whose circumference is \\(14\\pi ~cm\\)?", "\\(14~cm\\)" );
    }

    @Test
    public void testCirclesCase4() {
        Util utilSpy = Mockito.spy( util );
        testCircles( 4, utilSpy );
        testMethod( "What is the radius of a circle whose diameter is \\(14~cm\\)?", "\\(7~cm\\)" );
    }

    @Test
    public void testCirclesCase5() {
        Util utilSpy = Mockito.spy( util );
        testCircles( 5, utilSpy );
        testMethod( "What is the diameter of a circle whose radius is \\(7~cm\\)?", "\\(14~cm\\)" );
    }

    private void testVolumeOfPrisms( int caseNumber, Util utilSpy ) {
        // Set the case number
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( caseNumber );

        shapes.setType( ShapeSelection.Equation.VOLUME_OF_PRISMS );
        setUtilMock( utilSpy );
    }

    @Test
    public void testVolumeOfPrismsCase0() {
        Util utilSpy = Mockito.spy( util );

        // Set h and b
        when( utilSpy.randomInt( 5, 20 ) ).thenReturn( 13 );
        when( utilSpy.randomInt( 10, 30 ) ).thenReturn( 27 );

        testVolumeOfPrisms( 0, utilSpy );
        testMethod( "What is the volume of a prism whose height is \\(13~cm\\) and whose base area is \\(27~cm^{2}\\)?", "\\(351~cm^{3}\\)" );
    }

    @Test
    public void testVolumeOfPrismsCase1() {
        Util utilSpy = Mockito.spy( util );

        // Set l, w, h
        when( utilSpy.randomInt( 5, 20 ) ).thenReturn( 13, 7, 20 );

        testVolumeOfPrisms( 1, utilSpy );
        testMethod( "What is the volume of a rectangular prism whose length is \\(13~cm\\), width is \\(7~cm\\), and height is \\(20~cm\\)?", "\\(1820~cm^{3}\\)" );
    }

    @Test
    public void testSurfaceArea() {
        Util utilSpy = Mockito.spy( util );

        // Set l, w, h
        when( utilSpy.randomInt( 5, 20 ) ).thenReturn( 13, 7, 20 );

        shapes.setType( ShapeSelection.Equation.SURFACE_AREA );
        setUtilMock( utilSpy );

        testMethod( "What is the surface area of a rectangular prism whose length is \\(13~cm\\), width is \\(7~cm\\), and height is \\(20~cm\\)?", "\\(982~cm^{2}\\)" );
    }
}
