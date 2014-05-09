import java.awt.*;
public class ExperimentalSpawner implements BulletSpawner {
        private double x, y;
        double z1, z2;
        public ExperimentalSpawner (double x, double y) {
                this.x = x;
                this.y = y;
        }

        public EnemyEntity spawnBullet() {
                z1 += 0.1;
                z2 += 0.3;
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.002,
                                       Math.sin(z1),
                                       Math.cos(z2));
        }
        public double getX(){
                return xPos;
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
}
