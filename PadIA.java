package PONGv1;

/**
 * 
 * @author Gauthier Adelin
 * @version 2
 * @date 05/12/2017
 *
 */

//import java.awt.Color;
import java.awt.Graphics;

public class PadIA implements Pad {
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	Balle b1;
	double difficulte = 1.17+Math.random()*0.1;
	
	final double GRAVITY = 0.01;
	public PadIA(int player, Balle b) {
		upAccel = false;
		b1 = b;
		downAccel = false;
		y = 210;
		yVel = 0;
		
		if(player == 1)
			x = 20;
		else
			x = 660;
		
	}
	
	/**
	* 
	* @return Cr�e un pad aux couleurs et dimensions sp�cifi�es
	* s
	*
	*/
	public void draw(Graphics g) {
		g.setColor(Tennis.themePad);
		g.fillRect(x, (int)y, 20, 80);
		
	}
	
	/**
	* 
	* @return D�place le pad vers le haut ou le bas
	* 
	*
	*/
	public void move() {
		if(b1.getY() < y+40) {
			yVel -=2;
		}
		else if(b1.getY() > y+40){
			yVel +=2;
		}
		else if(!upAccel && !downAccel){
			yVel *= GRAVITY;
		}
		//DIFFICULTE
		difficulte = 2+Math.random()*0.1;
		if(yVel>=Math.abs(Balle.yVel)/difficulte)
			yVel=Math.abs(Balle.yVel)/difficulte;
		else if(yVel<=-Math.abs(Balle.yVel)/difficulte)
			yVel=-Math.abs(Balle.yVel)/difficulte;
		//System.out.println(difficulte);
		y += yVel;
		
		if(y<0)
			y=0;
		if(y>420)
			y=420;
	}

	public int getY() {
		return (int)y;
	}
}