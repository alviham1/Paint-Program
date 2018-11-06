package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawSquiggleCommand takes care of drawing a given Squiggle object on the panel.
 * This is because the Squiggle object does not know how to draw itself.
 *
 */
public class DrawSquiggleCommand implements DrawingCommand {
	private Squiggle squiggle;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawSquiggleCommand. This is the constructor.
	 * @param squiggle	The squiggle to be drawn
	 * @param color		The color property of the squiggle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawSquiggleCommand(Squiggle squiggle, Color color, int strokeThickness) {
		this.squiggle = squiggle;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return The Squiggle object
	 */
	public Squiggle getSquiggle() {
		return this.squiggle;
	}
	
	/**
	 * Set the Squiggle to the given Squiggle
	 * @param squiggle	The Squiggle to be set
	 */
	public void setSquiggle(Squiggle squiggle) {
		this.squiggle = squiggle;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(strokeThickness));
		
		for(int i = 0; i < this.squiggle.getPoints().size() - 1; i++){ 
			Point p1 = this.squiggle.getPoints().get(i);
			Point p2 = this.squiggle.getPoints().get(i+1);
			
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()); 
		}
	}
}
