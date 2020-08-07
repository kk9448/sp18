import edu.princeton.cs.algs4.Queue;
//import java.util.*;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    /** 返回类型为 Queue<Queue<Item>> 前面的<>括号, 声明Item继承了Comparable */


    private static <Item extends Comparable> Queue<Queue<Item>> makeSingleItemQueues(Queue<Item> items) {
        // DONE: Your code here!
        Queue<Queue<Item>> res = new Queue<>();
        for(Item x : items) {
            Queue<Item> q = new Queue<>();
            q.enqueue(x);
            res.enqueue(q);
        }
        return res;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(Queue<Item> q1, Queue<Item> q2) {
        //DONE: Your code here!
        Queue res = new Queue();
        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(q1.isEmpty()) {
                res.enqueue(q2.dequeue());
            } else if(q2.isEmpty()) {
                res.enqueue(q1.dequeue());
            } else {
                res.enqueue(getMin(q1, q2));
            }
        }
        return res;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(Queue<Item> items) {
        //DONE: Your code here!
        Queue<Queue<Item>> singleQueue = makeSingleItemQueues(items);
        items = singleQueue.dequeue();
        while(singleQueue.size() != 0) {
            items = mergeSortedQueues(items, singleQueue.dequeue());
        }
        return items;
    }

    @Test
    public void test1() {
        Queue<String> students = new Queue<String>();
        Queue<String> rightAns = new Queue<String>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");

        rightAns.enqueue("Alice");
        rightAns.enqueue("Ethan");
        rightAns.enqueue("Vanessa");
        Queue<String> res = mergeSort(students);
        for(int i = 0; i < students.size(); i++) {
            assertEquals(res.dequeue(), rightAns.dequeue());
        }
        assertTrue(true);

    }
}
