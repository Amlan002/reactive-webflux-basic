package com.spring.flux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.flux.entity.Order;
import com.spring.flux.repository.OrderRepository;
import com.spring.flux.request.OrderRequest;
import com.spring.flux.response.OrderResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Mono<Order> getById(Long id) {
		return orderRepository.findById(id);
	}

	public Mono<Order> createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Mono<Void> deleteOrder(Long id) {
		return orderRepository.deleteById(id);
	}

	public OrderResponse mapOrderToOrderResponse(Order order) {
		return new OrderResponse(order.getId(), order.getAmount(), order.getPlacedDate());
	}

	public Order mapOrderRequestToOrder(OrderRequest orderRequest) {
		return new Order(orderRequest.getAmount(), orderRequest.getPlacedDate());
	}

	public Order mapUpdateToOrder(Order order, OrderRequest orderRequest) {
		order.setAmount(orderRequest.getAmount());
		order.setPlacedDate(orderRequest.getPlacedDate());
		return order;
	}
}
