package tests;

import static org.junit.Assert.*;

import calculations.calculateComplexIndexes;
import org.junit.Test;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class testComplexIndexes {

    private final double[] DATALIST_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final double[] DATALIST_2 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
    private final double[] DATALIST_3 = {10.5, 2.42, 20.78, 5.0, 17.9};
    private final double[] DATALIST_4 = {5, 28.7, 28.7, 28.7, -5};


    /* TestCase Name: testCalculateComplexIndexes_1
     * Input/Output Parameter Analyzed: DATALIST_1
	 * Input Value Description: Sequence of positive numbers
	 * Testing Technique: Black-box
	 * Expected Results: 3.03 AND 9.18
	 */
    @Test
    public void testCalculateComplexIndexes_1() throws IOException {

        double result = calculateComplexIndexes.getStandardDeviation(DATALIST_1);
        assertEquals(3.03, result, 0);
        double result1 = calculateComplexIndexes.getVariance(DATALIST_1);
        assertEquals(9.18, result1, 0);

    }

    /* TestCase Name: testCalculateComplexIndexes_2
     * Input/Output Parameter Analyzed: DATALIST_2
	 * Input Value Description: Sequence of negative numbers
	 * Testing Technique: Black-box
	 * Expected Results: 3.03 AND 9.18
	 */
    @Test
    public void testCalculateComplexIndexes_2() throws IOException {

        double result = calculateComplexIndexes.getStandardDeviation(DATALIST_2);
        assertEquals(3.03, result, 0);
        double result1 = calculateComplexIndexes.getVariance(DATALIST_2);
        assertEquals(9.18, result1, 0);
    }

    /* TestCase Name: testCalculateComplexIndexes_3
	 * Input/Output Parameter Analyzed: DATALIST_3
	 * Input Value Description: Sequence of decimal numbers
	 * Testing Technique: Black-box
	 * Expected Results: 7.95 AND 63.20
	 */
    @Test
    public void testCalculateComplexIndexes_3() throws IOException {

        double result = calculateComplexIndexes.getStandardDeviation(DATALIST_3);
        assertEquals(7.95, result, 0);
        double result1 = calculateComplexIndexes.getVariance(DATALIST_3);
        assertEquals(63.20, result1, 0);
    }

    /* TestCase Name: testCalculateComplexIndexes_4
	 * Input/Output Parameter Analyzed: DATALIST_4
	 * Input Value Description: Sequence of numbers with repetitions
	 * Testing Technique: Black-box
	 * Expected Results: 16.11 AND 259.53
	 */
    @Test
    public void testCalculateComplexIndexes_4() throws IOException {

        double result = calculateComplexIndexes.getStandardDeviation(DATALIST_4);
        assertEquals(16.11, result, 0);
        double result1 = calculateComplexIndexes.getVariance(DATALIST_4);
        assertEquals(259.53, result1, 0);
    }
}