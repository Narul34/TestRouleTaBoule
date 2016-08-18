package testRouleTaBoule.window;

import java.awt.Graphics;

import javax.swing.JPanel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;

public class JCarte extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenerateurCoordCarte map = new GenerateurCoordCarte();
	private ElementBoule boule = new ElementBoule(new Coordonnees(GenerateurCoordCarte.startX,GenerateurCoordCarte.startY));
	
	public void paintComponent(Graphics g){
		System.out.println("Generation carte");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				// System.out.println(element[i][j].coordonnees.getX()+"
				// "+element[i][j].coordonnees.getY());
				g.drawImage(GenerateurCoordCarte.element[i][j].getImage(), GenerateurCoordCarte.element[i][j].getCoordonnees().getX(),
						GenerateurCoordCarte.element[i][j].getCoordonnees().getY(), this);
				g.drawImage(boule.getImage(), boule.getCoord().getX(), boule.getCoord().getY(), this);
			}
		}
	}
}
