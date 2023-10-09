package main.java9;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Also see: https://www.baeldung.com/java-9-http-client
 */
public class NewHttpClient {

	public static void main(String[] args) throws URISyntaxException {
		List<URI> targets = Arrays.asList(new URI("https://postman-echo.com/get?foo1=bar1"),
				new URI("https://postman-echo.com/get?foo2=bar2"));
		
		HttpClient client = HttpClient.newHttpClient();
		
		List<CompletableFuture<String>> futures = targets.stream()
				.map(target -> client
						.sendAsync(HttpRequest.newBuilder(target).GET().build(), HttpResponse.BodyHandlers.ofString())
						.thenApply(response -> response.body()))
				.collect(Collectors.toList());
		
	}

}
