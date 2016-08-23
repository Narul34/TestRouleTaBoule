package testRouleTaBoule.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EntreeClavier implements KeyListener {

	public static boolean haut,bas,gauche,droite;
	
	@Override
	public void keyPressed(KeyEvent e) {

		// Fleche du haut
		if (e.getKeyCode() == 38) {
			haut = true;
				System.out.println("Vers le haut");
		}

		// Fleche de gauche
		else if (e.getKeyCode() == 37) {
			System.out.println("Vers la gauche");
			gauche = true;

		}
		// Fleche de droite
		else if (e.getKeyCode() == 39) {
			System.out.println("Vers la droite");
			droite = true;

		}
		// Fleche de bas
		else if (e.getKeyCode() == 40) {
			System.out.println("Vers le bas");
			bas = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Fleche du haut
				if (e.getKeyCode() == 38) {
					System.out.println("relacher haut");
					haut = false;
				}

				// Fleche de gauche
				else if (e.getKeyCode() == 37) {
					System.out.println("relacher gauche");
					gauche = false;

				}
				// Fleche de droite
				else if (e.getKeyCode() == 39) {
					System.out.println("relacher droite");
					droite = false;

				}
				// Fleche de bas
				else if (e.getKeyCode() == 40) {
					System.out.println("relacher bas");
					bas = false;

				}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
