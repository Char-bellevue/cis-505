package Module_4.BowlingShopApp;

/*
 * Natarajan, C. (2026). BowlingShopApp [Java source code].
 * Reference:
 *     Liang, Y. D. (2019). Introduction to Java programming and data structures:
 *         Comprehensive version (12th ed.). Pearson.
 */

import java.util.LinkedList;

/**
 * Purpose: This class implements a generic queue data structure using a LinkedList.
 *          It provides enqueue, dequeue, and size operations for any object type.
 * Type Parameter: E - the type of elements held in this queue.
 */
public class GenericQueue<E> {

    // Private generic LinkedList that serves as the internal storage for the queue.
    private LinkedList<E> list = new LinkedList<>();

    /**
     * Purpose: Adds an item to the front of the queue (enqueue operation).
     * Input:   lItem - the item of generic type E to be added to the queue.
     */
    public void enqueue(E lItem) {
        list.addFirst(lItem);
    }

    /**
     * Purpose: Removes and returns the first item from the queue (dequeue operation).
     * Output:  The first item of generic type E removed from the queue.
     */
    public E dequeue() {
        return list.removeFirst();
    }

    /**
     * Purpose: Returns the current number of elements in the queue.
     * Output:  Integer representing the size of the internal list.
     */
    public int size() {
        return list.size();
    }
}