package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * PolylineManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class PolylineManipulatorStrategy extends ShapeManipulatorStrategy {

	private PaintPanel panel;
	private View view;
	private Polyline polyline;
	private Boolean previousDrag = false;
	private Point lastPoint = null;
	
	/**
	 * Initializing PolylineManipulatorStrategy. This is the constructor.
	 * @param panel	The PaintPanel of the program
	 * @param view	The View of the program
	 */
	public PolylineManipulatorStrategy(PaintPanel panel, View view) {
		this.view = view;
		this.panel = panel;
		this.polyline = new Polyline(panel, view);
	}

	/**
	 * @return	The Polyline object
	 */
	public Polyline getPolyline() {
		return this.polyline;
	} 
	
	/**
	 * @return Whether the polyline was previously dragged
	 */
	public Boolean getPreviousDrag() {
		return this.previousDrag;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// If there is a previous point 
		if(this.lastPoint != null) {
			ArrayList<Point> c_Points = this.polyline.getPoints();
			
			// The user has now dragged
			this.previousDrag = true;
			
			// Ensures that the feedback point gets deleted
			c_Points.remove(c_Points.size() - 1);
			this.getPolyline().addPoint(this.lastPoint);
			this.getPolyline().addPoint(new Point(e.getX(), e.getY()));
			// Refresh the panel
			panel.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Point newPoint = new Point(e.getX(), e.getY());
		this.polyline.addPoint(newPoint);
		this.lastPoint = newPoint;
		this.previousDrag = false;
		
		// Delete the previous polyline so the thickness slider is fully functional
		if(this.polyline.getPoints().size() > 1 && panel.getPaintModel().getShapes().size() > 0) {
			panel.getPaintModel().removeDrawingCommand();
		} 
		
		panel.getPaintModel().addDrawingCommand(new DrawPolylineCommand(this.polyline,
				panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));	
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
}
