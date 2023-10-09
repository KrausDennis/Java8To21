package main.java12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Enhancement: Collectors::teeing
 * 
 * It is a new static method teeing to java.util.stream.Collectors interface
 * which allows to collect using two independent collectors, then merge their
 * results using the supplied BiFunction.
 * 
 * Every element passed to the resulting collector is processed by both
 * downstream collectors, then their results are merged using the specified
 * merge function into the final result.
 * 
 * Please note that this function helps in performing a certain task in single
 * steps. We can already perform the given task in two steps if we do not use
 * the teeing() function. It’s just a helper function which helps in reducing
 * the verbosity.
 */
public class StreamEnhancement {

	public static void main(String[] args) {
		findMinAndMaxInASingleStep();
		filterItemsAndCountThem();

	}

	public static void findMinAndMaxInASingleStep() {
		List<Employee> employeeList = Arrays.asList(new Employee(1, "A", 100), new Employee(2, "B", 200),
				new Employee(3, "C", 300), new Employee(4, "D", 400));

		HashMap<String, Employee> result = employeeList.stream()
				.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
						Collectors.minBy(Comparator.comparing(Employee::getSalary)), (e1, e2) -> {
							HashMap<String, Employee> map = new HashMap<>();
							map.put("MAX", e1.get());
							map.put("MIN", e2.get());
							return map;
						}));

		System.out.println(result);
	}

	public static void filterItemsAndCountThem() {
		List<Employee> employeeList = Arrays.asList(new Employee(1, "A", 100), new Employee(2, "B", 200),
				new Employee(3, "C", 300), new Employee(4, "D", 400));

		HashMap<String, Object> result = employeeList.stream()
				.collect(Collectors.teeing(Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
						Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()), (list, count) -> {
							HashMap<String, Object> map = new HashMap();
							map.put("list", list);
							map.put("count", count);
							return map;
						}));

		System.out.println(result);
	}

}
