package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * This is the top level View+Controller, it contains other aspects of the
 * View+Controller.
 * 
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {

	private PaintModel model;

	// The components that make this up
	private PaintPanel PaintPanel;
	private ShapeChooserPanel ShapeChooserPanel;
	private ModeChooserView ModeChooserView;
	private ColourView ColourView;
	private JLabel mousecordinate;
	private JSlider slider;
	private ArrayList<DrawingCommand> shapesRemoved = new ArrayList<DrawingCommand>();
	private ArrayList<Integer> shapeTracker = new ArrayList<Integer>();
	private int tracker = 0;

	/**
	 * Initialize view and create/add elements to the JFrame.
	 * 
	 * @param model
	 *            The paint model
	 */
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());

		Container c = this.getContentPane();

		this.model = model;

		this.PaintPanel = new PaintPanel(model, this);
		c.add(this.PaintPanel, BorderLayout.CENTER);
		
		// Mouse coordinate position
		int X = 0;
		int Y = 0;
		mousecordinate = new JLabel("X: " + X + "px,  Y: " + Y + "px");
		c.add(mousecordinate, BorderLayout.SOUTH);
		
		this.pack();

		this.setMinimumSize(this.getSize());
		this.setVisible(true);
	}

	/**
	 * getter method for mouse coordinate
	 * 
	 * @return
	 */
	public JLabel getmousecordinate() {
		return mousecordinate;
	}

	/**
	 * getter method for paintPanel
	 * 
	 * @return
	 */
	public PaintPanel getPaintPanel() {
		return PaintPanel;
	}

	/**
	 * getter method for shapeChooserPanel
	 * 
	 * @return
	 */
	public ShapeChooserPanel getShapeChooserPanel() {
		return ShapeChooserPanel;
	}

	/**
	 * getter method for slider
	 * 
	 * @return
	 */
	public JSlider getSlider() {
		return slider;
	}
	
	/**
	 * getter method for slider
	 * 
	 * @return
	 */
	public PaintModel getPaintModel() {
		return this.model;
	}

	
	/**
	 * Create new components in the menu bar
	 * 
	 * @return the menu bar at the top of the frame
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		// File drop down
		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		// Edit drop down
		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		KeyStroke keyStrokeUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeUndo);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		KeyStroke keyStrokeRedo = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeRedo);


		menuItem = new JMenuItem("Clear Canvas");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);
		
		// shape buttons
		this.ShapeChooserPanel = new ShapeChooserPanel(this);
		
		// Fill/outline button
		this.ModeChooserView = new ModeChooserView(this);
		// Color selector button
		this.ColourView = new ColourView(this);
		
		// Thickness slider minimum and initial value of 1.
		this.slider = new JSlider(0, 100, 1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(10);


		JPanel selectorPanel = new JPanel();
		// Slider label
		selectorPanel.add(new JLabel("Thickness slider"));
		selectorPanel.add(this.slider);

		JPanel lowerPanel = new JPanel(new BorderLayout());
		//lowerPanel.add(this.a_ShapeChooserPanel, BorderLayout.WEST);
		lowerPanel.add(selectorPanel, BorderLayout.CENTER);
		lowerPanel.add(this.ModeChooserView, BorderLayout.WEST);
		lowerPanel.add(this.ColourView, BorderLayout.EAST);
	
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.add(this.ShapeChooserPanel);
		tabpane.add(lowerPanel);
		tabpane.setTitleAt(0, "Shapes");
		tabpane.setTitleAt(1, "ShapesEditor");
		
		menuBar.add(tabpane);

		return menuBar;
	}

	/**
	 * Remove a shape on the frame
	 */
	public DrawingCommand removeShapes() {
		PaintModel model = this.PaintPanel.getPaintModel();
		DrawingCommand shapeRemoved = model.getShapes().get(model.getShapes().size() - 1);
		// Remove the shape
		model.removeDrawingCommand();
		// Update the panel
		this.PaintPanel.repaint();

		// Since polyline removes shapes as well, we need to take into account of any
		// overlaps
		// If the current shape is a polyline
		if (this.PaintPanel.strategy.getClass() == PolylineManipulatorStrategy.class) {
			// Make a new polyline
			this.PaintPanel
					.setShapeStrategy(this.PaintPanel.shapefactory.create("Polyline", this.PaintPanel.getView()));
		}

		return shapeRemoved;
	}

	/**
	 * The required method for actionListener. it prints which button is selected
	 * 
	 * @param e
	 *            the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		PaintModel model = this.PaintPanel.getPaintModel();
		this.PaintPanel.closePoly();

		if (e.getActionCommand() == "Undo") {
			// Only undo if there is at least one shape present
			if (model.getShapes().size() > 0) {
				tracker++;
				shapesRemoved.add(removeShapes());
				shapeTracker.add(tracker);
			}
		} else if (e.getActionCommand() == "Clear Canvas") {
			if (model.getShapes().size() != 0) {
				tracker++;
			}
			// Keep removing shapes until there are none left
			while (model.getShapes().size() != 0) {
				shapesRemoved.add(removeShapes());
				shapeTracker.add(tracker);
			}
		} else if (e.getActionCommand() == "Redo") {
			// Only redo if there are shapes that were previously removed
			if (shapesRemoved.size() > 0) {
				int index = shapeTracker.size() - 1;
				while (shapeTracker.size() > 0 && shapeTracker.get(index) == tracker) {
					// Remove both the last shape and last tracker
					DrawingCommand addShape = shapesRemoved.remove(shapesRemoved.size() - 1);
					shapeTracker.remove(shapeTracker.size() - 1);
					index = shapeTracker.size() - 1;
					this.PaintPanel.getPaintModel().addDrawingCommand(addShape);
					this.PaintPanel.repaint();
				}
				// Since a shape was removed, decrease tracker by 1
				tracker--;
			}
		}

	}
}
