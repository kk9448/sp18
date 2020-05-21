package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package
//package <package name>;

import synthesizer.BoundedQueue;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        double capacity = Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>((int) capacity);
        for (int i = 0; i < (int) capacity; i++ ) {
            buffer.enqueue(0.0);
        }
        buffer.empty();

        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        buffer.empty();
        for (int i = 0; i < buffer.capacity(); i++) {
//            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }

        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double a = buffer.dequeue();
        double b = buffer.peek();
        double newValue = ((a + b) *0.5) * DECAY;
        buffer.enqueue(newValue);


        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
        // TODO: Return the correct thing.
    }
}
