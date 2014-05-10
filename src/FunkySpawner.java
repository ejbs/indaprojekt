import java.awt.Color;

public class FunkySpawner implements BulletSpawner {
        private double x, y;

        public FunkySpawner(double x, double y) {
                this.x  = x;
                this.y = y;
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
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.003,
                                       Math.cos(x)*-0.3,
                                       Math.tan(y)*0.1*Math.sin(x));
        }
        
}
