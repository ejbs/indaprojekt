import java.awt.Color;
import java.util.ArrayList;

/**
* The DriveBySpawner continously spawns bullets in a random direction.
*/
public class DriveBySpawner implements BulletSpawner {
	private double directionX, directionY;
	private int timer;
	/**
	* Returns a DriveBySpawner object.
	*/
	public DriveBySpawner() {
		directionX = Math.random()-0.5;
		directionY = Math.random()-0.5;
	}
	/**
	* @inheritDoc
	*/
	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height) {
		ArrayList<EnemyEntity> spawnedBullets = new ArrayList<EnemyEntity>();
		if(timer > 0){
			timer--;
			return new ArrayList<EnemyEntity>();
		}
		timer = 7;
		spawnedBullets.add( new EnemyEntity(x+(width/2), y+(height/2), 10, 10, Color.GREEN, 0.00001,
		directionX/3,
		directionY/3,
		null) );
		return spawnedBullets;
	}

}