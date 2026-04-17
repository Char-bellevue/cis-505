package Module_5.ExpenseTracker;

/*
 * Natarajan, C. (2026). ValidatorIO [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.Scanner;

/**
 * This utility class provides static input-validation methods that shield the
 * rest of the application from invalid user entries.
 */
public class ValidatorIO {

    // -------------------------------------------------------------------------
    // Static validation methods
    // -------------------------------------------------------------------------

    /**
     * Prompts the user repeatedly until a valid integer is entered.
     * Purpose  : Reads and validates an integer value from standard input,
     *            displaying an error message on every invalid attempt.
     * Input    : sc     — the shared Scanner connected to System.in.
     *            prompt — the message displayed to the user before each attempt.
     * Output   : The validated integer value entered by the user.
     */
    public static Integer getInt(Scanner sc, String prompt) {
        // Local variable to store the validated integer; starts at a safe default.
        Integer lInput = 0;

        // Flag that controls the validation loop; remains false until valid input.
        boolean lIsValid = false;

        // Keep prompting the user until a valid integer has been provided.
        while (!lIsValid) {
            System.out.print(prompt);

            // Check whether the next token in the stream is a valid integer.
            if (sc.hasNextInt()) {
                // Accept the integer and mark the input as valid.
                lInput   = sc.nextInt();
                lIsValid = true;
            } else {
                // Reject the token and inform the user of the error.
                System.out.println("\n  Error! Invalid integer value.\n");
            }

            // Consume the remainder of the current line (including the newline
            // character) so the next prompt is not skipped.
            sc.nextLine();
        }

        return lInput;
    }

    /**
     * Prompts the user repeatedly until a valid double is entered.
     * Purpose  : Reads and validates a double value from standard input,
     *            displaying an error message on every invalid attempt.
     * Input    : sc     — the shared Scanner connected to System.in.
     *            prompt — the message displayed to the user before each attempt.
     * Output   : The validated double value entered by the user.
     */
    public static double getDouble(Scanner sc, String prompt) {
        // Local variable to store the validated double; starts at a safe default.
        double lInput = 0.0;

        // Flag that controls the validation loop; remains false until valid input.
        boolean lIsValid = false;

        // Keep prompting the user until a valid double has been provided.
        while (!lIsValid) {
            System.out.print(prompt);

            // Check whether the next token in the stream is a valid double.
            if (sc.hasNextDouble()) {
                // Accept the double and mark the input as valid.
                lInput   = sc.nextDouble();
                lIsValid = true;
            } else {
                // Reject the token and inform the user of the error.
                System.out.println("\n  Error! Invalid decimal value.\n");
            }

            // Consume the remainder of the current line to prevent stream issues.
            sc.nextLine();
        }

        return lInput;
    }

    /**
     * Prompts the user and returns the next whitespace-delimited token entered.
     * Purpose  : Reads a single string token from standard input without
     *            performing additional validation.
     * Input    : sc     — the shared Scanner connected to System.in.
     *            prompt — the message displayed to the user.
     * Output   : The string token entered by the user.
     */
    public static String getString(Scanner sc, String prompt) {
        // Display the prompt so the user knows what to enter.
        System.out.print(prompt);

        // Capture and return the next whitespace-delimited token.
        String lInput = sc.next();

        // Consume the remainder of the line to keep the stream in a clean state.
        sc.nextLine();

        return lInput;
    }
}