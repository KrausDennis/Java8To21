package main;

/**
 * Java 17 Sealed Classes can restrict which other classes may extend them
 */
public class SealedClasses {

	abstract sealed class Shape permits Circle, Rectangle {
	}

	final class Circle extends Shape {
		int radius;
		
		
	} 

	final class Rectangle extends Shape {
		int a;
		int b;
	} 

	
	//public final class Triangle extends Shape {} // Compile error

	public double sealedClassesSwitch(Shape shape) {
		
		// No need for default case if all permitted types are covered
		double area = switch (shape) {
		    case Circle c    -> Math.pow(c.radius, 2) * Math.PI;
		    case Rectangle r -> r.a * r.b;
		};
		
		return area;
	}

}
