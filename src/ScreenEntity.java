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
	double getEnginePower();
	int getWidth();
	int getHeight();
	double getWeight();
	Color getColor();
	boolean getIntersectable();
	int getType();
	void draw(Graphics g);
}
