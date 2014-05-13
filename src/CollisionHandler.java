/**
 * The CollisionHandler class implements collisions between objects through the hasCollided method.
 * It operates with the assumption that the objects are rectangles.
 */
public class CollisionHandler {

        /**
         * Returns true if the objects b and a has collided with each other.
         */
	public boolean hasCollided(ScreenEntity b, ScreenEntity a){
		if(a.getX() + a.getWidth() > b.getX() + (b.getWidth()/2) && a.getX() < b.getX() + (b.getWidth()/2)){
			if(a.getY() + a.getHeight() > b.getY() + (b.getHeight()/2) && a.getY() < b.getY() + (b.getHeight()/2) ){
				return true;
			}
		}
		return false;
	}

	public boolean insideBounds(ScreenEntity a, int width, int height){
		if( a.getX() > width+10 || a.getX() < -10 ) {
			return false;
		}
		if( a.getY() > height+10 || a.getY() < -10 ){
			return false;
		}
		return true;
	}
}
