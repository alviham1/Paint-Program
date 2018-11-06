package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * TriangleManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class TriangleManipulatorStrategy extends ShapeManipulatorStrategy {

	private Triangle triangle;

	@Override
	public void mousePressed(MouseEvent e) {
		// starting point for the triangle 
		if (Triangle.getClick_count() == 0 || Triangle.getClick_count() >= 3){
			System.out.println(e.getX() + "  " + e.getY());
			Point starting = new Point(e.getX(), e.getY());
			// create new triangle
			this.triangle = new Triangle(starting, panel.getIsFilled());
		}
		else if (Triangle.getClick_count() == 1) {
			Point point2 = new Point(e.getX(), e.getY());
			this.triangle.addPoint2(point2);
			panel.getPaintModel().addDrawingCommand(new DrawTriangleCommand(this.triangle, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Triangle.getClick_count() == 2) {
			// Starting point for the triangle 
			Point starting = new Point(e.getX(), e.getY());
			// changing the third point of the triangle 
			this.triangle.addPoint3(starting);
			
		}
		panel.repaint();
	}
	
	public void mouseClicked(MouseEvent e) {
		
		System.out.println(Triangle.getClick_count());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Triangle.setClick_count(Triangle.getClick_count() + 1);
		System.out.println(Triangle.getClick_count());
		panel.repaint();
	}

}
