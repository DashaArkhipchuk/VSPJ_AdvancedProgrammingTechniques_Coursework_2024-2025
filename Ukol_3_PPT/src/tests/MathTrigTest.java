package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathTrigTest {

    private static final double EPS = 1e-5;

    @Test
    void testBasicAngles() {
        assertEquals(0.0, Math.sin(Math.toRadians(0)), EPS);
        assertEquals(1.0, Math.sin(Math.toRadians(90)), EPS);
        assertEquals(0.0, Math.sin(Math.toRadians(180)), EPS);
        assertEquals(-1.0, Math.sin(Math.toRadians(270)), EPS);

        assertEquals(0.0, Math.tan(Math.toRadians(0)), EPS);
        assertEquals(Math.sqrt(3) / 3, Math.tan(Math.toRadians(30)), EPS);
        assertEquals(1.0, Math.tan(Math.toRadians(45)), EPS);
    }

    @Test
    void testEdgeCases() {
        double tan90 = Math.tan(Math.toRadians(90));
        assertTrue(Math.abs(tan90) > 1e10);
        assertEquals(0.0, Math.sin(Math.toRadians(360)), EPS);
        assertEquals(0.5, Math.sin(Math.toRadians(30)), EPS);
    }

    @Test
    void testNegativeAngles() {
        assertEquals(-0.5, Math.sin(Math.toRadians(-30)), EPS);
        assertEquals(-1.0, Math.sin(Math.toRadians(-90)), EPS);
    }
}
