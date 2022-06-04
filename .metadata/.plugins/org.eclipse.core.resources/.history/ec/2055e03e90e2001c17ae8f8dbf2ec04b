package com.spring.flux.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

	// dont need generated value in reactive

	@Id
	@Column("id")
	private Long id;
	@Column("amount")
	private Double amount;
	@Column("placedDate")
	private LocalDateTime placedDate;

	public Order(Double amount, LocalDateTime placedDate) {
		this.amount = amount;
		this.placedDate = placedDate;
	}

}
