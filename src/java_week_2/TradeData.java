package java_week_2;

public class TradeData {
	private String direction, year, date, weekday, country, commodity, transport_mode, measure, value, cumulative;
	private String newMeasure, valueEuro, cumulativeEuro;
	
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
		this.newMeasure = "";
		this.valueEuro = "";
		this.cumulativeEuro = "";
	}
	
	public TradeData(TradeData toCopy) {
		this.direction = toCopy.direction;
		this.year = toCopy.year;
		this.date = toCopy.date;
		this.weekday = toCopy.weekday;
		this.country = toCopy.country;
		this.commodity = toCopy.commodity; 
		this.transport_mode = toCopy.transport_mode;
		this.measure = toCopy.measure;
		this.value = toCopy.value;
		this.cumulative = toCopy.cumulative;
		this.newMeasure = toCopy.newMeasure;
		this.valueEuro = toCopy.valueEuro;
		this.cumulativeEuro = toCopy.cumulativeEuro;
	}
	
	public void convertToEuro() {
		this.newMeasure = "€";
		try {
			this.valueEuro = Long.toString((long) (Long.parseLong(this.value) * 0.85));
			this.cumulativeEuro = Long.toString((long) (Long.parseLong(this.cumulative) * 0.85));
		}
		catch (NumberFormatException nfe) {
		      nfe.printStackTrace();
		}
	}
		
	public String getDirection() {
		return this.direction;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public int getMonth() {
		Date date = new Date(this.date);
		return date.getMonth();
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public String getCommodity() {
		return this.commodity;
	}
	
	public String getTransport_mode() {
		return this.transport_mode;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Long getLongValue() {
		return Long.parseLong(this.value);
	}
	
	public String getMeasure() {
		return this.measure;
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
		return this.direction + " " + 
				this.date + " " + 
				this.commodity + " " + 
				this.transport_mode + " "  + 
				this.measure + " " + 
				this.value + " " + 
				this.cumulative + " " + 
				this.newMeasure + " " + 
				this.valueEuro + " " + 
				this.cumulativeEuro;  
	}
}
