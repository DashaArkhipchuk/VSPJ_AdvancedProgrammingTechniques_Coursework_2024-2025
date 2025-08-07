package tests;

import Version_2.Faktura;
import Version_2.FakturaBuilder;
import Version_2.Prijemce;
import Version_2.Sazba;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Version_2.FakturaBuilder} class.
 * Verifies the builder pattern implementation for creating {@link Version_2.Faktura} instances.
 */
class FakturaBuilderTest {

    /**
     * Tests the complete builder workflow with all parameters explicitly set.
     * Verifies that:
     * - The builder correctly sets all invoice properties
     * - The built invoice contains all specified values
     * - The VAT calculation is correct
     */
    @Test
    void testBuilderCreatesValidFaktura() {
        // Create test recipient
        Prijemce prijemce = new Prijemce(
                "Jan", "Novák", "Hlavní 123",
                "Praha", "11000", "123456789",
                "jan@example.com"
        );

        // Set test dates
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(14);

        // Build invoice using the builder
        Faktura faktura = new FakturaBuilder()
                .setCisloDokladu("FV2023001")       // Set document number
                .setDatumVystaveni(today)           // Set issue date
                .setDatumSplatnosti(dueDate)        // Set due date
                .setPrijemce(prijemce)              // Set recipient
                .setCenaBezDPH(1000.0)              // Set base price
                .setSazba(new Sazba("B", 21.0))     // Set VAT rate
                .build();                           // Create the invoice

        // Verify all invoice properties
        assertAll(
                // Document identification
                () -> assertEquals("FV2023001", faktura.getCisloDokladu(),
                        "Document number should match builder input"),

                // Dates verification
                () -> assertEquals(today, faktura.getDatumVystaveni(),
                        "Issue date should match builder input"),
                () -> assertEquals(dueDate, faktura.getDatumSplatnosti(),
                        "Due date should match builder input"),

                // Recipient verification
                () -> assertEquals(prijemce, faktura.getPrijemce(),
                        "Recipient should match builder input"),

                // Financial verification (21% of 1000 = 210 → 1210 total)
                () -> assertEquals(1210.0, faktura.getCastky().getSDPH(), 0.001,
                        "Price with VAT should be correctly calculated")
        );
    }

    /**
     * Tests the builder with default values for dates.
     * Verifies that:
     * - Default issue date is today
     * - Default due date is 14 days after issue
     * - Explicitly set values are properly maintained
     */
    @Test
    void testBuilderWithDefaults() {
        // Create test recipient
        Prijemce prijemce = new Prijemce(
                "Jan", "Novák", "Hlavní 123",
                "Praha", "11000", "123456789",
                "jan@example.com"
        );

        // Build invoice using only mandatory fields
        Faktura faktura = new FakturaBuilder()
                .setCisloDokladu("FV2023001")       // Required: document number
                .setPrijemce(prijemce)              // Required: recipient
                .setCenaBezDPH(1000.0)              // Required: base price
                .setSazba(new Sazba("B", 21.0))     // Required: VAT rate
                .build();                           // Create invoice with defaults

        // Verify default dates are set correctly
        assertAll(
                () -> assertEquals(LocalDate.now(), faktura.getDatumVystaveni(),
                        "Default issue date should be today"),
                () -> assertEquals(LocalDate.now().plusDays(14), faktura.getDatumSplatnosti(),
                        "Default due date should be 14 days from today")
        );
    }
}