package testRouleTaBoule.elements;

public class ElementLimite extends Element {


	public ElementLimite(Coordonnees coord) {
		super(coord, texture.getLimite());
	}
	public boolean isSolid(){
		return true;
		
	}

}
