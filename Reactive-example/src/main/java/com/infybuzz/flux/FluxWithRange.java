package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FluxWithRange {

	public static void main(String[] args) {
		Flux<Integer> flux = Flux.range(5, 10);
		flux.subscribe(System.out::println);

	}

}
