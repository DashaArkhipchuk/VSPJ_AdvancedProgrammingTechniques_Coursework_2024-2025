package tests;

import Main.Dvojbran;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DvojbranTest {

    private static final double EPS = 0.01;

    @Test
    void testStandardCase() {
        double Uin = 12.0, R1 = 4.0, R2 = 8.0;
        double Uout = Dvojbran.vypocetUout(Uin, R1, R2);
        assertEquals(8.0, Uout, EPS);

        double Iout = Dvojbran.vypocetIout(Uout, R2);
        assertEquals(1.0, Iout, EPS);
    }

    @Test
    void testEqualResistances() {
        double Uin = 10.0;
        double R1 = 10.0, R2 = 10.0;
        double Uout = Dvojbran.vypocetUout(Uin, R1, R2);
        assertEquals(5.0, Uout, EPS);

        double Iout = Dvojbran.vypocetIout(Uout, R2);
        assertEquals(0.5, Iout, EPS);
    }

    @Test
    void testZeroInputVoltage() {
        double Uout = Dvojbran.vypocetUout(0.0, 10.0, 5.0);
        assertEquals(0.0, Uout, EPS);
    }

    @Test
    void testZeroResistance() {
        double Uout = Dvojbran.vypocetUout(5.0, 0.0, 5.0); // R1 = 0
        assertEquals(5.0, Uout, EPS);

        double Iout = Dvojbran.vypocetIout(Uout, 5.0);
        assertEquals(1.0, Iout, EPS);
    }

    @Test
    void testHighResistances() {
        double Uout = Dvojbran.vypocetUout(1000.0, 10000.0, 1000.0);
        assertEquals(90.91, Uout, 0.1);

        double Iout = Dvojbran.vypocetIout(Uout, 1000.0);
        assertEquals(0.09, Iout, 0.01);
    }
}
