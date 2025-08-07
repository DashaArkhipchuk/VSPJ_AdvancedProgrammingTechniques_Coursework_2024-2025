package main.task2;

import java.util.List;

/**
 * Data container class representing output results of quadratic equation calculations.
 * Part of the Data Layer.
 */
public class OutputRecord {

    /** Coefficient for x^2 used in calculations */
    public double a;

    /** Coefficient for x used in calculations */
    public double b;

    /** Constant term used in calculations */
    public double c;

    /** List of formatted results (x:y pairs) */
    public List<String> results;

    /**
     * Constructs an OutputRecord with calculation results.
     *
     * @param a       Coefficient for x² used
     * @param b       Coefficient for x used
     * @param c       Constant term used
     * @param results List of formatted "x:y" result strings
     */
    public OutputRecord(double a, double b, double c, List<String> results) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.results = results;
    }
}