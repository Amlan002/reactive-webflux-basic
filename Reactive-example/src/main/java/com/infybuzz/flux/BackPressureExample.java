package com.infybuzz.flux;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BackPressureExample {

	public static void main(String[] args) {
		Flux<Integer> flux = Flux.range(1, 10).log();
		System.out.println("==========All values=========");
		flux.subscribe(System.out::println, ex -> ex.printStackTrace(), () -> System.out.println("Completed"));

		System.out.println("==========only 5 values=========");
		flux.subscribe(new BaseSubscriber<Integer>() {

			protected void hookOnSubscribe(Subscription subscription) {
				subscription.request(5);

				// print two at a time
				/*
				 * for (int i = 1; i <= 5; i++) { subscription.request(2); }
				 */
			}

			protected void hookOnNext(Integer value) {

				// if you want only 3 values from 5
				if (value == 3) {
					cancel();
				}
				System.out.println("Value " + value);
			}

			// total value is 10 thats why Completed will not be printed, if the
			// hookOnSubscribe's request param is 10 then Completed will be printed
			protected void hookOnComplete() {
				System.out.println("Completed");
			}

			protected void hookOnError(Throwable throwable) {
				throwable.printStackTrace();
			}
		});
	}

}
