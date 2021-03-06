package com.infybuzz.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.infybuzz.flux.support.Order;

import reactor.core.publisher.Flux;

public class MapWithFlux {

	public static void main(String[] args) {
		System.out.println("Simple map with filter");
		Flux<Order> flux = Flux.just(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0));
		Flux<Long> flux2 = flux.filter(x -> x.getAmount() > 100).map(o -> o.getId());
		flux2.subscribe(System.out::println);

		System.out.println("Simple map with comparision with java 8");

		List<Order> list = Arrays.asList(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0));
		List<Long> list2 = list.stream().filter(z -> z.getAmount() > 100).map(a -> a.getId())
				.collect(Collectors.toList());
		list2.forEach(System.out::println);

	}

}
