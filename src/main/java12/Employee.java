package main.java12;

import java.util.Objects;

class Employee {
	int id;
	String department;
	int salary;

	public Employee(int id, String department, int salary) {
		super();
		this.id = id;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, id, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && id == other.id && salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", department=" + department + ", salary=" + salary + "]";
	}

}