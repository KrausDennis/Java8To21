package main.java21;

/**
 * Tip: Consider using Sealed classes over Enums
 * 
 * However, all variations need to be in the same source file, and Enum types
 * doesn’t support modelling cases when an instance is needed instead of a
 * constant, e.g. to represent individual messages of a type.
 * 
 * Sealed classes offer a nice alternative to Enum types making it possible to
 * use regular classes to model the fixed alternatives. This will come to full
 * power once Pattern Matching for switch becomes production ready, after that
 * Sealed classes can be used in switch expressions just like enums, and the
 * compiler can automatically check if all cases are covered.
 * 
 * Enum values can be enumerated with the values method. For Sealed classes and
 * interfaces, the permitted subclasses can be listed with
 * getPermittedSubclasses.
 */
public class SealedClassesVsEnums {

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


	enum Expression {
		ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
	};

	public void m() {
		
		var exp = Expression.ADDITION;
	
		var value = switch(exp) {
			case ADDITION -> "1";
			default -> "2";
		};
	}

	public double sealedClassesSwitch(Shape shape) {
		
		// No need for default case if all permitted types are covered
		double area = switch (shape) {
		    case Circle c    -> Math.pow(c.radius, 2) * Math.PI;
		    case Rectangle r -> r.a * r.b;
		};
		
		return area;
	}
	
	public static void main(String[] args) {
		getPermittedSubclasses(Shape.class);
	}
	
	public static void getPermittedSubclasses(Class<?> classs) {
		
		Class<?>[] subClasses = classs.getPermittedSubclasses();
		
		if(subClasses == null) {
			return;
		}
		
		for(Class<?> subClass : subClasses) {
			System.out.println(subClass.getSimpleName() + " ,isSealed: " + subClass.isSealed());
			getPermittedSubclasses(subClass);
		}
		
		System.out.println();
	}
	
	
	
}
