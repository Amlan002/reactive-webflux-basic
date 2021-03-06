package com.infybuzz.flux;

import java.util.Optional;

import reactor.core.publisher.Mono;

public class OptionalMono {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("Amlan");
		Mono<String> stringMono = Mono.justOrEmpty(optional);
		System.out.println("optional to mono---------");
		stringMono.subscribe(System.out::println);

		Optional<String> optionalEmpty = Optional.empty();
		Mono<String> stringMonoEmpty = Mono.justOrEmpty(optionalEmpty);
		System.out.println("empty optional to mono---------");
		stringMonoEmpty.subscribe(System.out::println);

		Optional<String> optionalNull = null;
		Mono<String> stringMonoNull = Mono.justOrEmpty(optionalNull);
		System.out.println("null optional to mono---------");
		stringMonoNull.subscribe(System.out::println);

	}

}
