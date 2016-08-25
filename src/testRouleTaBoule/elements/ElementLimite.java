package testRouleTaBoule.elements;

import testRouleTaBoule.graphics.ImagesSprites;

public class ElementLimite extends Element {

	public ElementLimite(Coordonnees coord) {
		super(coord, ImagesSprites.limite);
	}

	public boolean isSolid() {
		return true;

	}

}
