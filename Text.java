package ca.utoronto.utm.paint;

import java.awt.Font;

/**
 * Text creates a new text object which takes in a starting location and the size of the rectangle
 * surrounding it and it extends Shape
 *
 */
public class Text extends Shape {
	
	private Point start;
	private int width, height;
	private String text = "";
	private Font font;
	
	/**
	 * Initialize a new Text with specified width, height, starting position
	 *
	 * @param start
	 *            the desired starting location stored as the x and y coordinates in Point format
	 * @param width
	 *            the desired width of the rectangle stored as int
	 * @param height
	 *            the desired height if the rectangle stored as int
	 * 
	 */
	public Text(Point start, int width, int height) {
		super(false);
		this.start = start;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * this is a getter method which returns the starting point stored in the parameter this.start 
	 * @return
	 */
	public Point getStart() {
		return this.start;
	}
	
	/**
	 * this is a setter method with sets the Start Point 
	 * @param s
	 * 		desired Starting point to set for the rectangle 
	 */
	public void setStart(Point s) {
		this.start = s;
	}
	
	/**
	 * this is a getter method which returns the current width of the rectangle 
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * @return the font of the text
	 */
	public Font getFont() {
		return this.font;
	}
	
	/**
	 * setter method which sets the width of the rectangle with parameter 
	 * @param width
	 * 			contains the new desired width of the rectangle in int 
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Sets the font given the font and size
	 * @param newFont	The new font
	 * @param newSize	The new size
	 */
	public void setFont(String newFont, int newSize) {
		this.font = new Font(newFont, Font.PLAIN, newSize);
	}
	
	/**
	 * this is a getter method which returns the current width of the rectangle 
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * getter method returns the current height of the rectangle stored in this.height
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * setter method which sets the width of the rectangle with parameter 
	 * @param width
	 * 			contains the new desired width of the rectangle in int 
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * setter method which sets the height of the rectangle with the parameter 
	 * @param height
	 * 			contains the new desired height of the rectangle in int 
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
