/**
 * 
 * @author Nicolas Patelli
 * @version 2
 * @date 06/12/2017
 *
 */





package PONGv1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	PadJoueur p1;
	PadIA p2;
	Balle b1;
	boolean partieLancee;
	Graphics gfx;
	Image img;
	
	private static final long serialVersionUID = 1L; 
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void init() {
		this.resize(WIDTH, HEIGHT);
		partieLancee = false;
		this.addKeyListener(this);
		p1 = new PadJoueur(1);
		b1 = new Balle();
		p2 = new PadIA(2, b1);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void paint(Graphics g) {
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0,  0,  WIDTH,  HEIGHT);
		
		if(b1.getX() <40) {
			gfx.setColor(Color.white);
			gfx.drawString("Fin de partie ! Vous avez perdu !", 270, 250);
		}
		else if (b1.getX() > 660) {
			gfx.setColor(Color.white);
			gfx.drawString("Fin de partie ! Vous avez gagné !", 270, 250);
		}
		else {
			p1.draw(gfx);
			b1.draw(gfx);
			p2.draw(gfx);
		}
		
		if(!partieLancee) {
			gfx.setColor(Color.white);
			gfx.drawString("- Pong -", 327, 100);
			gfx.drawString("Entrée pour commencer ...", 280, 130);
			

		}
		g.drawImage(img, 0, 0, this);
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void update(Graphics g) {
		paint(g);
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void run() {
		for(;;) {
			if(partieLancee) {
				p1.move();
				p2.move();
				b1.move();
				b1.checkPaddleCollision(p1, p2);
			}
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			partieLancee = true;
		}
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}
	
	/**
	 * 
	 * @return un chiffre aléatoire qui gèrera de la vitesse de départ de la balle
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
