import java.awt.*;

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
	void setSpawner(BulletSpawner bs);
	EnemyEntity spawnBullet();
	Color getColor();
        /**
         * Is the object collideable/solid?
         **/
        boolean isIntersectable();
        int getType();
        /**
         * Called at each draw, lets the object draw to the canvas g.
         **/
        void draw(Graphics g);
        /**
         * Called for each game tick, used for book keeping and other things
         **/
        void tick();
}
