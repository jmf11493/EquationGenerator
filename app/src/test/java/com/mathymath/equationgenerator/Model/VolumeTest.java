package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.VolumeSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class VolumeTest {

    @Mock
    Util util = new Util();

    Volume volume = new Volume();

    private void setUtilMock( Util utilSpy ) {
        volume.util = utilSpy;
    }

    @Test
    public void testFindingVolumeRadiusCylinder() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set 'part' to radius
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        // Set shape to cylinder
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 0 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.FINDING_VOLUME );
        volume.generate();

        assertEquals( "Determine the volume of a cylinder whose radius is \\(2.3~cm\\) and height is \\(5.2~cm\\)", volume.getEquation() );
        assertEquals( "\\(27.508\\pi\\approx172.838~cm^{3}\\)", volume.getAnswer() );
    }

    @Test
    public void testFindingVolumeDiameterCylinder() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set 'part' to diameter
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        // Set shape to cylinder
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 0 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.FINDING_VOLUME );
        volume.generate();

        assertEquals( "Determine the volume of a cylinder whose diameter is \\(4.6~cm\\) and height is \\(5.2~cm\\)", volume.getEquation() );
        assertEquals( "\\(27.508\\pi\\approx172.838~cm^{3}\\)", volume.getAnswer() );
    }

    @Test
    public void testFindingVolumeDiameterCone() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set 'part' to diameter
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 );
        // Set shape to cone
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 1 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.FINDING_VOLUME );
        volume.generate();

        assertEquals( "Determine the volume of a cone whose diameter is \\(4.6~cm\\) and height is \\(5.2~cm\\)", volume.getEquation() );
        assertEquals( "\\(9.169\\pi\\approx28.806~cm^{3}\\)", volume.getAnswer() );
    }

    @Test
    public void testFindingVolumeRadiusSphere() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set 'part' to radius
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        // Set shape to sphere
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 2 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.FINDING_VOLUME );
        volume.generate();

        assertEquals( "Determine the volume of a sphere whose radius is \\(2.3~cm\\)", volume.getEquation() );
        assertEquals( "\\(16.223\\pi\\approx50.965~cm^{3}\\)", volume.getAnswer() );
    }

    @Test
    public void testFindingVolumeRadiusHemisphere() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set 'part' to radius
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 );
        // Set shape to hemisphere
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.FINDING_VOLUME );
        volume.generate();

        assertEquals( "Determine the volume of a hemisphere whose radius is \\(2.3~cm\\)", volume.getEquation() );
        assertEquals( "\\(8.111\\pi\\approx25.483~cm^{3}\\)", volume.getAnswer() );
    }

    @Test
    public void testWorkingBackwardsCylinderRadius() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set shape to cylinder - find radius
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 0 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.WORKING_BACKWARDS );
        volume.generate();

        assertEquals( "Determine the radius of a cylinder whose height is \\(5.2~cm\\) and volume is \\(27.508\\pi\\)", volume.getEquation() );
        assertEquals( "\\(radius = 2.3\\)", volume.getAnswer() );
    }

    @Test
    public void testWorkingBackwardsCylinderHeight() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set shape to cylinder - find height
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 1 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.WORKING_BACKWARDS );
        volume.generate();

        assertEquals( "Determine the height of a cylinder whose radius is \\(2.3~cm\\) and volume is \\(27.508\\pi\\)", volume.getEquation() );
        assertEquals( "\\(height = 5.2\\)", volume.getAnswer() );
    }

    @Test
    public void testWorkingBackwardsConeRadius() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set shape to cone - find radius
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 2 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.WORKING_BACKWARDS );
        volume.generate();

        assertEquals( "Determine the radius of a cone whose height is \\(5.2~cm\\) and volume is \\(9.169\\pi\\)", volume.getEquation() );
        assertEquals( "\\(radius = 2.3\\)", volume.getAnswer() );
    }

    @Test
    public void testWorkingBackwardsConeHeight() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set shape to cone - find height
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 3 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.WORKING_BACKWARDS );
        volume.generate();

        assertEquals( "Determine the height of a cone whose radius is \\(2.3~cm\\) and volume is \\(9.169\\pi\\)", volume.getEquation() );
        assertEquals( "\\(height = 5.2\\)", volume.getAnswer() );
    }

    @Test
    public void testWorkingBackwardsSphereRadius() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set radius to 2.3
        when( utilSpy.randomDecimal( new BigDecimal( "0.5" ), new BigDecimal( "5" ), 1 ))
                .thenReturn( new BigDecimal( "2.3" ) );
        // Set height to 5.2
        when( utilSpy.randomDecimal( new BigDecimal( "2" ), new BigDecimal( "10" ), 1 ))
                .thenReturn( new BigDecimal( "5.2" ) );
        // Set shape to sphere - find radius
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 4 );

        setUtilMock( utilSpy );

        // Set method to finding volume
        volume.setType( VolumeSelection.Equation.WORKING_BACKWARDS );
        volume.generate();

        assertEquals( "Determine the radius of a sphere whose volume is \\(16.223\\pi\\)", volume.getEquation() );
        assertEquals( "\\(radius = 2.3\\)", volume.getAnswer() );
    }
}
