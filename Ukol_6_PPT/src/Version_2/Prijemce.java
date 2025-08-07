package Version_2;

/**
 * The Prijemce class represents the recipient of an invoice.
 * It holds personal and contact details such as first name, last name, address, phone number, and email.
 */
public class Prijemce {
    private String jmeno;      // First name of the recipient
    private String prijmeni;   // Last name of the recipient
    private String ulice;      // Street address of the recipient
    private String mesto;      // City of the recipient
    private String psc;        // Postal code of the recipient
    private String telefon;    // Phone number of the recipient
    private String email;      // Email address of the recipient

    /**
     * Constructor to initialize the recipient with all required details.
     *
     * @param jmeno First name of the recipient
     * @param prijmeni Last name of the recipient
     * @param ulice Street address of the recipient
     * @param mesto City of the recipient
     * @param psc Postal code of the recipient
     * @param telefon Phone number of the recipient
     * @param email Email address of the recipient
     */
    public Prijemce(String jmeno, String prijmeni, String ulice, String mesto, String psc, String telefon, String email) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.ulice = ulice;
        this.mesto = mesto;
        this.psc = psc;
        this.telefon = telefon;
        this.email = email;
    }

    /**
     * Returns a formatted string representing the recipient's full information.
     *
     * @return A string with the recipient's name, address, phone, and email.
     */
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", " + ulice + ", " + mesto + ", " + psc + ", tel: " + telefon + ", email: " + email;
    }

    /**
     * Gets the first name of the recipient.
     *
     * @return First name of the recipient
     */
    public String getJmeno() {
        return this.jmeno;
    }

    /**
     * Gets the last name of the recipient.
     *
     * @return Last name of the recipient
     */
    public String getPrijmeni() {
        return this.prijmeni;
    }

    /**
     * Gets the street address of the recipient.
     *
     * @return Street address of the recipient
     */
    public String getUlice() {
        return this.ulice;
    }

    /**
     * Gets the email address of the recipient.
     *
     * @return Email address of the recipient
     */
    public String getEmail() {
        return this.email;
    }
}
