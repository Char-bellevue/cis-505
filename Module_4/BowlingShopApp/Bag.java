package Module_4.BowlingShopApp;

 /*
 * Natarajan, C. (2026). BowlingShopApp [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This class represents a bowling bag product.
 *          It extends the Product superclass and adds a type field
 *          that specifies how many bowling balls the bag can hold.
 */
public class Bag extends Product {

    // Private data field for the bag type (e.g., Single, Double, Triple) with default empty string.
    private String type = "";

    /**
     * Purpose: No-argument constructor that creates a default Bag object.
     *          Calls the superclass constructor to initialize inherited fields.
     */
    public Bag() {
        super();
    }

    /**
     * Purpose: Returns the type of the bowling bag.
     * Output:  String representing the bag's type (ball capacity).
     */
    public String getType() {
        return type;
    }

    /**
     * Purpose: Sets the type of the bowling bag.
     * Input:   lType - the new type string describing the bag's ball capacity.
     */
    public void setType(String lType) {
        this.type = lType;
    }

    /**
     * Purpose: Overrides the toString method to append the bag's type
     *          to the superclass string representation.
     * Output:  Formatted multi-line string including all product fields plus type.
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
             + "Type: " + type;
    }
}
