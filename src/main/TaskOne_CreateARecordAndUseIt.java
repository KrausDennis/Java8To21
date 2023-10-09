package main;

public class TaskOne_CreateARecordAndUseIt {

	public record Rectangle(double a, double b) {
		
		public Rectangle {
			if(a <= 0 || b <= 0) {
				throw new RuntimeException("No negative or zero allowed!");
			}
		}
		
		public Rectangle(double a) {
			this(a,a);
		}
		
		public Rectangle getSquare(double a) {
			return new Rectangle(a,a);
		}
		
		public double getSurface() {
			return this.a * this.b;
		}
	}
	
	
	public static void task() {
		
		Rectangle rect = new Rectangle(2, 3);
		System.out.println(rect);
		System.out.println(rect.getSurface());
		
	}
}
