package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * PopularChooserView is a JPanel that allows the user to select a popular color.
 * They are selected through the a list of JButtons available on the JPanel that contain
 * common colors.
 */
public class PopularColourView extends JPanel implements ActionListener {
	
	private ColourChooserView colourChooser;
	
	/**
	 * Initializing PopularColourView. This is where the JPanel items are created
	 * and added
	 * @param ColourChooserView	The location of where PopularColourView originates from
	 */
	public PopularColourView(ColourChooserView colourChooser) {
		this.colourChooser = colourChooser;
		this.setLayout(new FlowLayout());
		
		JButton colourButton; 

		//the list of popular colors
		Color[] colourList = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK,
				new Color(255, 0, 255), Color.WHITE, Color.GRAY, Color.BLACK};
		
		for(int i = 0; i < 10; i++) {
			colourButton = new JButton();
			colourButton.setPreferredSize(new Dimension(25, 25));
			colourButton.setBackground(colourList[i]);
			colourButton.addActionListener(this);
			this.add(colourButton);
		}
	}

	/**
	 * The required method for ActionListener. Changes elements within colourChooser
	 * when the button is clicked on
	 * @param e	The button that was clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		Color colour = button.getBackground();
		
		// Change the preview color, sliders and labels to the color selected
		this.colourChooser.getContentPane().setBackground(colour);
		this.colourChooser.setSliders(colour.getRed(), colour.getGreen(), colour.getBlue());
		this.colourChooser.setLabels(colour.getRed(), colour.getGreen(), colour.getBlue());
	}

}
