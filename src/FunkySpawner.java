import java.awt.Color;

/**
 * The funky spawner gives us a circle pattern
 */
public class FunkySpawner implements BulletSpawner {
        private double step, currentStep;

        public FunkySpawner() {
                this.step = (Math.PI*2)/16;
                this.currentStep = 0;
        }

        public EnemyEntity spawnBullet(double x, double y) {
                this.currentStep++;
                return new EnemyEntity(x, y, 10, 10, Color.GREEN, 0.00001,
                                       Math.cos(step*currentStep)/3,
                                       Math.sin(step*currentStep)/3,
                                       null);
        }

}
