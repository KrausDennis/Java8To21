package main.java10;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 */
public class CollectionAndStreamChanges {

	public static void main(String[] args) {
		List<String> strings = List.of("String1", "String2");
		Set<String> set = Set.of("1", "2");

		// New collectors (java 10) 
		strings.stream().collect(Collectors.toUnmodifiableList());
		set.stream().collect(Collectors.toUnmodifiableSet());
	}
}
