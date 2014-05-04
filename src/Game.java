import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Game implements KeyListener{

	//The height of the screen.
	private final int HEIGHT = 900;
	//The width of the screen.
	private final int WIDTH = 1600;
	//The current score.
	private int score;
	//The highest achieved score for the current game session.
	private int highscore;
	//the visual frame on which everything is displayed
	private JFrame frame;
	//Two graphics instances due to double buffering.
	private Graphics g, bufferG;
	//Image used for double buffering.
	private Image i;
	//A list of all entities in the game.
	private ArrayList<ScreenEntity> entities;
	//A map keeping track of which keys are pressed down.
	public static HashMap<String,Boolean> keys;

	/**
	 * The constructor to call in order to initiate the game.
	 */
	public Game() {
		initComponents();
		gameLoop();
	}

	/**
	 * The never ending loop sustaining the game's calculations and screen updates.
	 */
	private void gameLoop() {
		//determines the maximum fps of the game.
		final int maxFPS = 100;
		//a counter that helps with the fps determination.
		int loopCounter = 0;
		while (true){
			score++;
            //This comparison might not be 100% accurate at high fps.
            // Just use mod (%) to fix this?
		    if(loopCounter == (int)(1000/maxFPS)){
				//updating the screen
				drawScreen();
				loopCounter = 0;
			}
			loopCounter++;
			//Doing all calculations regarding the entities on the screen.
			calculatePhysics();
			try{
				//a short sleep to make the game smoother
				Thread.sleep(1);
			}
			catch(Exception e){
				System.out.println("Failed to sleep thread");
			}
		}
	}

	/**
	 * Does all calculations regarding physics.
	 */
	private void calculatePhysics(){
		//This loop makes the entities move according to their current speed.
		for(ScreenEntity e : entities){
        	e.tick();
		}
	}

	/**
	 * Called in order to repaint the background and all entities on the screen.
	 */
	private void drawScreen(){
		bufferG.setColor(Color.BLACK);
		bufferG.fillRect(0,0,WIDTH,HEIGHT);
		for(ScreenEntity e: entities){
			e.draw(bufferG);
		}
		bufferG.setFont(new Font("Monospaced", Font.BOLD, 25));
		bufferG.setColor(Color.YELLOW);
		bufferG.drawString(Integer.toString(highscore),1485,50);
		bufferG.drawString("HIGHSCORE:",1330,50);
		bufferG.drawString(Integer.toString(score),1485,80);
		bufferG.drawString("SCORE:",1390,80);
		//Double buffering.
		g.drawImage(i,0,0,null);
	}

	/**
	 * Spawns a new bullet with random values and adds it to entities.
	 */
	 private void spawnBullet(){
		 //Needs improvement to spawn in a better way.
		 entities.add( new EnemyEntity(30,30,15,15,Color.GREEN,0.002,0.1,0.1) );
	 }

	/**
	 * Called when a key has been pressed.
	 * @param e The KeyEvent generated
	 */
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case 38: keys.put("up", true);break;
			case 40: keys.put("down", true);break;
			case 37: keys.put("left", true);break;
			case 39: keys.put("right", true);break;
		}
	}

	/**
	 * Called when a key has been typed.
	 * @param e The KeyEvent generated
	 */
	public void keyTyped(KeyEvent e){
		//This KeyEvent is ignored.
	}

	/**
	 * Called when a key has been released.
	 * @param e The KeyEvent generated
	 */
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
			case 38: keys.put("up", false);break;
			case 40: keys.put("down", false);break;
			case 37: keys.put("left", false);break;
			case 39: keys.put("right", false);break;
		}
	}

	/**
	 * initializes all values in order to make the game work.
	 */
	private void initComponents() {
		frame = new JFrame("DON'T LEAVE THE SCREEN!");
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g = frame.getGraphics();
		i = frame.createImage(WIDTH,HEIGHT);
		bufferG = i.getGraphics();

		entities = new ArrayList<ScreenEntity>();
		entities.add( new PlayerEntity(300,300,25,25,Color.RED) );
		spawnBullet();
		keys = new HashMap<String,Boolean>();
		keys.put("up", false);
		keys.put("down", false);
		keys.put("right", false);
 		keys.put("left", false);
	}

	public static void main(String[] args) {
		new Game();
	}
}
