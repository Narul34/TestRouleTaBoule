package testRouleTaBoule.sound;


import java.io.File;

import javax.sound.sampled.*;

public class Sound {
    private AudioFormat format;
    static Clip clip = null;
    /**
     * 
     * @param filename le lien vers le fichier song (URL ou absolute path)
     */

    public static void play(){
    	System.out.println("before try");
    	try{
    		System.out.println("Sound is going to be played");
    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("zic/theme.wav"));
    	clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
         clip.loop(Clip.LOOP_CONTINUOUSLY);
         System.out.println("Sound is playing");
        }
        catch(Exception ex)
        {
          System.out.println("Error with playing sound.");
          ex.printStackTrace();
        }
    }
    
    public static void stop(){
    	clip.stop();
    	 System.out.println("Sound is stopping");
    }
}
