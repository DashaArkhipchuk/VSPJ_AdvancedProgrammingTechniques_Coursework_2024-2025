package main.task1;

/**
 * Extends KvR to represent a quadratic equation with a specific x value
 * and pre-calculated y value.
 */
public class KvREx extends KvR {
    private double x, y;

    /**
     * Constructs an extended quadratic equation with pre-calculated y value.
     * @param a Coefficient of x^2
     * @param b Coefficient of x
     * @param c Constant term
     * @param x The x value for which to calculate y
     */
    public KvREx(double a, double b, double c, double x) {
        super(a, b, c);
        this.x = x;
        this.y = calcY();
    }

    /**
     * Gets the x value.
     * @return The x value
     */
    public double getX() { return x; }

    /**
     * Gets the pre-calculated y value.
     * @return The y value (a*x² + b*x + c)
     */
    public double getY() { return y; }

    /**
     * Calculates the y value for the stored x.
     * @return The calculated y value
     */
    public double calcY() {
        return getA() * x * x + getB() * x + getC();
    }
}
