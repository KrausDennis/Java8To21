package main.java9;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Performant way of getting the call stack
 */
public class StackWalkerApi {

	public static void main(String[] args) {
		methodOne();
	}

	public static void methodOne() {
		methodTwo();
	}

	public static void methodTwo() {
		methodThree();
	}

	public static void methodThree() {
		List<StackFrame> stackTrace = StackWalker.getInstance().walk(StackWalkerApi::walkExample);
		System.out.println(stackTrace);
	}

	public static List<StackFrame> walkExample(Stream<StackFrame> stackFrameStream) {
		return stackFrameStream.collect(Collectors.toList());
	}

}
