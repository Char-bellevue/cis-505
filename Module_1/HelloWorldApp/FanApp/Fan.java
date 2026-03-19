package FanApp;
/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by Natarajan, C. (2026). CIS 505 Intermediate Java Programming.
        Bellevue University.
*/

/**
 * Represents a Fan object with speed, on/off state, radius, and color properties.
 * Provides constants for speed levels, accessor/mutator methods, and a toString override.
 */
public class Fan {

    // Constants representing the speed levels of the fan
    public static final int STOPPED = 0;
    public static final int SLOW    = 1;
    public static final int MEDIUM  = 2;
    public static final int FAST    = 3;

    // Private class fields with default values
    private int speed  = STOPPED;
    private boolean on = false;
    private double radius = 6.0;
    private String color  = "white";

    /**
     * No-argument constructor that initializes the fan with default values.
     */
    public Fan() {
        // Default values already assigned at declaration
    } // end Fan

    /**
     * Argument constructor that initializes the fan with the provided values.
     * @param speed  int - the speed of the fan
     * @param on     boolean - the on/off state of the fan
     * @param radius double - the radius of the fan
     * @param color  String - the color of the fan
     */
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    } // end Fan

    public int getSpeed() {
        return speed;
    } // end getSpeed

    public void setSpeed(int speed) {
        this.speed = speed;
    } // end setSpeed

    public boolean isOn() {
        return on;
    } // end isOn

    public void setOn(boolean on) {
        this.on = on;
    } // end setOn

    public double getRadius() {
        return radius;
    } // end getRadius

    public void setRadius(double radius) {
        this.radius = radius;
    } // end setRadius

    public String getColor() {
        return color;
    } // end getColor

    public void setColor(String color) {
        this.color = color;
    } // end setColor

    /**
     * Returns a string description of the fan.
     * If the fan is on, returns the speed, color, and radius.
     * If the fan is off, returns the color, radius, and a message indicating the fan is off.
     */
    @Override
    public String toString() {

        if (on) {
            return "The fan speed is set to " + speed
                + " with a color of " + color
                + " and a radius of " + radius;
        } else {
            return "The fan is " + color
                + " with a radius of " + radius
                + " and the fan is off";
        }

    } // end toString

} // end Fan