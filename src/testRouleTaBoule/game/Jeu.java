package testRouleTaBoule.game;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;
import testRouleTaBoule.sound.Sound;
import testRouleTaBoule.window.GenerateurCoordCarte;
import testRouleTaBoule.window.JCarte;

public class Jeu {

	private JCarte carte;
	private ElementBoule boule;
	private GenerateurCoordCarte map = new GenerateurCoordCarte();
	private JLabel imgBoule;
	public static JLabel hitBox;
	
	private Thread thread;

	Graphics g;

	public static boolean run = false;

	public Jeu() {
		run = true;
		carte = new JCarte();
		boule = new ElementBoule(new Coordonnees(GenerateurCoordCarte.startX, GenerateurCoordCarte.startY));
		imgBoule = new JLabel();

		imgBoule.setIcon(new ImageIcon(boule.getImage()));
		imgBoule.setBounds(GenerateurCoordCarte.startX, GenerateurCoordCarte.startY, ElementBoule.BOULE_WIDTH,
				ElementBoule.BOULE_HEIGHT);

		carte.layeredPane.add(imgBoule, new Integer(1));

	}

	public void boucle() {

		int fps = 70;
		double timePerTick = 1000000000 / fps; // en nanoseconde
		double delta = 0; // valeur utilis� pour le rendu, on met a jour et on
							// reaffiche seulement lorsqu'elle vaut 1 ou plus
		long now; // temps actuel
		long lastTime = System.nanoTime(); // dernier temps relev�
		long timer = 0; // le temps qui s'est ecoul� entre maintenant et le
						// dernier temps relev�
		// int ticks = 0;

		while (run) {

			if (Sound.Smenu == true) {
				if (Sound.isPlayingMenu) {

				} else {
					Sound.playMenu();
				}

			}
			if (Sound.Sjeu == true) {
				if (Sound.isPlayingJeu) {

				} else {
					Sound.stopMenu();
					Sound.playTheme();
				}

			}
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				boule.getInput();
				imgBoule.setBounds(boule.getCoord().getX(),
						boule.getCoord().getY() + carte.fenetre.mnuMenuBar.getHeight(), ElementBoule.BOULE_WIDTH,
						ElementBoule.BOULE_HEIGHT);

				carte.layeredPane.repaint();

				delta--;
			}
			timer = timer % 1000000000;

		}

	}

}