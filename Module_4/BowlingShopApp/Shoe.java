package Module_4.BowlingShopApp;

/*
 * Natarajan, C. (2026). BowlingShopApp [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This class represents a bowling shoe product.
 *          It extends the Product superclass and adds a size field.
 */
public class Shoe extends Product {

    // Private data field for the shoe size with default value of 0.
    private double size = 0;

    /**
     * Purpose: No-argument constructor that creates a default Shoe object.
     *          Calls the superclass constructor to initialize inherited fields.
     */
    public Shoe() {
        super();
    }

    /**
     * Purpose: Returns the size of the bowling shoe.
     * Output:  double representing the shoe size.
     */
    public double getSize() {
        return size;
    }

    /**
     * Purpose: Sets the size of the bowling shoe.
     * Input:   lSize - the new shoe size as a double.
     */
    public void setSize(double lSize) {
        this.size = lSize;
    }

    /**
     * Purpose: Overrides the toString method to append the shoe's size
     *          to the superclass string representation.
     * Output:  Formatted multi-line string including all product fields plus size.
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
             + "  Size: " + size;
    }
}