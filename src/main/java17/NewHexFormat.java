package main.java17;

import java.util.HexFormat;

public class NewHexFormat {

	public static void main(String[] args) {
		HexFormat.of().toHexDigits(123);
		// ==> "0000007b"
		HexFormat.fromHexDigits("0000007b");
		// ==> 123
	}

}
