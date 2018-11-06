package ca.utoronto.utm.paint;

/**
 * A Triangle is a Shape.The Triangle class creates a new triangle with the specified size and center location
 * It extends the abstract class shape.
 */
public class EquilateralTriangle extends Shape{
	private int[] pointsx = {0, 0, 0};
	private int[] pointsy = {0, 0, 0};
	private Point centre;
	private Point start;
	private Point p2;
	private Point p3;
	
	/**
	 * Initialize a new Triangle with specified Color, width, height, position, fill and stroke
	 *
	 * @param start
	 *            the desired starting location stored as the x and y coordinates in Point format
	 * @param fill
	 *            the desired fill type so if true the shape is filled else it not filled and just outline
	 * 
	 */
	public EquilateralTriangle(Point center, Boolean fill) {
		super(fill);
		this.centre = center;
		
	}
	
	/**
	 * getter method to get starting position 
	 * @return
	 */	
	public Point getCentre() {
		return centre;
	}
	/**
	 * set the centre of the circle to centre 
	 * @param centre the new centre to be set
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	public Point getStart() {
		return start;
	}
	
	public void SetStart(Point start) {
		this.start  = start;
		this.pointsx[0] = start.getX();
		this.pointsy[0] = start.getY();
	}
	
	public Point getPoint2() {
		return p2;
	}
	
	public void SetPoint2(Point point2) {
		this.p2  = point2;
		this.pointsx[1] = p2.getX();
		this.pointsy[1] = p2.getY();
	}
	
	public Point getPoint3() {
		return p3;	
	}
	
	public void SetPoint3(Point point3) {
		this.p3  = point3;
		this.pointsx[2] = p3.getX();
		this.pointsy[2] = p3.getY();
	}
	
	public int[] getPointsX() {
		return this.pointsx;
	}
	
	public int[] getPointsY() {
		return this.pointsy;
	}
	
}