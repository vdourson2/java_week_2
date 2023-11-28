package java_week_2;

public enum Mesure {
	M("m"), 
	CM("cm"),
	MM("mm");
	
	private final String unity;
	
	private Mesure(String unity){
		this.unity = unity; 
	}
	
	public String getUnity() {
		return this.unity;
	}
	
	public static Mesure findMesure(String givenMesure) {
		for (Mesure value:values()) {
			if (value.unity.equals(givenMesure)) {
				return value;
			}
		}
		return null;
	}
}
