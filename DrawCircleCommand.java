package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawCircleCommand takes care of drawing a given Circle object on the panel.
 * This is because the Circle object does not know how to draw itself.
 *
 */
public class DrawCircleCommand implements DrawingCommand {
	private Circle circle;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawCircleCommand. This is the constructor.
	 * @param circle	The circle to be drawn
	 * @param color		The color property of the circle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawCircleCommand(Circle circle, Color color, int strokeThickness) {
		this.circle = circle;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return The Circle object
	 */
	public Circle getCircle() {
		return this.circle;
	}
	
	
	/**
	 * @return paints the circle onto the canvas
	 */
	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke(strokeThickness));
		g2d.setColor(color);
		
		int x = this.circle.getCentre().getX() - this.circle.getRadius();
		int y = this.circle.getCentre().getY() - this.circle.getRadius();
		int diameter = this.circle.getRadius() * 2;
		
		if (!this.circle.getIsFilled()) {
			g2d.drawOval(x, y, diameter, diameter);
		} else {
			g2d.fillOval(x, y, diameter, diameter);
		}
	}
}
