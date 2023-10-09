package main;

public class Main {

	/**
	 * TODO: Create a text block containing a square of '*' with a side length of 4
	 * 
	 * TODO: Create a text block with a placeholder, which gets inserted via the format function
	 * 
	 */
	public static void main(String[] args) {

		String square = """
				****
				*  *
				*  *
				****
				""";
		
		System.out.println(square);
		
		String placeholder = """
				My name is %s
				""".formatted("Dennis");
		
		System.out.println(placeholder);
	}

}
