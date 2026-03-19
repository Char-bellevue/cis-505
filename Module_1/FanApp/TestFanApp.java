package FanApp;

/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by Natarajan, C. (2026). CIS 505 Intermediate Java Programming.
        Bellevue University.
*/

/**
 * TestFanApp is used to test the Fan class.
 * Creates two Fan instances and displays their details.
 */
public class TestFanApp {

    public static void main(String[] args) {

        // Create fan1 using default constructor
        Fan fan1 = new Fan();

        // Create fan2 using argument constructor
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display fan details
        System.out.println(fan1);
        System.out.println(fan2);

    } // end main

} // end TestFanApp
