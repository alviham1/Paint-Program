package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * CircleManipulatorStrategy manipulates a given Circle object when the user presses
 * or drags the mouse on the panel
 */
public class CircleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private Circle circle; //the circle which is being created 
	private int x1,y1; // The x and y point of starting point 
		
	@Override
	public void mousePressed(MouseEvent e) {
		// Starting point for the circle
		x1 = e.getX();
		y1 = e.getY();
		
		Point centre = new Point(x1, y1);
		this.circle = new Circle(centre, 0, panel.getIsFilled());
		this.panel.getPaintModel().addDrawingCommand(new DrawCircleCommand(this.circle, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// the current final points of the feedback circle
		int x2 = e.getX();
		int y2 = e.getY();
		
		//distance formula to get the radius
		int radius = (int) ((Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2))));
		this.circle.setRadius(radius);
		
		panel.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
