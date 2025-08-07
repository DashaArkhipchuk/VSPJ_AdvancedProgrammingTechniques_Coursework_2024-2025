package Version_1;

import java.time.LocalDate;

/**
 * Represents an invoice with all necessary accounting information.
 * Contains details about the recipient, amounts, VAT rate, and issue/due dates.
 */
public class Faktura {
    private final String cisloDokladu;
    private final LocalDate datumVystaveni;
    private final LocalDate datumSplatnosti;
    private final String jmeno;
    private final String prijmeni;
    private final String ulice;
    private final String mesto;
    private final String psc;
    private final String telefon;
    private final String email;
    private final double cenaBezDPH;
    private final double cenaSDPH;
    private final String sazbaZkratka;
    private final double sazbaHodnota;

    /**
     * Constructs a new Invoice with all required details.
     *
     * @param cisloDokladu Document number (e.g., "INV2023001")
     * @param datumVystaveni Issue date of the invoice
     * @param datumSplatnosti Due date of the invoice
     * @param jmeno Recipient's first name
     * @param prijmeni Recipient's last name
     * @param ulice Recipient's street address
     * @param mesto Recipient's city
     * @param psc Recipient's postal code
     * @param telefon Recipient's phone number
     * @param email Recipient's email address
     * @param cenaBezDPH Price without VAT
     * @param cenaSDPH Price including VAT
     * @param sazbaZkratka VAT rate code (e.g., "A", "B", "C")
     * @param sazbaHodnota VAT rate percentage (e.g., 21.0)
     */
    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti,
                   String jmeno, String prijmeni, String ulice, String mesto, String psc,
                   String telefon, String email, double cenaBezDPH, double cenaSDPH,
                   String sazbaZkratka, double sazbaHodnota) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.telefon = telefon;
        this.email = email;
        this.cenaBezDPH = cenaBezDPH;
        this.cenaSDPH = cenaSDPH;
        this.sazbaZkratka = sazbaZkratka;
        this.sazbaHodnota = sazbaHodnota;
    }

    /**
     * Returns a formatted string representation of the invoice.
     * @return Formatted string containing all invoice details
     */
    @Override
    public String toString() {
        return "Faktura č. " + cisloDokladu + "\n" +
                "Vystaveno: " + datumVystaveni + ", Splatnost: " + datumSplatnosti + "\n" +
                "Příjemce: " + jmeno + " " + prijmeni + ", " + ulice + ", " + mesto + ", " + psc + "\n" +
                "Kontakt: " + telefon + ", " + email + "\n" +
                "Cena bez DPH: " + cenaBezDPH + " Kč, Cena s DPH: " + cenaSDPH + " Kč\n" +
                "Sazba DPH: " + sazbaZkratka + " (" + sazbaHodnota + "%)";
    }

    // Getter methods

    /** @return The document number of the invoice */
    public String getCisloDokladu() {
        return cisloDokladu;
    }

    /** @return The issue date of the invoice */
    public LocalDate getDatumVystaveni() {
        return this.datumVystaveni;
    }

    /** @return The due date of the invoice */
    public LocalDate getDatumSplatnosti() {
        return this.datumSplatnosti;
    }

    /** @return The recipient's first name */
    public String getJmeno() {
        return this.jmeno;
    }

    /** @return The recipient's last name */
    public String getPrijmeni() {
        return this.prijmeni;
    }

    /** @return The recipient's street address */
    public String getUlice() {
        return this.ulice;
    }

    /** @return The recipient's city */
    public String getMesto() {
        return this.mesto;
    }

    /** @return The recipient's postal code */
    public String getPsc() {
        return this.psc;
    }

    /** @return The recipient's email address */
    public String getEmail() {
        return this.email;
    }

    /** @return The recipient's phone number */
    public String getTelefon() {
        return this.telefon;
    }

    /** @return The price without VAT */
    public double getCenaBezDPH() {
        return this.cenaBezDPH;
    }

    /** @return The price including VAT */
    public double getCenaSDPH() {
        return this.cenaSDPH;
    }

    /** @return The VAT rate code */
    public String getSazbaZkratka() {
        return this.sazbaZkratka;
    }

    /** @return The VAT rate percentage value */
    public double getSazbaHodnota() {
        return this.sazbaHodnota;
    }
}