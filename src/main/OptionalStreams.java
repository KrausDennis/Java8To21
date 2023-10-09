package main;

import java.util.List;
import java.util.Optional;

public class OptionalStreams {

	/**
	 * TODO: Filter out the empty optionals and convert the others by using the
	 * Stream-API
	 * 
	 * @return
	 */
	public static List<String> filterAndConvert(List<Optional<String>> optionals) {
		return optionals.stream().flatMap(Optional::stream).toList();
	}

}
