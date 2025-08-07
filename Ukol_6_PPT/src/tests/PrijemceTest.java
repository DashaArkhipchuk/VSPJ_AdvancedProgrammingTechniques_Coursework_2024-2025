package tests;

import Version_2.Prijemce;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Version_2.Prijemce} class.
 * Verifies that object creation and string representation work as expected.
 */
class PrijemceTest {

    /**
     * Tests correct instantiation of {@link Prijemce} object.
     * Verifies that:
     * - All fields are initialized and accessible via getters.
     */
    @Test
    void testPrijemceCreation() {
        Prijemce prijemce = new Prijemce(
                "Jan",
                "Novák",
                "Hlavní 123",
                "Praha",
                "11000",
                "123456789",
                "jan@example.com"
        );

        assertAll(
                () -> assertEquals("Jan", prijemce.getJmeno(), "First name should match"),
                () -> assertEquals("Novák", prijemce.getPrijmeni(), "Last name should match"),
                () -> assertEquals("Hlavní 123", prijemce.getUlice(), "Street should match"),
                () -> assertEquals("jan@example.com", prijemce.getEmail(), "Email should match")
        );
    }

    /**
     * Tests the output of {@link Prijemce#toString()} method.
     * Verifies that:
     * - String contains full name
     * - Address and contact info are included
     */
    @Test
    void testToString() {
        Prijemce prijemce = new Prijemce(
                "Jan",
                "Novák",
                "Hlavní 123",
                "Praha",
                "11000",
                "123456789",
                "jan@example.com"
        );
        String result = prijemce.toString();

        assertAll(
                () -> assertTrue(result.contains("Jan Novák"), "Should contain full name"),
                () -> assertTrue(result.contains("Hlavní 123"), "Should contain street"),
                () -> assertTrue(result.contains("123456789"), "Should contain contact number")
        );
    }
}