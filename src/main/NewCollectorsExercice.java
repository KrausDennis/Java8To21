package main;

import java.util.List;

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

		return null;
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
