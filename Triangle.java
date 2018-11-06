package ca.utoronto.utm.paint;

/**
 * A Triangle is a Shape.The Triangle class creates a new triangle with the specified size and center location
 * It extends the abstract class shape.
 */
public class Triangle extends Shape{ 
	
	private int[] pointsx = {0, 0, 0};
	private int[] pointsy = {0, 0, 0};
	private Point start;
	private static int click_count;
	/**
	 * Initialize a new Triangle with specified Color, width, height, position, fill and stroke
	 *
	 * @param start
	 *            the desired starting location stored as the x and y coordinates in Point format
	 * @param fill
	 *            the desired fill type so if true the shape is filled else it not filled and just outline
	 * 
	 */
	public Triangle(Point Start, Boolean fill) {
		super(fill);
		this.pointsx[0] = Start.getX();
		this.pointsy[0] = Start.getY();
		this.pointsx[1] = Start.getX();
		this.pointsy[1] += Start.getY();
		this.pointsx[2] += Start.getX();
		this.pointsy[2] += Start.getY();
		setClick_count(0);

		//this.isFilled = fill;
		this.start = Start;
		
	}
	
	/**
	 * increases or decreases the y value of the second point 
	 * @param x2 the desired position of the second point 
	 */
	public void addPoint2(Point x2) {
		this.pointsx[1] = x2.getX();
		this.pointsy[1] = x2.getY();
		
	} 
	/**
	 * increases or decreases the x,y value of the third point 
	 * @param x3 the desired position of the third point
	 */
	public void addPoint3(Point x3) {
		this.pointsx[2] = x3.getX();
		this.pointsy[2] = x3.getY();
	} 
	
	/**
	 * getter method to get starting position 
	 * @return
	 */
	public Point getStart() {
		return this.start;
	}
	
	public int[] getPointsX() {
		return this.pointsx;
	}
	
	public int[] getPointsY() {
		return this.pointsy;
	}

	public static int getClick_count() {
		return click_count;
	}

	public static void setClick_count(int click_count) {
		Triangle.click_count = click_count;
	}

	public void setStart(Point starting) {
		this.start = starting;
		
	}
	
}
