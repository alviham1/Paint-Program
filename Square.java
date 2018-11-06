package ca.utoronto.utm.paint;

/**
 * The Circle class creates a new square with the specified starting point and sidelenght.
 * It extends the abstract class shape. 
 *
 */
public class Square extends Shape{

	private Point start;
	private int sideLength;

	/**
	 * Creates an instance of Square that has a starting point, a side length, and
	 * is either filled or not filled.
	 * 
	 * @param start
	 *            The starting Point (x,y) of the square (top-left corner)
	 * @param sideLength
	 *            The length of each side of the square
	 * @param isFilled
	 *            Indicates whether the square should be drawn filled or not
	 */
	public Square(Point start, int sideLength, boolean fill) {
		super(fill);
		this.start = start;
		this.sideLength = sideLength;
	}

	/**
	 * @return the starting point of the Square
	 */
	public Point getStart() {
		return this.start;
	}

	/**
	 * Sets the starting point of the Square to the point provided.
	 * 
	 * @param start The new starting point of the Square
	 */
	public void setStart(Point start) {
		this.start = start;
	}

	/**
	 * 
	 * @return the side length of the Square
	 */
	public int getSideLength() {
		return this.sideLength;
	}

	/**
	 * Sets the side length of the Square to an integer value 'l'
	 * 
	 * @param l Integer representing new side length of the Square
	 */
	public void setSideLength(int l) {
		this.sideLength = l;
	}

}