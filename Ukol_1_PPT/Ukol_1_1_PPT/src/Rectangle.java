/**
 * The Rectangle class represents a rectangle defined by its width and height.
 * It provides methods to calculate the area and perimeter of the rectangle.
 */
public class Rectangle {
    private double width;
    private double height;

    /**
     * Constructor to initialize the width and height of the rectangle.
     *
     * @param width  The width of the rectangle
     * @param height The height of the rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return The area (width * height)
     */
    public double calculateArea() {
        return width * height;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     *
     * @return The perimeter (2 * (width + height))
     */
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

