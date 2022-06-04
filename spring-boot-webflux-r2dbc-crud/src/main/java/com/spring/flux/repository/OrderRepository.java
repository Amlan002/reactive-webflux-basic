package com.spring.flux.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.spring.flux.entity.Order;

@Repository
public interface OrderRepository extends R2dbcRepository<Order, Long> {

}
