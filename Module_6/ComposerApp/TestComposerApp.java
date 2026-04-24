package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). TestComposerApp.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.List;
import java.util.Scanner;

/**
 * Purpose: This class tests the Composer and MemComposerDao classes.
 * Input: User menu selections and composer data.
 * Output: Composer information displayed to the console.
 */
public class TestComposerApp {

    private static final String APP_HEADER = "  Welcome to the Composer App\n";

    private MemComposerDao gComposerDao;

    /**
     * Purpose: Default constructor initializes the composer data access object.
     * Input: None.
     * Output: TestComposerApp object.
     */
    public TestComposerApp() {
        gComposerDao = new MemComposerDao();
    }

    /**
     * Purpose: Entry point of the application.
     * Input: Command-line arguments.
     * Output: None.
     */
    public static void main(String[] pArgs) {

        TestComposerApp lApp = new TestComposerApp();
        lApp.run();
    }

    /**
     * Purpose: Runs the main application loop, displaying the menu and handling user input.
     * Input: None.
     * Output: None.
     */
    private void run() {

        Scanner lScanner = new Scanner(System.in);
        int lMenuChoice = 0;

        System.out.println(APP_HEADER);

        while (lMenuChoice != 4) {

            displayMenu();
            System.out.print("  Please choose an option: ");
            lMenuChoice = Integer.parseInt(lScanner.nextLine());

            if (lMenuChoice == 1) {
                displayComposers();
            }
            else if (lMenuChoice == 2) {
                findComposer(lScanner);
            }
            else if (lMenuChoice == 3) {
                insertComposer(lScanner);
            }
            else if (lMenuChoice == 4) {
                System.out.println("\n  Goodbye.");
            }
        }

        lScanner.close();
    }

    /**
     * Purpose: Displays the main menu options to the user.
     * Input: None.
     * Output: Formatted menu printed to the console.
     */
    private void displayMenu() {

        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit");
        System.out.println();
    }

    /**
     * Purpose: Retrieves and displays all composers from the data access object.
     * Input: None.
     * Output: List of composers printed to the console.
     */
    private void displayComposers() {

        System.out.println();
        System.out.println("  --DISPLAYING COMPOSERS--");

        List<Composer> lComposerList = gComposerDao.findAll();

        for (Composer lComposer : lComposerList) {
            System.out.println("  " + lComposer.toString().replace("\n", "\n  "));
            System.out.println();
        }
    }

    /**
     * Purpose: Prompts the user for an id and displays the matching composer.
     * Input: Scanner for reading user input.
     * Output: Matching composer printed to the console, or not found message.
     */
    private void findComposer(Scanner pScanner) {

        System.out.print("\n  Enter an id: ");
        int lId = Integer.parseInt(pScanner.nextLine());

        Composer lComposer = gComposerDao.findBy(lId);

        System.out.println();

        if (lComposer != null) {
            System.out.println("  --DISPLAYING COMPOSER--");
            System.out.println("  " + lComposer.toString().replace("\n", "\n  "));
        }
        else {
            System.out.println("  Composer not found.");
        }

        System.out.println();
    }

    /**
     * Purpose: Prompts the user to enter a new composer and inserts it into the data access object.
     * Input: Scanner for reading user input.
     * Output: None.
     */
    private void insertComposer(Scanner pScanner) {

        System.out.print("\n  Enter an id: ");
        int lId = Integer.parseInt(pScanner.nextLine());

        System.out.print("  Enter a name: ");
        String lName = pScanner.nextLine();

        System.out.print("  Enter a genre: ");
        String lGenre = pScanner.nextLine();

        Composer lNewComposer = new Composer(
            lId,
            lName,
            lGenre
        );

        gComposerDao.insert(lNewComposer);

        System.out.println();
    }
}