package java_week_2;

import java.time.LocalDate;
import java.util.Arrays;

public class Date {
	private  int year, month, day;
	
	public Date(String date) {
		String[] arrayDate = date.split("/");
		this.year = Integer.parseInt(arrayDate[2]);
		this.month = Integer.parseInt(arrayDate[1]);
		this.day = Integer.parseInt(arrayDate[0]);
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public LocalDate createLocalDate() {
		return LocalDate.of(year, month, day);
	}
	
}
