package java_week_2;

//This class contains a mesure of length with its value and unit
//This class gives the possibility to convert unit from the enum type Unit
public class Mesure {
	private double value;
	private Unit unit;
	
	//Constructor with a digit and a unit
	public Mesure(double value, Unit unit) {
		this.value = value;
		this.unit = unit;
	}
	
	//Constructor with a string containing digits and characters
	public Mesure(String stringEntry) {
		String[] part = stringEntry.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); 
		this.value = Double.parseDouble(part[0]);
		this.unit = Unit.findUnit(part[1]);
	}
	
	public double getValue() {
		return value;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public void convertToMeter() {
		switch (unit) {
			case M :
				break;
			case CM :
				value = value/100;
				break;
			case MM :
				value = value /1000;
				break;
		}
		unit = Unit.M;
	}
	
	
	
}
