/**
 * The Main class contains the main method, which is the entry point of the program.
 * It reads a rectangle from the user and prints its area and perimeter.
 */
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = RectangleIO.readRectangle(); // Get rectangle from user input
        RectangleIO.printResults(rectangle);               // Output calculated area and perimeter
    }
}