package credit.suisse;

import java.util.List;

public abstract class Shape {
	
  public abstract void draw(List<Coordinate> coordinates,char[][] canvas,char color);
  
  public void dispay(char[][] canvas){
	  if(canvas.length >=1)
		  for(int rows=0;rows < canvas.length;rows++){
			  for(int cols=0;cols < canvas[0].length;cols++){
				  System.out.print(canvas[rows][cols]);
			  }
		  System.out.println();
	  }
  }


  
}
