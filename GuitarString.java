/*
 * GuitarString.java
 * 
 */

package assign3;
import java.lang.Math;
/**
 * Represents a string of a guitar and inherits InstString
 *
 */
public class GuitarString extends InstString{
    /**
     * Constructor that takes the frequency of the string
     * @param frequency the frequency of the string
     */
    public GuitarString(double frequency) {	
	   super(frequency);
        for (int a = 0; a < capacity; a++){
            buffer.enqueue(0);
        }
    }
    
    /**
     * Constructor that is used only for debugging
     * @param init the values that will be placed into the buffer
     */
    public GuitarString(double[] init) {
        super(init.length);
    	for (double a: init){
    	    buffer.enqueue(a);
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
        //System.out.println(buffer.getSize());
       for (int a = 0; a < capacity; a++){
            double r = Math.random() -.5; //should be .5)
            buffer.enqueue(r);
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
    /**
     * Main method that tests the guitar string
     *
     */
       public static void main(String[] args) {
            int N = Integer.parseInt(args[0]); 
            double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };
            GuitarString testString = new GuitarString(samples);       
            for (int i = 0; i < N; i++) {           
                int t = testString.time();           
                double sample = testString.sample();           
                System.out.printf("%6d %8.4f\n", t, sample);           
                testString.tic();       
            }   
        } 

}
