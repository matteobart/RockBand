/*
 * InstString.java
 *
 */

package assign3;

/**
 * An abstract class representing a string
 *
 */
public abstract class InstString{
    protected RingBuffer buffer;
    protected int ticCount = 0;
    protected final double SAMPLING_RATE = 44100;
    protected int capacity;
    protected final double DECAY_RATE = .996;
    
    /**
     * Constructor for the InstString
     * @param frequency takes the frequency of the string
     */
    InstString(double frequency){
        capacity = (int) (SAMPLING_RATE/frequency);
        buffer = new RingBuffer(capacity);
    }
    
    /**
     * Alternate constuctor for the InstString
     * @param sizeOfBuffer the size of the buffer
     */
    InstString(int sizeOfBuffer){
        capacity = sizeOfBuffer;
        buffer = new RingBuffer(sizeOfBuffer);
    }

    
    public abstract void pluck();
    /**
     * Simulates and updates the values in the buffer, slowly decaying them
     * Gives a ringing effect
     * Make sure to ticCount++
     */
    public abstract void tic();

    /**
     * Shows the next value in the buffer
     * @returns the next value in the buffer
     */
    public double sample(){
	   return buffer.peek();
    }

    /**
     * Helps keep track of time
     * @returns the amount of times the tic method has been called
     */
    public int time(){
	   return ticCount;
    }

}
