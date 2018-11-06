package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * ColourView is a JButton that opens the ColourChooserView if clicked on
 */
public class ColourView extends JButton implements ActionListener {

	private View view;
	
	/**
	 * Initializing ColourView. This is the constructor.
	 * @param model	The paint model which holds the shape methods
	 */
	public ColourView(View view) {
		this.view = view;
		this.setText("Colour");
		this.addActionListener(this);
	}
	
	/**
	 * The required method for ActionListener. Opens an occurrence of
	 * ColourChooserView if the button is clicked one
	 * @param e	The button that was clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new ColourChooserView(this.view);
	}
}
