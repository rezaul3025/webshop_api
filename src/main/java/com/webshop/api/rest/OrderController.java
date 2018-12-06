package com.webshop.api.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.webshop.api.domain.Order;
import com.webshop.api.dto.OrderDTO;
import com.webshop.api.service.OrderService;

@RestController
public class OrderController implements OrderApi {
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(final OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public ResponseEntity<Order> place(@Valid OrderDTO orderDTO) {
		
		return new ResponseEntity<>(orderService.placeOrder(orderDTO), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Order>> findBetweenThePeriod(String fromStr, String toStr) {
		LocalDateTime fromLocalDateTime = LocalDateTime.parse(fromStr);
		LocalDateTime toLocalDateTime = LocalDateTime.parse(toStr);
		
		Date from = Date.from(fromLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());

		Date to = Date.from(toLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());

		//List<Order> orders = orderService.findBetwwenThePeriod(from, to);
		return new ResponseEntity<>(orderService.findBetwwenThePeriod(from, to), HttpStatus.OK);
	}

}
