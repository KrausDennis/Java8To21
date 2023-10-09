package main.java17;

import java.time.Clock;
import java.time.InstantSource;

public class NewInstantSource {

	public static void main(String[] args) {
		InstantSource s = Clock.systemUTC();
		s.instant();
	}
	
}
