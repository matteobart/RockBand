/*
 * Guitar.java
 */
package assign3;

/**
 * Represents a Guitar object and inherits from the Instrument class
 *
 */
public class Guitar extends Instrument{

    /**
     * Creates a guitar object based on the number of notes wanted
     * @param numNotes the number of different notes
     */
    public Guitar(int numNotes){
        strings = new InstString[numNotes];
        for(int a = 0; a < numNotes; a++){
            strings[a] = new GuitarString(440 * Math.pow(2, (double)(a-24)/(double)12));
        }
    }		    
}
