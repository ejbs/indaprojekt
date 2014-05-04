import java.awt.*;

public class PlayerEntity implements ScreenEntity {

	private final int TYPE = 0;
	private Color color;
	private boolean intersectable;
	private double xPos;
	private double yPos;
	private double xVel;
	private double yVel;
	private double enginePower;
	private int width;
	private int height;

	public PlayerEntity(double x, double y, int width, int height, Color c) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.color = c;
		this.intersectable = true;
		this.enginePower = 0.002;
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

	public double getWeight(){
		return width*height;
	}

	public Color getColor(){
		return color;
	}

	public boolean getIntersectable(){
		return intersectable;
	}

	public int getType(){
		return TYPE;
	}

	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillRect( (int)getX(), (int)getY(), getWidth(), getHeight() );
	}

    public void tick() {
    	if(Game.keys.get("up")){
			this.setVelocityY(this.getVelocityY()-this.getEnginePower());
		}
		if(Game.keys.get("down")){
			this.setVelocityY(this.getVelocityY()+this.getEnginePower());
		}
		if(Game.keys.get("left")){
			this.setVelocityX(this.getVelocityX()-this.getEnginePower());
		}
		if(Game.keys.get("right")){
			this.setVelocityX(this.getVelocityX()+this.getEnginePower());
		}
		this.xPos += this.xVel;
		this.yPos += this.yVel;
	}

	public boolean isIntersectable() {
		return true;
	}
}
