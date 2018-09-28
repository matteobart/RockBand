/*
 * Instrument.java
 */
package assign3;
/**
 * An abstract class the all instruments will inherit
 *
 */
public abstract class Instrument {
    /**
     * An array of each of the strings represented on the instrumet
     */
    protected  InstString[] strings;
 
    /**
     * Will play a note based on the input
     * @param i the index of the string in the array
     */
    public void playNote(int i){
        strings[i].pluck();
    }

    /**
     * Samples and tics all of the strings
     * @returns the sample of all of the strings 
     */
    public  double ringNotes(){
        double ret = 0;
        for (int a = 0; a < strings.length; a++){
            ret += strings[a].sample();
            strings[a].tic();

        }
        return ret;
    }

}
