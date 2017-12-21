package PONGv2;
//import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Adelin Gauthier
 * @version 3.1
 *
 */

public class Balle {
	public static double xVel, yVel, x, y;
	
	public Balle() {
		x = 350;
		y = 250;
		xVel = 3*getRandomDirection();
		yVel = 2*getRandomDirection();
	}
	
	public static int getRandomDirection() {
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
		g.setColor(Tennis.themeBalle);
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
			if (y > p1.getY()+60 && y <= p1.getY() + 80) {
				xVel = -xVel;
				yVel = Math.abs(yVel);
				
			} else if (y >= p1.getY() && y < p1.getY() + 20) {
				xVel = -xVel;
				yVel = -Math.abs(yVel);
			} else if (y >= p1.getY()+20 && y <= p1.getY() + 60) {
				xVel = -xVel;
			}
		}
		else if(x >= 650){
			if (y > p2.getY()+60 && y <= p2.getY() + 80) {
				xVel = -xVel;
				yVel = Math.abs(yVel);
				
			} else if (y >= p2.getY() && y < p2.getY() + 20) {
				xVel = -xVel;
				yVel = -Math.abs(yVel);
			} else if (y >= p2.getY()+20 && y <= p2.getY() + 60) {
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
		   if (Tennis.scoreActuel > 3 && Tennis.scoreActuel < 5) {
			   Balle.xVel = 5;
			   Balle.yVel = 2;
		   }
		   else if (Tennis.scoreActuel > 5 && Tennis.scoreActuel < 10) {
			   Balle.xVel = 7;
			   Balle.yVel = 4;
		   }
		   else if (Tennis.scoreActuel > 10) {
			   Balle.xVel = 10;
			   Balle.yVel = 6;
		   }
		//System.out.println("Vélocité : "+xVel + " " + yVel);
		//System.out.println("Position : "+x + " " + y);
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