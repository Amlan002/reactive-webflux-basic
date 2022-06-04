package com.spring.flux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler {

	public Mono<ServerResponse> getAll(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(Flux.just(new Order(1L, 100.0), new Order(2L, 200.0), new Order(3L, 300.0), new Order(4L, 400.0),
						new Order(5L, 500.0), new Order(6L, 600.0), new Order(7L, 700.0), new Order(8L, 800.0),
						new Order(9L, 900.0), new Order(10L, 1000.0), new Order(11L, 1100.0), new Order(12L, 1200.0),
						new Order(13L, 1300.0), new Order(14L, 1400.0)), Order.class);
	}

	public Mono<ServerResponse> getOne(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(new Order(1L, 100.0)),
				Order.class);
	}
}
