package com.webshop.api.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webshop.api.domain.Order;
import com.webshop.api.dto.OrderDTO;

@RequestMapping(value="/api/v1")
public interface OrderApi {
	
	@PostMapping(value="/order")
	ResponseEntity<Order> place(@RequestBody OrderDTO orderDTO);
	
	@GetMapping(value="/orders")
	ResponseEntity<List<Order>> findBetweenThePeriod(@RequestParam("from") String from,
			@RequestParam("to") String to);
}
