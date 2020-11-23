package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.FractionsDecimalsPercentsSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FractionsDecimalsPercentsTest {

    @Mock
    Util util = new Util();

    FractionsDecimalsPercents fractionsDecimalsPercents = new FractionsDecimalsPercents();

    private void setUtilMock( Util utilSpy ) {
        fractionsDecimalsPercents.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        fractionsDecimalsPercents.generate();

        assertEquals( equation, fractionsDecimalsPercents.getEquation() );
        assertEquals( answer, fractionsDecimalsPercents.getAnswer() );
    }

    private void testFraction( int a, int b ) {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 1, 25 ) ).thenReturn( a, b );

        setUtilMock( utilSpy );
        fractionsDecimalsPercents.setType( FractionsDecimalsPercentsSelection.Equation.FRACTION );
    }

    @Test
    public void testFractionWholeNumber() {
        testFraction( 4, 8 );
        testMethod( "\\(\\frac{4}{8}\\)", "\\(\\frac{4}{8}=0.5=50\\%\\)" );
    }

    @Test
    public void testFractionRepeating() {
        testFraction( 1, 3 );
        testMethod( "\\(\\frac{1}{3}\\)", "\\(\\frac{1}{3}\\approx0.3333\\approx33.33\\%\\)" );
    }

    @Test
    public void testDecimal() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 4 ) ).thenReturn( 2 );
        when( utilSpy.randomDecimal( new BigDecimal( "0.01" ), new BigDecimal( "3" ), 2 ) ).thenReturn( new BigDecimal( "2.10" ) );

        setUtilMock( utilSpy );
        fractionsDecimalsPercents.setType( FractionsDecimalsPercentsSelection.Equation.DECIMAL );
        testMethod( "\\(2.1\\)", "\\(2.1=\\frac{210}{100}=\\frac{21}{10}=210\\%\\)" );
    }

    @Test
    public void testPercent() {
        Util utilSpy = Mockito.spy( util );

        when( utilSpy.randomInt( 2, 4 ) ).thenReturn( 2 );
        when( utilSpy.randomDecimal( new BigDecimal( "0.01" ), new BigDecimal( "3" ), 2 ) ).thenReturn( new BigDecimal( "2.10" ) );

        setUtilMock( utilSpy );
        fractionsDecimalsPercents.setType( FractionsDecimalsPercentsSelection.Equation.PERCENT );
        testMethod( "\\(210\\%\\)", "\\(210\\%=\\frac{210}{100}=2.1\\)" );
    }
}
