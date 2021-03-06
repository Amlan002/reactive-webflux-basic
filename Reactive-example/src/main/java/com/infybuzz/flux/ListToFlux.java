package com.infybuzz.flux;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class ListToFlux {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("am", "ar", "kh");
		Flux<String> stringFlux = Flux.fromIterable(list);
		stringFlux.subscribe(System.out::println);
	}

}
