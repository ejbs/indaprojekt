import java.awt.*;
import java.util.ArrayList;

/**
* The ExperimentalSpawner spawns bullets in a seemingly unpridictable
* pattern which relies on trigonometry.
*/
public class ExperimentalSpawner implements BulletSpawner {
	private double z1, z2;

	/**
	* Returns an ExperimentalSpawner object.
	*/
	public ExperimentalSpawner () {
	}

	/**
	* @inheritDoc
	*/
	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height) {
		ArrayList<EnemyEntity> spawnedBullets = new ArrayList<EnemyEntity>();
		z1 += 0.1;
		z2 += 0.3;
		spawnedBullets.add( new EnemyEntity(x+(width/2), y+(height/2), 10, 10, Color.GREEN, 0.002,
		Math.sin(z1)/3,
		Math.cos(z2)/3,
		null) );
		return spawnedBullets;
	}
}
