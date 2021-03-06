package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FilterWithFlux {

	public static void main(String[] args) {
		Flux<String> stringFlux = Flux.just("am55", "ary6", "7kh");
		System.out.println("Main data-----");
		stringFlux.subscribe(System.out::println);
		System.out.println("After filter-----contain only a");
		Flux<String> filterStringFlux = Flux.just("am55", "ary6", "7kh").filter(s -> s.contains("a"));
		filterStringFlux.subscribe(System.out::println);
	}

}
