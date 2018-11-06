package ca.utoronto.utm.paint;



/**
 * A Polygon is a Shape.The Polygon class creates a new polygon with the specified size(number of sides) and center location
 * It extends the abstract class shape.
 */
public class Polygon extends Shape {
	private int[] pointsx = new int[3]; // where the x coordinates of vertices of the polygon is stored
	private int[] pointsy = new int[3]; // where the y coordinates of vertices of the polygon is stored
	private Point centre; // the center of the polygon
	private Point start; // the start of the polygon
	private int side; // intial number of sides 
	
	/**
	 * Initialize a new Polygon with specified number of sides, position, fill
	 *
	 * @param center
	 *            the desired center location stored as the x and y coordinates in Point format
	 * @param sides
	 * 			  the desired number of sides of the shape	
	 * @param fill
	 *            the desired fill type so if true the shape is filled else it not filled and just outline
	 * 
	 */
	public Polygon(Point centre, int sides, Boolean fill) {
		super(fill);
		this.centre = centre;
		this.side = sides;
		this.pointsx = new int[side];
		this.pointsy = new int[side];
		
	}

	/**
	 * getter method to get first vertex point  
	 * @return
	 */
	public Point getStart() {
		return start;
	}
	/**
	 * set the first vertex of the polygon 
	 * @param start desired position of the first vertex
	 */
	public void SetStart(Point start) {
		this.start  = start;
		this.pointsx[0] = start.getX();
		this.pointsy[0] = start.getY();
	}
	
	
	/**
	 * getter method to get center position 
	 * @return
	 */	
	public Point getCentre() {
		return centre;
	}
	/**
	 * set the centre of the polygon to centre 
	 * @param centre the new centre to be set
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
		
	}
	/**
	 * list that contains all the vertices of the polygon
	 * @param p1  one of the desired vertex of polygon 
	 * @param index tells you the number of vertex which you have already added  
	 */
	public void addPoints(Point p1, int index) {
		this.pointsx[index] = p1.getX();
		this.pointsy[index] = p1.getY();
	}
	
	/**
	 * getter method to get the x coordintes of the vertices of the polygon 
	 * @return
	 */
	public int[] getPointsX() {
		return this.pointsx;
	}
	/**
	 * getter method to get the y coordintes of the vertices of the polygon
	 * @return
	 */
	public int[] getPointsY() {
		return this.pointsy;
	}
	
	/**
	 * getter method to get the number of sides 
	 * @return
	 */
	public int getSide() {
		return this.side;
	}
	/**
	 * setter methof to set the number of sides 
	 * @param side the desired side 
	 */
	public void setSide(int side) {
		this.side = side;
	}
	
}
