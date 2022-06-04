package com.spring.flux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	private Long id;
	private Double amount;
}
