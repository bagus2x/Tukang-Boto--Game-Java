package bagus.game.logic;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UFrame {	
	JFrame frame;
	LogicPanel gamePanel;
	ImageIcon logo = new ImageIcon("assets/icon.png");
	JLabel l;
	
	private final static int WIDTH = 606;
	private final static int HEIGHT = 606;
	
	public UFrame() {
	    frame = new JFrame();
	    frame.setTitle("Tukang Boto | bagus2x");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gamePanel = new LogicPanel();
	    gamePanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	    frame.add(gamePanel);

	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setIconImage(logo.getImage());
	    frame.setVisible(true);
	    
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}
	public static int getWIDTH() {
		return WIDTH;
	}

}
