package main.java9;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperatorForAnonInnerClasses {

	public void change() {
		List<Integer> numbers = new ArrayList<>();
		
		// Now possible:
		List<Integer> numbers2 = new ArrayList<>() {
		    // ...
		};
		
	}
	
}
