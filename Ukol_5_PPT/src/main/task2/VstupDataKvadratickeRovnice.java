package main.task2;

/**
 * Abstract base class for quadratic equation input data loaders.
 * Part of the Data Layer.
 */
public abstract class VstupDataKvadratickeRovnice {

    /** Path to the input data file */
    protected String filename;

    /**
     * Constructs a data loader with specified file path.
     *
     * @param filename Path to the input data file
     */
    public VstupDataKvadratickeRovnice(String filename) {
        this.filename = filename;
    }

    /**
     * Abstract method to be implemented by concrete loaders.
     *
     * @return Iterable collection of InputRecords
     * @throws Exception If data loading fails
     */
    public abstract Iterable<InputRecord> load() throws Exception;
}