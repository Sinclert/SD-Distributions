package calculations;

import java.io.IOException;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class calculateIndexes {

    /**
     * Method to calculate the mean of a double values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getMean(double[] dataSeries) throws IOException {

        double mean = 0;

        // Calculates the sum of the elements of the document.
        for (int i = 0; i < dataSeries.length; i++) {
            mean += dataSeries[i];
        }

        mean = mean / dataSeries.length;
        mean = mean * 100;
        mean = Math.round(mean);
        mean = mean / 100;
        return mean;
    }

    /**
     * Method to calculate the median of a double values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getMedian(double[] dataSeries) throws IOException {

        double median;
        int length = dataSeries.length;

        // Now we order the array. We will use the bubble sorting algorithm.
        double l;
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < (length - i - 1); k++) {
                if (dataSeries[k] > dataSeries[k + 1]) {
                    l = dataSeries[k];
                    dataSeries[k] = dataSeries[k + 1];
                    dataSeries[k + 1] = l;
                }
            }
        }

        // If the matrix has an odd size, it return the element in the middle position
        if (length % 2 == 1) {
            int a = (length / 2);
            median = dataSeries[a];
        }

        // If the matrix has an even size it returns the mean between the two middle elements
        else {
            int a = (length / 2);
            median = dataSeries[a] + dataSeries[a - 1];
            median = median / 2;
        }

        median = median * 100;
        median = Math.round(median);
        median = median / 100;
        return median;
    }

    /**
     * Method to calculate the mode of a double values sequence
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double getMode(double[] dataSeries) throws IOException {

        double mode = 0;

        // Now we order the array. We will use the bubble sorting algorithm
        double l;
        for (int i = 0; i < dataSeries.length; i++) {
            for (int k = 0; k < (dataSeries.length - i - 1); k++) {
                if (dataSeries[k] > dataSeries[k + 1]) {
                    l = dataSeries[k];
                    dataSeries[k] = dataSeries[k + 1];
                    dataSeries[k + 1] = l;
                }
            }
        }

        // Now we calculate the mode
        int cont = 0, count;
        for (int i = 0; i < dataSeries.length; i++) {
            count = 0;
            for (int j = 0; j < dataSeries.length; j++) {
                if (dataSeries[i] == dataSeries[j]) {
                    count++;
                }
            }
            if (cont < count) {
                cont = count;
                mode = dataSeries[i];
            }
        }
        return mode;
    }
}