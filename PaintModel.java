package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable; 

/**
 * PaintModel is where all the shapes are connected and painted on the
 * canvas.
 */

public class PaintModel extends Observable implements DrawingCommand{

	private ArrayList<DrawingCommand> shapes = new ArrayList<DrawingCommand>();
	private Color lastColor = Color.black;
	private boolean isFilled = false;
	
	/**
	 * Adds a shape to the shapes ArrayList
	 * @param shape	Shape to be added
	 */
	public void addDrawingCommand(DrawingCommand shape) { 
		this.shapes.add(shape);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Removes the last shape within shapes
	 */
	public void removeDrawingCommand() {
		this.shapes.remove(this.shapes.size() - 1);
	}
	
	/**
	 * @return The shapes array
	 */
	public ArrayList<DrawingCommand> getShapes() {
		return this.shapes;
	}
	
	/**
	 * Change the last color used for the shapes
	 * @param color	New last color
	 */
	public void changeLastColor(Color color) {
		this.lastColor = color;
	}
	
	/**
	 * @return	The last color used for the shapes
	 */
	public Color getLastColor() {
		return lastColor;
	}
	
	/**
	 * Sets isFilled to a new boolean
	 * @param isFilled	New value for isFilled
	 */
	public void setIsFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	/**
	 * @return	The isFilled boolean
	 */
	public boolean getIsFilled() {
		return this.isFilled;
	}	
	
	/**
	 * Paints the shape on the main frame using g2d
	 * @param g2d	The Graphics2D object to draw shapes
	 * @param color	The color the object should be set to
	 * @param stroke	The stroke width of the shape
	 */
	public void execute(Graphics2D g2d) {
		for (DrawingCommand Shape : this.shapes) {
			Shape.execute(g2d);
		}
	}
}
