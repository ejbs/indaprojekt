import java.awt.Color;
import java.awt.Graphics;


/**
 * The EnemyEntity class defines basic behavior and fields 
 * for other objects such as bullets and bosses to inherit from.
 */
public class EnemyEntity implements ScreenEntity{
        private final int TYPE = 1;
        // Current color of the EnemyEntity
        private Color color;
	private boolean intersectable;
        // Current x- and y-position
	private double xPos;
	private double yPos;
        // Current x- and y-velocity
	private double xVel;
	private double yVel;
        
	private double enginePower;
        // The width and height of the EnemyEntity
	private int width;
	private int height;
        // The BulletSpawner which EnemyEntity may use to spawn bullets with.
        // May be null, in which case no bullets will be spawned (see EnemyEntity.spawnBullet())
	public BulletSpawner bs;

	public EnemyEntity(double x, double y, int width, int height, Color c, double enginePower, double xVel, double yVel, BulletSpawner bs) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.color = c;
		this.intersectable = true;
		this.enginePower = enginePower;
		this.xVel = xVel;
		this.yVel = yVel;
		if(bs != null){
			this.bs = bs;
		}
	}

	public double getX(){
		return xPos;
	}

	public void setX(double x){
		this.xPos = x;
	}

	public double getY(){
		return yPos;
	}

	public void setY(double y){
		this.yPos = y;
	}

	public double getVelocityX(){
		return xVel;
	}

	public void setVelocityX(double x){
		this.xVel = x;
	}

	public double getVelocityY(){
		return yVel;
	}

	public void setVelocityY(double y){
		this.yVel = y;
	}

	public double getEnginePower(){
		return enginePower;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public Color getColor(){
		return color;
	}

	public boolean isIntersectable(){
		return intersectable;
	}

	public int getType(){
		return TYPE;
	}

        /**
         * Draws the EnemyEntity to the Graphics object g.
         * The EnemyEntity is drawn with the current color as a rectangle
         */
	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillRect( (int)getX(), (int)getY(), getWidth(), getHeight() );
	}

	public void setSpawner(BulletSpawner bs) {
		this.bs = bs;
	}
        
        /**
         * A call to spawnBullet() may return null if bs is null, otherwise will return whatever bs.spawnBullet() returns (most likely an EnemyEntity object).
         */
	public EnemyEntity spawnBullet(){
		if(bs != null){
			return bs.spawnBullet(xPos, yPos, width, height);
		}
		return null;
	}
        /**
         * tick() changes the x and y position with the current velocities accordingly (simple addition).
         */
	public void tick() {
                this.xPos += this.xVel;
		this.yPos += this.yVel;
	}
}
