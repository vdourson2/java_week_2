package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HigestValue {
	public static void main(String[] args) {
		Optional<Long> optionalResult = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		System.out.println(optionalResult.orElse(0l));
	}//End main
	
	public static Optional<Long> processInputFile(String inputFilePath) {
		
		List<TradeData> allValues = new ArrayList<TradeData>();		
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
	    } 	
	    catch (IOException e) {
	    	System.out.println("Loading failed" + e);
	    }
	    
	    //Filter the data to include only records from the year 2019, where the country is 'China', the commodity is 'all', and the transport mode is also 'all'.
    	//Extract the export values from the filtered records and store them in a list.
	    List<Long> filteredValues = new ArrayList<Long>();
    	filteredValues = allValues.stream()
					    		  .filter(l -> l.getYear().equals("2019") && l.getCountry().equals("China") && l.getCommodity().equals("All") && l.getTransport_mode().equals("All") && l.getDirection().equals("Exports"))
					    		  .map(l -> Long.parseLong(l.getValue()))
					    		  .collect(Collectors.toList());
    	
    	
      
    	//Use the streaming API to find the highest export value from the filtered records.
    	Optional<Long> optionalMaxValue = filteredValues.stream()
    							.max(Long::compare);
    	
    	//Another method to sort the filtered data based on export values in descending order.
    	Collections.sort(filteredValues);
    	Collections.reverse(filteredValues);
    	Long maxValue = filteredValues.get(0);
    	System.out.println(maxValue);
		
		return optionalMaxValue ;
	}
}
