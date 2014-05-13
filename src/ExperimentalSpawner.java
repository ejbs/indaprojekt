import java.awt.*;
import java.util.ArrayList;

/**
 * The ExperimentalSpawner is a small test spawner
 * which spawns bullets in a relatively interesting pattern.
 */
public class ExperimentalSpawner implements BulletSpawner {
        private double z1, z2;
        public ExperimentalSpawner () {
        }

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
