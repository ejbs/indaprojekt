import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Game implements KeyListener{

	//The height of the screen.
	public static final int HEIGHT = 900;
	//The width of the screen.
	public static final int WIDTH = 1600;
	//The path to the highscore-saving file.
    private final String HIGHSCORE_PATH = "highscore.txt";
	//The current score.
	public static int score;
	//The highest achieved score for the current game session.
	private int highscore;
	//Increases difficulty value is lowered
	public static int difficulty;
	//Keeps track of whether the player has lost or not.
	private boolean gameOver;
	//the visual frame on which everything is displayed.
	private JFrame frame;
	//Two graphics instances due to double buffering.
	private Graphics g, bufferG;
	//Image used for double buffering.
	private Image i;
	//An instance of CollisionHandler to keep track of collisions.
	private CollisionHandler collisions;
	//A list of all entities in the game.
	public static ArrayList<ScreenEntity> entities;
	//A spawner object that deals with the spawning of new bullets.
	public static ArrayList<BulletSpawner> spawners;
	//A map keeping track of which keys are pressed down.
	public static HashMap<String,Boolean> keys;

	/**
	 * The constructor to call in order to initiate the game.
	 */
	public Game() {
		initComponents();
		gameLoop();
		gameOver();
	}

	/**
	 * The never ending loop sustaining the game's calculations and screen updates.
	 */
        //TODO: remove bullets when they exit the screen
        //      maybe put the screen drawing in a new thread?
	private void gameLoop() {
		//a counter that helps with the fps determination and bullet spawning.
		int loopCounter = 0;

		while (!gameOver){
            if(loopCounter%10 == 0){
				drawScreen();
				score++;
				if(loopCounter%difficulty == 0){
					spawnBullets();
				}
				if(score%500 == 0 && difficulty > 10){
					difficulty = difficulty-10;
				}
			}
			loopCounter++;

			//Doing all calculations regarding the entities on the screen.
			calculatePhysics();
			try{
				//a short sleep to make the game smoother.
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
		for(ScreenEntity e: entities){
			e.tick();
		}

		for(int i = 1; i < entities.size(); i++){
			if(collisions.hasCollided(entities.get(0),entities.get(i))){
				gameOver = true;
			}
			if(!collisions.insideBounds(entities.get(i),WIDTH,HEIGHT)){
				entities.remove(i);
			}
		}
		if(!collisions.insideBounds(entities.get(0),WIDTH,HEIGHT)){
			gameOver = true;
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
		bufferG.drawString("DIFFICULTY:",10,50);
		bufferG.drawString(getDifficulty(),175,50);
		//Double buffering.
		g.drawImage(i,0,0,null);
	}

	/**
	 * Returns a String representation of the current difficulty.
	 *
	 * @return a String representation of the current difficulty.
	 */
	private String getDifficulty(){
		switch(difficulty){
                case 50: return "NORMAL";
                case 40: return "HARD";
                case 30: return "VERY HARD";
                case 20: return "NIGHTMARE";
                case 10: return "DEATH WISH";
                default: return "WALK IN THE PARK";
		}
	}

	/**
	 * Loops through all of the active BulletSpawners and lets each one spawn a bullet
	 */
    private void spawnBullets(){
		ArrayList<ScreenEntity> entitiesToAdd = new ArrayList<ScreenEntity>();
		for(ScreenEntity e: entities){
			EnemyEntity tmp = e.spawnBullet();
			if(tmp != null){
				entitiesToAdd.add(tmp);
			}
		}
		entities.addAll(entitiesToAdd);
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

	private void gameOver(){
		bufferG.setFont(new Font("Monospaced", Font.BOLD, 110));
		bufferG.setColor(Color.YELLOW);
		bufferG.drawString("GAME OVER",WIDTH/4,HEIGHT/2);
		g.drawImage(i,0,0,null);
                if(score > highscore) {
                        highscore = score;
                        saveHighscore();
                }
        }

	private void saveHighscore() {
		// The following overwrites the file if present, so we don't have to bother about any pre-existing files.
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(HIGHSCORE_PATH, "UTF-8");
			pw.println(highscore);
			pw.close();
		} catch(Exception e) {
			System.err.println("Something faulty happened while writing to the highscore file");
			System.exit(1);
		}
	}
	private void readHighscore() {
		BufferedReader f = null;
		try {
			f = new BufferedReader(new InputStreamReader(new FileInputStream(HIGHSCORE_PATH), "UTF-8"));
			String l;
			while((l = f.readLine()) != null) {
				highscore = Integer.parseInt(l);
			}
		} catch(Exception e) {
			System.err.println("Something faulty happened while reading the highscore file");
			System.exit(1);
		}
	}

	/**
	 * initializes all values in order to make the game work.
	 */
	private void initComponents() {
                spawners = new ArrayList<BulletSpawner>();
		frame = new JFrame("DON'T LEAVE THE SCREEN!");
		frame.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g = frame.getGraphics();
		i = frame.createImage(WIDTH,HEIGHT);
		bufferG = i.getGraphics();
		collisions = new CollisionHandler();

		entities = new ArrayList<ScreenEntity>();
		entities.add( new PlayerEntity(300,300,20,20,Color.RED) );
		entities.add( new EnemyEntity(600,600,15,15,Color.WHITE,0.001,0,0,new ExperimentalSpawner()) );
		//entities.add( new EnemyEntity(600,600,15,15,Color.WHITE,0.001,0,0,new FunkySpawner() ) );
		keys = new HashMap<String,Boolean>();
		keys.put("up", false);
		keys.put("down", false);
		keys.put("right", false);
 		keys.put("left", false);
 		gameOver = false;
 		difficulty = 60;
        readHighscore();
	}

	public static void main(String[] args) {
		new Game();
	}
}
