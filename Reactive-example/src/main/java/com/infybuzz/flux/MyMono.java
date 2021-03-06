package com.infybuzz.flux;

import reactor.core.publisher.Mono;

public class MyMono {

	public static void main(String[] args) {
		Mono<String> stringMono1 = Mono.just("Ak");
		System.out.println("Simple mono----------");
		stringMono1.subscribe(System.out::println);
		Mono<String> stringMono2 = Mono.error(new RuntimeException());
		System.out.println("Exception ---------");
		stringMono2.subscribe(System.out::println);
	}

}
