package testRouleTaBoule.elements;

// Classe qui g�n�re des entiers x et y correspondant aux coordonn�es d'un objet.
public class Coordonnees {
	private Integer x;
	private Integer y;

	// ========== CONSTRUCTEUR ============

	public Coordonnees(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}

	// ========== ACCESSEURS ============

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
