package java_week_2;

import java.time.LocalDate;

public class TradeData {
	private String direction, year, date, weekday, country, commodity, transport_mode, measure, value, cumulative;
	
//	TradeDate(array arLine){
//		this.direction = arLine[0];
//		this.year = arłine[1];
//	}
	
	public void setDirection(String dir) {
		this.direction = dir;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	
	public void setCommodity(String c) {
		this.commodity = c;
	}
	
	
	public String toString() {
		return this.direction + " " + this.date + " " + this.commodity + " " + this.transport_mode + " "  + this.measure + " " + this.value + " " + this.cumulative;  
	}
}
