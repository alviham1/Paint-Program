package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * DrawEraserCommand takes care of drawing a given Eraser object on the panel.
 * This is because the Eraser object does not know how to draw itself.
 *
 */
public class DrawEraserCommand implements DrawingCommand {
	private Squiggle eraser;

	/**
	 * Initializing DrawEraserCommand. This is the constructor.
	 * @param eraser	The Eraser to be drawn
	 */
	public DrawEraserCommand(Squiggle eraser) {
		this.eraser = eraser;
	}

	@Override
	public void execute(Graphics2D g2d) {
		
		g2d.setColor(Color.white);
		g2d.setStroke(new BasicStroke(20));
		
		for(int i = 0; i < this.eraser.getPoints().size() - 1; i++){ 
			Point p1 = this.eraser.getPoints().get(i);
			Point p2 = this.eraser.getPoints().get(i+1);
	
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()); 
		}
	}
}
