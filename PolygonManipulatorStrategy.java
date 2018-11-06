package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * PolygonManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class PolygonManipulatorStrategy extends ShapeManipulatorStrategy {

	private Polygon polygon; // the polygon that is getting created 
	private int sides; // number of sides of the polygon
	private int x1, y1;
	
	
	/**
	 * Initializing PolygonManipulatorStrategy. This is the constructor.
	 * @param sides the desired number of sides of the polygon 
	 */

	public PolygonManipulatorStrategy(int sides) {
		this.sides = sides;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// starting point for the triangle
		x1 = e.getX();
		y1 = e.getY();
		Point center = new Point(e.getX(), e.getY());
		// create new triangle
		this.polygon = new Polygon(center, sides, panel.getIsFilled());
		panel.getPaintModel().addDrawingCommand(new DrawPolygonCommand(this.polygon,
				panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point starting = new Point(e.getX(), e.getY());
		this.polygon.SetStart(starting);
		
		double m = Math.sqrt(Math.pow((this.polygon.getStart().getX() - this.polygon.getCentre().getX()), 2)
				+ Math.pow((this.polygon.getStart().getY() - this.polygon.getCentre().getY()), 2));
		double a1 = Math.atan2((this.polygon.getStart().getY() - this.polygon.getCentre().getY()),
				(this.polygon.getStart().getX() - this.polygon.getCentre().getX()));
		
		double previousSide = a1;
		
		for(int i = 2; i <= sides; i++) {
			double currentSide = previousSide + 2 * Math.PI / sides;
			Point currentPoint = new Point(this.polygon.getCentre().getX() + (int) (m * Math.cos(currentSide)),
					this.polygon.getCentre().getY() + (int) (m * Math.sin(currentSide)));
			this.polygon.addPoints(currentPoint, i-1);
			previousSide = currentSide;
		}
		panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
