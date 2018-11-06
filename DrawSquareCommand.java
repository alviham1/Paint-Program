package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawSquareCommand takes care of drawing a given Square object on the panel.
 * This is because the Square object does not know how to draw itself.
 *
 */
public class DrawSquareCommand implements DrawingCommand {
	private Square square;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawSquareCommand. This is the constructor.
	 * @param square	The square to be drawn
	 * @param color		The color property of the square
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawSquareCommand(Square square, Color color, int strokeThickness) {
		this.square = square;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return The Square object
	 */
	public Square getSquare() {
		return this.square;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke(strokeThickness));
		g2d.setColor(color);
		
		Point start = this.square.getStart();
		int sideLength = this.square.getSideLength();
		
		g2d.drawRect(start.getX(), start.getY(), sideLength, sideLength);
		
		
		if (!this.square.getIsFilled()) {
			g2d.drawRect(start.getX(), start.getY(), sideLength, sideLength);
		} else {
			g2d.fillRect(start.getX(), start.getY(), sideLength, sideLength);
		}
		
	}
}
