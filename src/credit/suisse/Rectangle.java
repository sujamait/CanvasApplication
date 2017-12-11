package credit.suisse;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {
   
	private Shape line;
	
    public void draw(List<Coordinate> coordinates,char[][] canvas,char color) {
    	Coordinate inputA =coordinates.get(0);
		Coordinate inputB =coordinates.get(1);
		
		this.setLine(new Line());
		coordinates = new ArrayList<Coordinate>();
		coordinates.add(new Coordinate(inputA.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputA.getY()));
		line.draw(coordinates,canvas,'x');
		coordinates.clear();
		coordinates.add(new Coordinate(inputA.getX(),inputB.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputB.getY()));
		line.draw(coordinates,canvas,'x');
		coordinates.clear();
		coordinates.add(new Coordinate(inputA.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputA.getX(),inputB.getY()));
		line.draw(coordinates,canvas,'x');
		coordinates.clear();
		coordinates.add(new Coordinate(inputB.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputB.getY()));
		line.draw(coordinates,canvas,'x');
		
	}

	public Shape getLine() {
		return line;
	}

	public void setLine(Shape line) {
		this.line = line;
	};

}
