package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * ShapeManipulatorStrategy is an abstract class that allows each shape to know what
 * to do when the mouse position or status is modified.
 *
 */
public abstract class ShapeManipulatorStrategy {
	
	protected PaintPanel panel;
	
	/**
	 * Initializing the panel variable
	 * @param panel	The PaintPanel of the application
	 */
	public void plug(PaintPanel panel) {
		this.panel = panel;
	}
	
	/**
	 * The actions to be performed when the user presses the mouse
	 * @param e	The Event for the mouse
	 */
	public abstract void mousePressed(MouseEvent e) ;
	
	/**
	 * The actions to be performed when the user drags the mouse
	 * @param e	The Event for the mouse
	 */
	public abstract void mouseDragged(MouseEvent e) ;

	/**
	 * The actions to be performed when the user releases the mouse
	 * @param e	The Event for the mouse
	 */
	public abstract void mouseReleased(MouseEvent e) ;

}
