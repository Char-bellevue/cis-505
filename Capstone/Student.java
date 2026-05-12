package Capstone;

/*
 * Natarajan, C. (2026). GradeBookApp Sprint 1 Student Class [Java source code].
 * Bellevue University.
 * CIS505-T301 Intermediate Java Programming.
 *
 * References
 * Liang, Y. D. (2019). Introduction to Java programming and data structures,
 *     comprehensive version (12th ed.). Pearson.
 * Oracle. (2024). Java programming documentation.
 *     https://docs.oracle.com/en/java/
 */

/*
 * This class stores student information for the GradeBookApp.
 * Input: Student information entered by the user.
 * Output: Student object data and formatted student records.
 */
public class Student {

    // Global variables for student information.
    private String gFirstName;
    private String gLastName;
    private String gCourse;
    private String gGrade;

    /*
     * This constructor creates an empty Student object.
     * Input: No input values.
     * Output: Empty Student object.
     */
    public Student() {
    }

    /*
     * This constructor creates a Student object with values.
     * Input: First name, last name, course, and grade.
     * Output: Fully initialized Student object.
     */
    public Student(String lFirstName,
                   String lLastName,
                   String lCourse,
                   String lGrade) {

        gFirstName = lFirstName;
        gLastName  = lLastName;
        gCourse    = lCourse;
        gGrade     = lGrade;
    }

    /*
     * This method returns the student first name.
     * Input: No input values.
     * Output: Student first name string.
     */
    public String getFirstName() {
        return gFirstName;
    }

    /*
     * This method sets the student first name.
     * Input: Student first name string.
     * Output: Updated first name field value.
     */
    public void setFirstName(String lFirstName) {
        gFirstName = lFirstName;
    }

    /*
     * This method returns the student last name.
     * Input: No input values.
     * Output: Student last name string.
     */
    public String getLastName() {
        return gLastName;
    }

    /*
     * This method sets the student last name.
     * Input: Student last name string.
     * Output: Updated last name field value.
     */
    public void setLastName(String lLastName) {
        gLastName = lLastName;
    }

    /*
     * This method returns the student course name.
     * Input: No input values.
     * Output: Student course name string.
     */
    public String getCourse() {
        return gCourse;
    }

    /*
     * This method sets the student course name.
     * Input: Student course name string.
     * Output: Updated course field value.
     */
    public void setCourse(String lCourse) {
        gCourse = lCourse;
    }

    /*
     * This method returns the student grade.
     * Input: No input values.
     * Output: Student grade string.
     */
    public String getGrade() {
        return gGrade;
    }

    /*
     * This method sets the student grade.
     * Input: Student grade string.
     * Output: Updated grade field value.
     */
    public void setGrade(String lGrade) {
        gGrade = lGrade;
    }

    /*
     * This method returns a comma-separated string of student data.
     * Input: No input values.
     * Output: Formatted string matching the CSV record format.
     */
    @Override
    public String toString() {
        return gFirstName + "," + gLastName + "," + gCourse + "," + gGrade;
    }

}