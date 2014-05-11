import java.awt.Color;
import java.awt.Graphics;

public class SimpleEnemy extends EnemyEntity {
        FunkySpawner sp;
        boolean first;

        public SimpleEnemy(int x, int y) {
                super(x, y, 30, 30, Color.MAGENTA, 0.002, 0.1, 0.1);
                sp =  new FunkySpawner(x, y);
                first = true;
        }
        
        public void tick() {
                super.tick();
                sp.setX(super.getX());
                sp.setY(super.getY());
                for(int i = 0; i < 15; i++) {
                        Game.entities.add(sp.spawnBullet());
                }
        }
}

