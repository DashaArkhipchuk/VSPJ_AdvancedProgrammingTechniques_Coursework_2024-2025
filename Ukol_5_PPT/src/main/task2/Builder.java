package main.task2;

/**
 * Factory class for creating Provider instances with different configurations.
 * Part of the Presentation Layer.
 */
public class Builder {

    /**
     * Creates a Provider instance configured with CSV file handlers.
     *
     * @param inputFile  Path to the input CSV file containing quadratic equation parameters
     * @param outputFile Path to the output CSV file for results
     * @return Configured Provider instance ready for execution
     */
    public static Provider create1(String inputFile, String outputFile) {
        return new Provider(
                new VstupDataCSV(inputFile),
                new VystupDataCSV(outputFile)
        );
    }
}