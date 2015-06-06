package calculations;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class calculateSkewness {

    /**
     * Method to calculate the skewness of a float values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getSkewness(double[] dataSeries) throws IOException {

        double addition = 0.0;
        double factor = calculateComplexIndexes.getStandardDeviation(dataSeries);
        double average = calculateIndexes.getMean(dataSeries);

        for (int i = 0; i < dataSeries.length; i++) {
            addition += Math.pow(dataSeries[i] - average, 3);
        }

        factor = Math.pow(factor, 3);
        addition = addition / (factor * dataSeries.length);
        addition = addition * 100;
        addition = Math.round(addition);
        addition = addition / 100;
        return addition;
    }
}