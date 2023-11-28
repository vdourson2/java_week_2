package java_week_2;

public class Rectangle {
	private float length, width;
	
	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}
	
	public float getlength() {
		return length;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float surface() {
		return length * width;
	}
}
