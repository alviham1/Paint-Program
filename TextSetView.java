package ca.utoronto.utm.paint;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * TextSetView is a JFrame that allows the user to edit the text to be added
 * to the panel.
 *
 */
public class TextSetView extends JFrame implements ActionListener {

	private Text text;
	private PaintPanel panel;
	private JTextField writeText = new JTextField();
	
	/**
	 * Initializing TextSetView. This is the constructor
	 * @param text	The text to be set
	 * @param panel	The panel to be drawn on
	 */
	public TextSetView(Text text, PaintPanel panel) {
		super("Text Setter");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.text = text;
		this.panel = panel;
			
		JButton okButton = new JButton("OK");
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okButton.addActionListener(this);
		
		this.add(this.writeText);
		this.add(okButton);
		
		this.pack();
		this.setSize(new Dimension(300, 100));
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.text.setText(writeText.getText());
		new TextFontView(this.text, this.panel);
		this.dispose();
	}
	
}
