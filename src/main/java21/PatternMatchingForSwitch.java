package main.java21;

public class PatternMatchingForSwitch {

	enum Expression {
		ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
	};

	public String old(Expression expression) {
		return switch (expression) {
		case ADDITION -> "+";
		case SUBTRACTION -> "-";
		case MULTIPLICATION -> "*";
		case DIVISION -> "/";
		};
	}

	// ----------------------------------------------------

	abstract sealed class Shape permits Circle, Rectangle {
	}

	final class Circle extends Shape {
		int radius;
	}

	final class Rectangle extends Shape {
		int a;
		int b;
	}

	public double withTypePatterns(Shape expr) {
		return switch (expr) {
			case Circle circle -> circle.radius * 2 * Math.PI;
			case Rectangle rect -> rect.a * rect.b;
		};
	}

	public double withTypePatternsAndGuards(Shape expr) {
		return switch (expr) {
			case Circle circle when circle.radius >= 0 -> circle.radius * 2 * Math.PI;
			case Rectangle rect when rect.a >= 0 && rect.b >= 0 -> rect.a * rect.b;
		};
	}

	// ----------------------------------------------------------------

	public void supportForNull(String s) {
		switch (s) {
			case null -> System.out.println("Null");
			case "Foo" -> System.out.println("Foo");
			default -> System.out.println("Something else");
		}
	}

	// EXHAUSTIVENESS CHECK -------------------------------------------
	sealed interface I<T> permits A, B {
	}

	final class A<X> implements I<String> {
	}

	final class B<Y> implements I<Y> {
	}

	/**
	 * This code compiles because the compiler can detect that only A and B are the
	 * valid subtypes of I, and that due to the generic parameter Integer, the
	 * parameter can only be an instance of B<Integer>.
	 * 
	 * Exhaustiveness is checked at compile time but if at runtime a new
	 * implementation pops up (e.g. from a separate compilation), the compiler also
	 * inserts a synthetic default case that throws a MatchException.
	 * 
	 * @param i
	 * @return
	 */
	static int testGenericSealedExhaustive(I<Integer> i) {
		return switch (i) {
			case B<Integer> bi -> 42;
		};
	}

	// ORDER CHECK -----------------------------------------------------------------
	static void orderMatters() {
		Object o = 1234;

		// Compile error - the second case is dominated by a preceding case label
		String formatted = switch (o) {
			case Integer i when i > 10 -> String.format("a large Integer %d", i);
			case Integer i -> String.format("a small Integer %d", i);
			default -> "something else";
		};

		System.out.println(formatted);
	}

	/**
	 * For readability reasons, the dominance checking forces constant case labels
	 * to appear before the corresponding type-based pattern. The goal is to always
	 * have the more specific cases first. As an example, the cases in the following
	 * snippet are only valid in this exact order. If you’d try to rearrange them,
	 * you would get a compilation error.
	 */
	static void orderMattersConstants() {
		Integer num = 1234;

		String text = switch (num) {
			case -1, 1 -> "special case";
			case Integer i -> "other integer";
		};

		System.out.println(text);
	}

}
