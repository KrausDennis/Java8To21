package main;

/**
 * Java 16 Immutable, final (no inheritance) data containers, implementing the
 * default functionality
 */
public class Records {

	public static void main() {
		standard();
	}

	private static void standard() {
		record ImmutableDto(String content) {
		}

		var dto = new ImmutableDto("Test");
		dto.content();
		dto.hashCode();
		dto.equals(null);
		System.out.println(dto);
	}

	private static void extraFeatures() {
		record Vehicle(String brand, String licensePlate, int count) {

			// Checks
			public Vehicle(String brand, int count) {
				this(brand, null, 5);

				if (count < 5) {
					throw new RuntimeException();
				}

			}

			public Vehicle(String brand) {
				this(brand, null, 5);
			}

			// Other methods possible
			public String brandAsLowerCase() {
				return brand().toLowerCase();
			}

			// Static methods possible
			public static String brandAsUpperCase(Vehicle vehicle) {
				return vehicle.brand.toUpperCase();
			}
		}

	}

}
