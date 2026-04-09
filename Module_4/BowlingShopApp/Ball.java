package Module_4.BowlingShopApp;

/*
 * Author: [Your Last Name], [Your First Name]
 * Course: [Course Name]
 * Date: 2026
 * Assignment: Assignment 4.2 - Bowling Shop Application
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This class represents a bowling ball product.
 *          It extends the Product superclass and adds a color field.
 */
public class Ball extends Product {

    // Private data field for the bowling ball's color with default empty string.
    private String color = "";

    /**
     * Purpose: No-argument constructor that creates a default Ball object.
     *          Calls the superclass constructor to initialize inherited fields.
     */
    public Ball() {
        super();
    }

    /**
     * Purpose: Returns the color of the bowling ball.
     * Output:  String representing the ball's color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Purpose: Sets the color of the bowling ball.
     * Input:   lColor - the new color string for the bowling ball.
     */
    public void setColor(String lColor) {
        this.color = lColor;
    }

    /**
     * Purpose: Overrides the toString method to append the ball's color
     *          to the superclass string representation.
     * Output:  Formatted multi-line string including all product fields plus color.
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
             + "Color: " + color;
    }
}