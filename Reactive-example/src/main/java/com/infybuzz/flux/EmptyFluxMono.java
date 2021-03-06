package com.infybuzz.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmptyFluxMono {

	public static void main(String[] args) {
		Flux<?> emptyFlux = Flux.empty();
		System.out.println("Empty flux-------but with null it will raise exception");
		emptyFlux.subscribe(System.out::println);

		Mono<?> emptyMono = Mono.empty();
		System.out.println("Empty mono-------but with null it will raise exception");
		emptyMono.subscribe(System.out::println);

		Mono<?> emptyMono2 = Mono.justOrEmpty(null);
		System.out.println("Empty mono-------");
		emptyMono2.subscribe(System.out::println);
	}

}
