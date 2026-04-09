package Module_4.BowlingShopApp;

/*
 * Natarajan, C. (2026). BowlingShopApp [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This class represents a generic product in a bowling shop.
 *          It serves as the superclass for all specific product types.
 */
public class Product {

    // Private data fields with default values as specified in the assignment.
    private String code = "";
    private String description = "";
    private double price = 0;

    /**
     * Purpose: No-argument constructor that creates a default Product object.
     *          All fields are initialized to their default values.
     */
    public Product() {
        // Default constructor — fields already initialized above.
    }

    /**
     * Purpose: Returns the product code.
     * Output:  String representing the product code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Purpose: Sets the product code.
     * Input:   lCode - the new product code string.
     */
    public void setCode(String lCode) {
        this.code = lCode;
    }

    /**
     * Purpose: Returns the product description.
     * Output:  String representing the product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Purpose: Sets the product description.
     * Input:   lDescription - the new product description string.
     */
    public void setDescription(String lDescription) {
        this.description = lDescription;
    }

    /**
     * Purpose: Returns the product price.
     * Output:  double representing the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Purpose: Sets the product price.
     * Input:   lPrice - the new price as a double.
     */
    public void setPrice(double lPrice) {
        this.price = lPrice;
    }

    /**
     * Purpose: Overrides the default toString method to return a formatted
     *          string representation of the product with all three fields.
     *          Price is formatted using the "$%,6.2f" pattern as specified.
     * Output:  Formatted multi-line string of product fields.
     */
    @Override
    public String toString() {
        // Build the formatted price string using printf-style formatting.
        String lFormattedPrice = String.format("$%,6.2f", price);

        return "  Product code: " + code + "\n"
             + "  Description: " + description + "\n"
             + "  Price: " + lFormattedPrice;
    }
}