import java.awt.Color;

/**
 * The funky spawner gives us a circle pattern
 */
public class FunkySpawner implements BulletSpawner {
        private double x, y, step, currentStep;

        public FunkySpawner(double x, double y) {
                this.x  = x;
                this.y = y;
                this.step = (Math.PI*2)/16;
                this.currentStep = 0;
        }
        public double getX(){
                return x;
        }
        
	public void setX(double x){
		this.x = x;
	}

	public double getY(){
		return y;
	}
        
	public void setY(double y){
		this.y = y;
	}
        public EnemyEntity spawnBullet() {
                this.currentStep++;
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.00001,
                                       Math.cos(step*currentStep),
                                       Math.sin(step*currentStep));
        }
        
}
