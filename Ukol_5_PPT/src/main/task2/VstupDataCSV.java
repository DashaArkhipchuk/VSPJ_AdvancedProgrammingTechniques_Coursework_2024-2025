package main.task2;

import java.io.*;
import java.util.*;

/**
 * CSV implementation of input data loader.
 * Part of the Data Layer.
 */
public class VstupDataCSV extends VstupDataKvadratickeRovnice {

    /**
     * Constructs a CSV data loader.
     *
     * @param filename Path to the input CSV file
     */
    public VstupDataCSV(String filename) {
        super(filename);
    }

    /**
     * Loads and parses data from CSV file.
     *
     * @return Iterable collection of InputRecords
     * @throws Exception If file reading or parsing fails
     */
    @Override
    public Iterable<InputRecord> load() throws Exception {
        List<InputRecord> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length < 4) {
                throw new IllegalArgumentException("Špatný formát řádku: " + line);
            }

            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[1]);
            double c = Double.parseDouble(parts[2]);

            List<Double> xs = new ArrayList<>();
            for (int i = 3; i < parts.length; i++) {
                xs.add(Double.parseDouble(parts[i]));
            }

            records.add(new InputRecord(a, b, c, xs));
        }

        reader.close();
        return records;
    }
}