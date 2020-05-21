// DONE: Make sure to make this class a part of the synthesizer package
package synthesizer;
//import org.omg.CORBA.Object;
import java.util.Iterator;

//DONE: Make sure to make this class and all of its methods public
//DONE: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        fillCount = 0;
        first = 0;
        last = 0;

        // DONE: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else {
            rb[last] = x;
            /** better way */
            last = (last + 1) % capacity;
            /** normal way */
//        if (fillCount == 0) {
//            rb[first] = x;
//        } else {
//            last = last + 1;
//            if (last > capacity - 1) {
//                last = 0;
//            }
//            rb[last] = x;
//
//        }
            fillCount += 1;
            // DONE: Enqueue the item. Don't forget to increase fillCount and update last.

        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T returnItem = rb[first];
        /** better way */
        first = (first + 1) % capacity;
        /** normal way */
//        if (first == capacity - 1) {
//            first = 0;
//            fillCount = fillCount - 1;
//            return  returnItem;
//        }
//        first = first + 1;

        fillCount = fillCount - 1;
        return  returnItem;
        // DONE: Dequeue the first item. Don't forget to decrease fillCount and update
    }


    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            return rb[first];
            // DONE: Return the first item. None of your instance variables should change.
        }

    }

//    public void empty() {
//        fillCount = 0;
//
//    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<T> {
        private int num = first;
        @Override
        public boolean hasNext() {
            /** not a good way 1 */
//            if (first == last && fillCount == capacity) {
//                return false;
//            } else {
//                return true;
//            }
            /** not a good way 2 */
//            boolean ans = first == last && fillCount == capacity;
//            return !ans;

            return first != last || fillCount != capacity;
        }

        @Override
        public T next() {
            T returnItem = rb[num];
            num += 1;
            return returnItem;
        }
    }

    // DONE: When you get to part 5, implement the needed code to support iteration.
}
