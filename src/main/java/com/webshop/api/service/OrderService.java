package com.webshop.api.service;

import com.webshop.api.domain.Order;
import com.webshop.api.dto.OrderDTO;

import java.util.Date;
import java.util.List;

public interface OrderService {
	
	Order placeOrder(OrderDTO orderDTO);

	List<Order> findBetwwenThePeriod(Date from, Date to);
}
