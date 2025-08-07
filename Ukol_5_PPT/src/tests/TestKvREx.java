package main.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestKvREx {

    @Test
    void testConstructorAndGetters() {
        KvREx equation = new KvREx(1, 2, 3, 4);
        assertAll(
                () -> assertEquals(1, equation.getA()),
                () -> assertEquals(2, equation.getB()),
                () -> assertEquals(3, equation.getC()),
                () -> assertEquals(4, equation.getX())
        );
    }

    @Test
    void testCalcY() {
        KvREx equation = new KvREx(1, 0, 0, 2); // y = x^2
        assertEquals(4, equation.getY());

        equation = new KvREx(2, 3, 4, 1); // y = 2x^2 + 3x + 4
        assertEquals(9, equation.getY());
    }

    @Test
    void testInheritance() {
        KvREx equation = new KvREx(1, 2, 3, 4);
        assertTrue(equation instanceof KvR);
    }
}