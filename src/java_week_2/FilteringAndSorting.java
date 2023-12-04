package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringAndSorting {
	public static void main(String[] args) {
		List<Long> result = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		for (Long res:result) {
			System.out.println(res);
		}
		

	}//End main
	
	public static List<Long> processInputFile(String inputFilePath) {
		
		List<TradeData> allValues = new ArrayList<TradeData>();
		List<Long> filteredValues = new ArrayList<Long>();
		List<Long> sortedList = new ArrayList<Long>();
				
	    try (InputStream inputFS = new FileInputStream(new File(inputFilePath));
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS))) {
	    	
	    	//Skip the header of the csv
	    	//Convert each line into an object of TradeData class
	    	allValues = br.lines()
	    		  .skip(1)
	    		  .map(line -> line.split(","))
	    		  .map((ar) -> {
	    			  TradeData trLine = new TradeData(ar);
	    			  return trLine;
	    		  })
	    		  .collect(Collectors.toList());
	      
	    	//Filter the data to include only records from the year 2018 where the country, commodity, and transport_mode have the value 'all'.
	    	//Extract the import values from the filtered records and store them in a list.
	    	filteredValues = allValues.stream()
	    		  .filter(l -> l.getYear().equals("2018") && l.getCountry().equals("All") && l.getCommodity().equals("All") && l.getTransport_mode().equals("All") && l.getDirection().equals("Imports"))
	    		  .map(l -> Long.parseLong(l.getValue()))
	    		  .collect(Collectors.toList());
	      
	    	//Sort the list of import values in ascending order 
	    	sortedList = filteredValues.stream()
	    		  .sorted()
	    		  .collect(Collectors.toList());
	    } 
	    catch (IOException e) {
	    	System.out.println("Loading failed" + e);
	    }
		
		return sortedList ;
	}
}
