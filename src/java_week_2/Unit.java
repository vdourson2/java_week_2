package java_week_2;


//This Enum contains 
public enum Unit {
	M("m"), 
	CM("cm"),
	MM("mm");
	
	private final String unit;
	
	//Constructor
	private Unit(String unit){
		this.unit = unit; 
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	//Find the good enum unit from a string
	public static Unit findUnit(String givenUnit) {
		for (Unit value:values()) {
			if (value.unit.equals(givenUnit.toLowerCase())) {
				return value;
			}
		}
		return null;
	}
}
