package com.infybuzz.flux.scheduler;

import com.infybuzz.flux.support.Order;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ParallelScheduler {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("stated with - " + Thread.currentThread().getName());

		Flux<Order> flux = Flux.just(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0));
		Flux<Long> fLong = flux.publishOn(Schedulers.parallel()).map(o -> {
			System.out.println("map1 with - " + Thread.currentThread().getName());
			return o.getId();
		}).publishOn(Schedulers.parallel()).map(o -> {
			System.out.println("map2 with - " + Thread.currentThread().getName());
			return o * 2;
		});

		fLong.subscribe(o -> System.out.println("sub with - " + Thread.currentThread().getName()));

		Thread.sleep(3000);
	}

}
