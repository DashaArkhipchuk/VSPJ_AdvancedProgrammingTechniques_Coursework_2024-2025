package Version_2;

import java.time.LocalDate;

/**
 * Builder class for creating an invoice (Faktura). This class allows for step-by-step construction
 * of an invoice by setting various attributes such as invoice number, issue date, due date, recipient,
 * price without VAT, and VAT rate.
 */
public class FakturaBuilder {
    private String cisloDokladu;
    private LocalDate datumVystaveni = LocalDate.now();
    private LocalDate datumSplatnosti = LocalDate.now().plusDays(14);
    private Prijemce prijemce;
    private double cenaBezDPH;
    private Sazba sazba;

    /**
     * Sets the invoice number.
     *
     * @param cisloDokladu The invoice number (e.g., FV2023001)
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setCisloDokladu(String cisloDokladu) {
        this.cisloDokladu = cisloDokladu;
        return this;
    }

    /**
     * Sets the issue date of the invoice.
     *
     * @param datumVystaveni The date when the invoice is issued
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setDatumVystaveni(LocalDate datumVystaveni) {
        this.datumVystaveni = datumVystaveni;
        return this;
    }

    /**
     * Sets the due date of the invoice.
     *
     * @param datumSplatnosti The due date for payment
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setDatumSplatnosti(LocalDate datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
        return this;
    }

    /**
     * Sets the recipient of the invoice.
     *
     * @param prijemce The recipient of the invoice
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setPrijemce(Prijemce prijemce) {
        this.prijemce = prijemce;
        return this;
    }

    /**
     * Sets the price without VAT.
     *
     * @param cenaBezDPH The price without VAT
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setCenaBezDPH(double cenaBezDPH) {
        this.cenaBezDPH = cenaBezDPH;
        return this;
    }

    /**
     * Sets the VAT rate.
     *
     * @param sazba The VAT rate to be applied
     * @return The current instance of FakturaBuilder
     */
    public FakturaBuilder setSazba(Sazba sazba) {
        this.sazba = sazba;
        return this;
    }

    /**
     * Builds and returns a Faktura object using the set attributes.
     *
     * @return A new Faktura object with the set attributes
     */
    public Faktura build() {
        ZauctujFakturu zauctuj = new ZauctujFakturu(
                cisloDokladu, datumVystaveni, datumSplatnosti, prijemce, cenaBezDPH, sazba
        );
        return zauctuj.vytvorFakturu();
    }
}