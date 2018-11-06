package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * LineManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class LineManipulatorStrategy extends ShapeManipulatorStrategy{
	
	private Line line; // line that is being crated 
	

	@Override
	public void mousePressed(MouseEvent e) {
		// starting point for the triangle 
		Point center = new Point(e.getX(), e.getY());
		Point start = new Point(e.getX() +1, e.getY() +1);
		// create new triangle
		this.line = new Line(center, start); 	
		panel.getPaintModel().addDrawingCommand(new DrawLineCommand(this.line, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point starting = new Point(e.getX(), e.getY());
		this.line.SetEnd(starting);
		
        panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}


