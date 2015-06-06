package tests;

import static org.junit.Assert.*;

import calculations.calculateSkewness;
import org.junit.Test;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class testSkewness {

    private final double[] DATALIST_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final double[] DATALIST_2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
    private final double[] DATALIST_3 = {10.5, 2.42, 20.78, 5.0, 17.9};
    private final double[] DATALIST_4 = {5, 28.7, 28.7, 28.7, -5};

    /* TestCase Name: testCalculateSkewness_1
     * Input/Output Parameter Analyzed: DATALIST_1
	 * Input Value Description: Sequence of positive numbers
	 * Testing Technique: Black-box
	 * Expected Results: 0
	 */
    @Test
    public void testCalculateSkewness_1() throws IOException {

        double result = calculateSkewness.getSkewness(DATALIST_1);
        assertEquals(0, result, 0);
    }

    /* TestCase Name: testCalculateSkewness_2
     * Input/Output Parameter Analyzed: DATALIST_2
	 * Input Value Description: Sequence of negative numbers
	 * Testing Technique: Black-box
	 * Expected Results: 0
	 */
    @Test
    public void testCalculateSkewness_2() throws IOException {

        double result = calculateSkewness.getSkewness(DATALIST_2);
        assertEquals(0, result, 0);
    }

    /* TestCase Name: testCalculateSkewness_3
     * Input/Output Parameter Analyzed: DATALIST_3
	 * Input Value Description: Sequence of decimal numbers
	 * Testing Technique: Black-box
	 * Expected Results: 0.07
	 */
    @Test
    public void testCalculateSkewness_3() throws IOException {

        double result = calculateSkewness.getSkewness(DATALIST_3);
        assertEquals(0.07, result, 0);
    }

    /* TestCase Name: testCalculateSkewness_4
     * Input/Output Parameter Analyzed: DATALIST_4
	 * Input Value Description: Sequence of repeated numbers
	 * Testing Technique: Black-box
	 * Expected Results: -0.39
	 */
    @Test
    public void testCalculateIndexes_4() throws IOException {

        double result = calculateSkewness.getSkewness(DATALIST_4);
        assertEquals(-0.39, result, 0);
    }
}
