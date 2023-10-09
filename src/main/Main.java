package main;

public class Main {

	/**
	 * TODO: Create an abstract sealed class "Shape" allowing Circle and Rectangle
	 * to inherit from
	 * 
	 * TODO: Create a final class Circle inheriting from Shape with the attribute
	 * 'radius'
	 * 
	 * TODO: Create a final class Rectangle inheriting from Shape with the
	 * attributes 'a' and 'b'
	 * 
	 * TODO: Create a method accepting a 'Shape', which returns the surface of the
	 * given Shape using a switch expression with a type pattern
	 * 
	 * TODO: Write a method listing all classes inheriting from the 'Shape' class
	 * 
	 */
	public static void main(String[] args) {
		Circle c = new Circle();
		c.radius = 4;

		System.out.println(getSurface(c));
		getPermittedSubclasses(Shape.class);
	}

	private static double getSurface(Shape shape) {
		return switch (shape) {
			case Rectangle r -> r.a * r.b;
			case Circle c -> c.radius * 2 * Math.PI;
			case Triangle t -> 0.5 * t.b() * t.h();
		};
	}

	private static void getPermittedSubclasses(Class<?> classs) {
		Class<?>[] subClasses = classs.getPermittedSubclasses();

		if (subClasses == null) {
			return;
		}

		for (Class<?> subClass : subClasses) {
			System.out.println(subClass.getSimpleName() + " ,isSealed: " + subClass.isSealed());
			getPermittedSubclasses(subClass);
		}
	}

}
