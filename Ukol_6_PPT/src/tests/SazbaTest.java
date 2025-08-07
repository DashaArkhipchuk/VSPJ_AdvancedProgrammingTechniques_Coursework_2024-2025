package tests;

import Version_2.Sazba;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Version_2.Sazba} class.
 * Verifies correct creation and string representation of VAT rate objects.
 */
class SazbaTest {

    /**
     * Tests proper instantiation of a {@link Sazba} object.
     * Verifies that:
     * - VAT code and rate value are correctly set and retrievable.
     */
    @Test
    void testSazbaCreation() {
        Sazba sazba = new Sazba("B", 21.0);

        assertAll(
                () -> assertEquals("B", sazba.getZkratka(), "VAT code should match"),
                () -> assertEquals(21.0, sazba.getHodnota(), "VAT rate should match")
        );
    }

    /**
     * Tests the {@link Sazba#toString()} method.
     * Verifies that:
     * - The string format includes both VAT code and percentage.
     */
    @Test
    void testToString() {
        Sazba sazba = new Sazba("B", 21.0);
        assertEquals("B (21.0%)", sazba.toString(), "String format should match expected output");
    }
}