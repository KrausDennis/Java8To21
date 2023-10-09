package main;

/**
 * Java 15
 */
public class TextBlocks {

	public static void main(String[] args) {

		String string = """
				Test
				String \
				SameRowAsPrevious
	            """;
		
		System.out.println(string);		
	}
	
}
