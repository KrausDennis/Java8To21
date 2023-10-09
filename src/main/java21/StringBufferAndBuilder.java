package main.java21;

public class StringBufferAndBuilder {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.repeat("Hello", 3);
		System.out.println(buffer.toString());
		
		StringBuilder builder = new StringBuilder();
		builder.repeat("Hello", 3);
		System.out.println(builder.toString());
		
	}

}
