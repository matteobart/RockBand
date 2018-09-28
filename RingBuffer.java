/*****************************************************************************
 *
 *  This is a template file for RingBuffer.java. It lists the constructors and
 *  methods you need, along with descriptions of what they're supposed to do.
 *  
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 *****************************************************************************/
package assign3;
/**
 * A type of data structure that holds values in a "circular" fashion
 * Has a fixed capacity and works as FILO
 *
 */
public class RingBuffer {
    private int first;            // index of first item in buffer
    private int last;             // index of last item in buffer
    private int size;             // current number of items of buffer
    private double[] buffer;

    /**
     * Creates an empty buffer, with given max capacity
     * @param capacity the maximum numbers of elements the buffer can hold
     */
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
	buffer = new double[capacity];

    }

    /**
     * returns the number of items currently in the buffer
     * @returns the number of items in the buffer
     */
    public int getSize() {
        // YOUR CODE HERE
        return size;
    }

    /**
     * Determines whether the buffer is storing any values
     * @returns whether the buffer size is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns whether the buffer is full of values
     * @returns whether of not the buffer is at maximum capacity
     */
    public boolean isFull() {
        return size == buffer.length;
    }

    /**
     * Adds an item to the end of the buffer
     * Be sure to check if the buffer is full
     * @param x the value to be added to the buffer
     */
    public void enqueue(double x) {
        if (isFull()) { throw new RuntimeException("Ring buffer overflow"); }
        size++;
        buffer[last] = x;
        last++;
        if (last == buffer.length) last = 0;
	
    }

    /**
     * Delete and return the item in the the front of the buffer (first item)
     * @returns the first item
     */
    public double dequeue() {
        if (isEmpty()) { throw new RuntimeException("Ring buffer underflow"); }
        // YOUR CODE HERE
        size--;
        double ret = buffer[first];
        buffer[first] = 0; //you don't need to do this
        first++;
        if (first == buffer.length) first = 0; //might cause an error p. not
        return ret;
    }

    /**
     * return (but do not delete) item from the front
     * @returns the first item
     */
    public double peek() {
        if (isEmpty()) { throw new RuntimeException("Ring buffer underflow"); }
        return buffer[first];
    }
    /**
     *
     * a simple test of the constructor and methods in RingBuffer
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
	   
	}
		double t = buffer.dequeue();
		buffer.enqueue(t);
		System.out.println("Size after wrap-around is " 
				   + buffer.getSize());
        while (buffer.getSize() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }
}



