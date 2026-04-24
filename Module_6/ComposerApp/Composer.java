package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). Composer.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */


/**
 * Purpose: This class represents a composer object.
 * Input: Composer id, name, and genre values.
 * Output: A Composer object and formatted string representation.
 */
public class Composer {

    private int gId;
    private String gName;
    private String gGenre;

    /**
     * Purpose: Default constructor initializes empty composer.
     * Input: None.
     * Output: Default Composer object.
     */
    public Composer() {
        this.gId = 0;
        this.gName = "";
        this.gGenre = "";
    }

    /**
     * Purpose: Constructor initializes all data fields.
     * Input: Composer id, name, and genre.
     * Output: Initialized Composer object.
     */
    public Composer(int pId, String pName, String pGenre) {
        this.gId = pId;
        this.gName = pName;
        this.gGenre = pGenre;
    }

    /**
     * Purpose: Returns composer id.
     * Input: None.
     * Output: Integer id.
     */
    public int getId() {
        return gId;
    }

    /**
     * Purpose: Sets composer id.
     * Input: Integer id.
     * Output: None.
     */
    public void setId(int pId) {
        this.gId = pId;
    }

    /**
     * Purpose: Returns composer name.
     * Input: None.
     * Output: String name.
     */
    public String getName() {
        return gName;
    }

    /**
     * Purpose: Sets composer name.
     * Input: String name.
     * Output: None.
     */
    public void setName(String pName) {
        this.gName = pName;
    }

    /**
     * Purpose: Returns composer genre.
     * Input: None.
     * Output: String genre.
     */
    public String getGenre() {
        return gGenre;
    }

    /**
     * Purpose: Sets composer genre.
     * Input: String genre.
     * Output: None.
     */
    public void setGenre(String pGenre) {
        this.gGenre = pGenre;
    }

    /**
     * Purpose: Returns formatted string representation.
     * Input: None.
     * Output: Formatted string.
     */
    @Override
    public String toString() {
        return "Composer{" +
                "id=" + gId +
                ", name='" + gName + '\'' +
                ", genre='" + gGenre + '\'' +
                '}';
    }
}