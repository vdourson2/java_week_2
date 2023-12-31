package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//To improve :
//- Store class variables from ColumnsSets in an array (with static initialization),
//- Write documentation
//- Try-with-ressources
//- Try to transform the stream but not reduce it. It's unnecessary here (try map?)
public class Unique_values {

	public static void main(String[] args) {
		ColumnsSets res = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		System.out.println(res.getColumn1());
		System.out.println(res.getColumn2());

	}//End main
	
	public static ColumnsSets processInputFile(String inputFilePath) {
		
		ColumnsSets result = new ColumnsSets();
		
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

	      // skip the header of the csv
	      result = br.lines()
	    		  .skip(1)
	    		  .map(line -> line.split(","))
	    		  .reduce(new ColumnsSets(), (subresult, arrayLine) -> ColumnsSets.addLine(arrayLine),
	    				  (acc1, acc2) -> ColumnsSets.addVoid());
	      br.close();
	    } 
	    catch (IOException e) {
	    	System.out.println("Loading failed" + e);
	    }
		
		return result ;
	}
	
}//End class Unique_value


