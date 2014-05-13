import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * This is a special kind of spawner as it spawns its bullets 'globally'
 * on the edges of the screen (and not from a specific point on screen).
 * Therefore it does not implement the BulletSpawner interface.
 */
public class SimpleSpawner {
        // WIDTH and HEIGHT refers to the width and the height of the screen
        private final int WIDTH, HEIGHT;
        public SimpleSpawner(int width, int height) {
                this.WIDTH = width;
                this.HEIGHT = height;
        }
        public EnemyEntity spawnBullet() {
                if(Math.random() > 0.5) {
			if(Math.random() > 0.5){
			       return new EnemyEntity(0, Math.random()*HEIGHT, 10, 10, Color.GREEN, 0.002, 0.2, 0,null);
			}
			else {
				return new EnemyEntity(WIDTH, Math.random()*HEIGHT, 10, 10, Color.GREEN, 0.002, -0.2, 0,null);
			}
		}
		else {
			if(Math.random() > 0.5){
				return new EnemyEntity(Math.random()*WIDTH, 0, 10, 10, Color.GREEN, 0.002, 0, 0.2,null);
			}
			else {
				return new EnemyEntity(Math.random()*WIDTH, HEIGHT, 10, 10, Color.GREEN, 0.002, 0, -0.2,null);
			}
		}
        }
}
