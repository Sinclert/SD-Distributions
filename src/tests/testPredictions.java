package tests;

import static org.junit.Assert.*;

import calculations.calculateDistribution;
import calculations.calculatePredictions;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class testPredictions {

    private final double[] DATALIST_NORMAL = {52, 51, 49, 46, 48, 48, 51, 46, 49, 50, 48, 52, 49, 49, 49, 50, 51, 48, 50, 50, 53, 52, 50, 51, 51, 52, 51,
            50, 53, 50, 53, 48, 48, 46, 46, 48, 47, 51, 47, 49, 49, 47, 48, 50, 46, 46, 50, 52, 48, 48, 53, 50, 51, 50, 49, 49, 52, 54, 53, 52, 46, 47, 52,
            49, 49, 48, 52, 51, 49, 49, 51, 50, 49, 52, 52, 52, 47, 50, 49, 49, 49, 48, 52, 49, 50, 49, 49, 48, 52, 47, 51, 54, 50, 52, 50, 52, 47, 49, 53, 48};
    private final double[] DATALIST_EXPONENTIAL = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20, 20, 30, 30, 30, 40, 40, 50, 70, 90, 120, 140};
    private final double[] DATALIST_BINOMIAL = {1, 0, 1, 1 ,1 ,0 ,0 ,1 ,1 ,1, 0 , 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0};
    private final double[] DATALIST_TSTUDENT = {3, 4, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

    /* TestCase Name: testCalculatePredictions_1
     * Input/Output Parameter Analyzed: DATALIST_NORMAL
	 * Input Value Description: Sequence of numbers following a normal distribution
	 * Testing Technique: Black-box
	 * Expected Results: 45.75 AND 53.67
	 */
    @Test
    public void testCalculatePredictions_1() throws IOException {

        double [] result = calculatePredictions.normalPredictions(DATALIST_NORMAL);
        assertEquals(45.75, result[0], 0);
        assertEquals(53.67, result[1], 0);
    }

    /* TestCase Name: testCalculatePredictions_2
     * Input/Output Parameter Analyzed: DATALIST_EXPONENTIAL
	 * Input Value Description: Sequence numbers following a exponential distribution
	 * Testing Technique: Black-box
	 * Expected Results: -42.96 AND 93.58
	 */
    @Test
    public void testCalculatePredictions_2() throws IOException {

        double [] result = calculatePredictions.exponentialPredictions(DATALIST_EXPONENTIAL);
        assertEquals(-42.96, result[0], 0);
        assertEquals(93.58, result[1], 0);
    }

    /* TestCase Name: testCalculatePredictions_3
     * Input/Output Parameter Analyzed: DATALIST_BINOMIAL
	 * Input Value Description: Sequence numbers following a binomial distribution
	 * Testing Technique: Black-box
	 * Expected Results: 0.39 AND 0.8
	 */
    @Test
    public void testCalculatePredictions_3() throws IOException {

        double [] result = calculatePredictions.binomialPredictions(DATALIST_BINOMIAL);
        assertEquals(0.39, result[0], 0);
        assertEquals(0.8, result[1], 0);
    }

    /* TestCase Name: testCalculatePredictions_4
     * Input/Output Parameter Analyzed: DATALIST_TSTUDENT
	 * Input Value Description: Sequence numbers following a t-student distribution
	 * Testing Technique: Black-box
	 * Expected Results: -9 AND 56
	 */
    @Test
    public void testCalculatePredictions_4() throws IOException {

        double [] result = calculatePredictions.studentPredictions(DATALIST_TSTUDENT);
        assertEquals(-9, result[0], 0);
        assertEquals(56, result[1], 0);
    }

    /* TestCase Name: testDoPredictions_1
     * Input/Output Parameter Analyzed: input.txt
	 * Input Value Description: Sequence numbers following a normal distribution
	 * Testing Technique: Black-box
	 * Expected Results: correct creation of the document with normal parameters
	 */
    @Test
    public void testDoPredictions_1() throws IOException, ParseException {

        calculatePredictions.doPredictions("/Users/Sinclert/Desktop/", "Input", ".txt");
    }
}
