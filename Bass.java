/*
 * Bass.java
 */
package assign3;
/**
 * Represents a Bass object
 * Extends the Instrument class
 *
 */
public class Bass extends Instrument{

    /**
     * Constructor that takes the number of notes wanted on the bass
     * @param numNotes the numbers of notes
     */
    
    public Bass(int numNotes){
        strings = new InstString[numNotes];
        for(int a = 0; a < numNotes; a++){
            strings[a] = new GuitarString(440 * Math.pow(2, (double)(a-48)/(double)12));
        }
    }		    
}
