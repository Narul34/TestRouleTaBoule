package testRouleTaBoule.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EntreeClavier implements KeyListener {

	private boolean[] touches;
	public boolean haut, bas, gauche, droite;
	
	public EntreeClavier() {
		touches = new boolean [256];
	}
	
	public void cycleTick() {
		haut = touches[KeyEvent.VK_Z];	
		bas = touches[KeyEvent.VK_S];	
		gauche = touches[KeyEvent.VK_Q];	
		droite = touches[KeyEvent.VK_D];	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		touches[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		touches[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

}
