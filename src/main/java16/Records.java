package main.java16;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Record Classes introduce a new type declaration to the language to define
 * immutable data classes. Instead of the usual ceremony with private fields,
 * getters and constructors, it allows us to use a compact syntax.
 * 
 * Record Classes intended to be transparent carriers of their shallowly
 * immutable data. To support this design they come with a set of restrictions.
 * 
 * Fields of a Record Class are not only final by default, it’s not even
 * possible to have any non-final fields.
 * 
 * The header of the definition has to define everything about the possible
 * states. It can’t have additional fields in the body of the Record Class.
 * Moreover, while it’s possible to define additional constructors to provide
 * default values for some fields, it’s not possible to hide the canonical
 * constructor that takes all record fields as arguments.
 * 
 * Finally, Record Classes can’t extend other classes, they can’t declare native
 * methods, and they are implicitly final and can’t be abstract.
 * 
 * -----------------------------------------------------------------------------
 * 
 * Tip: Check your libraries
 * 
 * Record Classes do not adhere to the JavaBeans conventions: - They have no
 * default constructor. - They do not have setter methods. - The accessor
 * methods does not follow the getX() form.
 * 
 * They have no default constructor. They do not have setter methods. The
 * accessor methods does not follow the getX() form. For these reasons, some
 * tools that expect JavaBeans might not fully work with records.
 * 
 * One such case is that records can’t be used as JPA (e.g. Hibernate) entities.
 * There’s a discussion about aligning the specification to Java Records on the
 * jpa-dev mailinglist, but so far I did not find news about the state of the
 * development process. It worth to mention however that Records can be used for
 * projections without problems.
 * 
 * Most other tools I’ve checked (including Jackson, Apache Commons Lang, JSON-P
 * and Guava) support records, but since it’s pretty new there are also some
 * rough edges. For example, Jackson, the popular JSON library was an early
 * adopter of records. Most of its features, including serialization and
 * deserialization work equally well for Record Classes and JavaBeans, but some
 * features to manipulate the objects are yet to be adapted.
 * 
 * -----------------------------------------------------------------------------
 * Tip: Use pattern matching to easily access members
 * 
 * Instead of doing all the work manually, consider using Pattern Matching for
 * switch or Pattern Matching for instanceof in combination with Record Patterns
 * to easily access the members of a record.
 * 
 */
public class Records {

	// Standard record
	public record Point(int x, int y) {
	};

	// With explicit, canonical (default) constructor
	public record Point2(int x, int y) {
		public Point2 {
			if (x < 0) {
				throw new IllegalArgumentException("x can't be negative");
			}
			if (y < 0) {
				y = 0;
			}
		}
	}

	// With additional constructor
	public record Point3(int x, int y) {
		public Point3(int x) {
			this(x, 0);
		}
	}

	// With overriden default methods
	public record Point4(int x, int y) {
		@Override
		public int x() {
			return x;
		}
	}

	// With additional methods
	public record Point5(int x, int y) {
		static Point5 zero() {
			return new Point5(0, 0);
		}

		boolean isZero() {
			return x == 0 && y == 0;
		}
	}

	/**
	 * Tip: Use Local Records to model intermediate transformations
	 * 
	 * Complex data transformations require us to model intermediate values. Before
	 * Java 16, a typical solution was to rely on Pair or similar holder classes
	 * from a library, or to define your own (maybe inner static) class to hold this
	 * data.
	 * 
	 * The problem with this is that the former one quite often proves to be
	 * inflexible, and the latter one pollutes the namespace by introducing classes
	 * only used in context of a single method. It’s also possible to define classes
	 * inside a method body, but due to their verbose nature it was rarely a good
	 * fit.
	 * 
	 * Java 16 improves on this, as now it’s also possible to define Local Records
	 * in a method body.
	 * 
	 */

	class Product {
		int basePriceInEur;
		int discountPercentage;
	}

	public void localRecords(List<Product> products) {

		record ProductWithSaving(Product product, double savingInEur) {
		}

		products.stream().map(p -> new ProductWithSaving(p, p.basePriceInEur * p.discountPercentage))
				.sorted((p1, p2) -> Double.compare(p2.savingInEur, p1.savingInEur)).map(ProductWithSaving::product)
				.limit(5).collect(Collectors.toList());

	}

	/**
	 * Just a sneak peak of a JDK 21 feature
	 */
	public void patternMatchingWithRecords() {
		interface Shape {};
		record Point2D(int x, int y) implements Shape {};
		record ColoredPoint(Point2D point, String color) implements Shape {};
		
		Shape point = new ColoredPoint(new Point2D(1,4), "Green");
		
		if(point instanceof ColoredPoint(Point2D(int x, int y), String color)) {
			System.out.println(point);
			System.out.println(x);
			System.out.println(y);
			System.out.println(color);
		}
		
		switch(point) {
			case Point2D(var x, var y) -> System.out.println("Point2D x=" + x + " , y = " + y);
			case ColoredPoint cp -> System.out.println("ColoredPoint");
			default -> throw new IllegalArgumentException("Unexpected value: " + point);
		}
		
	}
	
}
