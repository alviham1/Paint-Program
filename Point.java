package ca.utoronto.utm.paint;

/**
 * Point is a class used as a means of creating shapes, such as Squiggle. 
 */
public class Point {
	int x, y;
	
	/**
	 * Initialize Point. This is the constructor.
	 * @param x	The x-value of the point 
	 * @param y The y-value of the point
	 */
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * Returns the x position of the point
	 * @return	x position
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets an x value for the point
	 * @param x	The new x value for the point
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the y position of the point
	 * @return	y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets a y value for the point
	 * @param y	The new y value for the point
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
