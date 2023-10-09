package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */
public class CollectionAndStreamChanges {

	public static void main(String[] args) {

		// New Constructors for collections (Java 9)
		// Unmodifiable objects
		List<String> strings = List.of("String1", "String2");
		Set<String> set = Set.of("1", "2");
		Map<String, Integer> map = Map.of("Key1", 10, "Key2", 11);
				
		System.out.println(strings);
		System.out.println(set);
		System.out.println(map);

		// New collectors (java 9) 
		strings.stream().collect(Collectors.toUnmodifiableList());
		set.stream().collect(Collectors.toUnmodifiableSet());
		
		optionalStreams();
	}
	
	
	public static void optionalStreams() {
		// Stream out of optional (Java 9)
				List<Optional<String>> listOfOptionals = Arrays.asList(
						  Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));
				
				// Old Java 8
				List<String> filteredList = listOfOptionals.stream()
						  .filter(Optional::isPresent)
						  .map(Optional::get)
						  .collect(Collectors.toList());
				System.out.println(filteredList);
				
				filteredList = listOfOptionals.stream()
						  .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
						  .collect(Collectors.toList());
				System.out.println(filteredList);
				
				filteredList = listOfOptionals.stream()
						  .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
						  .collect(Collectors.toList());
				System.out.println(filteredList);
				
				// -- Old
				
				// New 
				filteredList = listOfOptionals.stream()
						  .flatMap(Optional::stream)
						  .collect(Collectors.toList());
				System.out.println();
				System.out.println("NEW");
				System.out.println();
				System.out.println(filteredList);
	}
	
}
