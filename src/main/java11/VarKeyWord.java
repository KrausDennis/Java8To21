package main.java11;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VarKeyWord {

	public void m() {
		
		var message = "Hello";
		System.out.println(message);
		
	}
	
	public void readability() {
		
		// LocalDate
		var date = LocalDate.parse("2019-08-13");
		var dayOfWeek = date.getDayOfWeek(); // -> DayOfWeek
		var dayOfMonth = date.getDayOfMonth(); // -> int
		
		// Joda Time
		var jodaDayOfWeek = date.getDayOfWeek(); // -> int
	}
	
	/**
	 * Official style guide: <br>
	 * https://openjdk.org/projects/amber/guides/lvti-style-guide
	 */
	public void typeInformation() {
		
		Map<String, String> myMap = new HashMap<String, String>(); // Pre Java 7
		Map<String, String> myMap2 = new HashMap<>(); // Using Diamond operator
		
		var myMap3 = new HashMap<>(); // -> Map<Object, Object>
		var myMap4 = new HashMap<String, String>(); 
		
		byte   b = 1;
		short  s = 1;
		int    i = 1;
		long   l = 1;
		float  f = 1;
		double d = 1;
		
		// with var
		var shouldBeLong = 1; // -> int
		var isLong = 1L; // -> long
		
	}
	
}
