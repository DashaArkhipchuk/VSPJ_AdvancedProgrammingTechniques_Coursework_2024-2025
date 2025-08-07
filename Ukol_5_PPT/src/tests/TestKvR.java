package tests;

import main.task1.KvR;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class TestKvR {

    // Test-specific subclass with package-private access
    static class TestableKvR extends KvR {
        public TestableKvR(double a, double b, double c) {
            super(a, b, c);
        }

        // Expose protected methods for testing
        public void testSetA(double a) {
            setA(a);
        }

        public void testSetB(double b) {
            setB(b);
        }

        public void testSetC(double c) {
            setC(c);
        }
    }

    @Test
    void testProtectedSettersViaSubclass() {
        TestableKvR equation = new TestableKvR(1, 1, 1);
        equation.testSetA(2);
        equation.testSetB(3);
        equation.testSetC(4);

        assertAll(
                () -> assertEquals(2, equation.getA()),
                () -> assertEquals(3, equation.getB()),
                () -> assertEquals(4, equation.getC())
        );
    }

    @Test
    void testConstructorAndGetters() {
        KvR equation = new KvR(2, 3, 5);
        assertAll(
                () -> assertEquals(2, equation.getA()),
                () -> assertEquals(3, equation.getB()),
                () -> assertEquals(5, equation.getC())
        );
    }
}