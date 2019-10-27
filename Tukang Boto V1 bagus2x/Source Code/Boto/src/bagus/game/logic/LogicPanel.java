package bagus.game.logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LogicPanel extends JPanel implements ActionListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private final static int WIDTH = UFrame.getWIDTH();
	private final static int HEIGHT = UFrame.getHEIGHT();
	private int playerLn=WIDTH/8;
	private int playerX = WIDTH/2-playerLn/2;
	private int playerY = (int)(HEIGHT*0.9);
	private int ballX = playerX+10;
	private int ballY = playerY-HEIGHT/2;
	private int ballXXdir = -1;
	private int ballYYdir = -2;
	
	int skor = 0;
	String msg = " ";
	
	private byte delay=8;
	boolean play = true, play2 =false;
	boolean isTouched = false;
	
	Timer timer;
	Draw draw = new Draw();
	List<List<Integer>> randomColor = new RandomColor().getColor();
	
	int[] itc = new int[2];
	
	ImageIcon pl = new ImageIcon("assets/player.jpg");
	
	List<List<Integer>> poil = Draw.arrayF();
	
	Image background;
	
  	private BufferedImage image;

	public LogicPanel() {


		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setOpaque(false);
		timer = new Timer(delay, this);
		timer.start();
        //reads the image
        try {
            image = ImageIO.read(new File("assets/background.jpg"));

        } catch (IOException ioe) {
        }
		
	}

	public void paint(Graphics g) {

        g.drawImage(image,3,3,this);
		
		pl.paintIcon(this, g,playerX, playerY);
		
		g.setColor(Color.white);
		g.fillOval(ballX, ballY, 20,20);	
		
		g.setColor(Color.white);
		g.setFont(new Font("calibri",Font.BOLD,20));
		g.drawString("SCORE "+skor, WIDTH-110, HEIGHT-33);
		

		g.drawString(msg, WIDTH/2-50, HEIGHT/2);
		g.drawString(" ", WIDTH/2-50, HEIGHT/2);
		
		draw.bricks(g, itc, poil, randomColor, play);	
		g.dispose();
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
	
		if(key == KeyEvent.VK_RIGHT) {

			if(playerX >= WIDTH-playerLn-3) {
				playerX = WIDTH-playerLn-3;
			}else {
				moveR();
			}
		}
		if(key == KeyEvent.VK_LEFT) {

			if(playerX <= 3) {
				playerX = 3;
			}else {
				moveL();
			}
		}if(key == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				playerX = WIDTH/2-playerLn/2;
				playerY = (int)(HEIGHT*0.9);
				ballX = playerX+10;
				ballY = playerY-HEIGHT/2;	
				ballXXdir = -1;
				ballYYdir = -2;
				msg = " ";
				skor = 0;
						
				poil = Draw.arrayF();

			}
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			
			for(int i = 0; i < poil.size(); i++) {
//				Cek kondisi intersect
				this.isTouched = new Rectangle(poil.get(i).get(0), poil.get(i).get(1), 57, 17).intersects(new Rectangle(ballX, ballY, 20,20));
				if(isTouched) {
					
					itc[0] = poil.get(i).get(0);
					itc[1] =  poil.get(i).get(1);
					
					ballYYdir = -ballYYdir;					
					skor +=1;
				}			
			}	
	
			if(new Rectangle(playerX, playerY, playerLn, (int)(playerLn/10)).intersects(new Rectangle(ballX, ballY, 20,20))) {
				ballYYdir = -ballYYdir;				
			}
			
			ballX += ballXXdir;
			ballY += ballYYdir;
			
			if(ballX <= 3) {
				ballXXdir = -ballXXdir;
			}
			if(ballX >= WIDTH-20-3) {
				ballXXdir = -ballXXdir;
			}
			if(ballY <= 3) {
				ballYYdir = -ballYYdir;
			}
			if(poil.size() == 0) {
				play = false;
				msg = "ANDA MENANG";
			}else if(ballY>=HEIGHT-3){
				play = false;
				msg = "ANDA KALAH";
				
			}

		}
		repaint();
	}
	
	public void moveR() {
		playerX += 15;
		play = true;
	}
	public void moveL() {
		playerX -= 15;	
		play = true;
	}
}
