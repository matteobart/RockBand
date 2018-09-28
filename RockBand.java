/*
 * RockBand.java
 *
 */

package assign3;
import cos126.StdDraw;
import cos126.StdAudio;
import java.io.*;
import java.util.ArrayList;
/**
 * A super cool rockband that will play super cool music
 * A RockBand class that has multiple Instruments
 */
public class RockBand {
    /**
     * Lets you use all of the insruments at one through terminal
     * If left with no arguments the user uses the keyboard to play sounds
     * Or can play textfiles by making args[0] equal to "-play_from_file"
     * and args[1] to the name of the textfile (with the extension)
     */
    public static void main(String[] args) {
        Instrument[] instruments = {new Guitar(37), new Bass(37), new Piano(37), new Drum(19)};
        String guitarBassKeyboard = "`1234567890-=qwertyuiop[]\\asdfghjkl;'";
        String pianoKeyboard = "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"";
        String drumKeyboard = "ZXCVBNM<>?zxcvbnm,.";
        boolean lowMode = false;

        if (args.length != 0 && args[0].equals("-play_from_file")){
            File file = new File(args[1]);
            BufferedReader reader = null;
            ArrayList<String> list = new ArrayList<String>();
            try {
                reader = new BufferedReader(new FileReader(file));
                String text = null;
                
                while ((text = reader.readLine()) != null) {
                    String[] add = text.split(" ");
                    for (String thing: add){
                        if (!thing.equals("\n") || !thing.equals("")) list.add(thing);
                    }
                }
                reader.close();

            } catch (Exception e){
                System.out.println("Exception Occured");
            }
            int currentSpeed = 6000;
            for (String word: list){
                if (word.contains("@@")) System.out.println(word.replace("@@",""));
                else if (word.contains("##")) currentSpeed = Integer.parseInt(word.replace("##",""));
                else if (word.equals("/")) {
                    for (int a = 0; a < currentSpeed; a++){
                        double total = 0;
                        for (Instrument i: instruments) {
                            total += i.ringNotes();
                        }
                        StdAudio.play(total);
                    }
                }
                else {
                    //System.out.println(word);
                    word = word.replace("LL", "*").replace("/","&");
                    for (char c: word.toCharArray()){
                        if (c == '*') lowMode = true;
                        if (c == '&') lowMode = false;
                        int val = guitarBassKeyboard.indexOf(c);
                        if (val != -1){
                            if (lowMode = false) instruments[0].playNote(val);
                            else instruments[1].playNote(val);
                        }
                        
                        val = pianoKeyboard.indexOf(c);
                        if (val != -1){
                            instruments[2].playNote(val);
                        }
                        
                        val = drumKeyboard.indexOf(c);
                        if (val != -1){
                            instruments[3].playNote(val);
                        }
                    
                    }
                    
                    for (int a = 0; a < currentSpeed; a++){
                        double total = 0;
                        for (Instrument i: instruments){
                            total += i.ringNotes();
                        }
                        StdAudio.play(total);
                    }
                }
            }
            
        } else {
            while (true){
                if (StdDraw.hasNextKeyTyped()) {
                    char key = StdDraw.nextKeyTyped();
                    
                    if (key == '\n') {
                        lowMode = !lowMode;
                        System.out.println("s");
                    }
                    
                    int val = guitarBassKeyboard.indexOf(key);
                    if (val != -1){
                        if (lowMode = false) instruments[0].playNote(val);
                        else instruments[1].playNote(val);
                    }
                    
                    val = pianoKeyboard.indexOf(key);
                    if (val != -1){
                        instruments[2].playNote(val);
                    }
                    
                    val = drumKeyboard.indexOf(key);
                    if (val != -1){
                        instruments[3].playNote(val);
                    }
                }
                double sample = 0;
                for (Instrument i: instruments){
                    sample += i.ringNotes();
                }
                StdAudio.play(sample);
                
            }
            
        }
        
    }
}
