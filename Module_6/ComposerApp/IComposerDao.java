
package Module_6.ComposerApp;
/*
 * Natarajan, C. (2026). IComposerDao.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

public interface IComposerDao {

    /**
     * Purpose: Find all composers.
     * Input: None.
     * Output: List of composers.
     */
    public java.util.List<Composer> findAll();

    /**
     * Purpose: Find a composer by id.
     * Input: Composer id.
     * Output: Composer object or null.
     */
    public Composer findById(Integer pId);

    /**
     * Purpose: Insert a new composer.
     * Input: Composer object.
     * Output: True if successful.
     */
    public boolean insert(Composer pComposer);

    /**
     * Purpose: Update an existing composer.
     * Input: Composer object.
     * Output: True if successful.
     */
    public boolean update(Composer pComposer);

    /**
     * Purpose: Delete a composer by id.
     * Input: Composer id.
     * Output: True if successful.
     */
    public boolean delete(Integer pId);
}