package main.java14;

import java.time.DayOfWeek;

/**
 * Java 14 Feature: Switch Expressions
 * 
 * 
 * 
 *
 * 
 * A branch is either a single expression or if it consist of multiple
 * statements it has to be wrapped in a block.
 * 
 * Third, cases of a switch expression are exhaustive. This means that for
 * String, primitive types and their wrappers the default case always has to be
 * defined.
 */
public class SwitchExpressions {

	public void m() {

		/**
		 * For switch expressions cases don’t fall-through. So no more subtle bugs
		 * caused by missing breaks. To avoid the need for fall-through, multiple
		 * constants can be specified for each case in a comma separated list.
		 * 
		 * A branch is either a single expression or if it consist of multiple
		 * statements it has to be wrapped in a block.
		 */
		DayOfWeek d = DayOfWeek.FRIDAY;
		int numLetters = switch (d) {
			case MONDAY, FRIDAY, SUNDAY -> 6;
			case TUESDAY -> 7;
			default -> {
				String s = d.toString();
				int result = s.length();
				yield result;
			}
		};

		System.out.println(numLetters);

		/**
		 * Can also be used as an expression
		 */
		int k = 3;
		System.out.println(switch (k) {
			case 1 -> "one";
			case 2 -> "two";
			default -> "many";
		});

		/**
		 * Each case has its own scope.
		 * 
		 * Cases of a switch expression are exhaustive. This means that for String,
		 * primitive types and their wrappers the default case always has to be defined.
		 */
		String s = switch (k) {
			case 1 -> {
				String temp = "one";
				yield temp;
			}
			case 2 -> {
				String temp = "two";
				yield temp;
			}
			default -> "many";
		};

		/**
		 * For enums either a default case has to be present, or all cases have to be
		 * explicitly covered. Relying on the latter is quite nice to ensure that all
		 * values are considered. Adding an extra value to the enum will result in a
		 * compile error for all switch expressions where it’s used.
		 */
		enum Day {
			MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
		}

		Day day = Day.TUESDAY;
		String expression = switch (day) {
			case MONDAY -> ":(";
			case TUESDAY, WEDNESDAY, THURSDAY -> ":|";
			case FRIDAY -> ":)";
			case SATURDAY, SUNDAY -> ":D";
		};
	}

	/**
	 * Switch expression can not only used with the lambda-like arrow-form cases.
	 * The old switch statement with its colon-form cases can also be used as an
	 * expression using yield.
	 * 
	 * This version can also be used as an expression, but it’s more similar to the
	 * old switch statement because
	 * 
	 * cases fall through cases share the same scope My advice? Don’t use this form,
	 * use switch expressions with the arrow syntax instead to get all the benefits.
	 */
	public void fallthrough(String s) {

		int result = switch (s) {
			case "foo":
			case "bar":
				yield 2;
			default:
				yield 3;
		};
	}
}
