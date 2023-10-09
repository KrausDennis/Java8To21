package main;

import java.util.List;
import java.util.stream.Collectors;

public class NewCollectorsExercice {

	private static final String PART_1 = "Part1";
	private static final String PART_2 = "Part2";
	private static final String PART_3 = "";
	private static final String PART_4 = null;

	/**
	 * 1. Create a new List with List.of containing all constants <br>
	 * 2. Stream the List and filter out all blank streams <br>
	 * 3. Convert to an unmodifiable list <br>
	 * 
	 * Hint: Use a Collector for it.
	 * 
	 */
	public static void task() {
		List<String> results = getFilteredStrings();

		validate(results);
	}

	private static List<String> getFilteredStrings() {

		List<String> results = List.of(PART_1, PART_2, PART_3, PART_4).stream().filter(s -> !s.isBlank())
				.collect(Collectors.toUnmodifiableList());

		return results;
	}

	private static void validate(List<String> results) {

		try {
			results.add("");
		} catch (UnsupportedOperationException ex) {
			System.out.println("You win");
		}

		throw new RuntimeException("You still have work to do!");

	}

}
