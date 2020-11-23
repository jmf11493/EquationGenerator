package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.ProbabilitySelection;
import com.mathymath.equationgenerator.Model.Selection.ProportionalReasoningSelection;
import com.mathymath.equationgenerator.Util.Event;
import com.mathymath.equationgenerator.Util.ProbabilityOptions;
import com.mathymath.equationgenerator.Util.Util;
import com.mathymath.equationgenerator.Util.WordProblem.WordProblem;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class ProbabilityTest {

    @Mock
    Util util = new Util();

    @Mock
    ProbabilityOptions probabilityOptions = new ProbabilityOptions();

    Probability probability = new Probability();

    private void setUtilMock( Util utilSpy ) {
        probability.util = utilSpy;
    }

    private void setProbabilityOptionsMock( ProbabilityOptions probabilityOptions ) {
        probability.setProbabilityOptions( probabilityOptions );
    }

    private void testMethod( String equation, String answer ) {
        probability.generate();

        assertEquals( equation, probability.getEquation() );
        assertEquals( answer, probability.getAnswer() );
    }

    @Test
    public void testTheoretical() {
        ProbabilityOptions probabilityOptionsSpy = Mockito.spy( probabilityOptions );

        Event theoreticalOption = new Event(
                "event name",
                "event description",
                "test",
                2
        );

        doReturn( theoreticalOption ).when( probabilityOptionsSpy ).getRandomTheoreticalOption();

        setProbabilityOptionsMock( probabilityOptionsSpy );

        probability.setType( ProbabilitySelection.Equation.THEORETICAL );

        testMethod( "Suppose you event description what is the theoretical probability that you test?", "\\(\\frac{1}{2}\\)" );
    }

    @Test
    public void testExperimental() {
        Util utilSpy = Mockito.spy( util );
        ProbabilityOptions probabilityOptionsSpy = Mockito.spy( probabilityOptions );

        Event theoreticalOption = new Event(
                "Coin",
                "flip a coin",
                new String[]{ "H", "T" }
        );

        when( utilSpy.randomInt( 5, 10 ) ).thenReturn( 7 );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn(
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0 );

        doReturn( theoreticalOption ).when( probabilityOptionsSpy ).getRandomExperimentalOptions();

        setProbabilityOptionsMock( probabilityOptionsSpy );
        setUtilMock( utilSpy );

        probability.setType( ProbabilitySelection.Equation.EXPERIMENTAL );

        testMethod( "Suppose you flip a coin 7 times and the results are shown below.<br><br><table border='1'><tr><td>Coin</td><td>H</td><td>H</td><td>H</td><td>H</td><td>H</td><td>H</td><td>H</td></tr></table><br>What is the experimental probability of getting T?",
                "\\(\\frac{0}{7}= 0\\)" );
    }

    @Test
    public void testTheoreticalCompound() {
        ProbabilityOptions probabilityOptionsSpy = Mockito.spy( probabilityOptions );

        Event theoreticalOption1 = new Event(
                "Coin",
                "flip a coin",
                "get heads",
                2
        );

        Event theoreticalOption2 = new Event(
                "Coin",
                "flip a coin",
                "get heads",
                2
        );

        doReturn( theoreticalOption1, theoreticalOption2 ).when( probabilityOptionsSpy ).getRandomTheoreticalOption();

        setProbabilityOptionsMock( probabilityOptionsSpy );

        probability.setType( ProbabilitySelection.Equation.THEORETICAL_COMPOUND );

        testMethod( "Suppose you flip a coin and flip another coin, what is the theoretical probability that you get heads for the Coin#1 <b>and</b> get heads for the Coin#2", "\\(\\frac{1}{2}\\cdot\\frac{1}{2}=\\frac{1}{4}\\)" );
    }

    @Test
    public void testExperimentalCompound() {
        Util utilSpy = Mockito.spy( util );
        ProbabilityOptions probabilityOptionsSpy = Mockito.spy( probabilityOptions );

        Event experimentalOption1 = new Event(
                "Card",
                "pick a random card",
                new String[]{ "Q", "K" }
        );

        Event experimentalOption2 = new Event(
                "Card",
                "pick a random card",
                new String[]{ "Q", "K" }
        );

        when( utilSpy.randomInt( 5, 10 ) ).thenReturn( 7 );
        when( utilSpy.randomInt( 0, 1 ) ).thenReturn( 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1);

        doReturn( experimentalOption1, experimentalOption2 ).when( probabilityOptionsSpy ).getRandomExperimentalOptions();

        setProbabilityOptionsMock( probabilityOptionsSpy );
        setUtilMock( utilSpy );

        probability.setType( ProbabilitySelection.Equation.EXPERIMENTAL_COMPOUND );

        testMethod( "Suppose you pick a random card and pick another random card 7 times each and the results are shown below.<br><br><table border='1'><tr><td>Card#1</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td></tr><tr><td>Card#2</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td><td>Q</td></tr></table><br>What is the experimental probability of getting K for the Card#1 <b>and</b> K for the Card#2?",
                "\\(\\frac{0}{7}= 0\\)" );
    }
}
