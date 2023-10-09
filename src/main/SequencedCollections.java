package main;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;

/**
 * Java 21
 * 
 * Sequenced Collections add interfaces to represent encounter order in
 * collections, allowing, for example, LinkedHashSet to serve as a substitute
 * for a List and adding convenience methods like getFirst and reverse
 */
public class SequencedCollections {

	void main() {

		var set = new LinkedHashSet<String>();
		var list = new ArrayList<String>();

		doSomething(set);
		doSomething(list);
	}

	void doSomething(SequencedCollection<String> seq) {
		
		seq.addFirst(null);
		seq.addLast(null);
		seq.getFirst();
		seq.getLast();
		seq.removeFirst();
		seq.removeLast();
		
		seq.reversed();
	}

}
