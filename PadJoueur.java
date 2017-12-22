package PONGv1;
/**
 * 
 * @author Nicolas Patelli
 * @version 2
 * @date 16/11/2017
 *
 */

//import java.awt.Color;
import java.awt.Graphics;

public class PadJoueur implements Pad{
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.5;
	public PadJoueur(int player) {
		upAccel = false;
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
	* @return Cree un pad aux couleurs et dimensions specifiees
	* 
	*
	*/
	public void draw(Graphics g) {
		g.setColor(Tennis.themePad);
		g.fillRect(x, (int)y, 20, 80);
		
	}
	
	/**
	* 
	* @return Deplace le pad vers le haut ou le bas
	* 
	*
	*/
	public void move() {
		if(upAccel) {
			yVel -=2;
		}
		else if(downAccel){
			yVel +=2;
		}
		else if(!upAccel && !downAccel){
			yVel *= GRAVITY;
		}
		
		if(yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;
		
		y += yVel;
		
		if(y<0)
			y=0;
		if(y>420)
			y=420;
	}

	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	public void setDownAccel(boolean input) {
		downAccel = input;
	}
	public int getY() {
		return (int)y;
	}

}
