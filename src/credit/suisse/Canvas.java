package credit.suisse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Canvas extends Shape {
     
	private int width;
	private int height;
	private Shape line;
	private Shape rectangle;
	private char[][] canvas;
	private List<Coordinate> coordinates;
	 
	public Canvas(int width, int height,List<Coordinate> inputCoordinates) {
		this.height=height+2;
		this.width=width+2;
		canvas = new char[this.height][this.width];		
		initializeCanvas(canvas);
		drawCanvas(inputCoordinates);
	}

	public boolean contains(Coordinate point){
		if((point.getX() > 0 && point.getX() <= this.height-2) 
			&& (point.getY() > 0 && point.getY() <= this.width-2))
		 return true;
		else
		 return false;
	}
	
	public boolean isValidLine(List<Coordinate> points){
		if(points.size()==2){
			if(points.get(0).getX().equals(points.get(1).getX()) || points.get(0).getY().equals(points.get(1).getY()))
				return true;
		}
		return false;
	}

	public void bucketFill(int c1,int c2,char color) {
		if((c1 > 0 && c1 <= this.height-2) &&
				(c2 > 0 && c2 <= this.width-2)){
			if(canvas[c1][c2]==color)
				 return;
			char existingColor = canvas[c1][c2];
			if(existingColor!=color){
				canvas[c1][c2]=color;
				Queue<Coordinate> queue = new ArrayDeque<>();
				queue.add(new Coordinate(c1,c2));
				while(!queue.isEmpty()){
					Coordinate n = queue.poll();
					if(n!=null){
						if(canvas[n.getX()][n.getY()-1]==existingColor){
							canvas[n.getX()][n.getY()-1]=color;
							queue.add(new Coordinate(n.getX(),n.getY()-1));
						}
						if(canvas[n.getX()][n.getY()+1]==existingColor){
							canvas[n.getX()][n.getY()+1]=color;
							queue.add(new Coordinate(n.getX(),n.getY()+1));
						}
						if(canvas[n.getX()-1][n.getY()]==existingColor){
							canvas[n.getX()-1][n.getY()]=color;
							queue.add(new Coordinate(n.getX()-1,n.getY()));
						}
						if(canvas[n.getX()+1][n.getY()]==existingColor){
							canvas[n.getX()+1][n.getY()]=color;
							queue.add(new Coordinate(n.getX()+1,n.getY()));
						}
					}
				}
			}
		}
		return;
	}


	private void drawCanvas(List<Coordinate> inputCoordinates) {
		Coordinate inputA =inputCoordinates.get(0);
		Coordinate inputB =inputCoordinates.get(1);
		this.line=new Line();
		this.rectangle=new Rectangle();
		coordinates = new ArrayList<Coordinate>();
		coordinates.add(new Coordinate(inputA.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputA.getY()));
		draw(coordinates,canvas,'|');
		coordinates.clear();
		coordinates.add(new Coordinate(inputA.getX(),inputB.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputB.getY()));
		draw(coordinates,canvas,'|');
		coordinates.clear();
		coordinates.add(new Coordinate(inputA.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputA.getX(),inputB.getY()));
		draw(coordinates,canvas,'-');
		coordinates.clear();
		coordinates.add(new Coordinate(inputB.getX(),inputA.getY()));
		coordinates.add(new Coordinate(inputB.getX(),inputB.getY()));
		draw(coordinates,canvas,'-');
	}
	
	 private void initializeCanvas(char[][] canvas) {
		if( canvas.length >=1 )
			for(int rows=0;rows < canvas.length;rows++){
			  for(int cols=0;cols < canvas[0].length;cols++){
				  canvas[rows][cols]=' ';  
			 }
	    }
	}

	@Override
	public void draw(List<Coordinate> coordinates,char[][] canvas,char color) {
		line.draw(coordinates,canvas, color);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Shape getLine() {
		return line;
	}

	public void setLine(Shape line) {
		this.line = line;
	}

	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	public char[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

	public Shape getRectangle() {
		return rectangle;
	}

	public void setRectangle(Shape rectangle) {
		this.rectangle = rectangle;
	}


}
