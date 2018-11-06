package ca.utoronto.utm.paint;

import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TextFontView is a JFrame that allows the user to select a font for its text.
 * The available fonts for the text are the ones installed on the current system.
 *
 */
public class TextFontView extends JFrame implements ActionListener {

	private JComboBox fontBox;
	private JComboBox sizeBox;
	private Text text;
	private JPanel panel;
	
	/**
	 * Initializing TextFontView. This is the constructor
	 * @param text	The text to be set
	 * @param panel	The panel to be drawn on
	 */
	public TextFontView(Text text, JPanel panel) {
		super("Font Chooser");
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.text = text; 
		this.panel = panel;
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		String[] sizes = new String[48];
		
		for(int i = 0; i < 40; i++) {
			sizes[i] = Integer.toString(i + 1);
		}
		
		sizes[40] = "45"; sizes[41] = "50"; sizes[42] = "55"; sizes[43] = "60"; sizes[44] = "65"; sizes[45] = "70";
		sizes[46] = "80"; sizes[47] = "100";
		
		this.fontBox = new JComboBox(fonts);
		this.fontBox.setSelectedIndex(4);
		
		this.sizeBox = new JComboBox(sizes);
		this.sizeBox.setSelectedIndex(11);
		
		JPanel fontPanel = new JPanel();
		fontPanel.add(new JLabel("Select your font"));
		fontPanel.add(this.fontBox);
		
		JPanel sizePanel = new JPanel();
		sizePanel.add(new JLabel("Select the size"));
		sizePanel.add(this.sizeBox);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		
		this.add(fontPanel);
		this.add(sizePanel);
		this.add(okButton);
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.text.setFont((String) this.fontBox.getSelectedItem(), Integer.parseInt((String) this.sizeBox.getSelectedItem()));
		this.panel.repaint();
		this.dispose();
	}
	
}
