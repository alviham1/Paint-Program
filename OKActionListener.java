package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * OKActionListener is an ActionListener for the OK JButton within
 * the color chooser frame
 */
public class OKActionListener implements ActionListener {
	
	private ColourChooserView view;
	private PaintModel model;
	
	/**
	 * Initializing OKActionListener. This is the constructor.
	 * @param view	The color chooser view in which the RGB sliders are in
	 * @param model	The paint model which holds the shape methods
	 */
	public OKActionListener(ColourChooserView view, PaintModel model) {
		this.view = view;
		this.model = model;
	}
	
	/**
	 * The required method for ActionListener. Sends the color to the 
	 * paint model and closes the current window if clicked.
	 * @param e	The button that was clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Color currentColour = this.view.getCurrentColour();
		// Sends the color in the color chooser to the paint model
		this.model.changeLastColor(currentColour);
		// Closes the color window but keeps the main frame open
		this.view.dispose();
	}

}
