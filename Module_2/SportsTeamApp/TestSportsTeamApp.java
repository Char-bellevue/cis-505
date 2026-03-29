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
 * Displays number of players and player names for each team in formatted summary.
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

        // Purpose: Display welcome message at program start
        System.out.println("Welcome to the Sports Team App"+ "\n");
        //System.out.println(); // Blank line after welcome

        // Purpose: Controls program continuation
        boolean lContinueProgram = true;

        while (lContinueProgram) {

             // Purpose: Prompt user to enter a team name
            System.out.print("Enter a team name: ");
            String lTeamName = lScanner.nextLine();

            // Create Team object
            Team lTeam = new Team(lTeamName);

            // Purpose: Prompt user for player names with hint
            System.out.println("\nEnter the player names:");
            System.out.print("  hint: use commas for multiple players; no spaces>: ");
           // System.out.println(); // Blank line after player input
            String lPlayerInput = lScanner.nextLine();

            // Split input into array and add players
            String[] lPlayerArray = lPlayerInput.split(",");
            for (String player : lPlayerArray) {
                lTeam.addPlayer(player);
            }

            // Display team summary
            System.out.println("\n--Team Summary--");
            System.out.println("Number of players in team: " + lTeam.getPlayerCount());

            StringBuilder lPlayerOutput = new StringBuilder();
            String[] lPlayers = lTeam.getPlayers();
            for (int lPlayerIndex = 0; lPlayerIndex < lTeam.getPlayerCount(); lPlayerIndex++) {
                lPlayerOutput.append(lPlayers[lPlayerIndex]).append(",");
            }
            System.out.println("Players on team: " + lPlayerOutput.toString());

            // Ask user to continue or exit the program
            System.out.print("\nContinue? (y/n): ");
            String lUserChoice = lScanner.nextLine();
            if (lUserChoice.equalsIgnoreCase("y")) {
                System.out.println(); // Blank line before next team entry
            } else {
                lContinueProgram = false;
                System.out.println("\n\nEnd of line...");
            }

        }

        lScanner.close();
    }
}