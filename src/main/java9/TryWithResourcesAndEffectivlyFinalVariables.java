package main.java9;

import java.io.BufferedReader;
import java.io.IOException;

public class TryWithResourcesAndEffectivlyFinalVariables {

	public String preJava7() throws IOException {

		BufferedReader br = new BufferedReader(null);
		try {
			return br.readLine();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	/**
	 * Automatic release of resources after the try block
	 * 
	 * @return
	 * @throws IOException
	 */
	public String java7() throws IOException {
		try (BufferedReader br = new BufferedReader(null)) {
			return br.readLine();
		}
	}

	public void java9() throws IOException {

		// Hard to read and no possibility to instantiate the buffered reader before
		try (BufferedReader br1 = new BufferedReader(null); BufferedReader br2 = new BufferedReader(null)) {
			System.out.println(br1.readLine() + br2.readLine());
		}
		
		// Now resources can be instantiated earlier
		BufferedReader br1 = new BufferedReader(null);
		BufferedReader br2 = new BufferedReader(null);
		try (br1; br2) {
		    System.out.println(br1.readLine() + br2.readLine());
		}

	}

}
