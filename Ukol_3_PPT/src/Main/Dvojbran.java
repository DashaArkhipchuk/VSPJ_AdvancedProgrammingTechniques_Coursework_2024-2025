package Main;

public class Dvojbran {

    /**
     * Computes and prints intermediate and final values for a loaded two-port network.
     *
     * @param Uin Input voltage
     * @param R1  Series resistor
     * @param R2  Load resistor
     */
    public static void vypocetDvojbran(double Uin, double R1, double R2) {
        System.out.println("== Výpočet dvojbranu ==");

        // Mezivýpočty
        double Rtotal = R1 + R2;
        double dividerRatio = R2 / Rtotal;

        System.out.println("R1 + R2 = " + R1 + " + " + R2 + " = " + Rtotal);
        System.out.println("Poměr děliče: R2 / (R1 + R2) = " + dividerRatio);

        // Výstupní napětí
        double Uout = Uin * dividerRatio;
        Uout = Math.round(Uout * 100.0) / 100.0;
        System.out.println("Výstupní napětí (Uout): " + Uout + " V");

        // Výstupní proud
        double Iout = Uout / R2;
        Iout = Math.round(Iout * 100.0) / 100.0;
        System.out.println("Výstupní proud (Iout): " + Iout + " A");
    }

    // Alternativní samostatné metody pro testování:
    public static double vypocetUout(double Uin, double R1, double R2) {
        return Math.round(Uin * R2 / (R1 + R2) * 100.0) / 100.0;
    }

    public static double vypocetIout(double Uout, double R2) {
        return Math.round(Uout / R2 * 100.0) / 100.0;
    }
}
