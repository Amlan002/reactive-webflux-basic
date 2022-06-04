package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class ArrayToFlux {

	public static void main(String[] args) {
		String[] array = new String[] { "am", "ar", "kh" };
		Flux<String> flux=Flux.fromArray(array);
		flux.subscribe(System.out::println);
	}

}
