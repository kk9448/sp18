import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     *
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item: q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /** Returns a random item from the given queue. */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted  A Queue of unsorted items
     * @param pivot     The item to pivot on
     * @param less      An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are less than the given pivot.
     * @param equal     An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are equal to the given pivot.
     * @param greater   An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        // Your code here!
        for (Item x : unsorted) {
            if(x.compareTo(pivot) > 0) {
                greater.enqueue(x);
            } else if (x.compareTo(pivot) == 0) {
                equal.enqueue(x);
            } else {
                less.enqueue(x);
            }
        }
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        if (items.size() <= 1) { // Return `items` itself when `items.size() < 0` (Base case)
            return items;
        }
        // Your code here!
        Queue<Item> less = new Queue<>();
        Queue<Item> equal = new Queue();
        Queue<Item> greater = new Queue();
        partition(items, getRandomItem(items), less, equal, greater);
        Queue<Item> sortedLess = quickSort(less);
        Queue<Item> res = catenate(sortedLess, equal);
        Queue<Item> sortedGreater = quickSort(greater);
        res =catenate(res, sortedGreater);
        return res;
    }

    @Test
    public void test2() {
        Queue<String> students = new Queue<String>();
        Queue<String> rightAns = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");

        rightAns.enqueue("Alice");
        rightAns.enqueue("Ethan");
        rightAns.enqueue("Vanessa");
        Queue<String> res = quickSort(students);
        for (int i = 0; i < students.size(); i++) {
            assertEquals(rightAns.dequeue(), res.dequeue());
        }
        assertTrue(true);

    }
}
