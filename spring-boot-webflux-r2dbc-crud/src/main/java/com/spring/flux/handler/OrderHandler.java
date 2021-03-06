package com.spring.flux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.flux.request.OrderRequest;
import com.spring.flux.response.OrderResponse;
import com.spring.flux.service.OrderService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class OrderHandler {

	@Autowired
	private OrderService orderService;

	public Mono<ServerResponse> getAllOrders(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
				orderService.getAllOrders().map(o -> orderService.mapOrderToOrderResponse(o)), OrderResponse.class);
	}

	// path variable
	public Mono<ServerResponse> getOnePathVariable(ServerRequest request) {
		
		String fHeader=request.headers().firstHeader("first-header");
		String sHeader=request.headers().firstHeader("seconde-header");
		log.info("Request Header--->First Header-"+fHeader+" || Second Header-"+sHeader);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.header("res-header", "dummy value")
				.body(orderService.getById(Long.valueOf(request.pathVariable("orderId")))
						.map(o -> orderService.mapOrderToOrderResponse(o)), OrderResponse.class);
	}

	// query param
	public Mono<ServerResponse> getOneByQueryParam(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(orderService.getById(Long.valueOf(request.queryParam("orderId").get()))
						.map(o -> orderService.mapOrderToOrderResponse(o)), OrderResponse.class);
	}

	public Mono<ServerResponse> createOrder(ServerRequest request) {
		Mono<OrderRequest> mono = request.bodyToMono(OrderRequest.class); // if the coming requet is list then use
																			// bodyToFlux -> Mono<String> mono =
																			// request.bodyToFlux(String.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(mono.map(orderService::mapOrderRequestToOrder).flatMap(o -> orderService.createOrder(o))
						.map(o -> orderService.mapOrderToOrderResponse(o)), OrderResponse.class);
	}

	public Mono<ServerResponse> updateOrder(ServerRequest request) {
		Mono<OrderRequest> mono = request.bodyToMono(OrderRequest.class);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(orderService.getById(Long.valueOf(request.pathVariable("orderId")))
						.flatMap(o -> mono.map(req -> orderService.mapUpdateToOrder(o, req)))
						.flatMap(order -> orderService.createOrder(order))
						.map(o -> orderService.mapOrderToOrderResponse(o)), OrderResponse.class);
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(orderService
				.deleteOrder(Long.valueOf(request.pathVariable("orderId"))).map(o -> "Order has been deleted"),
				String.class);
	}
}
