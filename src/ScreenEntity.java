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
	Color getColor();
	boolean isIntersectable();
	int getType();
	void draw(Graphics g);
}
