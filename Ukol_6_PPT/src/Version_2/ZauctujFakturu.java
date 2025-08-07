package Version_2;

import java.time.LocalDate;

/**
 * The ZauctujFakturu class is responsible for generating an invoice (Faktura).
 * It takes the necessary input data, calculates the VAT, and creates a Faktura object.
 */
public class ZauctujFakturu {
    private String cisloDokladu;  // Invoice number (e.g., "FV2023001")
    private LocalDate datumVystaveni;  // Date when the invoice was issued
    private LocalDate datumSplatnosti;  // Due date of the invoice
    private Prijemce prijemce;  // The recipient of the invoice
    private double cenaBezDPH;  // Price without VAT
    private Sazba sazba;  // VAT rate (e.g., 21%)

    /**
     * Constructor to initialize the ZauctujFakturu object with the necessary data.
     *
     * @param cisloDokladu Invoice number
     * @param datumVystaveni Date when the invoice was issued
     * @param datumSplatnosti Due date of the invoice
     * @param prijemce The recipient of the invoice
     * @param cenaBezDPH Price without VAT
     * @param sazba The VAT rate applied to the invoice
     */
    public ZauctujFakturu(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                          Prijemce prijemce, double cenaBezDPH, Sazba sazba) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.prijemce = prijemce;
        this.cenaBezDPH = cenaBezDPH;
        this.sazba = sazba;
    }

    /**
     * Creates a Faktura object by calculating the VAT and total price including VAT.
     * The calculated VAT is added to the price without VAT to form the final price with VAT.
     *
     * @return The Faktura object containing all necessary information, including the recipient and amounts.
     */
    public Faktura vytvorFakturu() {
        // Calculate the VAT based on the VAT rate and the price without VAT
        double dph = cenaBezDPH * sazba.getHodnota() / 100.0;
        double cenaSDPH = cenaBezDPH + dph;

        // Create Castky object to hold the amounts (price without VAT, price with VAT, and VAT rate)
        Castky castky = new Castky(cenaBezDPH, cenaSDPH, sazba);

        // Return a new Faktura object with all the data
        return new Faktura(cisloDokladu, datumVystaveni, datumSplatnosti, prijemce, castky);
    }
}