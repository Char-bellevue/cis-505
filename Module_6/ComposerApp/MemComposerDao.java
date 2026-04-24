package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). MemComposerDao.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: This class represents the operations in a composer data persistence layer.
 * Input: Composer objects and Integer keys.
 * Output: Results of data persistence operations on the composer list.
 */
public class MemComposerDao implements ComposerDao {

    private List<Composer> gComposers;

    /**
     * Purpose: Default constructor initializes a default list of five composer objects.
     * Input: None.
     * Output: MemComposerDao object with a pre-populated composer list.
     */
    public MemComposerDao() {
        gComposers = new ArrayList<>();

        gComposers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        gComposers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        gComposers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        gComposers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        gComposers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    /**
     * Purpose: Returns all composer objects in the list.
     * Input: None.
     * Output: List of Composer objects.
     */
    @Override
    public List<Composer> findAll() {
        return gComposers;
    }

    /**
     * Purpose: Returns a single composer object matching the given id.
     * Input: Integer key representing the composer id.
     * Output: Matching Composer object or null if not found.
     */
    @Override
    public Composer findBy(Integer pKey) {

        for (Composer lComposer : gComposers) {
            if (lComposer.getId() == pKey) {
                return lComposer;
            }
        }

        return null;
    }

    /**
     * Purpose: Adds a new composer object to the list of composers.
     * Input: Composer entity to insert.
     * Output: None.
     */
    @Override
    public void insert(Composer pEntity) {
        gComposers.add(pEntity);
    }
}