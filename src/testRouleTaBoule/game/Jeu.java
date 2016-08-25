package testRouleTaBoule.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;
import testRouleTaBoule.graphics.ImagesSprites;
import testRouleTaBoule.sound.Sound;
import testRouleTaBoule.window.GenerateurCoordCarte;
import testRouleTaBoule.window.JCarte;

public class Jeu implements Runnable {

	private JCarte carte;
	private ElementBoule boule;
	private GenerateurCoordCarte tabMap;
	private JLabel imgBoule;
	public static JLabel hitBox;

	private Thread thread;

	public static boolean running = false;

	public Jeu() {
		//ImagesSprites.init();
		tabMap = new GenerateurCoordCarte();
		carte = new JCarte();
		boule = new ElementBoule(new Coordonnees(GenerateurCoordCarte.startX, GenerateurCoordCarte.startY));

		imgBoule = new JLabel();
		imgBoule.setIcon(new ImageIcon(boule.getImage()));
		imgBoule.setBounds(GenerateurCoordCarte.startX, GenerateurCoordCarte.startY, ElementBoule.BOULE_WIDTH,
				ElementBoule.BOULE_HEIGHT);

		carte.layeredPane.add(imgBoule, new Integer(1));

	}

	public void run() {
		int fps = 70;
		double timePerTick = 1000000000 / fps; // en nanoseconde
		double delta = 0; // valeur utilisé pour le rendu, on met a jour et on
							// reaffiche seulement lorsqu'elle vaut 1 ou plus
		long now; // temps actuel
		long lastTime = System.nanoTime(); // dernier temps relevé
		long timer = 0; // le temps qui s'est ecoulé entre maintenant et le
						// dernier temps relevé
		// int ticks = 0;

		while (running) {

			if (Sound.Smenu) {
				if (Sound.isPlayingMenu) {

				} else {
					Sound.playMenu();
				}

			}
			if (Sound.Sjeu) {
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

	public void start() {
		if (running == true) {
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	/*
	 * public synchronized void stop() { if (!running) return; running = false;
	 * try { thread.join(); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}