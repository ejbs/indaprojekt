public class CollisionHandler {

	public CollisionHandler(){

	}

	public boolean hasCollided(ScreenEntity a, ScreenEntity b){
		if(a.getX() + (a.getWidth()/2) > b.getX() && a.getX() - (a.getWidth()/2) < b.getX()){
			return true;
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