package testRouleTaBoule.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import testRouleTaBoule.sound.Sound;

public class EntreeClavier implements KeyListener {

	public static boolean haut, bas, gauche, droite;

	@Override
	public void keyPressed(KeyEvent e) {

		// Fleche du haut
		if (e.getKeyCode() == 38) {
			haut = true;
			Sound.Sjeu = true;
		}

		// Fleche de gauche
		else if (e.getKeyCode() == 37) {
			gauche = true;

		}
		// Fleche de droite
		else if (e.getKeyCode() == 39) {
			droite = true;

		}
		// Fleche de bas
		else if (e.getKeyCode() == 40) {
			bas = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Fleche du haut
		if (e.getKeyCode() == 38) {
			haut = false;
		}

		// Fleche de gauche
		else if (e.getKeyCode() == 37) {
			gauche = false;

		}
		// Fleche de droite
		else if (e.getKeyCode() == 39) {
			droite = false;

		}
		// Fleche de bas
		else if (e.getKeyCode() == 40) {
			bas = false;

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
