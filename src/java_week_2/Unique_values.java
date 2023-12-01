package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Unique_values {

	public static void main(String[] args) {
		ColumnsSets res = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		System.out.println(res.getColumn1());

	}//End main
	
	public static ColumnsSets processInputFile(String inputFilePath) {
		
		ColumnsSets result = new ColumnsSets();
		//List<YourJavaItem> inputList = new ArrayList<YourJavaItem>();
		
		    try{
		      System.out.println("try");
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

//	private static Function<String, Integer> mapToItem = (line) -> {
//
//			
//		  String[] p = line.split(",");// a CSV has comma separated lines
//
//		  YourJavaItem item = new YourJavaItem();
//
//		  result.setItemNumber(p[0]);//<-- this is the first column in the csv file
//		  if (p[3] != null && p[3].trim().length() > 0) {
//		    item.setSomeProeprty(p[3]);
//		  }
//		  //more initialization goes here
//
//		  return item;
//		}

