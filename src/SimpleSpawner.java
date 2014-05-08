import javax.swing.*;
import java.awt.*;
import java.util.*;


public class SimpleSpawner implements BulletSpawner {
        private final int WIDTH, HEIGHT;
        public SimpleSpawner(int width, int height) {
                this.WIDTH = width;
                this.HEIGHT = height;
        }
        public EnemyEntity spawnBullet() {
                if(Math.random() > 0.5) {
			if(Math.random() > 0.5){
			       return new EnemyEntity(0, Math.random()*HEIGHT, 15, 15, Color.GREEN, 0.002, 0.1, 0);
			}
			else {
				return new EnemyEntity(WIDTH, Math.random()*HEIGHT, 15, 15, Color.GREEN, 0.002, -0.1, 0);
			}
		}
		else {
			if(Math.random() > 0.5){
				return new EnemyEntity(Math.random()*WIDTH, 0, 15, 15, Color.GREEN, 0.002, 0, 0.1);
			}
			else {
				return new EnemyEntity(Math.random()*WIDTH, HEIGHT, 15, 15, Color.GREEN, 0.002, 0, -0.1);
			}
		}
        }
}