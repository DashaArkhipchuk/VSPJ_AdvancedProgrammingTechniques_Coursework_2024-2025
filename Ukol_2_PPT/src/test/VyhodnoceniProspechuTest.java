package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.VyhodnoceniProspechu;

/**
 * Tests for VyhodnoceniProspechu class
 */
public class VyhodnoceniProspechuTest {
    /**
     * Tests the prumer(int[]) method.
     */
    @Test
    public void testPrumer() {
        VyhodnoceniProspechu vyhodnoceniProspechu = new VyhodnoceniProspechu();
        assertEquals(1.0, vyhodnoceniProspechu.prumer(new int[]{1, 1, 1}));
        assertEquals(2.5, vyhodnoceniProspechu.prumer(new int[]{2, 3}));
        assertEquals(5.0, vyhodnoceniProspechu.prumer(new int[]{5, 5, 5, 5}));
    }

    /**
     * Tests invalid inputs in prumer(int[]).
     */
    @Test
    public void testPrumerInvalidInput() {
        VyhodnoceniProspechu vyhodnoceniProspechu = new VyhodnoceniProspechu();
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prumer(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prumer(null));
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prumer(new int[]{0, 6}));
    }

    /**
     * Tests the prospech(int[]) method.
     */
    @Test
    public void testProspech() {
        VyhodnoceniProspechu vyhodnoceniProspechu = new VyhodnoceniProspechu();
        assertEquals("výborně", vyhodnoceniProspechu.prospech(new int[]{1, 1, 1}));
        assertEquals("chvalitebně", vyhodnoceniProspechu.prospech(new int[]{2, 2, 3}));
        assertEquals("dobře", vyhodnoceniProspechu.prospech(new int[]{3, 3, 3, 3}));
        assertEquals("dostatečně", vyhodnoceniProspechu.prospech(new int[]{4, 4, 4, 4}));
        assertEquals("nedostatečně", vyhodnoceniProspechu.prospech(new int[]{5, 5, 5}));
    }

    /**
     * Tests invalid inputs in prospech(int[]).
     */
    @Test
    public void testProspechInvalidInput() {
        VyhodnoceniProspechu vyhodnoceniProspechu = new VyhodnoceniProspechu();
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prospech(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prospech(null));
        assertThrows(IllegalArgumentException.class, () -> vyhodnoceniProspechu.prospech(new int[]{0, 6}));
    }
}
