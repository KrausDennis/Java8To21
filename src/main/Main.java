package main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

	private static final String FOO = "foo";
	private static final String BAR = "bar";
	
	public static void main(String[] args) {
		
		List<Optional<String>> listOfOptionals = Arrays.asList(Optional.empty(), Optional.of(FOO), Optional.empty(),
				Optional.of(BAR));

		List<String> result = OptionalStreams.filterAndConvert(listOfOptionals);
		
		doneCorrectly(result);
	}

	private static void doneCorrectly(List<String> result) {

		if(result == null || result.size() != 2 || !result.contains(FOO) || !result.contains(BAR)) {
			throw new RuntimeException("You still have work to do!");
		}
		
		System.out.println("You win!");
	}

}
