package java_week_2;

//This class contains a rectangle with its length and width.
public class Rectangle {
	private Mesure length, width;
	
	public Rectangle(Mesure length, Mesure width) {
		this.length = length;
		this.width = width;
	}
	
	public Mesure getlength() {
		return length;
	}
	
	public Mesure getWidth() {
		return width;
	}
	
	public double surfaceInMeters() {
		length.convertToMeter();
		width.convertToMeter();
		return length.getValue() * width.getValue();
	}
}
