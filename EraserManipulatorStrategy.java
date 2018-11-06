package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * EraserManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 * An eraser is essentially a squiggle with a white color so it cleans the canvas.
 */
public class EraserManipulatorStrategy extends SquiggleManipulatorStrategy {

	private Squiggle eraser = new Squiggle();

	@Override
	public void mousePressed(MouseEvent e) {
		Point c_Point = new Point(e.getX(), e.getY());
		this.eraser.addPoint(c_Point);
		panel.getPaintModel().addDrawingCommand(new DrawEraserCommand(this.eraser));	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point c_Point = new Point(e.getX(), e.getY());
		this.eraser.addPoint(c_Point);
		panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.eraser = new Squiggle();	
	}
}