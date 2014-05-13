import java.awt.Color;

public class BossSpawner implements BulletSpawner {
	private double step, currentStep;

	public BossSpawner(){
		this.step = 0.05;
                this.currentStep = 0;
	}

	public EnemyEntity spawnBullet(double x, double y, int width, int height){
		this.currentStep++;
                return new EnemyEntity(x+(width/2), y+(height/2), 10, 10, Color.GREEN, 0.00001,
                                       Math.cos(step*currentStep)/3,
                                       Math.sin(step*currentStep)/3,
                                       null);
	}

}
