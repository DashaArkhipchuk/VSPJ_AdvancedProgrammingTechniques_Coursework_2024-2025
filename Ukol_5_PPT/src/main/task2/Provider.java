package main.task2;

import main.task1.KvR;
import main.task1.YKvR;
import java.util.*;

/**
 * Core processor class that handles the quadratic equation calculations.
 * Part of the Business Logic Layer.
 */
public class Provider {

    /** Loader for input data */
    private final VstupDataKvadratickeRovnice loader;

    /** Writer for output data */
    private final VystupDataKvadratickeRovnice writer;

    /**
     * Constructs a Provider with specified data handlers.
     *
     * @param loader Input data loader implementation
     * @param writer Output data writer implementation
     */
    public Provider(VstupDataKvadratickeRovnice loader,
                    VystupDataKvadratickeRovnice writer) {
        this.loader = loader;
        this.writer = writer;
    }

    /**
     * Executes the main processing pipeline:
     * 1. Loads input data
     * 2. Processes each record
     * 3. Writes output data
     */
    public void execute() {
        try {
            Iterable<InputRecord> inputs = loader.load();
            List<OutputRecord> outputs = new ArrayList<>();

            for (InputRecord input : inputs) {
                outputs.add(processInputRecord(input));
            }

            writer.write(outputs);
        } catch (Exception e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    /**
     * Processes a single input record into an output record.
     *
     * @param input The input record to process
     * @return OutputRecord containing calculation results
     */
    private OutputRecord processInputRecord(InputRecord input) {
        KvR rovnice = new KvR(input.a, input.b, input.c);
        List<String> results = new ArrayList<>();

        for (double x : input.xs) {
            double y = YKvR.calc(rovnice, x);
            results.add(x + ":" + y);
        }

        return new OutputRecord(input.a, input.b, input.c, results);
    }
}