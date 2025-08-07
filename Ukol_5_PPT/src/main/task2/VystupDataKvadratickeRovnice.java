package main.task2;

/**
 * Abstract base class for quadratic equation output data writers.
 * Part of the Data Layer.
 */
public abstract class VystupDataKvadratickeRovnice {

    /** Path to the output data file */
    protected String filename;

    /**
     * Constructs a data writer with specified file path.
     *
     * @param filename Path to the output data file
     */
    public VystupDataKvadratickeRovnice(String filename) {
        this.filename = filename;
    }

    /**
     * Abstract method to be implemented by concrete writers.
     *
     * @param data Collection of OutputRecords to write
     * @throws Exception If data writing fails
     */
    public abstract void write(Iterable<OutputRecord> data) throws Exception;
}