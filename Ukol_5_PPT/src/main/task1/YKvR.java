package main.task1;

/**
 * Provides utility methods for calculating y values of quadratic equations.
 */
public class YKvR {
    /**
     * Calculates y value for a given quadratic equation and x.
     * @param rovnice The quadratic equation
     * @param x The x value to evaluate
     * @return The calculated y value (a*x² + b*x + c)
     */
    public static double calc(KvR rovnice, double x) {
        return rovnice.getA() * x * x + rovnice.getB() * x + rovnice.getC();
    }

    /**
     * Calculates y values for multiple x values.
     * @param rovnice The quadratic equation
     * @param xs Array of x values to evaluate
     * @return Array of corresponding y values
     */
    public static double[] calcY(KvR rovnice, double[] xs) {
        double[] ys = new double[xs.length];
        for (int i = 0; i < xs.length; i++) {
            ys[i] = calc(rovnice, xs[i]);
        }
        return ys;
    }
}
