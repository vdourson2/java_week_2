package java_week_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DifferenceOfTrade {

	public static void main(String[] args) {
		List<TradeData> allValues = processInputFile("assets/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		Map<Integer,Long> dataByMonths = groupByMonths("2019", allValues);
		System.out.println(dataByMonths);
	}//End main
	
	public static List<TradeData> processInputFile(String inputFilePath) {
		
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
	    
	    return allValues;
	}
	
	public static Map<Integer,Long> groupByMonths(String year, List<TradeData> allValues) {
		Map<Integer,Long> dataByMonths = new HashMap<>();
		dataByMonths = allValues.stream()
					.filter(l -> l.getYear().equals(year) && l.getCountry().contains("European Union"))
					.collect(Collectors.groupingBy(TradeData::getMonth,
                            Collectors.summingLong(TradeData::getLongValue)));
		return dataByMonths;
	}
}
	    
//	    //Filter the data to include only records from the year 2019, where the country is 'China', the commodity is 'all', and the transport mode is also 'all'.
//    	//Extract the export values from the filtered records and store them in a list.
//	    List<Long> filteredValues = new ArrayList<Long>();
//    	filteredValues = allValues.stream()
//					    		  .filter(l -> l.getYear().equals("2019") && l.getCountry().equals("China") && l.getCommodity().equals("All") && l.getTransport_mode().equals("All") && l.getDirection().equals("Exports"))
//					    		  .map(l -> Long.parseLong(l.getValue()))
//					    		  .collect(Collectors.toList());
//	
//}
