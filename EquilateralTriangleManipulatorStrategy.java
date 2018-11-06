package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * EquilateralTriangleManipulatorStrategy extends ShapeManipulatorStrategy and takes care of
 * what happens to the shape and panel when the user modifies the mouse position or status.
 *
 */
public class EquilateralTriangleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	private EquilateralTriangle equitriangle;
	private int x1,y1;

	@Override
	public void mousePressed(MouseEvent e) {
		// starting point for the triangle 
		x1 = e.getX();
		y1 = e.getY();
		Point center = new Point(e.getX(), e.getY());
		// create new triangle
		this.equitriangle = new EquilateralTriangle(center, panel.getIsFilled()); 	
		panel.getPaintModel().addDrawingCommand(new DrawEqTriangleCommand(this.equitriangle, panel.getPaintModel().getLastColor(), panel.getView().getSlider().getValue()));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point starting = new Point(e.getX(), e.getY());
		this.equitriangle.SetStart(starting);
		double m = Math.sqrt(Math.pow((this.equitriangle.getStart().getX() - this.equitriangle.getCentre().getX()), 2) + Math.pow((this.equitriangle.getStart().getY() 
                - this.equitriangle.getCentre().getY()), 2));
        double a1 = Math.atan2((this.equitriangle.getStart().getY() -  this.equitriangle.getCentre().getY()), (this.equitriangle.getStart().getX() - this.equitriangle.getCentre().getX()));
        double a2 = a1 + 2 * Math.PI / 3.0;
        double a3 = a2 + 2 * Math.PI / 3.0;
        Point p2 = new Point(this.equitriangle.getCentre().getX() + (int) (m * Math.cos(a2)), this.equitriangle.getCentre().getY() 
                + (int) (m * Math.sin(a2)));
        Point p3 = new Point(this.equitriangle.getCentre().getX()  + (int) (m * Math.cos(a3)), this.equitriangle.getCentre().getY()  
                + (int) (m * Math.sin(a3)));
		
        this.equitriangle.SetPoint2(p2);
        this.equitriangle.SetPoint3(p3);
       
        panel.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
