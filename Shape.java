package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observer;

/**
 *The Shape class provides definitions of common properties for objects that represent some form of geometric shape. 
 *This defines all the characteristics any Shape subclass must have. These properties include among others:
 *The color to be applied to the shape.
 *The Paint to be applied to stroke the outline of the shape (see setStroke).
 *it implements the interface shapeComponent. 
 */

public abstract class Shape {
	
	protected boolean isFilled;// private boolean isFilled.
	protected int x1 , y1;

	public Shape(boolean fill) {
		this.isFilled = fill;
	}
		
	/**
	 * 
	 * @return whether the Square is filled or not
	 */
	public boolean getIsFilled() {
		return this.isFilled;
	}
	
	/**
	 * set whether the shape is filled or not.
	 * 
	 * @param isFilled boolean representing whether the shape should be drawn filled      
	 */
	public void setIsFilled(boolean fill) {
		this.isFilled = fill;
	}
	
	/**
	 * Sets the color and stroke of the shape
	 * @param g2d	The Graphics2D object to draw shapes
	 * @param color	The color the object should be set to
	 * @param stroke	The stroke width of the shape
	 */
	public void setDesign(Graphics2D g2d, Color color, BasicStroke stroke) {
		g2d.setColor(color);
		g2d.setStroke(stroke);
	} 
}

