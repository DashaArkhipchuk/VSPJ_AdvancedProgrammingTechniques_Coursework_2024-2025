package main.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestYKvR {

    @Test
    void testCalc() {
        KvR equation = new KvR(1, 0, 0); // y = x^2
        assertEquals(4, YKvR.calc(equation, 2));

        equation = new KvR(2, 3, 4); // y = 2x^2 + 3x + 4
        assertEquals(9, YKvR.calc(equation, 1));
    }

    @Test
    void testCalcYWithEmptyArray() {
        KvR equation = new KvR(1, 0, 0);
        double[] result = YKvR.calcY(equation, new double[]{});
        assertEquals(0, result.length);
    }

    @Test
    void testCalcYWithMultipleValues() {
        KvR equation = new KvR(1, 2, 1); // y = x² + 2x + 1
        double[] xs = {0, 1, -1, 2};
        double[] expected = {1, 4, 0, 9};
        assertArrayEquals(expected, YKvR.calcY(equation, xs));
    }

    @Test
    void testCalcWithKvRExInstance() {
        KvR equation = new KvREx(1, 0, 0, 0); // Testing polymorphism
        assertEquals(4, YKvR.calc(equation, 2));
    }
}