package calculations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class calculateDistribution {

    /**
     * Method to verify the type of distribution followed by the data series
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static String[] checkDistribution(double[] dataSeries) throws IOException {

        String results[];
        int n = dataSeries.length;
        double p = 0;
        double lambda;
        double mean = calculateIndexes.getMean(dataSeries);
        double median = calculateIndexes.getMedian(dataSeries);
        double mode = calculateIndexes.getMode(dataSeries);
        double standardDeviation = calculateComplexIndexes.getStandardDeviation(dataSeries);
        double variance = calculateComplexIndexes.getVariance(dataSeries);
        double skewness = calculateSkewness.getSkewness(dataSeries);
        double kurtosis = calculateKurtosis.getKurtosis(dataSeries);


        // Here the array is ordered, using bubble sorting algorithm
        double l;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < (n - i - 1); k++) {
                if (dataSeries[k] > dataSeries[k + 1]) {
                    l = dataSeries[k];
                    dataSeries[k] = dataSeries[k + 1];
                    dataSeries[k + 1] = l;
                }
            }
        }

        // Here we calculate how many different values there are in the array
        int diffValues = 1;
        double first = dataSeries[0];
        double second = 0;
        for (int i = 0; i < n; i++) {
            if (dataSeries[i] != first) {
                second = dataSeries[i];
                diffValues++;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            if (dataSeries[i] != first && dataSeries[i] != second) {
                diffValues++;
                break;
            }
        }

        // In case of being a binomial, p is computed
        int[] frequency = new int[2];
        if (diffValues == 2) {

            // Within this loop, the frequency of each of the 2 values of the binomial distribution are computed
            for (int i = 0; i < n; i++) {
                if (dataSeries[i] == first) {
                    frequency[0] = frequency[0] + 1;
                } else {
                    frequency[1] = frequency[1] + 1;
                }
            }

            int auxiliary;
            // The greater of the 2 frequencies is considered as the numerator to calculate "p"
            if (frequency[0] > frequency[1]) {
                auxiliary = frequency[0];
            }
            else {
                auxiliary = frequency[1];
            }

            p = ((double) auxiliary / (double) n);
            p = p * 100;
            p = Math.round(p);
            p = p / 100;
        }


        /* DISTRIBUTION CHECKING */

        // Binomial case
        if (diffValues == 2) {
            results = new String[3];
            results[0] = "Binomial";
            results[1] = String.valueOf(n);
            results[2] = String.valueOf(p);
            return results;
        }

        // Normal case
        else if (Math.abs(mean - median) < 1.2 && Math.abs(median - mode) < 1.2) {
            results = new String[3];
            results[0] = "Normal";
            results[1] = String.valueOf(mean);
            results[2] = String.valueOf(standardDeviation);
            return results;
        }

        // Exponential case
        else if (skewness > 1.8 && skewness < 2.2 && kurtosis > 5.5 && kurtosis < 6.5) {
            results = new String[2];
            lambda = 1 / mean;
            lambda = lambda * 100;
            lambda = Math.round(lambda);
            lambda = lambda / 100;

            results[0] = "Exponential";
            results[1] = String.valueOf(lambda);
            return results;
        }

        // T-Student case
        else {
            results = new String[2];
            results[0] = "T-Student";
            results[1] = String.valueOf(n - 1);
            return results;
        }
    }

    /**
     * Method where the results are written in a file following the JSON format
     *
     * @param filePath
     * @param fileName
     * @param fileExtension
     * @throws IOException
     * @throws ParseException
     */
    public static void doDistribution(String filePath, String fileName, String fileExtension) throws IOException, ParseException {

        // Read the input file location.
        String inputFileLocation = filePath + fileName + fileExtension;

        // Opening the file
        FileReader inputReader = new FileReader(inputFileLocation);

        // Construct JSON Array
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(inputReader);
        JSONArray jArray = (JSONArray) jsonObject.get("dataSeries");


        double[] dataSeries = new double[jArray.size()];
        Long auxiliary;

        // Loop to get each element of the document into the dataSeries array
        for (int i = 0; i < jArray.size(); i++) {
            auxiliary = new Long((Long) jArray.get(i));
            dataSeries[i] = auxiliary.doubleValue();
        }

        JSONObject obj = new JSONObject();

        // To put the date in the output file name:
        Date date1 = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh;mm;ss");
        String ss = dateFormat.format(date1).toString();

        String suffix = "_distribution_";
        String OutputFileLocation = filePath + fileName + suffix + ss + fileExtension;
        FileWriter OutputWriter = new FileWriter(OutputFileLocation);

        String[] results = checkDistribution(dataSeries);
        obj.put("Distribution", results[0]);

        switch (results[0]) {
            case "Normal":
                obj.put("Mean", results[1]);
                obj.put("Standard deviation", results[2]);
                break;

            case "Binomial":
                obj.put("n", results[1]);
                obj.put("p", results[2]);
                break;

            case "Exponential":
                obj.put("Lambda", results[1]);
                break;

            case "T-Student":
                obj.put("Degrees of freedom", results[1]);
                break;
        }

        OutputWriter.write(obj.toJSONString());
        OutputWriter.flush();
        OutputWriter.close();
    }
}