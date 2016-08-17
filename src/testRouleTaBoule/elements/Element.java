package testRouleTaBoule.elements;

import java.awt.Image;

// Element du décors, caractérisé par des coorodonnees, une taille et une image.

public class Element {

	public static final int ELEMENT_WIDTH = 30;
	public static final int ELEMENT_HEIGHT = 30;

	private Coordonnees coordonnees;
	private Image image;

	// ========== CONSTRUCTEUR ============

	public Element(Coordonnees coordonnees, Image image) {
		super();
		this.setCoordonnees(coordonnees);
		this.setImage(image);
	}

	// =========== ACCESSEURS ===========
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

}
