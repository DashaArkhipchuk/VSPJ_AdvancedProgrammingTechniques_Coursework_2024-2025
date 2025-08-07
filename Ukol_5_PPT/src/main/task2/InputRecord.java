package main.task2;

import java.util.List;

/**
 * Data container class representing input records for quadratic equations.
 * Part of the Data Layer.
 */
public class InputRecord {

    /** Coefficient for x^2 in the quadratic equation */
    public double a;

    /** Coefficient for x in the quadratic equation */
    public double b;

    /** Constant term in the quadratic equation */
    public double c;

    /** List of x values to evaluate the equation for */
    public List<Double> xs;

    /**
     * Constructs an InputRecord with specified parameters.
     *
     * @param a  Coefficient for x^2
     * @param b  Coefficient for x
     * @param c  Constant term
     * @param xs List of x values to evaluate
     */
    public InputRecord(double a, double b, double c, List<Double> xs) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.xs = xs;
    }
}