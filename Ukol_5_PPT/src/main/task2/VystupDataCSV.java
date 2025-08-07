package main.task2;

import java.io.*;

/**
 * CSV implementation of output data writer.
 * Part of the Data Layer.
 */
public class VystupDataCSV extends VystupDataKvadratickeRovnice {

    /**
     * Constructs a CSV data writer.
     *
     * @param filename Path to the output CSV file
     */
    public VystupDataCSV(String filename) {
        super(filename);
    }

    /**
     * Writes calculation results to CSV file.
     *
     * @param data Collection of OutputRecords to write
     * @throws Exception If file writing fails
     */
    @Override
    public void write(Iterable<OutputRecord> data) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (OutputRecord rec : data) {
            StringBuilder sb = new StringBuilder();
            sb.append(rec.a).append(";")
                    .append(rec.b).append(";")
                    .append(rec.c);

            for (String r : rec.results) {
                sb.append(";").append(r);
            }

            writer.write(sb.toString());
            writer.newLine();
        }

        writer.close();
    }
}