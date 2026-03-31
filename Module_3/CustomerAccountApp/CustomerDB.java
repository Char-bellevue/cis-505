package Module_3.CustomerAccountApp;

/*
 * Natarajan, C. (2026). CustomerAccountApp [Java source code].
 */

/**
 * Purpose: This class acts as a simple in-memory customer database.
 *          It provides a static lookup method that returns a Customer object
 *          based on a given customer ID.
 */
public class CustomerDB {

    /**
     * Purpose: Looks up and returns a Customer object that corresponds to the
     *          provided customer ID. If the ID does not match any known record,
     *          a default Customer object is returned.
     * Input:   lId - an Integer representing the customer's ID number.
     * Output:  A Customer object whose fields match the given ID, or a
     *          default Customer object if no match is found.
     */
    public Customer getCustomer(Integer lId) {

        // Compare the provided ID against each known customer ID value.
        if (lId == 1007) {
            return new Customer(
                "Jennifer Patterson",
                "8422 Grover Ave.",
                "Bellevue",
                "68123"
            );
        } else if (lId == 1008) {
            return new Customer(
                "Michael Torres",
                "315 Maple Street",
                "Omaha",
                "68102"
            );
        } else if (lId == 1009) {
            return new Customer(
                "Sandra Lee",
                "7901 Pine Ridge Rd.",
                "Lincoln",
                "68501"
            );
        } else {
            // Return a default (empty) Customer when no ID matches.
            return new Customer();
        }
    }

}
