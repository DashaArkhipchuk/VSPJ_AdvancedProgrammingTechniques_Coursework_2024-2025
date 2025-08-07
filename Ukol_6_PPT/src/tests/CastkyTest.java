package tests;

import Version_2.Castky;
import Version_2.Sazba;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Version_2.Castky} class.
 * Verifies the functionality of the financial amounts container including:
 * <ul>
 *   <li>Proper storage and retrieval of amounts (with and without VAT)</li>
 *   <li>Correct association with VAT rate information</li>
 *   <li>Accurate string representation</li>
 * </ul>
 */
class CastkyTest {

    /**
     * Tests the constructor and getter methods of {@link Version_2.Castky}.
     * Verifies that:
     * <ul>
     *   <li>The amount without VAT is stored and retrieved correctly</li>
     *   <li>The amount with VAT is stored and retrieved correctly</li>
     *   <li>The VAT rate information is properly associated</li>
     * </ul>
     *
     * @see Version_2.Castky#Castky(double, double, Version_2.Sazba)
     * @see Version_2.Castky#getBezDPH()
     * @see Version_2.Castky#getSDPH()
     * @see Version_2.Castky#getSazba()
     */
    @Test
    void testCastkyCreation() {
        // Setup test data
        Sazba sazba = new Sazba("B", 21.0);
        double expectedBaseAmount = 1000.0;
        double expectedAmountWithVat = 1210.0;

        // Create test instance
        Castky castky = new Castky(expectedBaseAmount, expectedAmountWithVat, sazba);

        // Verify all properties
        assertAll(
                () -> assertEquals(expectedBaseAmount, castky.getBezDPH(),
                        "Base amount (without VAT) should match the constructor argument"),
                () -> assertEquals(expectedAmountWithVat, castky.getSDPH(),
                        "Amount with VAT should match the constructor argument"),
                () -> assertEquals(sazba, castky.getSazba(),
                        "VAT rate object should match the constructor argument")
        );
    }

    /**
     * Tests the {@link Version_2.Castky#toString()} method.
     * Verifies that the string representation:
     * <ul>
     *   <li>Contains the amount without VAT</li>
     *   <li>Contains the amount with VAT</li>
     *   <li>Contains the VAT rate information</li>
     *   <li>Formats all information correctly</li>
     * </ul>
     *
     * @see Version_2.Castky#toString()
     */
    @Test
    void testToString() {
        // Setup test data
        double baseAmount = 1000.0;
        double amountWithVat = 1210.0;
        String vatCode = "B";
        double vatRate = 21.0;

        // Create test instance
        Castky castky = new Castky(baseAmount, amountWithVat, new Sazba(vatCode, vatRate));
        String result = castky.toString();

        // Verify string representation
        assertAll(
                () -> assertTrue(result.contains("Cena bez DPH: " + baseAmount),
                        "String representation should contain the base amount"),
                () -> assertTrue(result.contains("s DPH: " + amountWithVat),
                        "String representation should contain the amount with VAT"),
                () -> assertTrue(result.contains(vatCode + " (" + vatRate + "%)"),
                        "String representation should contain the VAT rate information")
        );
    }
}