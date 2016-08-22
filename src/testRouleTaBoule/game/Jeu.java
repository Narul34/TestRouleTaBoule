package testRouleTaBoule.game;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;
import testRouleTaBoule.window.Fenetre;
import testRouleTaBoule.window.GenerateurCoordCarte;
import testRouleTaBoule.window.JCarte;

public class Jeu {

	private JCarte carte; 


	public static boolean run = false;
	
	public Jeu(){
		run = true;
		carte = new JCarte();
	}
	
	public void boucle(){

		while (run){
			System.out.println("update");
			
			
			
		}
		
	}
}