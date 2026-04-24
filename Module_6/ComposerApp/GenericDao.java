package Module_6.ComposerApp;

/*
 * Natarajan, C. (2026). GenericDao.java [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

/**
 * Purpose: This interface represents the operations in a data persistence layer.
 * Input: Generic entity type E and key type K.
 * Output: Generic DAO operations for any entity.
 */
public interface GenericDao<E, K> {

    /**
     * Purpose: Find all entities.
     * Input: None.
     * Output: List of entities.
     */
    java.util.List<E> findAll();

    /**
     * Purpose: Find a single entity by its key.
     * Input: Key value.
     * Output: Entity object or null.
     */
    E findBy(K key);

    /**
     * Purpose: Insert a new entity.
     * Input: Entity object.
     * Output: None.
     */
    void insert(E entity);
}