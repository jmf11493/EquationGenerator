package com.mathymath.equationgenerator.Util;

import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblemFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UtilUnitTest {

    @Mock
    private Util util;

    @Mock
    private WordProblem wordProblem = new WordProblemFactory().getRandomProportionalWordProblem();

    // TODO test multiple methods: http://www.computing.dcu.ie/blogs/using-junit4-executing-multiple-tests-different-test-cases

    @Before
    public void initialize() {
        util = new Util();
    }

    @Test
    public void testRemoveDoubleSigns() {
        System.out.println( "----------Test Remove Double Signs----------" );
        String badSigns = "1 -+ 3 +- 5 - + 1 + - 3 - - 2 --4++1+ +7";
        String expected = "1 - 3 - 5 - 1 - 3 + 2 +4+1+7";

        assertEquals( expected, util.removeDoubleSigns( badSigns ) );
    }

    @Test
    public void testRemovePowersOfOne() {
        System.out.println( "----------Test Remove Powers of One----------" );
        String testPowers = "\\(x^1 + x^11 + x^12 + x^1\\)";
        String expected = "\\(x + x^11 + x^12 + x\\)";

        String actual = util.removePowersOfOne( testPowers );

        assertEquals( expected, actual );
    }

    @Test
    public void testRemoveLeadingZero() {
        System.out.println( "----------Test Remove Leading Zero----------" );
        assertEquals( "\\(- 3x -7x +3\\)", util.removeLeadingZero( "\\(0h - 3x + 0y -7x -0y +3\\)" ) );
        assertEquals( "\\(3x -7x +3\\)", util.removeLeadingZero( "\\(0h + 3x + 0y -7x -0y +3\\)" ) );
        assertEquals( "70y", util.removeLeadingZero( "0x+70y-0" ) );
        assertEquals( "1x+2y=0", util.removeLeadingZero( "1x+2y=0" ) );
        assertEquals( "30 x -10", util.removeLeadingZero( "30 x + 0 y -10" ) );
        assertEquals( "- 7", util.removeLeadingZero( "0y - 7" ) );
        assertEquals( "- 7", util.removeLeadingZero( "0 - 7" ) );
        assertEquals( "30", util.removeLeadingZero( "30 - 0" ) );
        assertEquals( "7", util.removeLeadingZero( "0x + 7" ) );
        assertEquals( "\\(- 7\\)", util.removeLeadingZero( "\\(0x + 0 variable - 7\\)" ) );
        assertEquals( "\\(70y\\)", util.removeLeadingZero( "\\(0x+70y-0\\)" ) );
        assertEquals( "\\(1x+2y=0\\)", util.removeLeadingZero( "\\(1x+2y=0\\)" ) );
        assertEquals( "\\(30 x -10\\)", util.removeLeadingZero( "\\(30 x + 0 y -10\\)" ) );
        assertEquals( "\\(- 7\\)", util.removeLeadingZero( "\\(0y - 7\\)" ) );
        assertEquals( "\\(- 7\\)", util.removeLeadingZero( "\\(0 - 7\\)" ) );
        assertEquals( "\\(30\\)", util.removeLeadingZero( "\\(30 - 0\\)" ) );
        assertEquals( "\\(7\\)", util.removeLeadingZero( "\\(0x + 7\\)" ) );
        assertEquals( "\\(0\\)", util.removeLeadingZero( "\\(0\\)" ) );
    }

    @Test
    public void testRemoveTrailingZero() {
        System.out.println( "----------Test Remove Trailing Zero----------" );
        assertEquals( "5 ", util.removeTrailingZero( "5.0 " ) );
        assertEquals( "0.12314 ", util.removeTrailingZero( "0.123140000 " ) );
        assertEquals( "5.675894", util.removeTrailingZero( "5.675894" ) );
        assertEquals( "5.123x + 3.12y + 7.234= 32.3423 ", util.removeTrailingZero( "5.12300x + 3.120y + 7.2340= 32.3423000 " ) );
        assertEquals( "5.1 x + 3", util.removeTrailingZero( "5.10 x + 3" ) );
        assertEquals( "<td>-9</td>", util.removeTrailingZero( "<td>-9.0</td>" ) );
        assertEquals( "-9", util.removeTrailingZero( "-9.0" ) );
    }

    @Test
    public void testCleanEquation() {
        System.out.println( "----------Test Clean Equation----------" );
        assertEquals( "5.123x + 3.12y + 7.234= 32.342 ", util.cleanEquation( "5.12300x + 3.120y + 7.2340= 32.3423000 " ) );
    }

    @Test
    public void testRoundValue() {
        System.out.println( "----------Test Round Value----------" );
        assertEquals( "500.632", util.roundValue( "500.6321" ) );
        assertEquals( "500.63", util.roundValue( "500.6321", 2 ) );
        assertEquals( "500.7", util.roundValue( "500.65", 1 ) );
    }

    @Test
    public void testNonZeroRandomInt() {
        System.out.println( "----------Test Non Zero Random Int----------" );
        Integer random = util.nonZeroRandomInt( -2, 5 );
        System.out.println( "Random: " + random );
        assertNotEquals( 0, random.longValue() );
        assertTrue( random >= -2 );
        assertTrue( random <= 5 );
    }

    @Test
    public void testNonZeroRandom() {
        System.out.println( "----------Test Non Zero Random----------" );
        BigDecimal random = util.nonZeroRandom( -2, 5 );
        System.out.println( "Random: " + random );
        assertTrue( random.compareTo( BigDecimal.ZERO ) != 0 );
        assertTrue( random.compareTo( new BigDecimal( "-2" ) ) >= 0 );
        assertTrue( random.compareTo( new BigDecimal( "5" ) ) <= 0 );
    }

    @Test
    public void testRandomInt() {
        System.out.println( "----------Test Random Int----------" );
        Integer random = util.randomInt( -2, 5 );
        System.out.println( "Random: " + random );
        assertTrue( random >= -2 );
        assertTrue( random <= 5 );
    }

    @Test
    public void testRandom() {
        System.out.println( "----------Test Random Rational----------" );
        util.setRational( true );

        BigDecimal random = util.nonZeroRandom( -2, 5 );
        System.out.println( "Random: " + random );
        assertTrue( random.compareTo( new BigDecimal( "-2" ) ) >= 0 );
        assertTrue( random.compareTo( new BigDecimal( "5" ) ) <= 0 );
        assertTrue( random.toString().split( "\\." )[ 1 ].length() > 0 );

        System.out.println( "----------Test Random Non Rational----------" );
        util.setRational( false );

        random = util.nonZeroRandom( -2, 5 );
        System.out.println( "Random: " + random );
        assertTrue( random.compareTo( new BigDecimal( "-2" ) ) >= 0 );
        assertTrue( random.compareTo( new BigDecimal( "5" ) ) <= 0 );
        assertTrue( random.remainder( BigDecimal.ONE ).compareTo( BigDecimal.ZERO ) == 0 );
    }

    @Test
    public void testRandomDecimal() {
        System.out.println( "----------Test Random Decimal----------" );
        int decimalPlaces = 3;
        BigDecimal random = util.randomDecimal( new BigDecimal( "-2" ), new BigDecimal( "5" ), decimalPlaces );
        System.out.println( "Random: " + random );
        assertTrue( random.compareTo( new BigDecimal( "-2" ) ) >= 0 );
        assertTrue( random.compareTo( new BigDecimal( "5" ) ) <= 0 );
        assertTrue( random.remainder( BigDecimal.ONE ).compareTo( BigDecimal.ZERO ) != 0 );
        String randomString = random.toString();
        int length = randomString.split( "\\." )[ 1 ].length();
        assertEquals( decimalPlaces, length );
    }

    @Test
    public void testGenerateBase() {
        System.out.println( "----------Test Generate Base----------" );
        Util utilSpy = Mockito.spy( util );
        // Test case 0
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 0 ).thenCallRealMethod();
        assertEquals( "x", utilSpy.generateBase( true ) );

        // Test case 1
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 1 ).thenCallRealMethod();
        assertEquals( "y", utilSpy.generateBase( true ) );

        // Test case 2
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 2 ).thenCallRealMethod();
        String base1 = utilSpy.generateBase( true );
        int baseInt1 = Integer.parseInt( base1 );
        System.out.println( "Int base: " + baseInt1 );
        assertTrue( baseInt1 >= 2 );
        assertTrue( baseInt1 <= 10 );

        // Test case 3 positive
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 3 ).thenCallRealMethod();
        String base2 = utilSpy.generateBase( false );
        int baseInt2 = Integer.parseInt( base2 );
        System.out.println( "Int base: " + baseInt2 );
        assertTrue( baseInt2 >= 2 );
        assertTrue( baseInt2 <= 10 );

        // Test case 3 negative
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 3 ).thenCallRealMethod();

        String base3 = utilSpy.generateBase( true );
        System.out.println( "String base: " + base3 );
        base3 = base3.replaceAll( "\\(", "" ).replaceAll( "\\)", "" );
        int baseInt3 = Integer.parseInt( base3 );
        System.out.println( "Int base: " + baseInt3 );
        assertTrue( baseInt3 >= -10 );
        assertTrue( baseInt3 <= -2 );

        // Test case 4
        when( utilSpy.randomInt( Mockito.anyInt(), Mockito.anyInt() ) ).thenReturn( 4 ).thenCallRealMethod();
        assertEquals( "z", utilSpy.generateBase( true ) );
    }

    @Test
    public void testConvertToStandard() {
        System.out.println( "----------Test Convert To Standard----------" );
        assertEquals( "0.0", util.convertToStandard( new BigDecimal( "0.0" ), 0, 1 ) );
        assertEquals( "1.0", util.convertToStandard( new BigDecimal( "1.0" ), 0, 1 ) );
        assertEquals( "314.5", util.convertToStandard( new BigDecimal( "3.145" ), 2, 3 ) );
        assertEquals( "38.77", util.convertToStandard( new BigDecimal( "3.877" ), 1, 3 ) );
        assertEquals( "500000", util.convertToStandard( new BigDecimal( "5.0" ), 5, 1 ) );
        assertEquals( "3.666", util.convertToStandard( new BigDecimal( "36.66" ), -1, 2 ) );
        assertEquals( "0.0003666", util.convertToStandard( new BigDecimal( "36.66" ), -5, 2 ) );
    }

    @Test
    public void testStringEquals() {
        System.out.println( "----------Test String Equals----------" );
        assertEquals( true, util.stringEquals( "1", "1" ) );
        assertEquals( false, util.stringEquals( "1", "e" ) );
        assertEquals( true, util.stringEquals( "e", "e" ) );
        assertEquals( false, util.stringEquals( "e", "a" ) );
        assertEquals( false, util.stringEquals( "1", "2" ) );
    }

    @Test
    public void testGcd() {
        System.out.println( "----------Test GCD----------" );
        assertEquals( 4, util.gcd( 44, 8 ) );
        assertEquals( 4, util.gcd( -44, 8 ) );
        assertEquals( 1, util.gcd( 3, 8 ) );
        assertEquals( 1, util.gcd( 3, -1 ) );
        assertEquals( 1, util.gcd( -3, -1 ) );
    }

    @Test
    public void testGenerateFunction() {
        System.out.println( "----------Test Generate Function----------" );
        Util utilSpy = Mockito.spy( util );

        // Test case 1
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 ).thenReturn( 0 ).thenReturn( 0 ).thenReturn( 1 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 0 );
        when( utilSpy.nonZeroRandomInt( 2, 6 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 3 ).thenReturn( -3 );
        Map< String, String > res0 = utilSpy.generateFunction();
        assertEquals( "-3|x + 3|", res0.get( "functionPrinted" ) );
        assertEquals( "|x|", res0.get( "parent" ) );
        assertEquals( "(-\\infty , \\infty)", res0.get( "domain" ) );
        assertEquals( "(-\\infty , 0]", res0.get( "range" ) );
        assertEquals( "(-\\infty ,-3)", res0.get( "increasing" ) );
        assertEquals( "(-3, \\infty)", res0.get( "decreasing" ) );
        assertEquals( "Reflection over the \\(x\\)-axis;<br> Vertical stretch times 3;<br> Horizontal shift left 3 units;<br>", res0.get( "transforms" ) );

        // Test case 2
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 ).thenReturn( 1 ).thenReturn( 0 ).thenReturn( 1 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 1 );
        when( utilSpy.nonZeroRandomInt( 2, 6 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 3 ).thenReturn( 3 );
        Map< String, String > res4 = utilSpy.generateFunction();
        assertEquals( "-(x + 3)^2", res4.get( "functionPrinted" ) );
        assertEquals( "x^2", res4.get( "parent" ) );
        assertEquals( "(-\\infty , \\infty)", res4.get( "domain" ) );
        assertEquals( "(-\\infty , 0]", res4.get( "range" ) );
        assertEquals( "(-\\infty ,-3)", res4.get( "increasing" ) );
        assertEquals( "(-3, \\infty)", res4.get( "decreasing" ) );
        assertEquals( "Reflection over the \\(x\\)-axis;<br> Horizontal shift left 3 units;<br>", res4.get( "transforms" ) );

        // Test case 3
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 ).thenReturn( 0 ).thenReturn( 0 ).thenReturn( 1 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 2 );
        when( utilSpy.nonZeroRandomInt( 2, 6 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 3 ).thenReturn( -3 );
        Map< String, String > res5 = utilSpy.generateFunction();
        assertEquals( "3(x + 3)^3", res5.get( "functionPrinted" ) );
        assertEquals( "x^3", res5.get( "parent" ) );
        assertEquals( "(-\\infty , \\infty)", res5.get( "domain" ) );
        assertEquals( "(-\\infty , \\infty)", res5.get( "range" ) );
        assertEquals( "(-\\infty , \\infty)", res5.get( "increasing" ) );
        assertEquals( "\\)Never\\(", res5.get( "decreasing" ) );
        assertEquals( " Vertical stretch times 3;<br> Horizontal shift left 3 units;<br>", res5.get( "transforms" ) );

        // Test case 4
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0 ).thenReturn( 1 ).thenReturn( 1 ).thenReturn( 0 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( 2, 6 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( -3 ).thenReturn( 3 );
        Map< String, String > res8 = utilSpy.generateFunction();
        assertEquals( "-\\sqrt{x} -3", res8.get( "functionPrinted" ) );
        assertEquals( "\\sqrt{x}", res8.get( "parent" ) );
        assertEquals( "[0 , \\infty)", res8.get( "domain" ) );
        assertEquals( "(-\\infty , -3]", res8.get( "range" ) );
        assertEquals( "\\)Never\\(", res8.get( "increasing" ) );
        assertEquals( "(0, \\infty)", res8.get( "decreasing" ) );
        assertEquals( "Reflection over the \\(x\\)-axis;<br> Vertical shift down 3 units;<br>", res8.get( "transforms" ) );

        // Test case 5
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 1 ).thenReturn( 0 ).thenReturn( 1 ).thenReturn( 1 );
        when( utilSpy.randomInt( 0, 4 ) ).thenReturn( 4 );
        when( utilSpy.nonZeroRandomInt( 2, 6 ) ).thenReturn( 3 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( 3 ).thenReturn( -3 );
        Map< String, String > res9 = utilSpy.generateFunction();
        assertEquals( "3\\sqrt[3]{x}", res9.get( "functionPrinted" ) );
        assertEquals( "\\sqrt[3]{x}", res9.get( "parent" ) );
        assertEquals( "(-\\infty , \\infty)", res9.get( "domain" ) );
        assertEquals( "(-\\infty , \\infty)", res9.get( "range" ) );
        assertEquals( "(-\\infty , \\infty)", res9.get( "increasing" ) );
        assertEquals( "\\)Never\\(", res9.get( "decreasing" ) );
        assertEquals( " Vertical stretch times 3;<br>", res9.get( "transforms" ) );
    }

    @Test
    public void testGenerateForEval() {
        System.out.println( "----------Test Generate For Eval----------" );
        Util utilSpy = Mockito.spy( util );

        // Test case 1
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 0 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -8 );
        when( utilSpy.randomInt( 1, 10 ) ).thenReturn( 8 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( -2 ).thenReturn( -3 ).thenReturn( 5 ).thenReturn( 4 );

        Map< String, String > res1 = utilSpy.generateForEval();
        assertEquals( "-8", res1.get( "input1" ) );
        assertEquals( "0", res1.get( "input2" ) );
        assertEquals( "-2x^2 -3x + 5", res1.get( "functionPrinted" ) );
        assertEquals( "-99", res1.get( "answer1" ) );
        assertEquals( "5", res1.get( "answer2" ) );

        // Test case 2
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 1 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -8 );
        when( utilSpy.randomInt( 1, 10 ) ).thenReturn( 10 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( -2 ).thenReturn( -3 ).thenReturn( 5 ).thenReturn( 4 );

        Map< String, String > res2 = utilSpy.generateForEval();
        assertEquals( "-8", res2.get( "input1" ) );
        assertEquals( "2", res2.get( "input2" ) );
        assertEquals( "4x^3 -2x^2 -3x + 5", res2.get( "functionPrinted" ) );
        assertEquals( "-2147", res2.get( "answer1" ) );
        assertEquals( "23", res2.get( "answer2" ) );

        // Test case 3
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 2 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( -2 );
        when( utilSpy.randomInt( 1, 10 ) ).thenReturn( 8 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( -2 ).thenReturn( -3 ).thenReturn( 5 ).thenReturn( 4 );

        Map< String, String > res3 = utilSpy.generateForEval();
        assertEquals( "-2", res3.get( "input1" ) );
        assertEquals( "6", res3.get( "input2" ) );
        assertEquals( "-2|x| -3", res3.get( "functionPrinted" ) );
        assertEquals( "-7", res3.get( "answer1" ) );
        assertEquals( "-15", res3.get( "answer2" ) );

        // Test case 4
        when( utilSpy.randomInt( 0, 3 ) ).thenReturn( 3 );
        when( utilSpy.randomInt( -10, 10 ) ).thenReturn( 0 );
        when( utilSpy.randomInt( 1, 10 ) ).thenReturn( 8 );
        when( utilSpy.nonZeroRandomInt( -5, 5 ) ).thenReturn( -2 ).thenReturn( -3 ).thenReturn( 5 ).thenReturn( 4 );

        Map< String, String > res4 = utilSpy.generateForEval();
        assertEquals( "0", res4.get( "input1" ) );
        assertEquals( "8", res4.get( "input2" ) );
        assertEquals( "-2|x + 5| -3", res4.get( "functionPrinted" ) );
        assertEquals( "-13", res4.get( "answer1" ) );
        assertEquals( "-29", res4.get( "answer2" ) );
    }

    @Test
    public void testSimplifyFraction() {
        assertEquals( "\\frac{2}{3}", util.simplifyFraction( 2, 3 ) );
        assertEquals( "\\frac{-1}{3}", util.simplifyFraction( -6, 18 ) );
        assertEquals( "-2", util.simplifyFraction( -6, 3 ) );
    }

    @Test
    public void testSimplifyComplexFraction() {
        System.out.println( "----------Test Simplify Complex Fraction----------" );
        // Test no simplify
        assertEquals( "\\frac{5}{4}", util.removeTrailingZero( util.simplifyComplexFraction( "5", 4 ) ) );
        // Test imaginary simplified
        assertEquals( "-\\frac{33}{7}i", util.removeTrailingZero( util.simplifyComplexFraction( "-33i", 7 ) ) );
        // Test imaginary non fraction
        assertEquals( "3i", util.removeTrailingZero( util.simplifyComplexFraction( "33i", 11 ) ) );
        // Test sqrt no number in front
        assertEquals( "\\frac{\\sqrt{6}}{4}", util.removeTrailingZero( util.simplifyComplexFraction( "\\sqrt{6}", 4 ) ) );
        // Test sqrt number in front
        assertEquals( "\\frac{5\\sqrt{6}}{4}", util.removeTrailingZero( util.simplifyComplexFraction( "5\\sqrt{6}", 4 ) ) );
        // Test sqrt number in front is integer
        assertEquals( "\\frac{2\\sqrt{6}}{3}", util.removeTrailingZero( util.simplifyComplexFraction( "8\\sqrt{6}", 12 ) ) );
        // Test sqrt number in front with no remainder
        assertEquals( "3\\sqrt{6}", util.removeTrailingZero( util.simplifyComplexFraction( "6\\sqrt{6}", 2 ) ) );
        // Test negative
        assertEquals( "-\\frac{5}{4}", util.removeTrailingZero( util.simplifyComplexFraction( "-5", 4 ) ) );
    }

    @Test
    public void testSimplifyRadical() {
        System.out.println( "----------Test Simplify Radical----------" );
        assertEquals( "\\sqrt{1}", util.simplifyRadical( new BigDecimal( "1" ) ) );
        assertEquals( "\\sqrt{2}", util.simplifyRadical( new BigDecimal( "2" ) ) );
        assertEquals( "10.0\\sqrt{1}", util.simplifyRadical( new BigDecimal( "100" ) ) );
        assertEquals( "10.0\\sqrt{1}i", util.simplifyRadical( new BigDecimal( "-100" ) ) );
        assertEquals( "\\sqrt{53}", util.simplifyRadical( new BigDecimal( "53" ) ) );
    }

    @Test
    public void testGenerateProportionalWordProblem() {
        System.out.println( "----------Test Generate Proportional Word Problem----------" );
        WordProblem wordProblemSpy = Mockito.spy( wordProblem );
        when( wordProblemSpy.getMultiplicity() ).thenReturn( 2 );
        when( wordProblemSpy.getUnits() ).thenReturn( new BigDecimal( "3" ) );
        when( wordProblemSpy.getPluralPhrase() ).thenReturn( "hams" );
        when( wordProblemSpy.getSingularPhrase() ).thenReturn( "ham" );

        Util utilSpy = Mockito.spy( util );
        when( utilSpy.randomInt( 1, 5 ) ).thenReturn( 3 );

        // Test case 1
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( 0 );
        Map< String, String > res1 = utilSpy.generateProportionalWordProblem( wordProblemSpy );
        assertEquals( "Suppose \\(2\\) hams cost $\\(6\\). What is the cost of one ham?", res1.get( "problem" ) );
        assertEquals( "$\\(3\\)", res1.get( "answer" ) );

        // Test case 2
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( 1 );
        Map< String, String > res2 = utilSpy.generateProportionalWordProblem( wordProblemSpy );
        assertEquals( "Suppose \\(2\\) hams cost $\\(6\\). What is the cost of \\(5\\) hams?", res2.get( "problem" ) );
        assertEquals( "$\\(15\\)", res2.get( "answer" ) );

        // Test case 3
        when( utilSpy.randomInt( 0, 2 ) ).thenReturn( 2 );
        Map< String, String > res3 = utilSpy.generateProportionalWordProblem( wordProblemSpy );
        assertEquals( "Suppose \\(2\\) hams cost $\\(6\\). If a purchase of hams cost $\\(15\\), how many hams were purchased?", res3.get( "problem" ) );
        assertEquals( "\\(5\\) hams", res3.get( "answer" ) );
    }

}