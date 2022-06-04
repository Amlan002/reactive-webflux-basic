package com.spring.flux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.handler.OrderHandler;

@Component
public class OrderRouter {

	@Autowired
	private OrderHandler orderHandler;

	@Bean
	public RouterFunction<ServerResponse> orderRute() {
		return RouterFunctions.route(RequestPredicates.GET("/api/order/getAll"), orderHandler::getAll)
				.andRoute(RequestPredicates.GET("/api/order/getOne"), orderHandler::getOne);
	}

}
