package Module_2.SportsTeamApp;

/*
 * APA Citation:
 * Liang, Y. D. (2014). Introduction to Java Programming and Data Structures (Comprehensive Version).
 * Pearson Education.
 *
 * Assignment reference:
 * Instructions for Assignment 2.3 – TestSportsTeamApp.
 */

import java.util.Scanner;

/**
 * Purpose:
 * This class tests the Team class by allowing user input for multiple teams and players.
 *
 * Input:
 * Team name and comma-separated player names from user.
 *
 * Output:
 * Displays number of players and player names for each team.
 */
public class TestSportsTeamApp {

    /**
     * Purpose:
     * Main method to run the application.
     *
     * Input:
     * User input via console.
     *
     * Output:
     * Displays formatted team and player information.
     */
    public static void main(String[] args) {

        Scanner lScanner = new Scanner(System.in);

        // Purpose: Controls program continuation
        boolean lContinueProgram = true;

        while (lContinueProgram) {

            // Purpose: Prompt user for team name
            System.out.print("  Enter team name: ");
            String lTeamName = lScanner.nextLine();

            // Purpose: Create Team object
            Team lTeam = new Team(lTeamName);

            // Purpose: Prompt user for player names
            System.out.print("  Enter player names (comma-separated, no spaces): ");
            String lPlayerInput = lScanner.nextLine();

            // Purpose: Split input into array
            String[] lPlayerArray = lPlayerInput.split(",");

            // Purpose: Add players to team using loop
            for (int lIndex = 0; lIndex < lPlayerArray.length; lIndex++) {
                lTeam.addPlayer(lPlayerArray[lIndex]);
            }

            // Purpose: Display number of players
            System.out.println("  Number of players in team " + lTeam.getPlayerCount());

            // Purpose: Build player output string
            StringBuilder lPlayerOutput = new StringBuilder();

            String[] lPlayers = lTeam.getPlayers();

            for (int lIndex = 0; lIndex < lTeam.getPlayerCount(); lIndex++) {
                lPlayerOutput.append(lPlayers[lIndex]);

                if (lIndex < lTeam.getPlayerCount() - 1) {
                    lPlayerOutput.append(",");
                }
            }

            // Purpose: Display player list
            System.out.println("  Players on team: " + lPlayerOutput.toString());

            // Purpose: Ask user to continue
            System.out.print("  Do you want to enter another team? (yes/no): ");
            String lUserChoice = lScanner.nextLine();

            if (!lUserChoice.equalsIgnoreCase("yes")) {
                lContinueProgram = false;
            }

            System.out.println();
        }

        lScanner.close();
    }
}
