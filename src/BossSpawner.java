import java.awt.Color;
import java.util.ArrayList;

/**
* The BossSpawner spawns bullets in a circle pattern.
*/
public class BossSpawner implements BulletSpawner {
	private double step, currentStep;

	/**
	* Returns a BossSpawner object.
	*/
	public BossSpawner(){
		this.step = 0.05;
		this.currentStep = 0;
	}

	/**
	* @inheritDoc
	*/
	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height){
		ArrayList<EnemyEntity> spawnedBullets = new ArrayList<EnemyEntity>();
		this.currentStep++;
		spawnedBullets.add( new EnemyEntity(x+(width/2), y+(height/2), 10, 10, Color.GREEN, 0.00001,
		Math.cos(step*currentStep)/3,
		Math.sin(step*currentStep)/3,
		null) );
		return spawnedBullets;
	}

}
