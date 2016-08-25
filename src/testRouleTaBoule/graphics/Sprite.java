package testRouleTaBoule.graphics;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;

	public Sprite(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage decoupe(int x, int y, int width, int height) {
		return image.getSubimage(x, y, width, height);
	}
}
