package testRouleTaBoule.elements;

import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Texture extends JPanel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Image limite;
	private Image mur;
	private Image piege;
	private Image boule;
	private Image vide;

	// ========== CONSTRUCTEUR ============

	public Texture() {
		super();
		try {
			this.limite = ImageIO.read(new File("limite.jpg"));
			this.mur = ImageIO.read(new File("mur.jpg"));
			this.piege = ImageIO.read(new File("piege.jpg"));
			this.boule = ImageIO.read(new File("boule.png"));
			this.setVide(ImageIO.read(new File("vide.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//======== ACCESSEURS =======
	
	public Image getLimite() {
		return limite;
	}

	public Image getMur() {
		return mur;
	}

	public Image getPiege() {
		return piege;
	}

	public Image getBoule() {
		return boule;
	}

	public Image getVide() {
		return vide;
	}

	public void setVide(Image vide) {
		this.vide = vide;
	}

}
