package testRouleTaBoule.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class JCarte extends JPanel{
	
	/**
	 * 
	 */
	
	public Fenetre fenetre;
	public JLayeredPane layeredPane;
	private JPanel panMap;
	private JLabel imageMap;

	private static final long serialVersionUID = 1L;
	
	//======== Constructeur ==========
	
	public JCarte(){
		System.out.println("contructeur carte");
		dessine();
		fenetre = new Fenetre();
		
		imageMap = new JLabel(new ImageIcon("fondCarte.PNG"));
		imageMap.setBounds(0, 0,imageMap.getIcon().getIconWidth(),imageMap.getIcon().getIconHeight());
		
		panMap = new JPanel();
		panMap.setLayout(null);
		panMap.setBounds(0, fenetre.mnuMenuBar.getHeight(),imageMap.getIcon().getIconWidth(),imageMap.getIcon().getIconHeight());
		panMap.add(imageMap);
		
		layeredPane = fenetre.getLayeredPane();
		layeredPane.add(panMap, new Integer(0));
	}
	
	//Dessine dans un buffer l'image avant de la créé en tant que fichier
	
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
	
	// Créé un fichier jpg à partir du générateur de carte
	
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
