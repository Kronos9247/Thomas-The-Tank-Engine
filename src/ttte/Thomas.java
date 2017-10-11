package ttte;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Thomas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage img;
	
	public Thomas() {
		try {
			img = ImageIO.read(Thomas.class.getResourceAsStream("/Thomas_Tank_Engine.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void trigger() {
		try {
			img = ImageIO.read(Thomas.class.getResourceAsStream("/Thomas_Tank_Engine_V2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repaint();
		
		System.out.println("TRIGGERED!");
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(img, 0, 0, null);
	}
	
}
