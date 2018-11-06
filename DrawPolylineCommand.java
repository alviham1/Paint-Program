package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * DrawPolylineCommand takes care of drawing a given Polyline object on the panel.
 * This is because the Polyline object does not know how to draw itself.
 *
 */
public class DrawPolylineCommand implements DrawingCommand {
	private Polyline polyline;
	private int strokeThickness;
	private Color color;
	
	/**
	 * Initializing DrawPolylineCommand. This is the constructor.
	 * @param polyline		The Polyline to be drawn
	 * @param color			The color property of the Polyline
	 * @param strokeThickness	How large the stroke should be
	 */
	public DrawPolylineCommand(Polyline polyline, Color color, int strokeThickness) {
		this.polyline = polyline;
		this.strokeThickness = strokeThickness;
		this.color = color;
	}
	
	/**
	 * @return	The Polyline object
	 */
	public Polyline getPolyline() {
		return this.polyline;
	}
	
	/**
	 * Set the Polyline object
	 * @param polyline	The new Polyline object
	 */
	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}
	
	@Override
	public void execute(Graphics2D g2d) {
		// Need to convert the x and y points to an array since thats the input
		// type of g2d.drawPolyline()
		
		ArrayList<Point> c_Points = this.polyline.getPoints();
		int[] xList = new int[c_Points.size()];
		int[] yList = new int[c_Points.size()];
		
	    for (int i=0; i < xList.length; i++) {
	    		
	        xList[i] = c_Points.get(i).getX();
	        yList[i] = c_Points.get(i).getY();
	    }
	    // Can only draw the polyline if there is at least one point already present
	    if(xList.length > 0) {
	    	g2d.setStroke(new BasicStroke(strokeThickness));
			g2d.setColor(color);
	    	
	    	g2d.drawPolyline(xList, yList, xList.length);
	    }		
	}

}
