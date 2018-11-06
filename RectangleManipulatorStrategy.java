package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * RectangleManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class RectangleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Rectangle rectangle;
	private int x1,y1;
	
	@Override
	public void mousePressed(MouseEvent e) {
		// Starting point for the rectangle
		x1 = e.getX();
		y1 = e.getY();
		Point starting = new Point(x1, y1);
		// creating the new rectangle 
		this.rectangle = new Rectangle(starting, 0, 0, panel.getIsFilled());
		panel.getPaintModel().addDrawingCommand(new DrawRectangleCommand(this.rectangle, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// old and new mouse click coordinates
		int x2 = e.getX();
		int y2 = e.getY();

		// width and height compoenents of rectangle
		int width = (int) (Math.abs(x2 - x1));
		int height = (int) (Math.abs(y2 - y1));
		
		this.rectangle.setWidth(width);
		this.rectangle.setHeight(height);
		
		// minimum statring points
		int minx = Math.min(x1, x2);
		int miny = Math.min(y1, y2);
		this.rectangle.setStart(new Point(minx, miny));
		// adding to the model so that the you can see the rectangle
		panel.repaint();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
