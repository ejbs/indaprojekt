import java.awt.Color;
import java.awt.Graphics;

public class SimpleEnemy extends EnemyEntity {
        ExperimentalSpawner sp;

        public SimpleEnemy(int x, int y) {
                super(x, y, 30, 30, Color.MAGENTA, 0.002, 0.1, 0.1);
                sp =  new ExperimentalSpawner(x, y);
        }
        
        public void tick() {
                super.tick();
                sp.setX(super.getX());
                sp.setY(super.getY());
                // This is a bug
                // When does tick() get called?
                // Well, when entities is traversed.
                // And what shouldn't you do?
                // Modify a list while it is being traversed
                Game.entities.add(sp.spawnBullet());
        }
}
