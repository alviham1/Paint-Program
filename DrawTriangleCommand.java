package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawTriangleCommand takes care of drawing a given Triangle object on the panel.
 * This is because the Triangle object does not know how to draw itself.
 *
 */
public class DrawTriangleCommand implements DrawingCommand {
	private Triangle triangle;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawTriangleCommand. This is the constructor.
	 * @param triangle	The triangle to be drawn
	 * @param color		The color property of the triangle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawTriangleCommand(Triangle triangle, Color color, int strokeThickness) {
		this.triangle = triangle;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Triangle object
	 */
	public Triangle getTriangle() {
		return this.triangle;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(strokeThickness));
		g2d.setColor(color);
		
		int[] pointsX = this.triangle.getPointsX();
		int[] pointsY = this.triangle.getPointsY();
				
		if (!this.triangle.getIsFilled()) {
			g2d.drawPolygon(pointsX, pointsY, 3);
		} else {
			g2d.fillPolygon(pointsX, pointsY, 3);
		}
	}
}
