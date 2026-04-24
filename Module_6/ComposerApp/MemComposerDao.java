package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). MemComposerDao.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements IComposerDao {

    private List<Composer> gComposers;

    public MemComposerDao() {
        gComposers = new ArrayList<>();

        gComposers.add(new Composer(1007, "Ludwig van Beethoven", "Classical"));
        gComposers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        gComposers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        gComposers.add(new Composer(1010, "Claude Debussy", "Impressionist"));
        gComposers.add(new Composer(1011, "Igor Stravinsky", "Modern"));
    }

    @Override
    public List<Composer> findAll() {
        return gComposers;
    }

    @Override
    public Composer findBy(Integer pId) {

        for (Composer lComposer : gComposers) {
            if (lComposer.getId() == pId) {
                return lComposer;
            }
        }

        return null;
    }

    @Override
    public void insert(Composer pComposer) {
        gComposers.add(pComposer);
    }
}