public class SimpleEnemy extends EnemyEntity {
        BulletSpawner sp;

        public SimpleEnemy(int x, int y) {
                super(x, y, 30, 30, Color.PURPLE, 0.002, 1, 1);
                sp =  new ExperimentalSpawner(x, y);
        }
        
        public void tick() {
                super.tick();
                sp.setX(x);
                sp.setY(y);
                sp.spawnBullet();
        }
}
