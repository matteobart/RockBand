/*
 * Drum.java
 */
package assign3;
/**
 * Represents a drum object and inherits Instrumet
 *
 */
public class Drum extends Instrument{
    /**
     * Constructor for the drum class takes one input for the number of notes
     * @param numNotes the number of different notes
     */
    public Drum(int numNotes){
        strings = new InstString[numNotes];
        for(int a = 0; a < numNotes; a++){
            strings[a] = new DrumString(440 * Math.pow(2, (double)(a-24)/(double)12));
        }
    }		    
}
