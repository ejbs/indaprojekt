import java.util.ArrayList;

public interface BulletSpawner {

	/**
	* Returns an ArrayList containing all bullets spawned during this method call.
	* It may return an empty list.
	*/
	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height);
}