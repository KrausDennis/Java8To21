package main;

/**
 * Switch expressions (Java 17) with pattern matching and guarded patterns (Java 21)
 */
public class SwitchPatternMatching {

	public static void main(String[] args) {
		
		Object o = Integer.valueOf("5");

		String formatted = switch (o) {
	    	case Integer i when i > 10 -> String.format("a large Integer %d", i);
	    	case Integer i             -> String.format("a small Integer %d", i);
	    	case Long l                -> String.format("a Long %d", l);
	    	default                    -> o.toString();
		};
		
		System.out.println(formatted);
		
	}

}
