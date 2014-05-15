import java.awt.*;
import java.util.ArrayList;

/**
* This interface defines basic properties for the visible entities on the screen.
*/
public interface ScreenEntity {
	double getX();
	void setX(double d);
	double getY();
	void setY(double d);
	double getVelocityX();
	void setVelocityX(double d);
	double getVelocityY();
	void setVelocityY(double d);
	int getWidth();
	int getHeight();
	void addSpawner(BulletSpawner bs);
	ArrayList<EnemyEntity> spawnBullet();
	Color getColor();
	int getType();

	/**
	* Is the object collideable/solid?
	**/
	boolean isIntersectable();

	/**
	* Called at each draw, lets the object draw to the canvas g.
	**/
	void draw(Graphics g);

	/**
	* Called for each game tick, used for book keeping and other things
	**/
	void tick();
}
