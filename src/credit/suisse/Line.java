package credit.suisse;

import java.util.List;

public class Line extends Shape {

	@Override
	public void draw(List<Coordinate> coordinates,char[][] canvas,char color) {
	   Coordinate pointA = null;
	   Coordinate pointB = null;
	   if(coordinates!=null && coordinates.size()>1){
		   
		    pointA = coordinates.get(0);
		    pointB = coordinates.get(1);
		    
		    if(pointA.getY().equals(pointB.getY())){  //column line
			   for(int index=pointA.getX();index<=pointB.getX();index++){
				   canvas[index][pointA.getY()]=color;
			   }
		    }else{ //row line
			   for(int index=pointA.getY();index<=pointB.getY();index++){
				   canvas[pointA.getX()][index]=color;
			   }
		   }
		   //To Do Add Oblique line,currently not supported
	   }
	};
	  
}
