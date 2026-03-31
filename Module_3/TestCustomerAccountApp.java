package Module_3;

/*
 * Natarajan, C. (2026). CustomerAccountApp [Java source code].
 */

import java.util.Scanner;

/**
 * Purpose: This class serves as the main entry point for the Customer Account
 *          application. It coordinates user input, customer lookup, and account
 *          operations using the Customer, CustomerDB, and Account classes.
 * Input:   User-provided customer ID and menu selections via the console.
 * Output:  Account operation results and final customer/balance summary printed
 *          to standard output.
 */
public class TestCustomerAccountApp {

    /**
     * Purpose: Main method that drives the Customer Account application.
     *          Prompts for a customer ID, displays the account menu in a loop,
     *          handles menu selections, and displays a final summary upon exit.
     * Input:   args - command-line arguments (not used in this application).
     * Output:  Console output reflecting all user interactions and results.
     */
    public static void main(String[] args) {

        // Create a Scanner to read all user input from the console.
        Scanner lScanner = new Scanner(System.in);

        // Create an Account instance for the session with the default balance.
        Account lAccount = new Account();

        // Create a CustomerDB instance used to look up customer records.
        CustomerDB lCustomerDB = new CustomerDB();

        // -----------------------------------------------------------------------
        // Greet the user and prompt for a valid customer ID.
        // -----------------------------------------------------------------------
        System.out.println("  Welcome to the Customer Account App");
        System.out.println();
        System.out.println("  Enter a customer ID:");
        System.out.print("    ex: 1007, 1008, 1009>: ");
        int lCustomerId = lScanner.nextInt();

        // Consume the leftover newline character after reading the integer.
        lScanner.nextLine();

        // Use the entered ID to retrieve the matching Customer from the database.
        Customer lCustomer = lCustomerDB.getCustomer(lCustomerId);

        // -----------------------------------------------------------------------
        // Main interaction loop using do...while so the menu displays at least once.
        // -----------------------------------------------------------------------
        String lContinueChoice;

        do {
            System.out.println();

            // Display the account menu and read the user's option selection.
            lAccount.displayMenu();
            String lMenuSelection = lScanner.nextLine().trim();

            System.out.println();

            // -------------------------------------------------------------------
            // Handle each valid menu selection and invoke the corresponding method.
            // -------------------------------------------------------------------
            if (lMenuSelection.equalsIgnoreCase("D")) {

                // Prompt the user for the deposit amount and process the deposit.
                System.out.print("  Enter deposit amount: ");
                double lDepositAmount = lScanner.nextDouble();
                lScanner.nextLine();
                lAccount.deposit(lDepositAmount);

            } else if (lMenuSelection.equalsIgnoreCase("W")) {

                // Prompt the user for the withdrawal amount and process the withdrawal.
                System.out.print("  Enter withdraw amount: ");
                double lWithdrawAmount = lScanner.nextDouble();
                lScanner.nextLine();
                lAccount.withdraw(lWithdrawAmount);

            } else if (lMenuSelection.equalsIgnoreCase("B")) {

                // Display the current account balance using the required printf format.
                System.out.printf("  Account balance: $%,6.2f%n", lAccount.getBalance());

            } else {

                // Inform the user that the entered option is not recognized.
                System.out.println("  Error: Invalid option");

            }

            // -------------------------------------------------------------------
            // Ask the user whether they wish to continue or exit the menu loop.
            // -------------------------------------------------------------------
            System.out.println();
            System.out.print("  Continue? (y/n): ");
            lContinueChoice = lScanner.nextLine().trim();

        } while (lContinueChoice.equalsIgnoreCase("Y"));

        // -----------------------------------------------------------------------
        // After the loop exits, display the customer details and final balance.
        // -----------------------------------------------------------------------
        System.out.println();
        System.out.println(lCustomer.toString());
        System.out.println();
        System.out.printf(
            "  Balance as of %s is $%,6.2f%n",
            lAccount.getTransactionDate(),
            lAccount.getBalance()
        );
        System.out.println();
        System.out.println("  End of line...");

        // Close the Scanner resource to release the underlying input stream.
        lScanner.close();
    }

}
