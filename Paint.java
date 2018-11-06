package ca.utoronto.utm.paint;

/**
 * Paint hooks up PaintModel and View together to create a functioning
 * paint panel
 *
 */
public class Paint {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint();
			}
		});

	} 

	PaintModel model; // Model
	View a_View; // View+Controller

	public Paint() {
		// Create MVC components and hook them together

		// Model
		this.model = new PaintModel();

		// View+Controller
		this.a_View = new View(model);

	}
}
