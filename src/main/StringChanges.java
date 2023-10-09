package main;

import java.util.ArrayList;
import java.util.List;

public class StringChanges {

	public static void main(String[] args) {
		
		var string = "1,2,3";
		
		// Java 12 
		transform();
		System.out.println("44".indent(3));
		
		// Java 11
		System.out.println( string.isBlank());
		string.lines();
		string.repeat(4);
		string.strip();
	}

	// Java 12
	public static void transform() {

		// converting string to other objects
		String ids = "1,2,3";

		List<Employee> list4 = ids.transform(csvStr -> {
			String[] idArray = csvStr.split(",");
			List<Employee> empList = new ArrayList<>();
			for (String s1 : idArray) {
				empList.add(new Employee(Integer.parseInt(s1)));
			}
			return empList;
		});
		System.out.println(list4);
	}
}

class Employee {

	private int id;

	Employee(int i) {
		this.id = i;
	}

	@Override
	public String toString() {
		return String.format("Emp[%d]", this.id);
	}
}

