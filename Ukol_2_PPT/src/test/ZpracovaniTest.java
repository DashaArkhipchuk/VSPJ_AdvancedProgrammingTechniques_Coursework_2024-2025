package test;

import main.Zpracovani;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZpracovaniTest {
    /**
     * Tests the interval(int, int, int) method.
     */
    @Test
    public void testInterval() {
        // Inside the interval
        assertTrue(Zpracovani.interval(5, 10, 7), "7 should be inside (5,10)");
        assertTrue(Zpracovani.interval(-10, 0, -5), "-5 should be inside (-10,0)");

        // Outside the interval
        assertFalse(Zpracovani.interval(5, 10, 5), "5 is on the boundary, should return false");
        assertFalse(Zpracovani.interval(5, 10, 10), "10 is on the boundary, should return false");
        assertFalse(Zpracovani.interval(5, 10, 4), "4 is outside, should return false");
        assertFalse(Zpracovani.interval(5, 10, 11), "11 is outside, should return false");

        // Edge cases
        assertFalse(Zpracovani.interval(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE), "MIN_VALUE should be excluded");
        assertFalse(Zpracovani.interval(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE), "MAX_VALUE should be excluded");
        assertTrue(Zpracovani.interval(Integer.MIN_VALUE, Integer.MAX_VALUE, 0), "0 should be inside full int range");
    }

    /**
     * Tests the vzorkySestupně(double, double, double) method.
     */
    @Test
    public void testVzorkySestupne() {
        // Normal case
        assertArrayEquals(new double[]{10.0, 8.0, 6.0, 4.0, 2.0},
                Zpracovani.vzorkySestupně(10, 0, 2),
                0.01);

        // Edge case: Single step
        assertArrayEquals(new double[]{5.0},
                Zpracovani.vzorkySestupně(5, 4, 1),
                0.01);

        // Large step (skips over values)
        assertArrayEquals(new double[]{10.0, 3.0},
                Zpracovani.vzorkySestupně(10, 2, 7),
                0.01);
    }

    /**
     * Tests invalid inputs in vzorkySestupně(double, double, double).
     */
    @Test
    public void testVzorkySestupneInvalidInput() {
        // Negative or zero step
        assertThrows(IllegalArgumentException.class, () -> Zpracovani.vzorkySestupně(10, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> Zpracovani.vzorkySestupně(10, 0, -1));

        // Invalid range (odkud < kam)
        assertThrows(IllegalArgumentException.class, () -> Zpracovani.vzorkySestupně(0, 10, 1));
    }
}
