import java.awt.*;
public class ExperimentalSpawner implements BulletSpawner {
        double z1, z2;
        public ExperimentalSpawner () {
        }

        public EnemyEntity spawnBullet(double x, double y) {
                z1 += 0.1;
                z2 += 0.3;
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.002,
                                       Math.sin(z1)/3,
                                       Math.cos(z2)/3,
                                       null);
        }
}
