package ca.utoronto.utm.paint;


/**
 * A class to define a Rectangle with specified size and starting point.
 * it extends the abstract class shape. 
 */

public class Rectangle extends Shape{
	private Point start;
	private int width, height;
	
	/**
	 * Initialize a new Rectangle with specified Color, width, height, position, fill and stroke
	 *
	 * @param start
	 *            the desired starting location stored as the x and y coordinates in Point format
	 * @param width
	 *            the desired width of the rectangle stored as int
	 * @param height
	 *            the desired height if the rectangle stored as int
	 * @param fill
	 *            the desired fill type so if true the shape is filled else it not filled and just outline
	 * 
	 */
	public Rectangle(Point start, int width, int height, boolean fill) {
		super(fill);
		this.start = start;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * this is a getter method which returns the starting point stored in the parameter this.start 
	 * @return
	 */
	public Point getStart() {
		return this.start;
	}
	
	/**
	 * this is a setter method with sets the Start Point 
	 * @param s
	 * 		desired Starting point to set for the rectangle 
	 */
	public void setStart(Point s) {
		this.start = s;
	}
	/**
	 * this is a getter method which returns the current width of the rectangle 
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * getter method returns the current height of the rectangle stored in this.height
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * setter method which sets the width of the rectangle with parameter 
	 * @param width
	 * 			contains the new desired width of the rectangle in int 
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * setter method which sets the height of the rectangle with the parameter 
	 * @param height
	 * 			contains the new desired height of the rectangle in int 
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
