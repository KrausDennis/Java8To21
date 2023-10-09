package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingExcercise {

	public static void task() {
		List<Employee> employeeList = Arrays.asList(new Employee(1, "A", 100), new Employee(2, "B", 200),
				new Employee(3, "C", 300), new Employee(4, "D", 400));

		HashMap<String, Object> results = filterItemsAndCountThem(employeeList);

		validate(results);
	}

	/**
	 * TODO: Get the list of employees and their count who have a salary higher then
	 * '200' in a single operation using the Stream-API with the Collectors.teeing
	 * functionality.
	 * 
	 * Write the result in a HashMap<String, Object>. <br>
	 * The first entry should have the key 'list' and the value should be a list of
	 * the employees. <br>
	 * The second entry should have the key 'count' and the value should be the
	 * count of the employees.
	 * 
	 * 
	 * Hint: Use the Collectors.teeing Hint: For filtering use Collectors.filtering
	 * Hint: For counting use Collectors.counting
	 * 
	 * @return
	 */
	private static HashMap<String, Object> filterItemsAndCountThem(List<Employee> employeeList) {

		return null;
	}

	private static void validate(HashMap<String, Object> result) {

		Object employeeList = result.get("list");
		Object count = result.get("count");

		if (employeeList instanceof ArrayList<?> list && list.size() == 2 && count instanceof Long numberOfEmployees
				&& numberOfEmployees.equals(2L)) {
			System.out.println("You win!");
			return;
		}

		throw new RuntimeException("You still have work to do!");

	}

}
