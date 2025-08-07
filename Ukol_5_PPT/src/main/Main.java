package main;
import main.task2.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        while (true) {
            try {
                Provider p = Builder.create1(inputFile, outputFile);
                p.execute();
                break;
            } catch (Exception e) {
                System.out.println("Execution error: " + e.getMessage());
                System.out.print("Enter input file name: ");
                inputFile = sc.nextLine();
            }
        }
    }
}
