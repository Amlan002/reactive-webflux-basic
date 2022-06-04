package com.infybuzz.flux;

import com.infybuzz.flux.support.Item;

import reactor.core.publisher.Flux;

public class FlateMapWithFlux {

	public static void main(String[] args) {
		Flux<Long> flux = Flux.just(1L, 2L, 3L);
		Flux<Item> flux2 = flux.flatMap(orderId -> getIt(orderId));
		flux2.subscribe(i -> System.out.println(i.getItemname()));

	}

	public static Flux<Item> getIt(Long oId) {
		return Flux.just(new Item(1L, "Item-1"), new Item(2L, "Item-2"), new Item(3L, "Item-3"));
	}
}
