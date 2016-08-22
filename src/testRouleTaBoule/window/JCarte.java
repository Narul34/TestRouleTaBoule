package testRouleTaBoule.window;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import testRouleTaBoule.elements.Coordonnees;
import testRouleTaBoule.elements.ElementBoule;

public class JCarte extends JPanel{
	
	/**
	 * 
	 */
	
	Fenetre fenetre;
	Fenetre dessinMap;
	Graphics g;
	private JPanel panMap;
	JLabel imageMap;
	
	
	public JPanel getPanMap() {
		return panMap;
	}


	public void setPanMap(JPanel panMap) {
		this.panMap = panMap;
	}

	private static final long serialVersionUID = 1L;
	private GenerateurCoordCarte map = new GenerateurCoordCarte();
	private ElementBoule boule = new ElementBoule(new Coordonnees(GenerateurCoordCarte.startX,GenerateurCoordCarte.startY));
	
	public JCarte(){
		System.out.println("contructeur carte");
		fenetre = new Fenetre();
		dessine();
		this.imageMap = new JLabel(new ImageIcon("fondCarte.PNG"));
		panMap = new JPanel();
		panMap.add(imageMap);
		fenetre.setContentPane(panMap);

		
	}
	
	
	public Fenetre getFenetre() {
		return fenetre;
	}


	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}


	public void dessine(){
		//dessinMap = new Fenetre();
		BufferedImage bI = new BufferedImage(900,900,BufferedImage.TYPE_3BYTE_BGR); 
		System.out.println("Generation carte dans un fichier temporaire");
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				bI.getGraphics().drawImage(GenerateurCoordCarte.element[i][j].getImage(), GenerateurCoordCarte.element[i][j].getCoordonnees().getX(),
						GenerateurCoordCarte.element[i][j].getCoordonnees().getY(), this);
			}
		}
		saveJPG(bI);
	}
	
	public void saveJPG(BufferedImage buff){
		System.out.println("Creation du fichier image");
		try {
		File f = new File("fondCarte.PNG");
		FileOutputStream fichier = new FileOutputStream(f);
		ImageIO.write(buff, "PNG", fichier);
		fichier.close();
		} catch (Exception e) {
		System.out.println(e.getMessage());
		} 
	}
	
		
	
}
