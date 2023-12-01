package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filtering {

	public static void main(String[] args) {
		List<TradeData> result = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		
		System.out.println(result);
		

	}//End main
	
	public static List<TradeData> processInputFile(String inputFilePath) {
		
		List<TradeData> wantedValues = new ArrayList<TradeData>();
				
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

	      // skip the header of the csv
	      wantedValues = br.lines()
	    		  .skip(1)
	    		  .map(line -> line.split(","))
	    		  .filter(l -> l[1].equals("2016") && l[4].equals("All"))
	    		  .map((ar) -> {
	    			  TradeData trLine = new TradeData();
	    			  trLine.setDirection(ar[0]);
	    			  trLine.setDate(ar[2]);
	    			  return trLine;
	    		  })
	    		  .collect(Collectors.toList());
	    	
	      br.close();
	    } 
	    catch (IOException e) {
	    	System.out.println("Loading failed" + e);
	    }
		
		return wantedValues ;
	}
}
