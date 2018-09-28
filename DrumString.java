/*
 * DrumString.java
 *
 */

package assign3;
import java.lang.Math;

/**
 * Represents a drum string and inherits the InstString class
 *
 */
public class DrumString extends InstString{

    /**
     * The main constructor for the DrumString method
     * @param frequency the frequency of the string (ex. 440 Hz)
     */
    public DrumString(double frequency) {
        super(frequency);
        for (int a = 0; a < capacity; a++){
            buffer.enqueue(0);
        }
    }
    /**
     * Constructor mainly for debugging
     * @param init an array that will be placed into the buffer
     */
    public DrumString(double[] init) {
        super(init.length);
        for (int a = 0; a < init.length; a++){
            buffer.enqueue(init[a]);
        }
    }
    /**
     * Simulates the string making noise as if just "plucked"
     *
     */
    public void pluck() {
        while(!buffer.isEmpty()){
            //System.out.println(buffer.getSize());
            buffer.dequeue();
        }
        for (int a = 0; a < capacity; a++){
            double val = Math.sin(1.0/(double)capacity);
            if (val > 0) buffer.enqueue(1);
            else buffer.enqueue(-1);
        }
        
    }
    
    /**
     * Simulates and updates the values in the buffer, slowly decaying them
     * Gives a ringing effect
     */
    public void tic() {
        double b = 0.5; //% chance that it will be negated
        double s = 0.6; //stretch factor; %chance it will be a low pass filter
        double ran1 = Math.random();
        double ran2 = Math.random();
        double val1 = buffer.dequeue();
        double val2 = buffer.peek();
        if (ran1 < s) {
            if (ran2 < b) buffer.enqueue(val1);
            else buffer.enqueue(-val1);
        } else {
            if (ran2 < b) buffer.enqueue((val1+val2)*.5);
            else buffer.enqueue((val1+val2)*-.5);
        }
        ticCount++;
    }
}
