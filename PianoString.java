/*
 * PianoString.java
 *
 */

package assign3;
import java.lang.Math;

/**
 * Represents a piano string and inherits the InstString class
 *
 */
public class PianoString extends InstString {
    /**
     * The main constructor for the PianoString method
     * @param frequency the frequency of the string (ex. 440 Hz)
     */
    public PianoString(double frequency) {
        super(frequency);
        for (int a = 0; a < capacity; a++){
            buffer.enqueue(0);
        }
    }
    
    /**
     * Constructor mainly for debugging
     * @param init an array that will be placed into the buffer
     */
    public PianoString(double[] init) {
        super(init.length);
        for (int a = 0; a < capacity; a++){
            buffer.enqueue(init[a]);
        }
    }
    /**
     * Simulates the string making noise as if just "plucked"
     *
     */
    public void pluck() {
        int s = buffer.getSize();
        for(int a = 0; a < s; a++){
           double num = buffer.dequeue();
            //System.out.println(num);
            if ((a < (7.0/16.0) * (double) s) || (a > (9.0/16.0)*(double)s)){
                buffer.enqueue(0);
            } else {
                buffer.enqueue(.25*Math.sin(8*Math.PI*((a/(double)s)-(7.0/16.0))));
            }
        }
    }
    /**
     * Simulates and updates the values in the buffer, slowly decaying them
     * Gives a ringing effect
     */
    public void tic() {	
        ticCount++;
        double val1 = buffer.dequeue();
        double val2 = buffer.peek();
        double add = DECAY_RATE * ((val1 + val2)/2);
        buffer.enqueue(add);
    }

}
