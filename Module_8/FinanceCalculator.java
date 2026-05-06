package Module_8;

/*
    Natarajan, C. (2026). CIS 505 Intermediate Java Programming.
        Bellevue University.
*/

/**
 * Provides static financial calculation methods for computing future value
 * based on monthly payment, interest rate, and number of years.
 */
public class FinanceCalculator {

    // Purpose: Stores the number of months in a year as a constant.
    private static final int MONTHS_IN_YEAR = 12;

    // Purpose:  Calculates the future value of an investment based on monthly
    //           payment, interest rate, and number of years.
    // Input:    monthlyPayment - the monthly payment amount as a double.
    //           rate - the annual interest rate as a double.
    //           years - the number of years as an int.
    // Output:   Returns the calculated future value as a double.
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {

        // Purpose: Calculates the total number of months by multiplying years by months in a year.
        int lMonths = years * MONTHS_IN_YEAR;

        // Purpose: Calculates the interest rate using the formula (1 + rate / 100).
        double lInterestRate = (1 + rate / 100);

        // Purpose: Calculates the present value by multiplying monthly payment by number of months.
        double lPresentValue = monthlyPayment * lMonths;

        // Purpose: Calculates the future value using present value and compound interest.
        double lFutureValue = lPresentValue * (Math.pow(lInterestRate, lMonths));

        // Purpose: Returns the calculated future value to the caller.
        return lFutureValue;
    }
}
