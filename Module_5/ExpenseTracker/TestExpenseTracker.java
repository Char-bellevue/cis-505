package Module_5.ExpenseTracker;

/*
 * Natarajan, C. (2026). TestExpenseTracker [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class serves as the entry point of the Expense Tracker application.
 * It presents an interactive menu that lets the user view transactions,
 * add new transactions, and view a total monthly expense summary.
 */
public class TestExpenseTracker {

    // -------------------------------------------------------------------------
    // Helper method — builds the menu string
    // -------------------------------------------------------------------------

    /**
     * Builds and returns the formatted main-menu string.
     * Purpose  : Centralizes the menu text so that it can be passed directly
     *            to ValidatorIO.getInt() as the prompt argument.
     * Input    : None.
     * Output   : A multi-line String containing the full menu display.
     */
    private static String menu() {
        return "\n  Welcome to the Expense Tracker\n\n"
             + "  MENU OPTIONS\n"
             + "    1. View Transactions\n"
             + "    2. Add Transactions\n"
             + "    3. View Expense\n\n"
             + "  Please choose an option: ";
    }

    // -------------------------------------------------------------------------
    // Main method
    // -------------------------------------------------------------------------

    /**
     * Launches the Expense Tracker application and drives the main menu loop.
     * Purpose  : Continuously presents the menu to the user, delegates each
     *            selection to the appropriate logic block, and exits cleanly
     *            when the user chooses not to continue.
     * Input    : args — command-line arguments (not used in this application).
     * Output   : None (void); all output is written directly to System.out.
     */
    public static void main(String[] args) {

        // Create a single shared Scanner so the input stream is never duplicated.
        Scanner lScanner = new Scanner(System.in);

        // Flag that keeps the application running until the user opts to exit.
        String lContinue = "y";

        // ---- Outer loop: keep the menu visible until the user quits ----
        while (lContinue.equalsIgnoreCase("y")) {

            // Read and validate the user's menu selection.
            int lMenuSelection = ValidatorIO.getInt(lScanner, menu());

            // ---- Menu option 1: View all stored transactions ----
            if (lMenuSelection == 1) {
                System.out.println("\n  MONTHLY EXPENSES\n");

                try {
                    // Retrieve every transaction currently saved to disk.
                    ArrayList<Transaction> lTransactions = TransactionIO.findAll();

                    // Display each transaction with the amount formatted as currency.
                    for (Transaction lTransaction : lTransactions) {
                        System.out.println("  Date: "        + lTransaction.getDate());
                        System.out.println("  Description: " + lTransaction.getDescription());
                        System.out.printf( "  Amount: $%,6.2f%n", lTransaction.getAmount());
                        System.out.println();
                    }

                } catch (IOException lException) {
                    System.out.println("\n  Exception: " + lException.getMessage() + "\n");
                }

            // ---- Menu option 2: Add one or more new transactions ----
            } else if (lMenuSelection == 2) {

                // Start with a fresh list to collect all entries for this session.
                ArrayList<Transaction> lNewTransactions = new ArrayList<>();

                // Flag to keep the add-transaction sub-loop active.
                String lAddAnother = "y";

                // ---- Inner loop: let the user enter as many transactions as desired ----
                while (lAddAnother.equalsIgnoreCase("y")) {

                    // Collect the description and amount using validated input methods.
                    String lDescription = ValidatorIO.getString(
                            lScanner, "\n  Enter the description: ");
                    double lAmount      = ValidatorIO.getDouble(
                            lScanner, "  Enter the amount: ");

                    // Build a new Transaction using today's date and the user's values.
                    Transaction lTransaction = new Transaction(lDescription, lAmount);

                    // Stage the transaction for bulk writing.
                    lNewTransactions.add(lTransaction);

                    // Ask whether the user wants to record another transaction.
                    lAddAnother = ValidatorIO.getString(
                            lScanner, "\n  Add another transaction? (y/n): ");
                }

                // Persist all newly collected transactions to the expenses file.
                try {
                    TransactionIO.bulkInsert(lNewTransactions);
                } catch (IOException lException) {
                    System.out.println("\n  Exception: " + lException.getMessage() + "\n");
                }

            // ---- Menu option 3: Display the total of all expenses ----
            } else if (lMenuSelection == 3) {

                // Accumulator that will hold the running total of all amounts.
                double lMonthlyExpense = 0.0;

                try {
                    // Load all transactions from disk to compute the total.
                    ArrayList<Transaction> lTransactions = TransactionIO.findAll();

                    // Add each transaction's amount to the running total.
                    for (Transaction lTransaction : lTransactions) {
                        lMonthlyExpense += lTransaction.getAmount();
                    }

                    System.out.printf(
                            "%n  Your total monthly expense is $%,.2f%n", lMonthlyExpense);

                } catch (IOException lException) {
                    System.out.println("\n  Exception: " + lException.getMessage() + "\n");
                }

            }

            // Ask whether the user wants to return to the main menu or exit.
            lContinue = ValidatorIO.getString(lScanner, "\n  Continue? (y/n): ");
        }

        // Display the exit message and release the input stream.
        System.out.println("\n  Program terminated by the user...\n");
        lScanner.close();
    }
}