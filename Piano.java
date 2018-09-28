/*
 * Piano.java
 */

package assign3;


public class Piano extends Instrument{

    private static InstString[][] pStrings; //2D array of strings
    
    /**
     * Constructor for the Piano class
     * @param numNotes the number of notes to be represented
     */
    public Piano(int numNotes){
        pStrings = new InstString[numNotes][3];
        for(int a = 0; a < numNotes; a++){
            double freq = 440 * Math.pow(2, (double)(a-24)/(double)12);
            pStrings[a][0] = new GuitarString(freq);
            pStrings[a][1] = new GuitarString(freq + .45);
            pStrings[a][2] = new GuitarString(freq - .45);
        }
    }
    
    /**
     * Will play a note based on the input
     * @param i the index of the string in the array
     */
    @Override
    public void playNote(int index){
        for (int a = 0; a <3; a++){
            pStrings[index][a].pluck();
        }
    }
    /**
     * Samples and tics all of the strings
     * @returns the sample of all of the strings
     */
    @Override
    public double ringNotes(){
        double ret = 0;
        for (int i = 0; i < pStrings.length; i++){
            for (int a = 0; a < pStrings[i].length; a++){
                pStrings[i][a].tic();
                ret += pStrings[i][a].sample();
            
            }
        }
        return ret;
    }
			    

}
