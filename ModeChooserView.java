package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * ModeChooserView is a JButton that allows the user to select a fill of a shape.
 * If the JButton is Clicked it switches from Filled to Outline 
 * Filled - the shape is filled 
 * Outline - the shape has no fill.
 *
 */
class ModeChooserView extends JCheckBox implements ActionListener {
	private View a_View; // So we can talk to our parent or other components of the view
	
	/**
	 * Initializing ModeChooserVie. this is the constructor.
	 * @param a_View the view in which the button and paint panel is in 
	 */
	public ModeChooserView(View a_View) {
		this.a_View = a_View;

		this.setText("Outline");
		this.addActionListener(this);

	}
	/**
	 * The required method for actionListener. Sends if the shape should be filled or not 
	 * to the paint model 
	 * @param e the button that was clicked 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Outline") {
			this.a_View.getPaintPanel().setIsFilled(true);
			this.setText("Filled");
			
		} else if (e.getActionCommand() == "Filled") {
			this.a_View.getPaintPanel().setIsFilled(false);
			this.setText("Outline");
		}
	}
}