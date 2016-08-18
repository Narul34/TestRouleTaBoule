package testRouleTaBoule.elements;

public class ElementMur extends Element {

	public ElementMur(Coordonnees coord) {
		super(coord, texture.getMur());
	}
	
	public boolean isSolid() {
		return true;
	}

}
