package tests;

import Version_2.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link ZauctujFakturu} class.
 * Verifies that invoice creation correctly calculates VAT and sets all required fields.
 */
class ZauctujFakturuTest {

    /**
     * Tests the {@link ZauctujFakturu#vytvorFakturu()} method.
     * Verifies:
     * - Correct calculation of total amount including VAT.
     * - Correct VAT rate assignment.
     * - Proper linkage of all invoice components.
     */
    @Test
    void testVytvorFakturu() {
        Prijemce prijemce = new Prijemce(
                "Jan", "Novák", "Hlavní 123", "Praha", "11000", "123456789", "jan@example.com"
        );
        LocalDate today = LocalDate.now();

        ZauctujFakturu zauctuj = new ZauctujFakturu(
                "FV2023001",
                today,
                today.plusDays(14),
                prijemce,
                1000.0,
                new Sazba("B", 21.0)
        );

        Faktura faktura = zauctuj.vytvorFakturu();

        assertAll("Kontrola vytvořené faktury",
                () -> assertEquals(1000.0, faktura.getCastky().getBezDPH(), "Cena bez DPH by měla být 1000.0"),
                () -> assertEquals(1210.0, faktura.getCastky().getSDPH(), "Cena s DPH by měla být 1210.0"),
                () -> assertEquals("B", faktura.getCastky().getSazba().getZkratka(), "Zkratka sazby by měla být 'B'")
        );
    }
}