package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * SquiggleManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class SquiggleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Squiggle squiggle = new Squiggle();

	@Override
	public void mousePressed(MouseEvent e) {
		Point c_Point = new Point(e.getX(), e.getY());
		this.squiggle.addPoint(c_Point);
		panel.getPaintModel().addDrawingCommand(new DrawSquiggleCommand(this.squiggle, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point c_Point = new Point(e.getX(), e.getY());
		this.squiggle.addPoint(c_Point);
		panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		this.squiggle = new Squiggle();	
	}
}
