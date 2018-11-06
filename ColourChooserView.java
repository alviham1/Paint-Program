package ca.utoronto.utm.paint;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * ColourChooserView is a JFrame that allows the user to select a color.
 * The colors selected through the RGB sliders and the PopularColourView class
 * are applied to the shapes selected in the main frame.
 *
 */
public class ColourChooserView extends JFrame implements ChangeListener {
	
	private View view;
	private JSlider redSlider, greenSlider, blueSlider;
	private JLabel redLabel, greenLabel, blueLabel;
	private JButton okButton;
	private Color currentColour;
	
	/**
	 * Initializing ColourChooserView. This is the constructor.
	 * @param model	The paint model which holds the shape methods
	 */
	public ColourChooserView(View view) {
		super("Colour Chooser");
		this.view = view;
		this.getContentPane().setBackground(Color.WHITE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		PaintModel model = this.view.getPaintModel();
		
		// Creates 3 sliders that represent the RGB colour scheme
		this.redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		this.greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		this.blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
				
		this.redSlider.addChangeListener(this);
		this.greenSlider.addChangeListener(this);
		this.blueSlider.addChangeListener(this);
		
		// Initial slider numbers
		this.redLabel = new JLabel("0");
		this.greenLabel = new JLabel("0");
		this.blueLabel = new JLabel("0");
		
		// Created different panels for each slider which also have a label describing which colour 
		// it represents
		JPanel redPanel = new JPanel();
		redPanel.add(new JLabel("R")); redPanel.add(this.redSlider); redPanel.add(this.redLabel);
		JPanel greenPanel = new JPanel();
		greenPanel.add(new JLabel("G")); greenPanel.add(this.greenSlider); greenPanel.add(this.greenLabel);
		JPanel bluePanel = new JPanel();
		bluePanel.add(new JLabel("B")); bluePanel.add(this.blueSlider); bluePanel.add(this.blueLabel);
		
		JPanel bottomPanel = new JPanel();
		this.okButton = new JButton("OK");
		this.okButton.addActionListener(new OKActionListener(this, model));
		bottomPanel.add(this.okButton);
		
		// The new label is added to have space up top for the colour preview
		this.add(new JLabel(" "));
		this.add(redPanel);
		this.add(greenPanel);
		this.add(bluePanel); 
		this.add(new PopularColourView(this));
		this.add(bottomPanel);
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Sets the labels for the sliders to the current RGB values
	 * @param redVal	The red value (between 0 and 255)
	 * @param greenVal	The green value (between 0 and 255)
	 * @param blueVal	The blue value (between 0 and 255)
	 */
	public void setLabels(int redVal, int greenVal, int blueVal) {
		this.redLabel.setText("" + redVal);
		this.greenLabel.setText("" + greenVal);
		this.blueLabel.setText("" + blueVal);
	}
	
	/**
	 * Sets the sliders to the RGB colors if given the red, green and
	 * blue values
	 * @param redVal	The red value of the new color (between 0 and 255)
	 * @param greenVal	The green value of the new color (between 0 and 255)
	 * @param blueVal	The blue value of the new color (between 0 and 255)
	 */
	public void setSliders(int redVal, int greenVal, int blueVal) {
		this.redSlider.setValue(redVal);
		this.greenSlider.setValue(greenVal);
		this.blueSlider.setValue(blueVal);
	}
	
	/**
	 * Sets the current color selected to the parameter, color.
	 * @param colour	The color that the currentColor should be set to
	 */
	public void setCurrentColour(Color colour) {
		this.currentColour = colour;
	}
	
	/**
	 * Returns the current color selected
	 * @return	The current color selected
	 */
	public Color getCurrentColour() {
		return this.getContentPane().getBackground();
	}

	/**
	 * The required method for ChangeListener. Changes the labels and the
	 * background color if the user changes the slider position
	 * @param e	The slider in which the change occurred
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		// Grabs the RGB values set by the user
		int redVal = this.redSlider.getValue();
		int greenVal = this.greenSlider.getValue();
		int blueVal = this.blueSlider.getValue(); 
		
		setLabels(redVal, greenVal, blueVal);
		// Colour preview
		this.getContentPane().setBackground(new Color(redVal, greenVal, blueVal));
	}
}
