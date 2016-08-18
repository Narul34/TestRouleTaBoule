package testRouleTaBoule.elements;

import java.awt.Image;
import java.awt.Rectangle;

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
		collisionBox.x = 5;
		collisionBox.y = 10;
		collisionBox.width = 20;
		collisionBox.height = 20;
	}
	
	// Fonction de mouvement d'une creature
		public void move() {
			moveX();
			moveY();
		}
	
		public void moveX() {

			if (xMove > 0) {

				int fuX = (int) (coord.getX() + xMove + collisionBox.x + collisionBox.width) / Element.ELEMENT_WIDTH;
				if (!collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y) / Element.ELEMENT_HEIGHT)
						&& !collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT)) {
					coord.setX((int)(coord.getX() + xMove)) ;
				} else {
					coord.setX( fuX * Element.ELEMENT_WIDTH - collisionBox.x - collisionBox.width - 1);
				}
			} else if (xMove < 0) {
				int fuX = (int) (coord.getX() + xMove + collisionBox.x) / Element.ELEMENT_WIDTH;
				if (!collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y) / Element.ELEMENT_HEIGHT)
						&& !collisionAvecElement(fuX, (int) (coord.getY() + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT)) {
					coord.setX((int)(coord.getX() + xMove)) ;
				} else {
					coord.setX( fuX * Element.ELEMENT_WIDTH + Element.ELEMENT_WIDTH - collisionBox.x);
				}
			}
		}
		
		// Fonction de variation de la position y avec gestion des collisions
		public void moveY() {
			if (yMove < 0) {
				int fuY = (int) (coord.getY() + yMove + collisionBox.y) / Element.ELEMENT_HEIGHT;
				if (!collisionAvecElement((int) (coord.getX() + collisionBox.x) / Element.ELEMENT_WIDTH, fuY)
						&& !collisionAvecElement((int) (coord.getX() + collisionBox.x + collisionBox.width) / Element.ELEMENT_WIDTH, fuY)) {
					coord.setY((int)(coord.getY() + yMove));
				} else {
					coord.setY( fuY * Element.ELEMENT_HEIGHT + Element.ELEMENT_HEIGHT - collisionBox.y);
				}

			} else if (yMove > 0) {
				int fuY = (int) (coord.getY() + yMove + collisionBox.y + collisionBox.height) / Element.ELEMENT_HEIGHT;
				if (!collisionAvecElement((int) (coord.getX() + collisionBox.x) / Element.ELEMENT_WIDTH, fuY)
						&& !collisionAvecElement((int) (coord.getX() + collisionBox.x + collisionBox.width) / Element.ELEMENT_WIDTH, fuY)) {
					coord.setY((int)(coord.getY() + yMove));
				} else {
					coord.setY( fuY * Element.ELEMENT_HEIGHT - collisionBox.y - collisionBox.height -1);
				}
			}
		}
		
		protected boolean collisionAvecElement(int x, int y) {
			return GenerateurCoordCarte.element[x/30][y/30].isSolid();
		}
		
	// ==========Accesseurs============
	
		public Coordonnees getCoord(){
			return coord;
		}
		
		public Rectangle getCollisionBox(){
			return collisionBox;
		}
		
		public Image getImage(){
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
