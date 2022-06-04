package com.infybuzz.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class StreamToFlux {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("am", "ar", "kh");
		Stream<String> stream = list.stream();
		Flux<String> flux = Flux.fromStream(stream);
		flux.subscribe(System.out::println);
	}

}
