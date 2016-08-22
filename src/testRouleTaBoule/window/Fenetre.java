package testRouleTaBoule.window;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import testRouleTaBoule.input.EntreeClavier;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//************************************************************
		//Barre du menu
		JMenuBar mnuMenuBar = new JMenuBar();
		
		//options du menu
		JMenu mnuJeu  = new JMenu("Menu");
					
		JMenuItem mnuNouveau = new JMenuItem("Nouveau");
		JMenuItem mnuRestart = new JMenuItem("Restart");
		JMenuItem mnuQuitter = new JMenuItem("Quitter");
		
		JMenu mnuCarte = new JMenu("Cartes");
					
		JRadioButtonMenuItem mnuCarteSave1 = new JRadioButtonMenuItem("Labyrinthe #1");
		JRadioButtonMenuItem mnuCarteSave2 = new JRadioButtonMenuItem("Labyrinthe #2");
		JRadioButtonMenuItem mnuCarteSave3 = new JRadioButtonMenuItem("Labyrinthe #3");
		JRadioButtonMenuItem mnuCarteSave4 = new JRadioButtonMenuItem("Labyrinthe #4");
		
		ButtonGroup lesCartes = new ButtonGroup();
		
		JMenu mnuAide = new JMenu("Aide");
		
		
		JMenu mnuPropos = new JMenu("À Propos");
		//************************************************************
		
	public Fenetre() {
		this.setTitle("Roule ta Boule");
		this.setSize(917, 960);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new EntreeClavier());
		
		initMenu();
	}
	
public void initMenu(){
		
		
		mnuMenuBar.setBackground(Color.orange);
		mnuMenuBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));;
		mnuJeu.setMnemonic('M');
		
		mnuNouveau.setAccelerator(KeyStroke.getKeyStroke("alt shift N"));
		mnuNouveau.setMnemonic('N');
		mnuRestart.setAccelerator(KeyStroke.getKeyStroke("alt shift R"));
		mnuRestart.setMnemonic('R');
		mnuCarte.setMnemonic('C');
		mnuQuitter.setAccelerator(KeyStroke.getKeyStroke("alt F4"));
		mnuAide.setMnemonic('A');
		mnuPropos.setMnemonic('P');
		
		mnuCarteSave1.setAccelerator(KeyStroke.getKeyStroke("alt C 1"));
		mnuCarteSave2.setAccelerator(KeyStroke.getKeyStroke("alt C 2"));
		mnuCarteSave3.setAccelerator(KeyStroke.getKeyStroke("alt C 3"));
		mnuCarteSave4.setAccelerator(KeyStroke.getKeyStroke("alt C 4"));
		
		lesCartes.add(mnuCarteSave1);
		lesCartes.add(mnuCarteSave2);
		lesCartes.add(mnuCarteSave3);
		lesCartes.add(mnuCarteSave4);
		
		
		
		mnuCarte.add(mnuCarteSave1);
		mnuCarte.add(mnuCarteSave2);
		mnuCarte.add(mnuCarteSave3);
		mnuCarte.add(mnuCarteSave4);
		
		mnuJeu.add(mnuNouveau);
		mnuJeu.add(mnuRestart);
		mnuJeu.addSeparator();
		mnuJeu.add(mnuQuitter);
		mnuMenuBar.add(mnuJeu);
		mnuMenuBar.add(mnuCarte);
		mnuMenuBar.add(mnuAide);
		mnuMenuBar.add(mnuPropos);
		
		
		this.setJMenuBar(mnuMenuBar);
		
	}
	
}
