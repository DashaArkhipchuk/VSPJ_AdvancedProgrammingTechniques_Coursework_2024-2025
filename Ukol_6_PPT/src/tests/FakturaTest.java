package tests;

import Version_1.Faktura;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Version_1.Faktura} class.
 * Verifies the integrity of constructor logic, getter methods, and edge case handling
 * for the initial implementation of the invoice object.
 */
class FakturaTest {

    // --- Constants for test data ---
    private static final String TEST_CISLO = "FV2023001";
    private static final LocalDate TEST_VYSTAVENI = LocalDate.of(2023, 6, 15);
    private static final LocalDate TEST_SPLATNOST = LocalDate.of(2023, 7, 15);
    private static final String TEST_JMENO = "Jan";
    private static final String TEST_PRIJMENI = "Novák";
    private static final String TEST_ULICE = "Hlavní 123";
    private static final String TEST_MESTO = "Praha";
    private static final String TEST_PSC = "11000";
    private static final String TEST_TELEFON = "+420123456789";
    private static final String TEST_EMAIL = "jan.novak@example.com";
    private static final double TEST_CENA_BEZ_DPH = 1000.0;
    private static final double TEST_CENA_S_DPH = 1210.0;
    private static final String TEST_SAZBA_ZKRATKA = "B";
    private static final double TEST_SAZBA_HODNOTA = 21.0;

    /**
     * Tests the constructor and all getter methods of the {@link Faktura} class.
     * Verifies that:
     * - Each property is correctly stored and retrieved
     * - No mutation is possible (values remain fixed after creation)
     */
    @Test
    void testConstructorAndGetters() {
        Faktura faktura = createTestFaktura();

        assertAll(
                () -> assertEquals(TEST_CISLO, faktura.getCisloDokladu()),
                () -> assertEquals(TEST_VYSTAVENI, faktura.getDatumVystaveni()),
                () -> assertEquals(TEST_SPLATNOST, faktura.getDatumSplatnosti()),
                () -> assertEquals(TEST_JMENO, faktura.getJmeno()),
                () -> assertEquals(TEST_PRIJMENI, faktura.getPrijmeni()),
                () -> assertEquals(TEST_ULICE, faktura.getUlice()),
                () -> assertEquals(TEST_MESTO, faktura.getMesto()),
                () -> assertEquals(TEST_PSC, faktura.getPsc()),
                () -> assertEquals(TEST_TELEFON, faktura.getTelefon()),
                () -> assertEquals(TEST_EMAIL, faktura.getEmail()),
                () -> assertEquals(TEST_CENA_BEZ_DPH, faktura.getCenaBezDPH()),
                () -> assertEquals(TEST_CENA_S_DPH, faktura.getCenaSDPH()),
                () -> assertEquals(TEST_SAZBA_ZKRATKA, faktura.getSazbaZkratka()),
                () -> assertEquals(TEST_SAZBA_HODNOTA, faktura.getSazbaHodnota())
        );
    }

    /**
     * Tests the {@link Faktura#toString()} method.
     * Ensures that:
     * - The output contains all expected values
     * - The string format includes relevant invoice fields
     */
    @Test
    void testToString() {
        Faktura faktura = createTestFaktura();
        String result = faktura.toString();

        assertAll(
                () -> assertTrue(result.contains("Faktura č. " + TEST_CISLO)),
                () -> assertTrue(result.contains(TEST_VYSTAVENI.toString())),
                () -> assertTrue(result.contains(TEST_SPLATNOST.toString())),
                () -> assertTrue(result.contains(TEST_JMENO + " " + TEST_PRIJMENI)),
                () -> assertTrue(result.contains(TEST_ULICE)),
                () -> assertTrue(result.contains(TEST_MESTO)),
                () -> assertTrue(result.contains(TEST_PSC)),
                () -> assertTrue(result.contains(TEST_TELEFON)),
                () -> assertTrue(result.contains(TEST_EMAIL)),
                () -> assertTrue(result.contains(String.valueOf(TEST_CENA_BEZ_DPH))),
                () -> assertTrue(result.contains(String.valueOf(TEST_CENA_S_DPH))),
                () -> assertTrue(result.contains(TEST_SAZBA_ZKRATKA)),
                () -> assertTrue(result.contains(String.valueOf(TEST_SAZBA_HODNOTA)))
        );
    }

    /**
     * Tests edge case scenarios for the {@link Faktura} constructor:
     * - Empty strings and zero values
     * - Maximum value handling
     */
    @Test
    void testEdgeCases() {
        // Empty strings
        Faktura emptyFaktura = new Faktura(
                "", LocalDate.now(), LocalDate.now().plusDays(30),
                "", "", "", "", "",
                "", "", 0.0, 0.0,
                "", 0.0
        );

        assertAll(
                () -> assertEquals("", emptyFaktura.getCisloDokladu()),
                () -> assertEquals("", emptyFaktura.getJmeno()),
                () -> assertEquals(0.0, emptyFaktura.getCenaBezDPH())
        );

        // Max values
        Faktura maxFaktura = new Faktura(
                "A".repeat(100), LocalDate.MIN, LocalDate.MAX,
                "A".repeat(50), "A".repeat(50), "A".repeat(100),
                "A".repeat(50), "A".repeat(10), "A".repeat(20),
                "A".repeat(100), Double.MAX_VALUE, Double.MAX_VALUE,
                "ZZZ", 100.0
        );

        assertAll(
                () -> assertEquals(100, maxFaktura.getCisloDokladu().length()),
                () -> assertEquals(Double.MAX_VALUE, maxFaktura.getCenaSDPH()),
                () -> assertEquals(LocalDate.MAX, maxFaktura.getDatumSplatnosti())
        );
    }

    // Helper method for reusing consistent test data
    private Faktura createTestFaktura() {
        return new Faktura(
                TEST_CISLO, TEST_VYSTAVENI, TEST_SPLATNOST,
                TEST_JMENO, TEST_PRIJMENI, TEST_ULICE, TEST_MESTO, TEST_PSC,
                TEST_TELEFON, TEST_EMAIL, TEST_CENA_BEZ_DPH, TEST_CENA_S_DPH,
                TEST_SAZBA_ZKRATKA, TEST_SAZBA_HODNOTA
        );
    }
}