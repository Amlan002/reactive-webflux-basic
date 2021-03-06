package com.infybuzz.flux.scheduler;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class FluxWithSelay {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Started with " + Thread.currentThread().getName());
		Flux<Long> fLong = Flux.just(1L, 2L, 3L).delayElements(Duration.ofSeconds(1));
		fLong.subscribe(x -> System.out.println("Sub with " + Thread.currentThread().getName()));
		Thread.sleep(4000);
	}

}
