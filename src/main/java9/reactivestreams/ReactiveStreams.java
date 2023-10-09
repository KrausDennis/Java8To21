package main.java9.reactivestreams;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreams {

	public static void main(String[] args) throws InterruptedException {
		
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
	    EndSubscriber<String> subscriber = new EndSubscriber<>();
	    publisher.subscribe(subscriber);
	    List<String> items = List.of("1", "x", "2", "x", "3", "x");
		
	    items.forEach(publisher::submit);
	    
	    while (items.size() != subscriber.consumedElements.size()) {
            Thread.sleep(10);
        }
	    
	    publisher.close();	    
	}
	
}
