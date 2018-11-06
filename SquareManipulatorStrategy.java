package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * SquareManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class SquareManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Square square;
	private int x1,y1;

	@Override
	public void mousePressed(MouseEvent e) {
		// Starting point for the square.
		x1 = e.getX();
		y1 = e.getY();
		Point start = new Point(x1, y1);
		this.square = new Square(start, 0, panel.getIsFilled()); //fillstyle	
		panel.getPaintModel().addDrawingCommand(new DrawSquareCommand(this.square, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// the current final points of the feedback square
		int x2 = e.getX();
		int y2 = e.getY();
					
		// Distance formula to get the sidelenght.
		int sideLength = (int) ((Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2))));
		this.square.setSideLength(sideLength);
					
		// shifting initial point when square drawn right to left or down to up, we subtract from initial point
		// instead of setting new starting point to min(x1,x2), min(y1,y2) so as to discount any inaccuracies.
		int minX = x1;
		int minY = y1;
		if ((x2 - x1) < 0) {
			minX = (int) (x1 - sideLength);
		}
		if ((y2 - y1) < 0) {
			minY = (int) (y1 - sideLength);
		}
		this.square.setStart(new Point(minX, minY));
		panel.repaint();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
