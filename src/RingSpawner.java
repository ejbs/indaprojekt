import java.awt.Color;
import java.util.ArrayList;

/**
* The RingSpawner gives a pulse circle pattern.
*/
public class RingSpawner implements BulletSpawner {
	private double step, currentStep, timer;

	public RingSpawner() {
		this.step = (Math.PI*2)/16;
		this.currentStep = 0;
	}

	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height) {
		if(timer > 0){
			timer--;
			return new ArrayList<EnemyEntity>();
		}
		timer = 20;
		ArrayList<EnemyEntity> spawnedBullets = new ArrayList<EnemyEntity>();
		for(int i = 0; i < 16; i++){
			this.currentStep++;
			spawnedBullets.add( new EnemyEntity(x+(width/2), y+(height/2), 10, 10, Color.GREEN, 0.00001,
				Math.cos(step*currentStep)/3,
				Math.sin(step*currentStep)/3,
				null) );
		}
		return spawnedBullets;
	}

}