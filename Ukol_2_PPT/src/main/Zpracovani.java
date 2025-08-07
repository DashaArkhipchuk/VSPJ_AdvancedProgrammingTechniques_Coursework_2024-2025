package main;

import java.util.ArrayList;
import java.util.List;

public class Zpracovani {

    /**
     * Checks if a value is within the given interval, excluding the boundaries.
     *
     * @param odkud lower bound (exclusive)
     * @param kam upper bound (exclusive)
     * @param value value to check
     * @return true if value is inside (odkud, kam), false otherwise
     */
    public static boolean interval(int odkud, int kam, int value) {
        return value > odkud && value < kam;
    }

    /**
     * Generates a descending sequence of numbers from 'odkud' to 'kam' (exclusive) with a given step.
     *
     * @param odkud start value (inclusive)
     * @param kam end value (exclusive)
     * @param krok step size (must be positive)
     * @return an array of generated numbers
     * @throws IllegalArgumentException if step is non-positive or if odkud < kam
     */
    public static double[] vzorkySestupně(double odkud, double kam, double krok) {
        if (krok <= 0) {
            throw new IllegalArgumentException("Step must be positive.");
        }
        if (odkud < kam) {
            throw new IllegalArgumentException("Start value must be greater than end value.");
        }

        List<Double> values = new ArrayList<>();
        for (double i = odkud; i > kam; i -= krok) {
            values.add(i);
        }

        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
