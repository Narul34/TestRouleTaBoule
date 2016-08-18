package testRouleTaBoule.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EntreeClavier implements KeyListener {

	
	@Override
	public void keyPressed(KeyEvent e) {

		// Fleche du haut
		if (e.getKeyCode() == 38) {
			System.out.println("Vers le haut");
			boule.move();
		}

		// Fleche de gauche
		else if (e.getKeyCode() == 37) {
			System.out.println("Vers la gauche");

		}
		// Fleche de droite
		else if (e.getKeyCode() == 39) {
			System.out.println("Vers la droite");

		}
		// Fleche de bas
		else if (e.getKeyCode() == 40) {
			System.out.println("Vers le bas");

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
