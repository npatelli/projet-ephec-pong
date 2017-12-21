package PONGv2;
/**
 * 
 * @author Nicolas Patelli
 * @version 1
 * @date 16/11/2017
 *
 */
 
import java.awt.Graphics;

public interface Pad {
	public void draw(Graphics g);
	public void move();
	public int getY();
}