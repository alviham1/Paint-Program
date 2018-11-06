package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawLineCommand takes care of drawing a given Line object on the panel.
 * This is because the Line object does not know how to draw itself.
 *
 */
public class DrawLineCommand implements DrawingCommand {
	private Line line;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawLineCommand. This is the constructor.
	 * @param line			The Line to be drawn
	 * @param color			The color property of the EquilateralTriangle
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawLineCommand(Line line, Color color, int strokeThickness) {
		this.line = line;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Line object
	 */
	public Line getLine() {
		return this.line;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(this.strokeThickness));
		g2d.setColor(this.color);
		g2d.drawLine(this.line.getstart().getX(), this.line.getstart().getY(), this.line.getEnd().getX(), this.line.getEnd().getY());
       
	}

}
	

