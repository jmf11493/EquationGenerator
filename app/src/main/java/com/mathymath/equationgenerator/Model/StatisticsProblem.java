package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.StatisticsProblemSelection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsProblem extends Generator {

    public StatisticsProblem() {
        super();
        selectionList = new StatisticsProblemSelection();
    }

    @Override
    public String getEquation() {
        return "\\(" + util.cleanEquation( util.removeDoubleSigns( equation ) ) + "\\)";
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( answer );
    }

    @Override
    public void generate() {
        switch ( ( StatisticsProblemSelection.Equation ) type ) {
            case MEAN_MED_MODE_RANGE:
                meanMedModeRange();
                break;
            case MEAN_MAD:
                meanAndMad();
                break;
            case MIN_Q1_MED_Q3_MAX:
                minQ1MedQ3Max();
                break;
            default:
                // Nothing
        }
    }

    private void meanMedModeRange() {
        int a = util.randomInt( 2, 10 );
        int b = util.randomInt( 1, 5 ) + a;
        int c = util.randomInt( 1, 5 ) + b;
        int d = util.randomInt( 1, 5 ) + c;
        int e = util.randomInt( 1, 5 ) + d;

        String mean = util.roundValue( ( ( 4 * a + 2 * b + c + d + e ) / 9.0 ) + "", 2 );

        switch ( util.randomInt( 0, 3 ) ) {
            case 0:
                equation = a + ", " + b + ", " + a + ", " + e + ", " + b + ", " + d + ", " + a + ", " + c + ", " + a;
                break;
            case 1:
                equation = a + ", " + c + ", " + a + ", " + e + ", " + b + ", " + d + ", " + a + ", " + b + ", " + a;
                break;
            case 2:
                equation = a + ", " + e + ", " + a + ", " + b + ", " + b + ", " + d + ", " + a + ", " + c + ", " + a;
                break;
            case 3:
                equation = c + ", " + b + ", " + a + ", " + e + ", " + a + ", " + b + ", " + a + ", " + d + ", " + a;
                break;
            default:
                // Nothing
        }

        answer = "Mean = " + mean + "<br>Median = " + b + "<br>Mode = " + a + "<br>Range = " + ( e - a ) + "<br>Mean rounded to the nearest tenth.";
    }

    private void meanAndMad() {
        // Total
        BigDecimal a = new BigDecimal( "0" );

        ArrayList< BigDecimal > nums = new ArrayList<>();

        for ( int i = 0; i < 10; i++ ) {
            Integer randomNum = util.randomInt( 1, 10 );
            BigDecimal randomNumDec = new BigDecimal( randomNum.toString() );
            nums.add( randomNumDec );
            a = a.add( randomNumDec );
        }

        BigDecimal mean = a.divide( new BigDecimal( "10" ) );
        // Difference from the mean sum
        BigDecimal c = new BigDecimal( "0" );

        for ( int i = 0; i < 10; i++ ) {
            c = c.add( nums.get( i ).subtract( mean ).abs() );
        }
        // MAD
        BigDecimal mad = c.divide( new BigDecimal( "10" ) );

        equation = nums.toString().replace( "[", "" ).replace( "]", "" );
        answer = "Mean = " + mean + ", MAD = " + mad;
    }

    private void minQ1MedQ3Max() {
        ArrayList< Integer > nums = new ArrayList<>();
        ArrayList< Integer > orderedVals = new ArrayList<>();
        Map< Integer, Integer > numMap = new HashMap<>();

        int size = util.randomInt( 7, 15 );
        int min = util.randomInt( 0, 5 );
        int max = util.randomInt( 10, 20 );

        for ( int i = min; i <= max; i++ ) {
            numMap.put( i, 0 );
        }

        for ( int i = 0; i < size; i++ ) {
            int randomNum = util.randomInt( min, max );
            nums.add( i, randomNum );
            int count = numMap.get( randomNum );
            count++;
            numMap.put( randomNum, count );
        }

        // Sort the data
        for ( int i = min; i <= max; i++ ) {
            if ( numMap.get( i ) != 0 ) {
                for ( int j = 0; j < numMap.get( i ); j++ ) {
                    orderedVals.add( i );
                }
            }
        }

        equation = nums.toString().replace( "[", "" ).replace( "]", "" );
        BigDecimal median, q1, q3;
        BigDecimal two = new BigDecimal( "2" );

        if ( ( size % 2 ) == 0 ) {
            // Even number of values
            int half = size / 2;
            median = new BigDecimal( orderedVals.get( half - 1 ) ).add( new BigDecimal( orderedVals.get( half ) ) ).divide( two );

            if ( ( half % 2 ) == 0 ) {
                int quarter = ( half / 2 );
                q1 = new BigDecimal( orderedVals.get( quarter - 1 ) + "" ).add( new BigDecimal( orderedVals.get( quarter ) ) ).divide( two );
                q3 = new BigDecimal( orderedVals.get( quarter + half - 1 ) + "" ).add( new BigDecimal( orderedVals.get( quarter + half ) ) ).divide( two );
            } else {
                int quarter = ( int ) Math.floor( half / 2.0 );
                q1 = new BigDecimal( orderedVals.get( quarter ) );
                q3 = new BigDecimal( orderedVals.get( quarter + half ) );
            }

        } else {
            // Odd number of values
            int half = ( int ) Math.floor( size / 2.0 );
            median = new BigDecimal( orderedVals.get( half ) );

            if ( ( half % 2 ) == 0 ) {
                int quarter = ( half / 2 ) - 1;
                q1 = new BigDecimal( orderedVals.get( quarter ) + "" ).add( new BigDecimal( orderedVals.get( quarter + 1 ) ) ).divide( two );
                q3 = new BigDecimal( orderedVals.get( quarter + half + 1 ) + "" ).add( new BigDecimal( orderedVals.get( quarter + half + 2 ) ) ).divide( two );
            } else {
                int quarter = ( int ) Math.floor( half / 2.0 );
                q1 = new BigDecimal( orderedVals.get( quarter ) );
                q3 = new BigDecimal( orderedVals.get( quarter + half + 1 ) );
            }
        }

        answer = "Min = " + orderedVals.get( 0 ) + "<br>Q1 = " + q1 + "<br>Median = "
                + median + "<br>Q3 = " + q3 + "<br>Max = "
                + orderedVals.get( size - 1 ) + "<br>IQR = Q3-Q1 = " + q3.subtract( q1 );
    }
}
