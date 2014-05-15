import java.awt.*;
import java.util.ArrayList;

/**
* This is the PlayerEntity.
* It is the entity that the player controls on the screen.
*/
public class PlayerEntity implements ScreenEntity {
    //The type of a PlayerEntity is always 0.
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

    /**
    * Returns a PlayerEntity with the specified properties.
    */
    public PlayerEntity(double x, double y, int width, int height, Color c) {
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.color = c;
        this.intersectable = true;
        this.enginePower = 0.002;
    }

    /**
    * @inheritDoc
    */
    public double getX(){
        return xPos;
    }

    /**
    * @inheritDoc
    */
    public void setX(double x){
        this.xPos = x;
    }

    /**
    * @inheritDoc
    */
    public double getY(){
        return yPos;
    }

    /**
    * @inheritDoc
    */
    public void setY(double y){
        this.yPos = y;
    }

    /**
    * @inheritDoc
    */
    public double getVelocityX(){
        return xVel;
    }

    /**
    * @inheritDoc
    */
    public void setVelocityX(double x){
        this.xVel = x;
    }

    /**
    * @inheritDoc
    */
    public double getVelocityY(){
        return yVel;
    }

    /**
    * @inheritDoc
    */
    public void setVelocityY(double y){
        this.yVel = y;
    }

    /**
    * @inheritDoc
    */
    public double getEnginePower(){
        return enginePower;
    }

    /**
    * @inheritDoc
    */
    public int getWidth(){
        return width;
    }

    /**
    * @inheritDoc
    */
    public int getHeight(){
        return height;
    }

    /**
    * @inheritDoc
    */
    public double getWeight(){
        return width*height;
    }

    /**
    * @inheritDoc
    */
    public Color getColor(){
        return color;
    }

    /**
    * @inheritDoc
    */
    public boolean isIntersectable(){
        return intersectable;
    }

    /**
    * @inheritDoc
    */
    public int getType(){
        return TYPE;
    }

    /**
    * @inheritDoc
    */
    public void addSpawner(BulletSpawner bs){
    }

    /**
    * @inheritDoc
    */
    public ArrayList<EnemyEntity> spawnBullet(){
        return null;
    }

    /**
    * @inheritDoc
    */
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillRect( (int)getX(), (int)getY(), getWidth(), getHeight() );
    }

    /**
    * @inheritDoc
    */
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
}