import java.awt.*;
import java.util.ArrayList;

/**
* This interface defines basic properties for the visible entities on the screen.
*/
public interface ScreenEntity {

    /**
    * Returns the ScreenEntity's current position on the x-axis.
    */
    double getX();

    /**
    * Called to set the ScreenEntity's position on the x-axis.
    */
    void setX(double d);

    /**
    * Returns the ScreenEntity's current position on the y-axis.
    */
    double getY();

    /**
    * Called to set the ScreenEntity's position on the y-axis.
    */
    void setY(double d);

    /**
    * Returns the ScreenEntity's current velocity in the x-axis direction.
    */
    double getVelocityX();

    /**
    * Called to set the ScreenEntity's velocity oi the x-axis direction.
    */
    void setVelocityX(double d);

    /**
    * Returns the ScreenEntity's current velocity in the y-axis direction.
    */
    double getVelocityY();

    /**
    * Called to set the ScreenEntity's velocity oi the y-axis direction.
    */
    void setVelocityY(double d);

    /**
    * Returns the width of this ScreenEntity.
    */
    int getWidth();

    /**
    * Returns the height of this ScreenEntity.
    */
    int getHeight();

    /**
    * Called to add a BulletSpawner to this ScreenEntity.
    */
    void addSpawner(BulletSpawner bs);

    /**
    * Called to make this ScreenEntity spawn bullets according to its BulletSpawner.
    * This method may return null.
    */
    ArrayList<EnemyEntity> spawnBullet();

    /**
    * Returns the color of this ScreenEntity.
    */
    Color getColor();

    /**
    * Returns a double representing the acceleration power of this ScreenEtity.
    */
    double getEnginePower();

    /**
    * Returns the type of this ScreenEntity.
    */
    int getType();

    /**
    * Returns true if the object can collide with the player.
    * Otherwise it returns false.
    */
    boolean isIntersectable();

    /**
    * Called at each draw, lets the object draw to the canvas g.
    */
    void draw(Graphics g);

    /**
    * Called for each game tick, moves the ScreenEntity according to its velocity.
    */
    void tick();
}