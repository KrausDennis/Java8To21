package main.java21;

public class RecordPatterns {

	public static void main(String[] args) {

		interface Shape {
		};
		
		record Point2D(int x, int y) implements Shape {
		};
		
		record ColoredPoint(Point2D point, String color) implements Shape {
		};

		Shape point = new ColoredPoint(new Point2D(1, 4), "Green");

		// Record pattern for instanceof
		if (point instanceof ColoredPoint(Point2D(int x, int y), String color)) {
			System.out.println(point);
			System.out.println(x);
			System.out.println(y);
			System.out.println(color);
		}

		// Record pattern for swith expressions
		switch (point) {
			case Point2D(var x, var y) -> System.out.println("Point2D x=" + x + " , y = " + y);
			case ColoredPoint cp -> System.out.println("ColoredPoint");
			default -> throw new IllegalArgumentException("Unexpected value: " + point);
		}

	}

}
