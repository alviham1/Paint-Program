package ca.utoronto.utm.paint;

/**
 * ShapeStrategyFactory sets the new Manipulator given the button that was clicked
 * within the main application
 *
 */
public class ShapeStrategyFactory {
	
	/**
	 * ShapeStrategyFactory is initialized 
	 * @param type	The name of the button clicked
	 * @param view	The view of the application
	 * @return	The manipulator strategy corresponding to the button clicked
	 */
	public ShapeManipulatorStrategy create(String type, View view) {
		
		ShapeManipulatorStrategy strategy = new SquiggleManipulatorStrategy();
		
		if (type.equals("Circle"))
			return new CircleManipulatorStrategy();
		
		else if (type.equals("Square"))
			return new SquareManipulatorStrategy();
		
		else if (type.equals("Rectangle"))
			return new RectangleManipulatorStrategy();
		
		else if (type.equals("Triangle"))
			return new TriangleManipulatorStrategy();
		
		else if (type.equals("EquiTriangle"))
			return new EquilateralTriangleManipulatorStrategy();
		
		else if (type.equals("Polygon"))
			return new PolygonManipulatorStrategy(view.getPaintPanel().getSide());
		
		else if (type.equals("Text"))
			return new TextManipulatorStrategy();
		
		else if (type.equals("Line"))
			return new LineManipulatorStrategy();
		
		else if (type.equals("Polyline"))
			return new PolylineManipulatorStrategy(view.getPaintPanel(), view);
		
		else if (type.equals("Eraser"))
			return new EraserManipulatorStrategy();
		
		return strategy;		
	}

}
