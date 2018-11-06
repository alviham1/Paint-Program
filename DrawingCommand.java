package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * DrawingCommand is an interface that is used within all the drawable classes. 
 * Main use of this is to ensure each shape can be painted on the main frame.
 *
 */
public interface DrawingCommand {
	/**
	 * Paints the shape on the main frame using g2d
	 * @param g2d	The Graphics2D object to draw shapes
	 * @param color	The color the object should be set to
	 * @param stroke	The stroke width of the shape
	 */
	public void execute(Graphics2D g2d);
}

