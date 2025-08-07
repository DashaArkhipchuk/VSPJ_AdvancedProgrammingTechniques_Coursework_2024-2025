package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathSqrtTest {

    @Test
    void testPositiveValues() {
        assertEquals(10.0, Math.sqrt(100.0), 1e-10);
        assertEquals(1.4142, Math.sqrt(2.0), 1e-4);
        assertEquals(0.5, Math.sqrt(0.25), 1e-10);
    }

    @Test
    void testZero() {
        assertEquals(0.0, Math.sqrt(0.0), 1e-10);
    }

    @Test
    void testNegativeValue() {
        assertTrue(Double.isNaN(Math.sqrt(-1.0)));
        assertTrue(Double.isNaN(Math.sqrt(-999.9)));
    }

    @Test
    void testInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, Math.sqrt(Double.POSITIVE_INFINITY));
        assertTrue(Double.isNaN(Math.sqrt(Double.NEGATIVE_INFINITY)));
    }

    @Test
    void testNaNInput() {
        assertTrue(Double.isNaN(Math.sqrt(Double.NaN)));
    }
}
