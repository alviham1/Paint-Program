package ca.utoronto.utm.paint;

import java.util.ArrayList;

/**
 * This is the class that creates and paints the Polyline shape within
 * PaintPanel. It implements the interface ShapeComponent.
 */
public class Polyline { 
	
	private ArrayList<Point> c_Points = new ArrayList<Point>();
	private PaintPanel panel;
	private View a_View; 
	
	public Polyline(PaintPanel panel, View a_View) {
		this.panel = panel;
		this.a_View = a_View;
	}
	
	/**
	 * Adds a new point to the points array
	 * @param c_Point	New point to be added
	 */
	public void addPoint(Point c_Point) {
		int strokeWidth = this.a_View.getSlider().getValue();
		Point newPoint = c_Point;
		
		if(this.getPoints().size() > 0) {
			Point firstPoint = this.getPoints().get(0);
			Point lastPoint = this.getPoints().get(this.getPoints().size() - 1);
			
			// Used to measure the distance of the shape close 
			int distance = Math.max(15, strokeWidth / 2);
			
			PolylineManipulatorStrategy polyStrategy = (PolylineManipulatorStrategy)this.panel.strategy;
			// If the first point and current point are within distance of each other
			if((Math.abs(firstPoint.getX() - c_Point.getX()) < distance && Math.abs(firstPoint.getY() - c_Point.getY()) < distance) &&
					!polyStrategy.getPreviousDrag()) {
				// The point that is added will be the first point
				newPoint = firstPoint;
				// A new polyline will appear on the panel
				this.panel.setShapeStrategy(this.panel.shapefactory.create("Polyline", this.a_View));
			} 

			// If the last point and current point are within distance of each other AND 
			// the user is not currently dragging
			if((Math.abs(lastPoint.getX() - c_Point.getX()) < distance && Math.abs(lastPoint.getY() - c_Point.getY()) < distance) && 
					!polyStrategy.getPreviousDrag()) {
				// The point that is added will be the first point
				newPoint = firstPoint;
				// A new polyline will appear on the panel
				this.panel.setShapeStrategy(this.panel.shapefactory.create("Polyline", this.a_View));
			}
		}
		// Either the point the user gave OR the first point
		this.c_Points.add(newPoint);
	}
	
	/**
	 * Returns the points array that stores clicked points
	 * @return	An array of all the points
	 */
	public ArrayList<Point> getPoints() {
		return this.c_Points;
	}
}
