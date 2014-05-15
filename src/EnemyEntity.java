import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/**
* The EnemyEntity class defines behaviour for all kinds of
* enemies/bullets on the screen.
*/
public class EnemyEntity implements ScreenEntity {
    // The type of an enemy is always 1.
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
    public ArrayList<BulletSpawner> bs;

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
        this.bs = new ArrayList<BulletSpawner>();
        if(bs != null){
            this.bs.add(bs);
        }
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
    * Draws the EnemyEntity to the Graphics object g.
    * The EnemyEntity is drawn with the current color and dimensions.
    */
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillRect( (int)getX(), (int)getY(), getWidth(), getHeight() );
    }

    /**
    * @inheritDoc
    */
    public void addSpawner(BulletSpawner bs) {
        this.bs.add(bs);
    }

    /**
    * @inheritDoc
    */
    public ArrayList<EnemyEntity> spawnBullet(){
        if(bs.size() > 0){
            ArrayList<EnemyEntity> bulletsSpawned = new ArrayList<EnemyEntity>();
            for(BulletSpawner s: bs){
                bulletsSpawned.addAll(s.spawnBullet(xPos, yPos, width, height));
            }
            return bulletsSpawned;
        }
        return null;
    }

    /**
    * @inheritDoc
    */
    public void tick() {
        this.xPos += this.xVel;
        this.yPos += this.yVel;
    }
}