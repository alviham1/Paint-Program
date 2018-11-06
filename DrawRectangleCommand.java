package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawRectangleCommand takes care of drawing a given Rectangle object on the panel.
 * This is because the Rectangle object does not know how to draw itself.
 *
 */
public class DrawRectangleCommand implements DrawingCommand {
	private Rectangle rectangle;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawRectangleCommand. This is the constructor.
	 * @param rectangle	The rectangle to be drawn
	 * @param color		The color property of the rectangle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawRectangleCommand(Rectangle rectangle, Color color, int strokeThickness) {
		this.rectangle = rectangle;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Rectangle object
	 */
	public Rectangle getRectangle() {
		return this.rectangle;
	}

	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke(strokeThickness));
		g2d.setColor(color);
		
		Point start = this.rectangle.getStart();
		int width = this.rectangle.getWidth();
		int height = this.rectangle.getHeight();
		
		if (!this.rectangle.getIsFilled()) {
			g2d.drawRect(start.getX(), start.getY(), width, height);
		} else {
			g2d.fillRect(start.getX(), start.getY(), width, height);
		}
		
	}
}
