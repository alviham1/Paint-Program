package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * DrawPolygonCommand takes care of drawing a given different Polygons object on the panel.
 * This is because the Polygon object does not know how to draw itself.
 *
 */
public class DrawPolygonCommand implements DrawingCommand {

	private Polygon polygon; // the polygon we are creating
	private int strokeThickness; // the thickness of the outline of polygon 
	private Color color; // color of the polygon
	
	/**
	 * Initializing DrawPolygonCommand. This is the constructor.
	 * @param polygon	The polygon to be drawn
	 * @param color		The color property of the rectangle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawPolygonCommand(Polygon polygon, Color color, int strokeThickness) {
		this.polygon = polygon;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Polygon object
	 */
	public Polygon getpolygon() {
		return this.polygon;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke(this.strokeThickness));
		g2d.setColor(this.color);
		
		int[] pointsX = this.polygon.getPointsX();
		int[] pointsY = this.polygon.getPointsY();
				
		if (!this.polygon.getIsFilled()) {
			g2d.drawPolygon(pointsX, pointsY, this.polygon.getSide());
		} else {
			g2d.fillPolygon(pointsX, pointsY, this.polygon.getSide());
		}
		
	}

}

