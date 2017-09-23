# Distributions

This was my final project of Software Development course, which was based on building a piece of software to classify vectors of data into 4 major types of distributions: <a href="https://en.wikipedia.org/wiki/Binomial_distribution">Binomial</a>, <a href="https://en.wikipedia.org/wiki/Exponential_distribution">Exponential</a>, <a href="https://en.wikipedia.org/wiki/Normal_distribution">Normal</a> or <a href="https://en.wikipedia.org/wiki/Student%27s_t-distribution">T-student</a>.

<img align="center" src="https://upload.wikimedia.org/wikipedia/commons/7/75/Binomial_distribution_pmf.svg">

## What is in the repository?
There are 2 main folders:

<b>1. LIB:</b> containing two libraries needed for the creation of the software:

  * <b>JSON</b>
  * <b>JUNIT</b>
  
<b>2. SRC:</b> containing the main files of the project:

  * <b>Calculations:</b> where all files containning the calculations are stored. The main file is "calculateDistribution" because is the one which classifies the data vector performing calculations specified in the rest of files.<br>
  * <b>Tests:</b> where all the test files are stored. The applied testing procedure was unit testing, a test per file.
  
## Input and output:

### Input:
The input must be a data vector, with each data separated by commas, following the JSON format.

### Output:
The output will be also a JSON file, with the same name as the input one, but containing the suffix "_distribution_<current time>". However, depending on the type of distribution that results:

* <b>Binomial:</b> The output will contain the <b>"n"</b> and <b>"p"</b> values, characteristic values of a binomial distribution.
* <b>Exponential:</b> The output will contain the value <b>"λ"</b>, which defines the distribution.
* <b>Normal:</b> The output will contain the <b>mean</b> and the <b>standard devitation</b> of the distribution.
* <b>T-student:</b> The output will contain the <b>"degrees of freedom"</b>, characteristic value of a T-student distribution.
