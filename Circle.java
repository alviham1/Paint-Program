package ca.utoronto.utm.paint;

/**
 * The Circle class creates a new circle with the specified radius and center location it extends the abstract class shape. 
 * 
 */
public class Circle extends Shape {
	
	private Point centre;
	private int radius;

	/**
	 * Creates a new instance of Circle with the given center point and radius  and
	 * is either filled or not filled..
	 * 
	 * @param centre the desired centre location 
	 * @param radius the desired radius
	 */
	public Circle(Point centre, int radius, boolean fill) {
		super(fill);
		this.centre = centre;
		this.radius = radius;
	}

	
	/**
	 * return the centre point of the circle
	 * @return centre of the circle
	 */
	public Point getCentre() {
		return centre;
	}
	
	/**
	 * set the centre of the circle to centre
	 * 
	 * @param centre the new centre to be set
	 */
	public void setCentre(Point centre) {
		this.centre = centre;	
	}
	
	/**
	 * get the radius of the circle.
	 * 
	 * @return the radius
	 *
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * set the radius of the circle to radius
	 * 
	 * @radius the new radius to be set.
	 *
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
}
