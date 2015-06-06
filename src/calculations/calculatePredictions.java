package calculations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Authors:
 * Sinclert Perez Castaño (NIA: 100317201)
 * Silvia Barbero Rodriguez (NIA: 100316961)
 */

public class calculatePredictions {

    // This value is the Z of 95% in the case of a normal distribution
    private static final double CONFIDENT_Z = 1.96;

    /**
     * Method to calculate the normal prediction intervals
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double[] normalPredictions(double[] dataSeries) throws IOException {

        double[] results = new double[2];
        double mean = calculateIndexes.getMean(dataSeries);
        double standardDeviation = calculateComplexIndexes.getStandardDeviation(dataSeries);

        results[0] = mean - (CONFIDENT_Z * standardDeviation);
        results[1] = mean + (CONFIDENT_Z * standardDeviation);

        // Here we truncate the result to 2 decimal digits
        for (int i = 0; i < results.length; i++) {
            results[i] = results[i] * 100;
            results[i] = Math.round(results[i]);
            results[i] = results[i] / 100;
        }
        return results;
    }

    /**
     * Method to calculate the exponent prediction intervals, the same as normal case
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double[] exponentialPredictions(double[] dataSeries) throws IOException {

        return normalPredictions(dataSeries);
    }

    /**
     * Method to calculate the binomial prediction intervals
     *
     * @param dataSeries
     * @return
     */
    public static double[] binomialPredictions(double[] dataSeries) {

        double[] results = new double[2];
        int[] frequency = new int[2];
        double p, interval;
        frequency[0] = 0;
        frequency[1] = 0;

        double first = dataSeries[0];
        int n = dataSeries.length;

        // Within this loop, the frequency of each of the 2 values of the binomial distribution are computed
        for (int i = 0; i < n; i++) {
            if (dataSeries[i] == first) {
                frequency[0] = frequency[0] + 1;
            }
            else {
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
        interval = (Math.sqrt((p * (1 - p)) / n) * CONFIDENT_Z);

        results[0] = p - interval;
        results[1] = p + interval;

        // Here we truncate the result to 2 decimal digits
        for (int i = 0; i < results.length; i++) {
            results[i] = results[i] * 100;
            results[i] = Math.round(results[i]);
            results[i] = results[i] / 100;
        }
        return results;
    }

    /**
     * Method to calculate the t-student prediction intervals, the same as normal case
     *
     * @param dataSeries
     * @return
     * @throws IOException
     */
    public static double[] studentPredictions(double[] dataSeries) throws IOException {

        return normalPredictions(dataSeries);
    }

    /**
     * Method where the prediction intervals are written in a file following the JSON format
     *
     * @param filePath
     * @param fileName
     * @param fileExtension
     * @throws IOException
     * @throws ParseException
     */
    public static void doPredictions(String filePath, String fileName, String fileExtension) throws IOException, ParseException {

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

        String suffix = "_predictions_";
        String OutputFileLocation = filePath + fileName + suffix + ss + fileExtension;
        FileWriter OutputWriter = new FileWriter(OutputFileLocation);

        double[] intervals = new double[2];
        String distribution = calculateDistribution.checkDistribution(dataSeries)[0];

        switch (distribution) {
            case "Normal":
                intervals = normalPredictions(dataSeries);
                break;

            case "Exponential":
                intervals = exponentialPredictions(dataSeries);
                break;

            case "Binomial":
                intervals = binomialPredictions(dataSeries);
                break;

            case "T-Student":
                intervals = studentPredictions(dataSeries);
                break;
        }

        String predictions = Double.toString(intervals[0]) + ", " + Double.toString(intervals[1]);
        obj.put("Predictions with 95% of confidence", predictions);

        OutputWriter.write(obj.toJSONString());
        OutputWriter.flush();
        OutputWriter.close();
    }
}