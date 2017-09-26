package ttte;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Thread implements WindowListener, KeyListener {
	
	private JFrame frame;
	private double r;
	private double f;
	private double i;
	
	private double timer;
	
	public Main() {
		frame = gen(new Thomas());
		frame.addWindowListener(this);
		frame.addKeyListener(this);
	}
	
	@Override
	public void run() {
		super.run();
		
		while(true) {
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			
			r = (r + 5) % 360;
			f = f < 450 ? f+0.1 : f;
			i = i < 450 ? i+0.1 : i;
			
			if(f >= 20) {
				timer++;
				if(timer > 10) {
					timer = 0;
					
					gen(new Triggered()).setBounds((int)(Math.random() * dim.getWidth()), (int)(Math.random() * dim.getHeight()), 500, 500);
				}
			}
			
			double x = Math.cos(Math.toRadians(r)) * i + Math.random() * f;
			double y = Math.sin(Math.toRadians(r)) * i + Math.random() * f;
			
			frame.setBounds((int)((dim.getWidth()/2 - 500/2) + x), (int)((dim.getHeight()/2 - 500/2) + y), 500, 500);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static JFrame gen(JPanel panel) {
		JFrame frame = new JFrame("Thomas The Tank Engine");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		return frame;
	}
	
	public synchronized static void playSound(final String url) {
//		Clip clip;
//		try {
//			clip = AudioSystem.getClip();
//	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
//	        		Main.class.getClass().getResourceAsStream("/" + url));
//	        clip.open(inputStream);
//	        clip.loop(Integer.MAX_VALUE);
//	        clip.start(); 
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
		URL url2 = Main.class.getClass().getResource("/Thomas_The_Tank_Engine.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url2);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
	} catch (LineUnavailableException e) {
		e.printStackTrace();
	} catch (UnsupportedAudioFileException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
		new Main().start();
		
		playSound("Thomas_The_Tank_Engine.wav");
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		if(!startagain) main(new String[0]);
		else System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static boolean startagain;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_0) {
			startagain = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
