package main.task1;

/**
 * Represents a quadratic equation in the form ax² + bx + c.
 * Provides access to coefficients and protected setters for modification.
 */
public class KvR {
    private double a, b, c;

    /**
     * Constructs a quadratic equation with specified coefficients.
     * @param a Coefficient of x² (must not be zero for quadratic equation)
     * @param b Coefficient of x
     * @param c Constant term
     */
    public KvR(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Gets the coefficient of x^2.
     * @return The a coefficient
     */
    public double getA() { return a; }

    /**
     * Gets the coefficient of x.
     * @return The b coefficient
     */
    public double getB() { return b; }

    /**
     * Gets the constant term.
     * @return The c coefficient
     */
    public double getC() { return c; }

    /**
     * Protected setter for the x^2 coefficient.
     * @param a New value for a coefficient
     */
    protected void setA(double a) { this.a = a; }

    /**
     * Protected setter for the x coefficient.
     * @param b New value for b coefficient
     */
    protected void setB(double b) { this.b = b; }

    /**
     * Protected setter for the constant term.
     * @param c New value for c coefficient
     */
    protected void setC(double c) { this.c = c; }
}