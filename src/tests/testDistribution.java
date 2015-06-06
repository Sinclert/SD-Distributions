package tests;

import static org.junit.Assert.*;

import calculations.calculateComplexIndexes;
import calculations.calculateDistribution;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class testDistribution {

    private final double[] DATALIST_NORMAL = {52, 51, 49, 46, 48, 48, 51, 46, 49, 50, 48, 52, 49, 49, 49, 50, 51, 48, 50, 50, 53, 52, 50, 51, 51, 52, 51,
            50, 53, 50, 53, 48, 48, 46, 46, 48, 47, 51, 47, 49, 49, 47, 48, 50, 46, 46, 50, 52, 48, 48, 53, 50, 51, 50, 49, 49, 52, 54, 53, 52, 46, 47, 52,
            49, 49, 48, 52, 51, 49, 49, 51, 50, 49, 52, 52, 52, 47, 50, 49, 49, 49, 48, 52, 49, 50, 49, 49, 48, 52, 47, 51, 54, 50, 52, 50, 52, 47, 49, 53, 48};
    private final double[] DATALIST_EXPONENTIAL = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20, 20, 30, 30, 30, 40, 40, 50, 70, 90, 120, 140};
    private final double[] DATALIST_BINOMIAL = {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0};
    private final double[] DATALIST_TSTUDENT = {3, 4, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};


    /* TestCase Name: testCalculateComplexIndexes_1
     * Input/Output Parameter Analyzed: DATALIST_NORMAL
     * Input Value Description: Sequence of numbers following a normal distribution
     * Testing Technique: Black-box
     * Expected Results: 49.71 AND 2.02
     */
    @Test
    public void testCalculateDistribution_1() throws IOException {

        String[] result = calculateDistribution.checkDistribution(DATALIST_NORMAL);
        assertEquals("Normal", result[0]);
        assertEquals("49.71", result[1]);
        assertEquals("2.02", result[2]);
    }

    /* TestCase Name: testCalculateDistribution_2
     * Input/Output Parameter Analyzed: DATALIST_EXPONENTIAL
     * Input Value Description: Sequence of numbers following a exponential distribution
     * Testing Technique: Black-box
     * Expected Results: 0.04
     */
    @Test
    public void testCalculateDistribution_2() throws IOException {

        String[] result = calculateDistribution.checkDistribution(DATALIST_EXPONENTIAL);
        assertEquals("Exponential", result[0]);
        assertEquals("0.04", result[1]);
    }

    /* TestCase Name: testCalculateDistribution_3
     * Input/Output Parameter Analyzed: DATALIST_BINOMIAL
     * Input Value Description: Sequence of numbers following a binomial distribution
     * Testing Technique: Black-box
     * Expected Results: 22 AND 0.59
     */
    @Test
    public void testCalculateDistribution_3() throws IOException {

        String[] result = calculateDistribution.checkDistribution(DATALIST_BINOMIAL);
        assertEquals("Binomial", result[0]);
        assertEquals("22", result[1]);
        assertEquals("0.59", result[2]);
    }

    /* TestCase Name: testCalculateDistribution_4
     * Input/Output Parameter Analyzed: DATALIST_TSTUDENT
     * Input Value Description: Sequence of numbers following a t-student distribution
     * Testing Technique: Black-box
     * Expected Results: 11
     */
    @Test
    public void testCalculateDistribution_4() throws IOException {

        String[] result = calculateDistribution.checkDistribution(DATALIST_TSTUDENT);
        assertEquals("T-Student", result[0]);
        assertEquals("11", result[1]);
    }

    /* TestCase Name: testDoDistribution_1
     * Input/Output Parameter Analyzed: Input.txt
     * Input Value Description: Sequence of numbers following a normal distribution
     * Testing Technique: Black-box
     * Expected Results: correct creation of the document with normal parameters
     */
    @Test
    public void testDoDistribution_1() throws IOException, ParseException {

        calculateDistribution.doDistribution("/Users/Sinclert/Desktop/", "Input", ".txt");
    }
}