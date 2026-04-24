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
    public Composer findById(Integer pId) {

        for (Composer lComposer : gComposers) {
            if (lComposer.getId() == pId) {
                return lComposer;
            }
        }

        return null;
    }

    @Override
    public boolean insert(Composer pComposer) {
        gComposers.add(pComposer);
        return true;
    }

    @Override
    public boolean update(Composer pComposer) {
        Composer lExisting = findById(pComposer.getId());
        if (lExisting != null) {
            lExisting.setName(pComposer.getName());
            lExisting.setGenre(pComposer.getGenre());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer pId) {
        Composer lComposer = findById(pId);
        if (lComposer != null) {
            gComposers.remove(lComposer);
            return true;
        }
        return false;
    }
}