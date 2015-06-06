package tests;

import static org.junit.Assert.*;

import calculations.calculateIndexes;
import org.junit.Test;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class testIndexes {

    private final double[] DATALIST_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final double[] DATALIST_2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
    private final double[] DATALIST_3 = {10.5, 2.42, 20.78, 5.0, 17.9};
    private final double[] DATALIST_4 = {5, 28.7, 28.7, 28.7, -5};


    /* TestCase Name: testCalculateIndexes_1
     * Input/Output Parameter Analyzed: DATALIST_1
	 * Input Value Description: Sequence of positive numbers
	 * Testing Technique: Black-box
	 * Expected Results: 5.5, 5.5 AND 1
	 */
    @Test
    public void testCalculateIndexes_1() throws IOException {

        double result = calculateIndexes.getMean(DATALIST_1);
        assertEquals(5.5, result, 0);

        double result1 = calculateIndexes.getMedian(DATALIST_1);
        assertEquals(5.5, result1, 0);

        double result2 = calculateIndexes.getMode(DATALIST_1);
        assertEquals(1, result2, 0);
    }

    /* TestCase Name: testCalculateIndexes_2
     * Input/Output Parameter Analyzed: DATALIST_2
	 * Input Value Description: Sequence of negative numbers
	 * Testing Technique: Black-box
	 * Expected Results: -5.5, -5.5 AND -10
	 */
    @Test
    public void testCalculateIndexes_2() throws IOException {

        double result = calculateIndexes.getMean(DATALIST_2);
        assertEquals(-5.5, result, 0);

        double result1 = calculateIndexes.getMedian(DATALIST_2);
        assertEquals(-5.5, result1, 0);

        double result2 = calculateIndexes.getMode(DATALIST_2);
        assertEquals(-10, result2, 0);
    }

    /* TestCase Name: testCalculateIndexes_3
     * Input/Output Parameter Analyzed: DATALIST_3
	 * Input Value Description: Sequence of decimal numbers
	 * Testing Technique: Black-box
	 * Expected Results: 11.32, 10.5 AND 2.42
	 */
    @Test
    public void testCalculateIndexes_3() throws IOException {

        double result = calculateIndexes.getMean(DATALIST_3);
        assertEquals(11.32, result, 0);

        double result1 = calculateIndexes.getMedian(DATALIST_3);
        assertEquals(10.5, result1, 0);

        double result2 = calculateIndexes.getMode(DATALIST_3);
        assertEquals(2.42, result2, 0);
    }

    /* TestCase Name: testCalculateIndexes_4
     * Input/Output Parameter Analyzed: DATALIST_4
	 * Input Value Description: Sequence of repeated numbers
	 * Testing Technique: Black-box
	 * Expected Results: 17.22, 18.7 AND 28.7
	 */
    @Test
    public void testCalculateIndexes_4() throws IOException {

        double result = calculateIndexes.getMean(DATALIST_4);
        assertEquals(17.22, result, 0);

        double result1 = calculateIndexes.getMedian(DATALIST_4);
        assertEquals(28.7, result1, 0);

        double result2 = calculateIndexes.getMode(DATALIST_4);
        assertEquals(28.7, result2, 0);
    }
}
