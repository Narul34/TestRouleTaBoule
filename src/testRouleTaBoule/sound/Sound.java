package testRouleTaBoule.sound;

import java.io.File;

import javax.sound.sampled.*;

public class Sound {
	static Clip clip = null;
	public static boolean isPlayingJeu = false;
	public static boolean isPlayingMenu = false;
	public static boolean Smenu = true;
	public static boolean Sjeu = false;

	/**
	 * 
	 * @param filename
	 *            le lien vers le fichier song (URL ou absolute path)
	 */

	public static void playMenu() {
		System.out.println("before try");
		try {
			System.out.println("Sound is going to be played");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("zic/menu.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			System.out.println("Sound is playing");
			isPlayingMenu = true;
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void stopMenu() {
		clip.stop();
		Smenu = false;
		isPlayingMenu = false;

		System.out.println("Sound is stopping");
	}

	public static void playTheme() {
		Sjeu = true;
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("zic/theme.wav"));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);

			isPlayingJeu = true;
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public static void stopTheme() {
		Sjeu = false;
		clip.stop();
		isPlayingJeu = false;

		System.out.println("Sound is stopping");
	}
}
