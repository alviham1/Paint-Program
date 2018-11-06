package ca.utoronto.utm.paint;

/**
 * This is the class that creates and paints the line within PaintPanel.
 * 
 */
public class Line {
	private Point start; // point that start the line
	private Point end; // point that end the line
	
	/**
	 * Initialize a new line with specified starting and ending point
	 * @param start the desired starting point of the line
	 * @param end the desired ending point of the line
	 */
	public Line(Point start, Point end) {
		this.start = start;
		this.end  = end;
	}
	
	/**
	 * getter method to get starting point 
	 * @return
	 */	
	public Point getstart() {
		return start;
	}
	/**
	 * set the starting point of the line 
	 * @param start desired point from which the line should start
	 */
	public void setstart(Point start) {
		this.start = start;	
	} 
	
	/**
	 * getter method to get ending point 
	 * @return
	 */	
	public Point getEnd() {
		return end;
	}
	/**
	 * set the ending point of the line
	 * @param end desired point from which the line should end
	 */
	public void SetEnd(Point end) {
		this.end  = end;
	}
	
}
