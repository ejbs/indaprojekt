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
                Game.entities.add(sp.spawnBullet());
        }
}
