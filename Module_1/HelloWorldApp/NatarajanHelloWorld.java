package HelloWorldApp;
/*
 * Natarajan, C. (2026). CIS 505 Intermediate Java Programming. Bellevue University.
 */

public class NatarajanHelloWorld {

    /**
     * Entry point of the program. Prints a greeting message with the user's full name.
     * @param args String[]
     * @return prints the result to the console window.
     */
    public static void main(String[] args) {

        // Declare and initialize local variables for first and last name
        String lFirstName = "Charanya";
        String lLastName = "Natarajan";

        // Print a greeting message with the user's full name
        System.out.printf("Hello World from %s %s.%n", lFirstName, lLastName);
    } // end main

} // end NatarajanHelloWorld