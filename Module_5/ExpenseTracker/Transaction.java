package Module_5.ExpenseTracker;

/*
 * Natarajan, C. (2026). Transaction [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a single expense transaction containing a date,
 * a description, and a monetary amount.
 */
public class Transaction {

    // -------------------------------------------------------------------------
    // Instance fields — prefixed with 'g' to denote global (instance) scope
    // -------------------------------------------------------------------------

    /** The date of this transaction, stored in MM-dd-yyyy format. */
    private String gDate;

    /** A brief textual description of what this transaction was for. */
    private String gDescription;

    /** The monetary amount associated with this transaction. */
    private double gAmount;

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * No-argument constructor that creates a default transaction.
     * Purpose  : Initializes the transaction with today's date, an empty
     *            description, and a zero amount.
     * Input    : None.
     * Output   : A Transaction object populated with default field values.
     */
    public Transaction() {
        // Format today's date as MM-dd-yyyy to satisfy the default date requirement.
        DateTimeFormatter lFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        this.gDate        = LocalDate.now().format(lFormatter);
        this.gDescription = "";
        this.gAmount      = 0.0;
    }

    /**
     * Full argument constructor that creates a transaction with all three fields.
     * Purpose  : Initializes every data field with the caller-supplied values.
     * Input    : lDate        — the transaction date in MM-dd-yyyy format.
     *            lDescription — a short description of the transaction.
     *            lAmount      — the monetary amount of the transaction.
     * Output   : A fully populated Transaction object.
     */
    public Transaction(String lDate, String lDescription, double lAmount) {
        this.gDate        = lDate;
        this.gDescription = lDescription;
        this.gAmount      = lAmount;
    }

    /**
     * Convenience constructor that creates a transaction using today's date.
     * Purpose  : Builds a transaction with description and amount when the
     *            user does not supply a date; today's date is set automatically.
     * Input    : lDescription — a short description of the transaction.
     *            lAmount      — the monetary amount of the transaction.
     * Output   : A Transaction object whose date is set to today's date.
     */
    public Transaction(String lDescription, double lAmount) {
        // Delegate to the no-arg constructor so today's date is set correctly.
        this();
        this.gDescription = lDescription;
        this.gAmount      = lAmount;
    }

    // -------------------------------------------------------------------------
    // Accessor (getter) methods
    // -------------------------------------------------------------------------

    /**
     * Returns the date of this transaction.
     * Purpose  : Provides read-only access to the private gDate field.
     * Input    : None.
     * Output   : The date string formatted as MM-dd-yyyy.
     */
    public String getDate() {
        return gDate;
    }

    /**
     * Returns the description of this transaction.
     * Purpose  : Provides read-only access to the private gDescription field.
     * Input    : None.
     * Output   : The description string.
     */
    public String getDescription() {
        return gDescription;
    }

    /**
     * Returns the monetary amount of this transaction.
     * Purpose  : Provides read-only access to the private gAmount field.
     * Input    : None.
     * Output   : The amount as a primitive double value.
     */
    public double getAmount() {
        return gAmount;
    }

    // -------------------------------------------------------------------------
    // Mutator (setter) methods
    // -------------------------------------------------------------------------

    /**
     * Replaces the date of this transaction.
     * Purpose  : Provides write access to the private gDate field.
     * Input    : lDate — the new date string in MM-dd-yyyy format.
     * Output   : None (void); the internal date value is updated.
     */
    public void setDate(String lDate) {
        this.gDate = lDate;
    }

    /**
     * Replaces the description of this transaction.
     * Purpose  : Provides write access to the private gDescription field.
     * Input    : lDescription — the new description string.
     * Output   : None (void); the internal description value is updated.
     */
    public void setDescription(String lDescription) {
        this.gDescription = lDescription;
    }

    /**
     * Replaces the monetary amount of this transaction.
     * Purpose  : Provides write access to the private gAmount field.
     * Input    : lAmount — the new amount as a double value.
     * Output   : None (void); the internal amount value is updated.
     */
    public void setAmount(double lAmount) {
        this.gAmount = lAmount;
    }

    // -------------------------------------------------------------------------
    // Overridden Object methods
    // -------------------------------------------------------------------------

    /**
     * Returns a multi-line string representation of this transaction.
     * Purpose  : Overrides the default Object.toString so that printing a
     *            Transaction displays all three data fields on separate lines.
     * Input    : None.
     * Output   : A formatted string containing the date, description, and amount.
     */
    @Override
    public String toString() {
        return "Date: "         + gDate        + "\n"
             + "Description: "  + gDescription + "\n"
             + "Amount: "       + gAmount;
    }
}