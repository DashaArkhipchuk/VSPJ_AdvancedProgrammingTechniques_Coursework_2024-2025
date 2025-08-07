package tests;

import Version_2.Castky;
import Version_2.Faktura;
import Version_2.Prijemce;
import Version_2.Sazba;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Version_2.Faktura} class.
 * Verifies correctness of constructor, getters, and textual representation of invoice.
 */
class FakturaTest2 {

    /**
     * Tests correct construction of {@link Faktura} object using composition.
     * Verifies that:
     * - All properties are correctly assigned
     * - Values from composed objects are correctly retrievable
     */
    @Test
    void testFakturaCreation() {
        Prijemce prijemce = new Prijemce("Jan", "Novák", "Hlavní 123", "Praha", "11000", "123456789", "jan@example.com");
        Castky castky = new Castky(1000.0, 1210.0, new Sazba("B", 21.0));
        LocalDate today = LocalDate.now();

        Faktura faktura = new Faktura("FV2023001", today, today.plusDays(14), prijemce, castky);

        assertAll(
                () -> assertEquals("FV2023001", faktura.getCisloDokladu(), "Document number should match"),
                () -> assertEquals(today, faktura.getDatumVystaveni(), "Issue date should match"),
                () -> assertEquals(today.plusDays(14), faktura.getDatumSplatnosti(), "Due date should be correct"),
                () -> assertEquals(prijemce, faktura.getPrijemce(), "Recipient should match"),
                () -> assertEquals(castky, faktura.getCastky(), "Amount section should match")
        );
    }

    /**
     * Tests the textual representation of {@link Faktura} via the {@code toString()} method.
     * Verifies that:
     * - Output contains key elements (document number, date, recipient, price)
     * - Dates are formatted correctly
     */
    @Test
    void testToString() {
        Prijemce prijemce = new Prijemce("Jan", "Novak", "Hlavni 123", "Praha", "11000", "123456789", "jan@example.com");
        Castky castky = new Castky(1000.0, 1210.0, new Sazba("B", 21.0));
        Faktura faktura = new Faktura("FV2023001", LocalDate.now(), LocalDate.now().plusDays(14), prijemce, castky);

        String result = faktura.toString();

        assertAll(
                () -> assertTrue(result.contains("Faktura č. FV2023001"), "Should contain document number"),
                () -> assertTrue(result.contains("Vystaveno: " + LocalDate.now()), "Should contain today's date"),
                () -> assertTrue(result.contains("Jan Novak"), "Should contain recipient full name"),
                () -> assertTrue(result.contains("Cena bez DPH: 1000.0"), "Should contain base price")
        );
    }
}