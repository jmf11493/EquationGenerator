package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.StatisticsProblemSelection;
import com.mathymath.equationgenerator.Util.Util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class StatisticsProblemTest {

    @Mock
    Util util = new Util();

    StatisticsProblem statisticsProblem = new StatisticsProblem();

    private void setUtilMock( Util utilSpy ) {
        statisticsProblem.util = utilSpy;
    }

    private void testMethod( String equation, String answer ) {
        statisticsProblem.generate();
        assertEquals( equation, statisticsProblem.getEquation() );
        assertEquals( answer, statisticsProblem.getAnswer() );
    }

    private void testMeanModeRange( int caseNumber ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set a
        when( utilSpy.randomInt( 2, 10 ) ).thenReturn( 7 );

        // Set b, c, d, and e
        when( utilSpy.randomInt( 1, 5 ) )
                .thenReturn( 1 )
                .thenReturn( 2 )
                .thenReturn( 3 )
                .thenReturn( 4 );

        // Set test case to 0
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( caseNumber );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MEAN_MED_MODE_RANGE );
        setUtilMock( utilSpy );
    }

    @Test
    public void testMeanModeRangeCase0() {
        testMeanModeRange( 0 );
        // Set method to elimination
        testMethod( "\\(7, 8, 7, 17, 8, 13, 7, 10, 7\\)", "Mean = 9.33<br>Median = 8<br>Mode = 7<br>Range = 10<br>Mean rounded to the nearest tenth." );
    }

    @Test
    public void testMeanModeRangeCase1() {
        testMeanModeRange( 1 );
        // Set method to elimination
        testMethod( "\\(7, 10, 7, 17, 8, 13, 7, 8, 7\\)", "Mean = 9.33<br>Median = 8<br>Mode = 7<br>Range = 10<br>Mean rounded to the nearest tenth." );
    }

    @Test
    public void testMeanModeRangeCase2() {
        testMeanModeRange( 2 );
        // Set method to elimination
        testMethod( "\\(7, 17, 7, 8, 8, 13, 7, 10, 7\\)", "Mean = 9.33<br>Median = 8<br>Mode = 7<br>Range = 10<br>Mean rounded to the nearest tenth." );
    }

    @Test
    public void testMeanModeRangeCase3() {
        testMeanModeRange( 3 );
        // Set method to elimination
        testMethod( "\\(10, 8, 7, 17, 7, 8, 7, 13, 7\\)", "Mean = 9.33<br>Median = 8<br>Mode = 7<br>Range = 10<br>Mean rounded to the nearest tenth." );
    }

    @Test
    public void testMeanAndMad() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set random numbers
        when( utilSpy.randomInt( 1, 10 ) )
                .thenReturn( 10 )
                .thenReturn( 2 )
                .thenReturn( 3 )
                .thenReturn( 4 )
                .thenReturn( 1 )
                .thenReturn( 4 )
                .thenReturn( 3 )
                .thenReturn( 6 )
                .thenReturn( 8 )
                .thenReturn( 8 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MEAN_MAD );
        setUtilMock( utilSpy );
        testMethod( "\\(10, 2, 3, 4, 1, 4, 3, 6, 8, 8\\)", "Mean = 4.9, MAD = 2.48" );
    }

    private void testMinQ1MedQ3Max( int[] values ) {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( values.length );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 2 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 11 );

        // Set random numbers

        //when( utilSpy.randomInt( 1, 10 ) ).thenReturn( values );


        statisticsProblem.setType( StatisticsProblemSelection.Equation.MEAN_MAD );
        setUtilMock( utilSpy );
    }

    @Test
    public void testMinQ1MedQ3MaxSize10() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 10 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 1 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 20 );

        when( utilSpy.randomInt( 1, 20 ) ).thenReturn( 4, 12, 20, 6, 13, 1, 11, 14, 20, 10 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(4, 12, 20, 6, 13, 1, 11, 14, 20, 10\\)", "Min = 1<br>Q1 = 6<br>Median = 11.5<br>Q3 = 14<br>Max = 20<br>IQR = Q3-Q1 = 8" );

    }

    @Test
    public void testMinQ1MedQ3MaxSize11() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 11 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 3 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 11 );

        when( utilSpy.randomInt( 3, 11 ) ).thenReturn( 7, 8, 7, 3, 10, 3, 10, 11, 5, 3, 4 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(7, 8, 7, 3, 10, 3, 10, 11, 5, 3, 4\\)", "Min = 3<br>Q1 = 3<br>Median = 7<br>Q3 = 10<br>Max = 11<br>IQR = Q3-Q1 = 7" );

    }

    @Test
    public void testMinQ1MedQ3MaxSize12() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 12 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 3 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 13 );

        when( utilSpy.randomInt( 3, 13 ) ).thenReturn( 3, 8, 11, 5, 11, 5, 11, 6, 13, 7, 7, 13 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(3, 8, 11, 5, 11, 5, 11, 6, 13, 7, 7, 13\\)", "Min = 3<br>Q1 = 5.5<br>Median = 7.5<br>Q3 = 11<br>Max = 13<br>IQR = Q3-Q1 = 5.5" );

    }

    @Test
    public void testMinQ1MedQ3MaxSize13() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 13 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 1 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 12 );

        when( utilSpy.randomInt( 1, 12 ) ).thenReturn( 6, 6, 1, 5, 6, 4, 11, 7, 5, 3, 12, 9, 12 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(6, 6, 1, 5, 6, 4, 11, 7, 5, 3, 12, 9, 12\\)", "Min = 1<br>Q1 = 4.5<br>Median = 6<br>Q3 = 10<br>Max = 12<br>IQR = Q3-Q1 = 5.5" );

    }

    @Test
    public void testMinQ1MedQ3MaxSize14() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 14 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 4 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 17 );

        when( utilSpy.randomInt( 4, 17 ) ).thenReturn( 4, 13, 8, 17, 13, 5, 7, 9, 16, 17, 5, 16, 10, 8 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(4, 13, 8, 17, 13, 5, 7, 9, 16, 17, 5, 16, 10, 8\\)", "Min = 4<br>Q1 = 7<br>Median = 9.5<br>Q3 = 16<br>Max = 17<br>IQR = Q3-Q1 = 9" );

    }

    @Test
    public void testMinQ1MedQ3MaxSize15() {
        Util utilSpy = Mockito.spy( util );
        //--------- Set spy methods ------------------------

        // Set size
        when( utilSpy.randomInt( 7, 15 ) ).thenReturn( 15 );

        // Set min
        when( utilSpy.randomInt( 0, 5 ) ).thenReturn( 4 );

        // Set max
        when( utilSpy.randomInt( 10, 20 ) ).thenReturn( 12 );
        // 4 5 6 6 6 6 8 9 10 10 11 11 11 11 12

        when( utilSpy.randomInt( 4, 12 ) ).thenReturn( 5, 6, 10, 11, 6, 6, 10, 9, 4, 12, 11, 11, 11, 8, 6 );

        statisticsProblem.setType( StatisticsProblemSelection.Equation.MIN_Q1_MED_Q3_MAX );
        setUtilMock( utilSpy );
        testMethod( "\\(5, 6, 10, 11, 6, 6, 10, 9, 4, 12, 11, 11, 11, 8, 6\\)", "Min = 4<br>Q1 = 6<br>Median = 9<br>Q3 = 11<br>Max = 12<br>IQR = Q3-Q1 = 5" );

    }
}
