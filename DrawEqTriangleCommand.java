package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawEqTriangleCommand takes care of drawing a given EquilateralTriangle object on the panel.
 * This is because the EquilateralTriangle object does not know how to draw itself.
 *
 */
public class DrawEqTriangleCommand implements DrawingCommand {
	private EquilateralTriangle equitriangle;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawEqtriangleCommand. This is the constructor.
	 * @param equitriangle	The EquilateralTriangle to be drawn
	 * @param color			The color property of the EquilateralTriangle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawEqTriangleCommand(EquilateralTriangle equitriangle, Color color, int strokeThickness) {
		this.equitriangle = equitriangle;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The EquilateralTriangle object
	 */
	public EquilateralTriangle getequiTriangle() {
		return this.equitriangle;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke(this.strokeThickness));
		g2d.setColor(this.color);
		
		int[] pointsX = this.equitriangle.getPointsX();
		int[] pointsY = this.equitriangle.getPointsY();
				
		if (!this.equitriangle.getIsFilled()) {
			g2d.drawPolygon(pointsX, pointsY, 3);
		} else {
			g2d.fillPolygon(pointsX, pointsY, 3);
		}
	}

}
