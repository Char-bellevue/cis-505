package Module_3.CustomerAccountApp;

/*
 * Natarajan, C. (2026). CustomerAccountApp [Java source code].
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Purpose: This class represents a bank account with deposit, withdraw,
 *          balance inquiry, menu display, and transaction date capabilities.
 */
public class Account {

    // Default starting balance constant, as specified in the requirements.
    private static final double DEFAULT_BALANCE = 200.0;

    // Private data field storing the current account balance.
    private double balance;

    /**
     * Purpose: No-argument constructor that initializes the account balance
     *          to the default value of 200.
     * Input:   None.
     * Output:  An Account instance with a balance of $200.00.
     */
    public Account() {
        this.balance = DEFAULT_BALANCE;
    }

    /**
     * Purpose: Returns the current account balance.
     * Input:   None.
     * Output:  A double representing the current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Purpose: Increases the account balance by the specified deposit amount.
     * Input:   lAmt - a double representing the amount to deposit.
     * Output:  None. The balance field is updated internally.
     */
    public void deposit(double lAmt) {
        balance += lAmt;
    }

    /**
     * Purpose: Decreases the account balance by the specified withdrawal amount,
     *          but only if sufficient funds are available.
     * Input:   lAmt - a double representing the amount to withdraw.
     * Output:  None. The balance field is updated internally if funds allow.
     */
    public void withdraw(double lAmt) {
        // Only process the withdrawal when the balance covers the requested amount.
        if (balance >= lAmt) {
            balance -= lAmt;
        }
    }

    /**
     * Purpose: Prints the Account Menu to the console, showing available options
     *          for deposit, withdrawal, and balance inquiry.
     * Input:   None.
     * Output:  Formatted menu text printed to standard output.
     */
    public void displayMenu() {
        System.out.println("  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("    Enter option>: ");
    }

    /**
     * Purpose: Returns the current date formatted as MM-dd-yyyy, representing
     *          the date of the most recent transaction.
     * Input:   None.
     * Output:  A String containing today's date in MM-dd-yyyy format.
     */
    public String getTransactionDate() {
        // Retrieve today's date and format it according to the required pattern.
        LocalDate lToday = LocalDate.now();
        DateTimeFormatter lFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return lToday.format(lFormatter);
    }

}
