package Version_2;

import java.time.LocalDate;

/**
 * Represents an invoice (faktura) with essential details such as the invoice number,
 * the issue and due dates, the recipient's details (Prijemce), and the amounts (Castky).
 */
public class Faktura {
    private String cisloDokladu;
    private LocalDate datumVystaveni;
    private LocalDate datumSplatnosti;
    private Prijemce prijemce;
    private Castky castky;

    /**
     * Constructor to create an invoice object with the invoice number, issue date,
     * due date, recipient, and amounts (including VAT).
     *
     * @param cisloDokladu The invoice number (e.g., FV2023001)
     * @param datumVystaveni The date when the invoice was issued
     * @param datumSplatnosti The due date for payment of the invoice
     * @param prijemce The recipient (Prijemce) of the invoice
     * @param castky The amounts related to the invoice, including prices with and without VAT
     */
    public Faktura(String cisloDokladu, LocalDate datumVystaveni, LocalDate datumSplatnosti, Prijemce prijemce, Castky castky) {
        this.cisloDokladu = cisloDokladu;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.prijemce = prijemce;
        this.castky = castky;
    }

    /**
     * Returns the recipient (Prijemce) of the invoice.
     *
     * @return The recipient of the invoice
     */
    public Prijemce getPrijemce() {
        return prijemce;
    }

    /**
     * Returns the amounts related to the invoice (Castky).
     *
     * @return The amounts including price with and without VAT
     */
    public Castky getCastky() {
        return castky;
    }

    /**
     * Returns a string representation of the invoice, including its number, issue and due dates,
     * recipient details, and amounts.
     *
     * @return A formatted string with the invoice's details
     */
    @Override
    public String toString() {
        return "Faktura č. " + cisloDokladu + "\n" +
                "Vystaveno: " + datumVystaveni + ", Splatnost: " + datumSplatnosti + "\n" +
                "Příjemce: " + prijemce + "\n" +
                "Částky: " + castky;
    }

    /**
     * Returns the invoice number.
     *
     * @return The invoice number
     */
    public String getCisloDokladu() {
        return this.cisloDokladu;
    }

    /**
     * Returns the issue date of the invoice.
     *
     * @return The issue date
     */
    public LocalDate getDatumVystaveni() {
        return this.datumVystaveni;
    }

    /**
     * Returns the due date of the invoice.
     *
     * @return The due date
     */
    public LocalDate getDatumSplatnosti() {
        return this.datumSplatnosti;
    }
}