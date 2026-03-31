package Module_3.CustomerAccountApp;

/*
 * Natarajan, C. (2026). CustomerAccountApp [Java source code].
 */

/**
 * Purpose: This class represents a Customer with name, address, city, and zip fields.
 * It provides constructors, accessor methods, and a toString override.
 */
public class Customer {

    // Private data fields to store customer information.
    private String name;
    private String address;
    private String city;
    private String zip;

    /**
     * Purpose: No-argument constructor that creates a default Customer object.
     * Input:   None.
     * Output:  A Customer instance with default (empty string) field values.
     */
    public Customer() {
        this.name    = "";
        this.address = "";
        this.city    = "";
        this.zip     = "";
    }

    /**
     * Purpose: Argument constructor that creates a Customer using all four data fields.
     * Input:   lName    - the customer's full name.
     *          lAddress - the customer's street address.
     *          lCity    - the customer's city.
     *          lZip     - the customer's zip code.
     * Output:  A fully initialized Customer instance.
     */
    public Customer(String lName, String lAddress, String lCity, String lZip) {
        this.name    = lName;
        this.address = lAddress;
        this.city    = lCity;
        this.zip     = lZip;
    }

    // -------------------------------------------------------------------------
    // Accessor (getter) methods for all four private data fields.
    // -------------------------------------------------------------------------

    /**
     * Purpose: Returns the customer's name.
     * Input:   None.
     * Output:  A String representing the customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Purpose: Returns the customer's address.
     * Input:   None.
     * Output:  A String representing the customer's street address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Purpose: Returns the customer's city.
     * Input:   None.
     * Output:  A String representing the customer's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Purpose: Returns the customer's zip code.
     * Input:   None.
     * Output:  A String representing the customer's zip code.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Purpose: Overrides the default toString method to return a formatted
     *          string description of the customer with each field on its own line.
     * Input:   None.
     * Output:  A multi-line String containing all four customer fields.
     */
    @Override
    public String toString() {
        return  "--Customer Details--\n"
              + "  Name: "    + name    + "\n"
              + "  Address: " + address + "\n"
              + "  City: "    + city    + "\n"
              + "  Zip: "     + zip;
    }

}