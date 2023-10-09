package main.java21;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;

public class SequencedCollections {

	public static void main(String[] args) {
		var set = new LinkedHashSet<String>();
		var list = new ArrayList<String>();

		doSomething(set);
		doSomething(list);
	}

	static void doSomething(SequencedCollection<String> seq) {
		// ...
		seq.addFirst(null);
		seq.addLast(null);
		seq.getFirst();
		seq.getLast();
		seq.reversed();
	}
}
