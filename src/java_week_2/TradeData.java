package java_week_2;

import java.time.LocalDate;

public class TradeData {
	private String direction, year, date, weekday, country, commodity, transport_mode, measure, value, cumulative;
	
	public TradeData(String[] arLine){
		this.direction = arLine[0];
		this.year = arLine[1];
		this.date = arLine[2];
		this.weekday = arLine[3];
		this.country = arLine[4];
		this.commodity = arLine[5]; 
		this.transport_mode = arLine[6];
		this.measure = arLine[7];
		this.value = arLine[8];
		this.cumulative = arLine[9];
	}
	
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
