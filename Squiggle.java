package ca.utoronto.utm.paint;


import java.util.ArrayList;

/**
 * This is the class that creates and paints the Squiggle shape within
 * PaintPanel it implements the interface ShapeComponent.
 */

public class Squiggle{ 
	
	private ArrayList<Point> c_Points;
	
	/**
	 * Creates a new instance of Squiggle
	 */
	public Squiggle() {
		this.c_Points = new ArrayList<Point>();
	}
	
	/**
	 * @return	The points in squiggle
	 */
	public ArrayList<Point> getPoints() {
		return this.c_Points;
	}
	
	/**
	 * Add a point to the Squiggle ArrayList
	 * @param p	The point to be added to Squiggle
	 */
	public void addPoint(Point p) {
		this.c_Points.add(p);	
	}
}
