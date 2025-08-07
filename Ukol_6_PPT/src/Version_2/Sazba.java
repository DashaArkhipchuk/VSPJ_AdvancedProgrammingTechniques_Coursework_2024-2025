package Version_2;

/**
 * The Sazba class represents a VAT rate.
 * It contains a short code for the rate (e.g., "A", "B") and the actual percentage value of the VAT rate.
 */
public class Sazba {
    private String zkratka;   // Short code for the VAT rate (e.g., "A", "B")
    private double hodnota;   // Percentage value of the VAT rate (e.g., 21.0)

    /**
     * Constructor to initialize the VAT rate with its short code and percentage value.
     *
     * @param zkratka Short code for the VAT rate
     * @param hodnota Percentage value of the VAT rate
     */
    public Sazba(String zkratka, double hodnota) {
        this.zkratka = zkratka;
        this.hodnota = hodnota;
    }

    /**
     * Gets the short code for the VAT rate.
     *
     * @return The short code for the VAT rate
     */
    public String getZkratka() {
        return zkratka;
    }

    /**
     * Gets the percentage value of the VAT rate.
     *
     * @return The percentage value of the VAT rate
     */
    public double getHodnota() {
        return hodnota;
    }

    /**
     * Returns a string representation of the VAT rate, including its short code and percentage value.
     *
     * @return A formatted string representing the VAT rate (e.g., "A (21.0%)")
     */
    @Override
    public String toString() {
        return zkratka + " (" + hodnota + "%)";
    }
}