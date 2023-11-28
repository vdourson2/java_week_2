package java_week_2;

import java.util.Arrays;

public class Measurements {

	public static void main(String[] args) {
		Mesure mesure;
		System.out.println(Arrays.toString(args));
		if (args.length == 2) {
			//System.out.println(args[0]);
			mesure = Mesure.findMesure(args[0]);
			//System.out.println(mesure);
		}
		else {
			mesure = null;
		}
		System.out.println(mesure.name());
		
		
//		Mesure mesure = Mesure.M;
		
		
//		switch 
//		case M
//		case CM
//		case MM
	}

}
