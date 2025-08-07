package Test;

import Main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Fibonacci class.
 */
public class FibonacciTest {

    private Fibonacci fibonacci;

    /**
     * Sets up the Fibonacci instance before each test.
     */
    @BeforeEach
    public void setup() {
        fibonacci = new Fibonacci();
    }

    /**
     * Tests the non-recursive Fibonacci calculation method.
     */
    @Test
    public void testCalcNeRecursively() {
        assertEquals(0, fibonacci.calcNonRecursively(0));
        assertEquals(1, fibonacci.calcNonRecursively(1));
        assertEquals(5, fibonacci.calcNonRecursively(5));
        assertEquals(21, fibonacci.calcNonRecursively(8));
    }

    /**
     * Tests the recursive Fibonacci calculation method.
     */
    @Test
    public void testCalcRecursively() {
        assertEquals(0, fibonacci.calcRecursively(0));
        assertEquals(1, fibonacci.calcRecursively(1));
        assertEquals(5, fibonacci.calcRecursively(5));
        assertEquals(21, fibonacci.calcRecursively(8));
    }

    /**
     * Tests the dynamic programming Fibonacci method with memoization table.
     */
    @Test
    public void testCalcRecursivelyTable() {
        fibonacci.Init();
        assertEquals(0, fibonacci.calcRecursivelyTable(0));
        assertEquals(1, fibonacci.calcRecursivelyTable(1));
        assertEquals(5, fibonacci.calcRecursivelyTable(5));
        assertEquals(21, fibonacci.calcRecursivelyTable(8));
    }

    /**
     * Tests the printTable method for visual verification of computed values.
     */
    @Test
    public void testPrintTable() {
        fibonacci.Init();
        fibonacci.calcRecursivelyTable(10); // Fill the table up to the 10th Fibonacci number
        fibonacci.printTable();     // Print the filled table
    }
}