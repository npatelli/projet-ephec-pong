package PONGv1;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Adelin Gauthier
 * @version 3.1
 *
 */

public class Balle {
	double xVel, yVel, x, y;
	
	public Balle() {
		x = 350;
		y = 250;
		xVel = getRandomSpeed() * getRandomDirection();
		yVel = getRandomSpeed() * getRandomDirection();
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public double getRandomSpeed() {
		return (Math.random() * 3 + 2 );
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la direction de départ de la balle
	 */
	public int getRandomDirection() {
		int rand = (int)(Math.random() * 2);
		if (rand == 1) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Dessine la balle (couleur, taille)
	 * @param g La balle
	 */
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	
	/**
	 * Vérifie si il y a collision entre la balle et les pads. 
	 * Si oui, changement de direction.
	 * @param p1 Pad 1
	 * @param p2 Pad 2
	 */
	public void checkPaddleCollision(Pad p1, Pad p2) {
		if (x <= 50) {
			if (y >= p1.getY() && y <= p1.getY() + 80) {
				xVel = -xVel;
			}
		}
		else if(x >= 650){
			if (y >= p2.getY() && y <= p2.getY() + 80) {
				xVel = -xVel;
			}
		}
	}
	
		/**
		 * Mouvement de la balle
		 * Rebondit sur les bords horizontaux
		 */
	public void move() {
		x += xVel;
		y += yVel;
		
		if (y < 10) {
			yVel = -yVel;
		}
		if (y > 490) {
			yVel = -yVel;
		}
	}
	
	/**
	 * 
	 * @return le x sous forme d'un entier
	 */
	public int getX() {
		return (int)x;
	}
	
	/**
	 * 
	 * @return le y sous forme d'un entier
	 */
	public int getY() {
		return (int)y;
	}
}