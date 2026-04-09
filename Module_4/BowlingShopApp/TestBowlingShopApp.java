package Module_4.BowlingShopApp;

/*
 * Natarajan, C. (2026). BowlingShopApp [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.Scanner;

/**
 * Purpose: This class serves as the main driver to test the Product, Ball, Bag,
 *          Shoe, ProductDB, and GenericQueue classes. It presents a menu to the
 *          user and displays product listings based on the user's selection.
 */
public class TestBowlingShopApp {

    /**
     * Purpose: Displays the bowling shop's main menu options to the console.
     *          The menu lists all available product categories and the exit option.
     */
    public static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("   1. <b> Bowling Balls");
        System.out.println("   2. <a> Bowling Bags");
        System.out.println("   3. <s> Bowling Shoes");
        System.out.println("   4. <x> To exit");
        System.out.print("\nPlease choose an option: ");
    }

    /**
     * Purpose: Main entry point for the Bowling Shop application.
     *          Displays a welcome message, repeatedly shows the menu, retrieves
     *          products based on user input, and displays them until the user exits.
     * Input:   lArgs - command-line arguments (not used in this application).
     */
    public static void main(String[] lArgs) {

        // Create a Scanner object to read user input from the console.
        Scanner lScanner = new Scanner(System.in);

        // Display the welcome message to the user upon application startup.
        System.out.println("Welcome to the Bowling Shop");

        // Declare a variable to hold the user's menu selection.
        String lUserChoice;

        // Continue displaying the menu and processing selections until the user exits.
        do {
            // Display a blank line before the menu for readability.
            System.out.println();

            // Display the menu options to the user.
            displayMenu();

            // Read the user's menu selection from the console.
            lUserChoice = lScanner.nextLine().trim();

            // Check if the user has chosen to exit the application.
            if (!lUserChoice.equalsIgnoreCase("x")) {

                // Retrieve the appropriate product queue from the database using the user's choice.
                GenericQueue<Product> lProducts = ProductDB.getProducts(lUserChoice);

                // Display the product listing header if the queue contains any products.
                if (lProducts.size() > 0) {
                    System.out.println("\n--Product Listing--");
                }

                // Iterate through the queue and display each product using its toString method.
                while (lProducts.size() > 0) {
                    // Dequeue the next product and print its formatted string representation.
                    System.out.println(lProducts.dequeue().toString());
                    System.out.println();
                }
            }

        } while (!lUserChoice.equalsIgnoreCase("x"));

        // Display the exit message when the user chooses to end the session.
        System.out.println("\nEnd of line...");

        // Close the scanner resource to prevent any resource leaks.
        lScanner.close();
    }
}