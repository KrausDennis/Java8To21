package main;

import java.util.Arrays;

/**
 * Java 9
 * find the first mismatching element between two arrays
 */
public class ArraysMismatch {

	public static void main(String[] args) {

		int[] int1 = new int[] {1,3,5};
		int[] int2 = new int[] {1,4,5};
		
		int mismatchingIndex = Arrays.mismatch(int1, int2);
		
		System.out.println( "Mismatching index:" + mismatchingIndex);	
	}
	
}
