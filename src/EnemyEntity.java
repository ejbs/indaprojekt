import java.awt.Color;
import java.awt.Graphics;


public class EnemyEntity implements ScreenEntity{
    private final int TYPE = 1;
    private Color color;
	private boolean intersectable;
	private double xPos;
	private double yPos;
	private double xVel;
	private double yVel;
	private double enginePower;
	private int width;
	private int height;
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

	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillRect( (int)getX(), (int)getY(), getWidth(), getHeight() );
	}

	public void setSpawner(BulletSpawner bs) {
		this.bs = bs;
	}

	public EnemyEntity spawnBullet(){
		if(bs != null){
			return bs.spawnBullet(xPos, yPos);
		}
		return null;
	}

	public void tick() {
		this.xPos += this.xVel;
		this.yPos += this.yVel;
	}
}
