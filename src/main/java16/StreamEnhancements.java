package main.java16;

import java.util.List;
import java.util.stream.Stream;

public class StreamEnhancements {

	public static void main(String[] args) {

		List<String> result = Stream.of("one", "two", "three").filter(s -> s.length() == 3).toList();
		System.out.println(result);
		
		// Also see: https://nipafx.dev/java-16-stream-mapmulti/
		Stream.of(1, 2, 3, 4)
	    .mapMulti((number, downstream) -> downstream.accept(number))
	    .forEach(System.out::print); // prints 1234
	}

}
