package java_week_2;
import java.util.Arrays;

//The mission :
//Write a small program that will take in length and width measurements and then calculates the surface. The thing is that 
//the measurements can come in metres, centimetres (0.01 metre) or millimeters (0.001 m). The program takes in the measurements 
//as strings and then translates them to metres before calculating the surface. There are different ways of doing this, but since
//we are working with fixed concepts, this is a great opportunity to use enumerations. Enumerations can have methods, so use 
//a method to check if the incoming measurement (which could be x1 m, x1 cm or x1 mm) is in a correct unit of measurement and 
//then to decide which calculation to do in order to turn it into a metre.
//Do mind to make the program as correct as possible. People fill in the weirdest values!

public class Measurements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		Mesure length, width;
		if (args.length == 2) {
			length = new Mesure(args[0]);
			width = new Mesure(args[1]);
		} 
		else {
			length = null;
			width = null;
		}	
		
		Rectangle rectangle = new Rectangle(length, width);
		System.out.println("The surface in square meters is :");
		System.out.println(rectangle.surfaceInMeters() + " m²");
	}
}
