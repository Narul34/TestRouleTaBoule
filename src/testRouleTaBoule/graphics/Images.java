package testRouleTaBoule.graphics;

import java.awt.image.BufferedImage;

public class Images {

	
	// On a besoin d'une largeur et d'une hauteur fixe
		private static final int width = 30, height = 30;

		// Indice pour parcourir l'image a decouper
		private static int indiceX = 0;

		// nombre d'�l�ment � afficher except� la boule
		private static int nbElement = 4;

		// Tableau d'image pour la boule (6 imagesp our l'instant)
		public static BufferedImage[] boule = new BufferedImage[6];

		// les images des "tiles"
		public static BufferedImage vide;
		public static BufferedImage mur;
		public static BufferedImage limite;
		public static BufferedImage piege;
		
		public static void init() {
			Sprite image = new Sprite(ChargeImage.loadImage("/textures/boule_mobile.jpg")); // on charge l'image dans un ojbet Sprite

			// on d�coupe l'image pour la boule (premiere image a x=0 et y = 0
			for (int i = 0; i < boule.length; i++) {
				boule[i] = image.decoupe(indiceX, 0, width, height);
				indiceX += width;
			}
			indiceX = 0; // indice remis � 0 car les images des "tiles" commence en x =0 et y = 150

			// on decoupe l'image pour r�cup�r� les "tiles" ou �l�ments
			for (int i = 0; i < nbElement; i++) {
				switch (i) {
				case 0:
					limite = image.decoupe(indiceX, 150, width, height);
					break;
				case 1:
					mur = image.decoupe(indiceX, 150, width, height);
					break;
				case 2:
					piege = image.decoupe(indiceX, 150, width, height);
					break;
				case 3:
					vide = image.decoupe(indiceX, 150, width, height);
					break;
				default:
					;
				}
				indiceX += width;
			}

		}
}
