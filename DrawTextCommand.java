package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

/**
 * DrawTextCommand takes care of drawing a given Text object on the panel.
 * This is because the Text object does not know how to draw itself.
 *
 */
public class DrawTextCommand implements DrawingCommand {
	private Text text;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawTextCommand. This is the constructor.
	 * @param text	The text to be drawn
	 * @param color		The color property of the text
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawTextCommand(Text text, Color color, int strokeThickness) {
		this.text = text;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Text object
	 */
	public Text getText() {
		return this.text;
	}

	@Override
	public void execute(Graphics2D g2d) {
		FontMetrics fm = g2d.getFontMetrics();
		
		if(this.text.getText() != null) {
			g2d.setStroke(new BasicStroke(strokeThickness));
			g2d.setColor(color);
			
			Point start = this.text.getStart();
			int width = this.text.getWidth();
			int height = this.text.getHeight();
			
			g2d.setFont(this.text.getFont());
			
		    fm = g2d.getFontMetrics();
		    int w = fm.stringWidth(this.text.getText());
			
			g2d.drawString(this.text.getText(),(start.getX() + (width/2))- (w/2) , start.getY() + (height/2));
		}
	}
	
}
