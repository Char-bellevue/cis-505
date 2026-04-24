package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). TestComposerApp.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {

    private static final String APP_HEADER = "  Welcome to the Composer App\n";

    private MemComposerDao gComposerDao;

    public TestComposerApp() {
        gComposerDao = new MemComposerDao();
    }

    public static void main(String[] pArgs) {

        TestComposerApp lApp = new TestComposerApp();
        lApp.run();
    }
     private void run() {

        Scanner lScanner = new Scanner(System.in);
        int lMenuChoice = 0;

        while (lMenuChoice != 4) {

            displayMenu();
            System.out.print("  Enter selection: ");
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
     private void displayMenu() {

        System.out.println();
        System.out.println(APP_HEADER);
        System.out.println("  MENU OPTIONS");
        System.out.println("  1. View Composers");
        System.out.println("  2. Find Composer");
        System.out.println("  3. Add Composer");
        System.out.println("  4. Exit\n");
    }

    private void displayComposers() {

        List<Composer> lComposerList = gComposerDao.findAll();

        for (Composer lComposer : lComposerList) {
            System.out.println("  " + lComposer);
            System.out.println();
        }
    }

    private void findComposer(Scanner pScanner) {

        System.out.print("\n  Enter composer id: ");
        int lId = Integer.parseInt(pScanner.nextLine());

        Composer lComposer = gComposerDao.findById(lId);

        if (lComposer != null) {
            System.out.println("\n  " + lComposer);
        }
        else {
            System.out.println("\n  Composer not found.");
        }
    }

    private void insertComposer(Scanner pScanner) {

        System.out.print("\n  Enter composer id: ");
        int lId = Integer.parseInt(pScanner.nextLine());

        System.out.print("  Enter composer name: ");
        String lName = pScanner.nextLine();

        System.out.print("  Enter composer genre: ");
        String lGenre = pScanner.nextLine();

        Composer lNewComposer = new Composer(
            lId,
            lName,
            lGenre
        );

        gComposerDao.insert(lNewComposer);

        System.out.println("\n  Composer added successfully.");
    }
}