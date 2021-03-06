package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FirstFlux {

	public static void main(String[] args) {

		/*
		 * Flux<String> stringFlux1 = Flux.just("Aml", "Arp", "Lax").log();
		 * System.out.println("main array with log");
		 */

		Flux<String> stringFlux1 = Flux.just("Aml", "Arp", "Lax");
		System.out.println("main array");
		stringFlux1.subscribe(System.out::println);

		System.out.println("-----------------------------------");

		// concat values --> always you have to store it in variable
		stringFlux1 = stringFlux1.concatWithValues("Khu", "Wi");
		System.out.println("after adding values using concatWithValues");
		stringFlux1.subscribe(System.out::println);

		System.out.println("-----------------------------------");

		// concat diffreent flux --> always you have to store it in variable
		Flux<String> stringFlux2 = Flux.just("chi", "jap");
		System.out.println("after adding another flux");
		stringFlux2 = stringFlux2.concatWith(stringFlux1);
		stringFlux2.subscribe(System.out::println);

		System.out.println("-----------------------------------");

		// exception handing--> if doesnot throw exception then success** will be printed
		System.out.println("exception handling");
		Flux<String> stringFlux3 = Flux.just("us", "uk").concatWith(Flux.error(new RuntimeException()))
				.concatWithValues("pan");
		stringFlux3.subscribe(System.out::println, e -> System.out.println("Exception*"),
				() -> System.out.println("Success**"));
	}

}
