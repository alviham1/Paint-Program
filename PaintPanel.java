package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * PaintPanel is a JPanel where the user draws and selects shapes. It uses mouse listeners
 * in order to create the shapes and observes paint model for changes.
 *
 */
class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View a_View; // So we can talk to our parent or other components of the view
	
	protected ShapeManipulatorStrategy strategy;
	protected ShapeStrategyFactory shapefactory = new ShapeStrategyFactory();
	
	private Boolean fillstyle = false; // the fill style for all shapes 
	private int side; //for the polygon
	
	public PaintPanel(PaintModel model, View a_View) {
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(500, 500));
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.a_View = a_View;
		this.strategy = new SquiggleManipulatorStrategy(); 
		this.model = model;
		this.model.addObserver(this);
		this.a_View = a_View;
		
		strategy = new SquiggleManipulatorStrategy();
		strategy.plug(this);
	}
	
	public void setShapeStrategy(ShapeManipulatorStrategy s) {
		s.plug(this);
		strategy = s;
	}
	
	/**
	 * View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!

		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		
		g2d.setColor(Color.black);

		this.model.execute(g2d);
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 * Closes the polyline if the current shape that the user is on is
	 * a polyline
	 */
	public void closePoly() {
		if(strategy.getClass() == PolylineManipulatorStrategy.class) {
			PolylineManipulatorStrategy polyStrategy = (PolylineManipulatorStrategy)strategy; 
			if(polyStrategy.getPolyline().getPoints().size() > 0) {
				polyStrategy.getPolyline().addPoint(polyStrategy.getPolyline().getPoints().get(0));
				this.repaint();
			}
		}
	}
	
	/**
	 * Controller aspect of this 
	 */
	public void setStrategy(String type) {
		closePoly();
		strategy = shapefactory.create(type, this.a_View);
		this.setShapeStrategy(strategy);	
	}
	
	/**
	 * setter method which sets the IsFilled parameter to indicate the fill style of the shapes
	 * @param fill the desired fill in type boolean 
	 */
	public void setIsFilled(Boolean fill) {
		this.fillstyle = fill; 
	}
	
	/**
	 * @return the fill style (true or false)
	 */
	public Boolean getIsFilled() {
		return this.fillstyle;
	}
	
	/**
	 * @return the paint model
	 */
	public PaintModel getPaintModel() {
		return model;
	}

	/**
	 * @return the view
	 */
	public View getView() {
		return a_View;
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		a_View.getmousecordinate().setText("X: " + e.getX() + "px, Y:" + e.getY() + "px");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		a_View.getmousecordinate().setText("X: " + e.getX() + "px, Y:" + e.getY() + "px");
		
		this.strategy.mousePressed(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		a_View.getmousecordinate().setText("X: " + e.getX() + "px, Y:" + e.getY() + "px");

		this.strategy.mouseDragged(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		a_View.getmousecordinate().setText("X: " + e.getX() + "px, Y:" + e.getY() + "px");
		this.strategy.mouseReleased(e);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		a_View.getmousecordinate().setText("");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {		
	}
	
	public int getSide() {
		// TODO Auto-generated method stub
		return this.side;
	}
	
	public void SetSide(int side) {
		// TODO Auto-generated method stub
		this.side = side;
	}
}
