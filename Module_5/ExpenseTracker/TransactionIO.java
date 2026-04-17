package Module_5.ExpenseTracker;

/*
 * Natarajan, C. (2026). TransactionIO [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles all file-based reading and writing of Transaction objects
 * to and from the persistent expenses text file.
 */
public class TransactionIO {

    // -------------------------------------------------------------------------
    // Global (instance) constants and fields
    // -------------------------------------------------------------------------

    /** The name of the text file used to persist expense transactions. */
    private static final String FILE_NAME = "expenses.txt";

    /** The File object that represents the expenses text file on disk. */
    private static File gFile = new File(FILE_NAME);

    // -------------------------------------------------------------------------
    // Static file-write methods
    // -------------------------------------------------------------------------

    /**
     * Writes a list of transactions to the expenses text file.
     * Purpose  : Persists all Transaction objects in the supplied ArrayList to
     *            the expenses.txt file, appending when the file already exists
     *            or creating a new file when it does not.
     * Input    : transactions — the ArrayList of Transaction objects to write.
     * Output   : None (void); the file on disk is created or updated.
     * Throws   : IOException if a file I/O error occurs during writing.
     */
    public static void bulkInsert(ArrayList<Transaction> transactions)
            throws IOException {

        // Declare the PrintWriter outside the if-else so it is accessible later.
        PrintWriter lOutput = null;

        // Decide whether to append to an existing file or create a new one.
        if (gFile.exists()) {
            // File already exists — open in append mode so existing data is kept.
            lOutput = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            // File does not exist yet — create a fresh file for writing.
            lOutput = new PrintWriter(FILE_NAME);
        }

        // Iterate over every transaction and write each field to the file.
        for (Transaction lTransaction : transactions) {
            lOutput.print(lTransaction.getDate()        + " ");
            lOutput.print(lTransaction.getDescription() + " ");
            lOutput.println(lTransaction.getAmount());
        }

        // Close the stream to flush all buffered data and release the file handle.
        lOutput.close();
    }

    // -------------------------------------------------------------------------
    // Static file-read methods
    // -------------------------------------------------------------------------

    /**
     * Reads all transactions from the expenses text file and returns them as a list.
     * Purpose  : Opens expenses.txt, parses each line into a Transaction object,
     *            and collects the results into an ArrayList for the caller.
     * Input    : None.
     * Output   : An ArrayList containing every Transaction stored in the file.
     * Throws   : IOException if the file cannot be opened or read.
     */
    public static ArrayList<Transaction> findAll() throws IOException {

        // Create the list that will hold every transaction read from the file.
        ArrayList<Transaction> lTransactions = new ArrayList<>();

        // Open the expenses file for sequential reading.
        Scanner lInput = new Scanner(gFile);

        // Process every remaining line in the file.
        while (lInput.hasNext()) {
            // Read the three fields stored on each line: date, description, amount.
            String lDate        = lInput.next();
            String lDescription = lInput.next();
            double lAmount      = lInput.nextDouble();

            // Build a Transaction object from the parsed fields.
            Transaction lTransaction = new Transaction(lDate, lDescription, lAmount);

            // Add the newly created transaction to the result list.
            lTransactions.add(lTransaction);
        }

        // Release the file handle now that all records have been read.
        lInput.close();

        return lTransactions;
    }
}