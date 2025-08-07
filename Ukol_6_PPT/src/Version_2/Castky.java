package Version_2;

/**
 * Represents amounts on an invoice, including both the price excluding VAT (bezDPH),
 * the price including VAT (sDPH), and the VAT rate (sazba).
 */
public class Castky {
    private double bezDPH;
    private double sDPH;
    private Sazba sazba;

    /**
     * Constructor to create a Castky (amounts) object with the price excluding VAT,
     * the price including VAT, and the VAT rate.
     *
     * @param bezDPH Amount excluding VAT
     * @param sDPH  Amount including VAT
     * @param sazba VAT rate applied to the amounts
     */
    public Castky(double bezDPH, double sDPH, Sazba sazba) {
        this.bezDPH = bezDPH;
        this.sDPH = sDPH;
        this.sazba = sazba;
    }

    /**
     * Returns the amount excluding VAT.
     *
     * @return Amount excluding VAT
     */
    public double getBezDPH() {
        return bezDPH;
    }

    /**
     * Returns the amount including VAT.
     *
     * @return Amount including VAT
     */
    public double getSDPH() {
        return sDPH;
    }

    /**
     * Returns the VAT rate applied to the amounts.
     *
     * @return The VAT rate
     */
    public Sazba getSazba() {
        return sazba;
    }

    /**
     * Returns a string representation of the amounts, including the price excluding VAT,
     * the price including VAT, and the VAT rate.
     *
     * @return A formatted string with amounts and VAT rate
     */
    @Override
    public String toString() {
        return "Cena bez DPH: " + bezDPH + ", s DPH: " + sDPH + ", sazba: " + sazba;
    }
}