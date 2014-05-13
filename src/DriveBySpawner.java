import java.awt.Color;

/**
 * The DriveBySpawner gives us a circle pattern
 */
public class DriveBySpawner implements BulletSpawner {
        private double directionX, directionY;
        private int timer;

        public DriveBySpawner() {
			directionX = Math.random()-0.5;
			directionY = Math.random()-0.5;
        }

        public EnemyEntity spawnBullet(double x, double y) {
			if(timer > 0){
				timer--;
				return null;
			}
				timer = 10;
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.00001,
                                       directionX/3,
                                       directionY/3,
                                       null);
        }

}