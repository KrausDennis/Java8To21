package main.java16;

public class PatternMatchingInstanceOf {

	public void m() {
		
		// old
		Object obj = String.valueOf(6);
		
		if (obj instanceof String) {
		    String s = (String) obj;
		    System.out.println(s);
		}
		
		
		// New
		if (obj instanceof String s && s.length() > 5) {
		    System.out.println("Long string: " + s);
		} else if (obj instanceof String s) {
		    System.out.println(s);
		}
		
	}
	
}
