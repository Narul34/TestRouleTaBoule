package testRouleTaBoule.game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;
import testRouleTaBoule.window.Fenetre;
import testRouleTaBoule.window.GenerateurCoordCarte;
import testRouleTaBoule.window.JCarte;

public class Jeu {

	private JCarte carte; 
	private Fenetre fenetre;
	
	public Jeu(){
		carte = new JCarte();
		fenetre = new Fenetre();
		fenetre.setContentPane(carte);
		
		boucle();
	}
	
	public void boucle(){
		
		init();
		
		while(continuer){
			
		}
	}
	
}
