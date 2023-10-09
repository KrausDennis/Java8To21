package main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalStreams {

	private static final String FOO = "foo";
	private static final String BAR = "bar";
	
	public static void task() {
		List<Optional<String>> optionals = Arrays.asList(Optional.empty(), Optional.of(FOO), Optional.empty(),
				Optional.of(BAR));
		
		List<String> results = filterAndConvert(optionals);

		validate(results);
	}
	
	/**
	 * TODO: Filter out the empty optionals and convert the others by using the
	 * Stream-API
	 * 
	 * Hint: Use flatMap Hint: Use Optional::stream
	 * 
	 * @return
	 */
	private static List<String> filterAndConvert(List<Optional<String>> optionals) {

		return null;
	}

	private static void validate(List<String> result) {

		if (result == null || result.size() != 2 || !result.contains(FOO) || !result.contains(BAR)) {
			throw new RuntimeException("OptionalStreams: You still have work to do!");
		}

		System.out.println("OptionalStreams: You win!");
	}
}
