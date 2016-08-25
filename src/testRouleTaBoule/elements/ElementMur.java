package testRouleTaBoule.elements;

import testRouleTaBoule.graphics.ImagesSprites;

public class ElementMur extends Element {

	public ElementMur(Coordonnees coord) {
		super(coord, ImagesSprites.mur);
	}

	public boolean isSolid() {
		return true;
	}

}
