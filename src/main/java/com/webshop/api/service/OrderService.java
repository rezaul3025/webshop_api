package com.webshop.api.service;

import java.util.Date;
import java.util.List;

import com.webshop.api.domain.Order;
import com.webshop.api.dto.OrderDTO;

public interface OrderService {
	
	Order placeOrder(OrderDTO orderDTO);

	List<Order> findBetwwenThePeriod(Date from, Date to);
}
