package main.java15;

public class TextBlocks {

	/**
	 * Tip: Preserve trailing spaces Trailing spaces
	 * 
	 * In Text Blocks are ignored. This is usually not a problem but in some cases
	 * they do matter, for example in context of unit test when a method result is
	 * compared to a baseline value.
	 * 
	 * If this is the case be mindful about them and if a line ends with whitespace
	 * add \s or \t instead of the last space or tab to the end of the line.
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * Tip: Produce the correct newline characters for Windows
	 * 
	 * Line endings are represented with different control characters on Unix and
	 * Windows. The former one uses a single line feed (\n), while the latter uses
	 * carriage return followed by line feed (\r\n).
	 * 
	 * However, regardless to the operating system you choose to use or how you
	 * encode new lines in the source code, Text Blocks will use a single \n for
	 * each new line, which can lead to compatibility issues.
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * Tip: Pay attention to consistent indentation
	 * 
	 * Text Blocks work well with any kind of indentation: tabs spaces or even the
	 * mix of these two. It’s important though to use consistent indentation for
	 * each line in the block, otherwise the incidental indentation can’t be
	 * removed.
	 * 
	 * Most editors offer autoformatting and automatically add indentation on each
	 * new line when you hit enter. Make sure to use the latest version of these
	 * tools to ensure they play well with Text Blocks, and don’t try to add wrong
	 * indentations.
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * Tip: Interpolate Text Blocks with String Templates
	 * 
	 * Text Blocks do not support interpolation out of the box, but there are a
	 * couple of ways to achieve similar results. An alternative that works with
	 * older Java versions is to use String::formatted or String::format:
	 * 
	 */
	public void textBlock() {

		// Old
		String html = "";
		html += "<html>\n";
		html += "  <body>\n";
		html += "    <p>Hello, world</p>\n";
		html += "  </body>\n";
		html += "</html>\n";

		System.out.println(html);

		// New
		/**
		 * For each line-break in the source code, there will be a \n character in the
		 * result.
		 * 
		 * This can be prevented by ending the line with the \ character, which can be
		 * useful in case of very long lines that you’d like to split into two for
		 * keeping the source code readable.
		 */
		String htmlTextBlock = """
				<html>
				  <body>
				    <p>Hello, world</p>
				  </body>
				</html>
				""";

		System.out.println(htmlTextBlock);

		String sameLineTextBlock = """
					Line 1 \
					Also line 1
				""";

		System.out.println(sameLineTextBlock);

		// Tip: Interpolate Text Blocks with String Templates
		var name = "world";
		var greeting = """
				hello
				%s
				""".formatted(name);
	}

}
