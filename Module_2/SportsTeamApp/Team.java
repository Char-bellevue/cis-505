package Module_2.SportsTeamApp;

/*
 * APA Citation:
 * Liang, Y. D. (2014). Introduction to Java Programming and Data Structures (Comprehensive Version).
 * Pearson Education.
 *
 * Assignment reference:
 * Instructions for Assignment 2.3 – Team Class Design.
 */

/**
 * Purpose:
 * This class represents a sports team with a team name and a list of players.
 *
 * Input:
 * Team name (String), player names (String via method calls).
 *
 * Output:
 * Provides access to team name, player list, and player count.
 */
public class Team {

    // Purpose: Stores the name of the team
    private String gTeamName;

    // Purpose: Stores the players in the team
    private String[] gPlayers;

    // Purpose: Tracks the number of players currently in the team
    private int gPlayerCount;

    // Constant: Default team size
    private static final int MAX_PLAYERS = 20;

    /**
     * Purpose:
     * Constructor to initialize the team with a name.
     *
     * Input:
     * teamName (String)
     *
     * Output:
     * Initializes team object with default values.
     */
    public Team(String teamName) {
        this.gTeamName = teamName;
        this.gPlayers = new String[MAX_PLAYERS];
        this.gPlayerCount = 0;
    }

    /**
     * Purpose:
     * Adds a player to the team.
     *
     * Input:
     * playerName (String)
     *
     * Output:
     * Updates players array and increments player count.
     */
    public void addPlayer(String playerName) {
        if (gPlayerCount < MAX_PLAYERS) {
            gPlayers[gPlayerCount] = playerName;
            gPlayerCount++;
        }
    }

    /**
     * Purpose:
     * Returns the list of players.
     *
     * Input:
     * None
     *
     * Output:
     * String array of players.
     */
    public String[] getPlayers() {
        return gPlayers;
    }

    /**
     * Purpose:
     * Returns the number of players.
     *
     * Input:
     * None
     *
     * Output:
     * Integer player count.
     */
    public int getPlayerCount() {
        return gPlayerCount;
    }

    /**
     * Purpose:
     * Returns the team name.
     *
     * Input:
     * None
     *
     * Output:
     * String team name.
     */
    public String getTeamName() {
        return gTeamName;
    }
}
