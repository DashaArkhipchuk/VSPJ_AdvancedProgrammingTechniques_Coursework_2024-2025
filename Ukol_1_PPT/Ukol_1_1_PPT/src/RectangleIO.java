import java.util.Scanner;

/**
 * The RectangleIO class handles user input and output related to Rectangle objects.
 */
public class RectangleIO {

    /**
     * Prompts the user to enter the dimensions of a rectangle and returns
     * a new Rectangle object with those dimensions.
     *
     * @return A new Rectangle object based on user input
     */
    public static Rectangle readRectangle() {
        Scanner scanner = new Scanner(System.in);
        double width = 0;
        double height = 0;

        // Read and validate width
        while (true) {
            System.out.print("Enter the width of the rectangle: ");
            if (scanner.hasNextDouble()) {
                width = scanner.nextDouble();
                if (width > 0) {
                    break;
                } else {
                    System.out.println("Width must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        // Read and validate height
        while (true) {
            System.out.print("Enter the height of the rectangle: ");
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                if (height > 0) {
                    break;
                } else {
                    System.out.println("Height must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        return new Rectangle(width, height);
    }

    /**
     * Displays the calculated area and perimeter of the given rectangle.
     *
     * @param rectangle The Rectangle object whose results will be printed
     */
    public static void printResults(Rectangle rectangle) {
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
}

