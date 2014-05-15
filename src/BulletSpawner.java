import java.util.ArrayList;

/**
 * This interface is used by all spawners except SimpleSpawner (special case).
 * Implement this interface if you want to make a class which spawns bullets
 * and you want to use it with an EnemyEntity.
 */
public interface BulletSpawner {

	/**
	* Returns an ArrayList containing all bullets spawned during this method call.
	* It may return an empty list.
	*/
	public ArrayList<EnemyEntity> spawnBullet(double x, double y, int width, int height);
}
