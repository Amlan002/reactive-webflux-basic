package com.spring.flux.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.flux.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	// in browser not in postman bcoz in browser you can understand the thing
	@GetMapping(value = "/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Order> getAll() {
		Flux<Order> flux = Flux.just(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0),
				new Order(4L, 400.0), new Order(5L, 500.0), new Order(6L, 600.0), new Order(7L, 700.0),
				new Order(8L, 800.0), new Order(9L, 900.0), new Order(10L, 1000.0), new Order(11L, 1100.0),
				new Order(12L, 1200.0), new Order(13L, 1300.0), new Order(14L, 1400.0))
				.delayElements(Duration.ofSeconds(1)).log();
		return flux;
	}

	@GetMapping(value = "/getOne", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Order> getOne() {
		Mono<Order> mono = Mono.just(new Order(1L, 100.0)).log();
		return mono;
	}
}
