package main.java17;

public class SealedClasses {

	public sealed class Shape permits Circle, Quadrilateral, WeirdShape {
	}

	public final class Circle extends Shape {
	}

	public sealed class Quadrilateral extends Shape permits Rectangle, Parallelogram {
	}

	public final class Rectangle extends Quadrilateral {
	}

	public final class Parallelogram extends Quadrilateral {
	}

	public non-sealed class WeirdShape extends Shape {
	}


}
