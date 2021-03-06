package com.infybuzz.flux.scheduler;

import com.infybuzz.flux.support.Order;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ImmediateScheduler {

	public static void main(String[] args) {

		System.out.println("stated with - " + Thread.currentThread().getName());

		Flux<Order> flux = Flux.just(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0));
		Flux<Long> fLong = flux.publishOn(Schedulers.immediate()).map(o -> {
			System.out.println("map with - " + Thread.currentThread().getName());
			return o.getId();
		});

		fLong.subscribe(o -> System.out.println("sub with - " + Thread.currentThread().getName()));
	}

}
