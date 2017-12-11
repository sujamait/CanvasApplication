package credit.suisse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 Simple console version of a drawing program
 @author : SumitJ
*/

public class DrawingApplication {
	
	private static Shape canvas;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = new String();
		
		while(!input.equals("Q")){
			System.out.print("enter command: ");
			input=scanner.nextLine();
			canvas=processInput(input,canvas);
			System.out.println();
		}
		scanner.close();
	}

	private static Shape processInput(String input,Shape canvas) {
  
		char inputCommand;
		String inputArr[];
		List<Coordinate> inputCoordinates = new ArrayList<Coordinate>();
		if(input != null && !input.isEmpty()){
			inputCommand = input.charAt(0);
			inputArr = input.split(" ");
			try {
				switch(inputCommand) {
					case 'C' :
						inputCoordinates.add(new Coordinate(0,0));
						inputCoordinates.add(new Coordinate(Integer.parseInt(inputArr[2])+1,Integer.parseInt(inputArr[1])+1));
						canvas = new Canvas(Integer.parseInt(inputArr[1]),Integer.parseInt(inputArr[2]),inputCoordinates);
						canvas.dispay(((Canvas) canvas).getCanvas());
						inputCoordinates.clear();
					break;
					
					case 'L' :
					    if(prepareLineRectangle(inputArr, canvas, inputCoordinates)){
						    if(((Canvas) canvas).isValidLine(inputCoordinates)){
							   ((Canvas) canvas).getLine().draw(inputCoordinates, ((Canvas) canvas).getCanvas(), 'x');
							   canvas.dispay(((Canvas) canvas).getCanvas());
							   inputCoordinates.clear();
						    }else{
						       System.out.println("Currently only horizontal or vertical lines are supported");
							   return canvas;
						    }
					    }else{
					    	return canvas;
					    }
					
					break;
					
					case 'R' :
						 if(prepareLineRectangle(inputArr, canvas, inputCoordinates)){
						    if(!((Canvas) canvas).isValidLine(inputCoordinates)){
						      ((Canvas) canvas).getRectangle().draw(inputCoordinates, ((Canvas) canvas).getCanvas(), 'x');
						      canvas.dispay(((Canvas) canvas).getCanvas());
						      inputCoordinates.clear();
						    }else{
						      System.out.println("Not a Valid Rectangle");
							  return canvas;
						    }
						 }else{
						   return canvas;
						 }
						
					break;
					
					case 'B' :
						if(canvas == null){
							System.out.println("Draw A Canvas First");
							return null;
						}
						Coordinate c1 = new Coordinate(Integer.parseInt(inputArr[2]),Integer.parseInt(inputArr[1]));
						if(!((Canvas) canvas).contains(c1)){
							System.out.println("Please Draw Inside Canvas");
							return canvas;
						}
						((Canvas) canvas).bucketFill(c1.getX(),c1.getY(),inputArr[3].charAt(0));
						canvas.dispay(((Canvas) canvas).getCanvas());
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid command. Please Try again!!");
			} catch (java.lang.NumberFormatException e){
				System.out.println("Invalid Coordinates Please Try again!!");
			} catch (NullPointerException e){
				System.out.println("Invalid Input Please Try again!!");
			} catch(java.lang.StackOverflowError e){
				System.out.println("Please Try again!!");
		    }catch (Exception e) {
				System.out.println("Error Occured\n");
				e.printStackTrace();
				System.exit(1);
			}
		}else{
			System.out.println("Invalid command. Please Try again!!");
		}
		
		return canvas;
	}

	private static boolean prepareLineRectangle(String[] inputArr, Shape canvas, List<Coordinate> inputCoordinates) {
		Coordinate c1,c2;
		if(canvas == null){
			System.err.println("Please Draw A Canvas First");
			return false;
		}
		c1 = new Coordinate(Integer.parseInt(inputArr[2]),Integer.parseInt(inputArr[1]));
		c2 = new Coordinate(Integer.parseInt(inputArr[4]),Integer.parseInt(inputArr[3]));
		if(!(((Canvas) canvas).contains(c1) && ((Canvas) canvas).contains(c2))){
			System.out.println("Please Draw Inside Canvas");
			return false;
		}
		inputCoordinates.add(c1);
		inputCoordinates.add(c2);
		
		return true;
	}
}
