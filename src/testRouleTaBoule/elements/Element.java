package testRouleTaBoule.elements;

import java.awt.Image;


// Element du décors, caractérisé par des coorodonnees, une taille et une image.

public class Element {
	
	public static final int ELEMENT_WIDTH = 30;
	public static final int ELEMENT_HEIGHT = 30;

	protected Coordonnees coord;
	protected Image image;

	protected static Texture texture = new Texture();
	
	// ========== CONSTRUCTEUR ============

	public Element(Coordonnees coord, Image image) {
		this.image = image;
		this.coord = coord;
	}

	// =========== ACCESSEURS ===========
	
	public boolean isSolid() {
		return false;
	}
	
	public Coordonnees getCoord() {
		return coord;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public Coordonnees getCoordonnees() {
		return coord;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coord = coordonnees;
	}
}
