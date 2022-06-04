package com.spring.flux.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private Long id;
	private Double amount;
	private LocalDateTime placedDate;
}
