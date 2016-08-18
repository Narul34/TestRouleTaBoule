package testRouleTaBoule.window;

import javax.swing.JFrame;

import testRouleTaBoule.input.EntreeClavier;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Fenetre() {
		this.setTitle("Roule ta Boule");
		this.setSize(930, 940);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new EntreeClavier());
		
		
	}
	
}
