package synthesizer;

public interface BoundedQueue<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();
    default boolean isEmpty() {
        return false;
    }      // is the buffer empty (fillCount equals zero)?
    default boolean isFull() {
        return false;
    }

    void empty();
}
