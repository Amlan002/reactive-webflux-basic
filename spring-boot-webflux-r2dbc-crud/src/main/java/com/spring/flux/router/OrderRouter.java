package com.spring.flux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.handler.OrderHandler;

@Configuration
public class OrderRouter {
	@Autowired
	private OrderHandler orderHandler;

	@Bean
	public RouterFunction<ServerResponse> orderRute() {
		return RouterFunctions.route(RequestPredicates.GET("/api/order/getAll"), orderHandler::getAllOrders)
				.andRoute(RequestPredicates.GET("/api/order/getOnePathVariable/{orderId}"),
						orderHandler::getOnePathVariable)
				.andRoute(RequestPredicates.GET("/api/order/getOneByQueryParam"), orderHandler::getOneByQueryParam)
				.andRoute(RequestPredicates.POST("/api/order/create")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), orderHandler::createOrder)
				.andRoute(RequestPredicates.PUT("/api/order/update/{orderId}")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), orderHandler::updateOrder)
				.andRoute(RequestPredicates.DELETE("/api/order/delete/{orderId}"),
						orderHandler::delete);
	}
}
