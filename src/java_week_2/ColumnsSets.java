package java_week_2;

import java.util.HashSet;
import java.util.Set;

public class ColumnsSets {
	private static Set<String> column1 = new HashSet<>(), column2 = new HashSet<>(), column3, column4, column5, column6, column7, column8, column9, column10;
	
	
	
	public static ColumnsSets addLine(String[] arrayLine) {
		ColumnsSets temp = new ColumnsSets();
		column1.add(arrayLine[0]);
		column2.add(arrayLine[1]);
		return temp;
	}
	
	public static ColumnsSets addVoid() {
		ColumnsSets temp = new ColumnsSets();
		return temp;
	}
	
	public static Set<String> getColumn1(){
		return column1;
	}
	
	public static Set<String> getColumn2(){
		return column2;
	}
}
