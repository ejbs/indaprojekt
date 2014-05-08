import java.awt.*;
public class ExperimentalSpawner implements BulletSpawner {
        double x, y;
        double z1, z2, z3, z4;
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
}
