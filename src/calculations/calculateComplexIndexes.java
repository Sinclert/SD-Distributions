package calculations;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class calculateComplexIndexes {

    /**
     * Method to calculate the standard deviation of a double values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getStandardDeviation(double[] dataSeries) throws IOException {

        double average = calculateIndexes.getMean(dataSeries);
        double factor, result;
        double addition = 0.0;

        for (int i = 0; i < dataSeries.length; i++) {
            addition += Math.pow((dataSeries[i] - average), 2);
        }

        factor = (1.0 / (dataSeries.length - 1));
        addition = addition * factor;

        result = Math.sqrt(addition);
        result = result * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }

    /**
     * Method to calculate the variance of a double values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getVariance(double[] dataSeries) throws IOException {

        double result = Math.pow(getStandardDeviation(dataSeries), 2);
        result = result * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }
}