package testRouleTaBoule.elements;

import java.awt.Image;
import java.awt.Rectangle;

import testRouleTaBoule.input.EntreeClavier;
import testRouleTaBoule.window.GenerateurCoordCarte;

public class ElementBoule {

	public static final int BOULE_WIDTH = 30;
	public static final int BOULE_HEIGHT = 30;
	public static final float VITESSE_PAR_DEFAUT = 3.0f;

	private Coordonnees coord;
	private int width, height;
	private Image image;

	private float speed;
	private float xMove;
	private float yMove;

	private Texture texture = new Texture();

	private Rectangle collisionBox;

	public ElementBoule(Coordonnees coord) {
		this.image = texture.getBoule();
		this.coord = coord;
		this.width = BOULE_WIDTH;
		this.height = BOULE_HEIGHT;
		this.speed = VITESSE_PAR_DEFAUT;

		collisionBox = new Rectangle();
		collisionBox.x = 2;
		collisionBox.y = 2;
		collisionBox.width = 26;
		collisionBox.height = 26;

	}

	// Fonction de mouvement d'une creature
	public void move() {

		// moveXbis();
		// moveYbis();
		moveX();
		moveY();
	}

	public void moveXbis() {
		if (xMove > 0)
			coord.setX((int) (coord.getX() + xMove));
		else if (xMove < 0) {

			coord.setX((int) (coord.getX() + xMove));
		}

	}

	public void moveYbis() {
		coord.setY((int) (coord.getY() + yMove));
	}

	public void moveX() {

		// si on bouge vers la droite
		if (xMove > 0) {

			// coordonnées x future = coordonnee x de la partie extreme droite
			// de la hitbox + qqs pixels(en fonction de la vitesse xMove) /
			// taille d'un carré de texture
			// ce qui nous donne l'indice x du tableau d'élément créé dans le
			// générateur de carte
			int fuX = (int) (coord.getX() + xMove + collisionBox.x + collisionBox.width) / Element.ELEMENT_WIDTH;

			// si le booleen isSolid du carré de texture(de destination) en
			// indice x,y est egale a false
			// (y étant égale successivement au coin supérieur droit puis
			// inférieur droit de la hitbox)
			// on bouge normalement
			if (!collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y) / Element.ELEMENT_HEIGHT)
					&& !collisionAvecElement(fuX,
							(int) (coord.getY() + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT)) {
				coord.setX((int) (coord.getX() + xMove));

				// sinon, les coordonnees de x sont diminuer pour que le coté
				// droit de la box soit collé à un pixel près contre la texture
			} else {
				coord.setX(fuX * Element.ELEMENT_WIDTH - collisionBox.x - collisionBox.width - 1);
			}
			// si on bouge vers la gauche
		} else if (xMove < 0) {
			// coordonnées x future = coordonne x de la partie extreme gauche de
			// la hitbox - qqs pixels / taille carré texture
			int fuX = (int) (coord.getX() + xMove + collisionBox.x) / Element.ELEMENT_WIDTH;

			// si le booleen isSOlid du carré de texture en indice x, y est
			// egale a false
			// ( y étant égale successivement au coin supérieur gauche puis
			// inférieur gauche de la hitbox)
			// on bouge normalement
			if (!collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y) / Element.ELEMENT_HEIGHT)
					&& !collisionAvecElement(fuX,
							(int) (coord.getY() + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT)) {
				coord.setX((int) (coord.getX() + xMove));
				// sinon les coordonnées de x sont augmenter pour que le coté
				// gauche soit collé contre la texture
			} else {
				coord.setX(fuX * Element.ELEMENT_WIDTH + Element.ELEMENT_WIDTH - collisionBox.x);
			}
		}
	}

	// Fonction de variation de la position y avec gestion des collisions
	public void moveY() {

		int leftX = (int) (coord.getX() + collisionBox.x) / Element.ELEMENT_WIDTH; //(gauche de la hitbox)
		//System.out.println(leftX);
		int rightX = (int) (coord.getX() + collisionBox.x + collisionBox.width) / Element.ELEMENT_WIDTH; // (droite de la hitbox)
	//	System.out.println(rightX);
		// si on bouge vers le haut
		if (yMove < 0) {
			// coord future y = coord y de la partie haute de la hitbox
			int fuY = (int) (coord.getY() + yMove + collisionBox.y) / Element.ELEMENT_HEIGHT;
			// si le coin en haut à gauch ou le coin en haut a droite touche un
			// élément dont isSolid est false, on bouge normal
			if (!collisionAvecElement(leftX, fuY) && !collisionAvecElement(rightX, fuY)) {
				coord.setY((int) (coord.getY() + yMove));
			} else {
				coord.setY(fuY * Element.ELEMENT_HEIGHT + Element.ELEMENT_HEIGHT - collisionBox.y);
			}

			// si on bouge vers le bas
		} else if (yMove > 0) {
			// partie basse de la hitbox
			int fuY = (int) (coord.getY() + yMove + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT;
			if (!collisionAvecElement(leftX, fuY) && !collisionAvecElement(rightX, fuY)) {
				coord.setY((int) (coord.getY() + yMove));
			} else {
				coord.setY(fuY * Element.ELEMENT_HEIGHT - collisionBox.y - collisionBox.height -1);
			}
		}
	}

	protected boolean collisionAvecElement(int x, int y) {
		return GenerateurCoordCarte.element[x][y].isSolid();
	}

	public void getInput() {
		xMove = 0;
		yMove = 0;
		if (EntreeClavier.haut)
			yMove = -speed;
		if (EntreeClavier.bas)
			yMove = speed;
		if (EntreeClavier.gauche)
			xMove = -speed;
		if (EntreeClavier.droite)
			xMove = speed;
		move();
	}

	// ==========Accesseurs============

	public Coordonnees getCoord() {
		return coord;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}

	public Image getImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
