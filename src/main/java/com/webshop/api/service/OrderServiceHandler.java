package com.webshop.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.api.data.repository.OrderRepository;
import com.webshop.api.domain.Order;
import com.webshop.api.domain.OrderLine;
import com.webshop.api.domain.Product;
import com.webshop.api.dto.OrderDTO;
import com.webshop.api.dto.OrderLineDTO;

@Service
public class OrderServiceHandler implements OrderService {

	private final OrderRepository orderRepository;
	
	private final ProductService productService;
	
	@Autowired
	public OrderServiceHandler(final OrderRepository orderRepository, final ProductService productService) {
		this.orderRepository = orderRepository;
		this.productService = productService;
	}
	
	@Override
	public Order placeOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrderDate(orderDTO.getOrderDate());
		order.setCustomerId(orderDTO.getCustomerId());
		order.setCustomerEmail(orderDTO.getCustomerEmail());
		
		List<OrderLine> orderLines = new ArrayList<>();
		
		for(OrderLineDTO orderLineDTO : orderDTO.getOrderLines()) {
			Product product = productService.findById(orderLineDTO.getProductId());
			if(product != null) {
				OrderLine orderLine = new OrderLine();
				orderLine.setOrder(order);
				orderLine.setProduct(product);
				orderLine.setTitle(product.getName());
				orderLine.setPrice(product.getPrice());
				orderLine.setQuantity(orderLineDTO.getQuantity());
				orderLines.add(orderLine);
			}
		}
		
		order.setOrderLines(new HashSet<>(orderLines));
		
		if(!orderLines.isEmpty()) {
			return orderRepository.save(order);
		}
		
		return null;
	}

	@Override
	public List<Order> findBetwwenThePeriod(Date from, Date to) {
		return orderRepository.findByOrderDateAfterAndOrderDateBefore(from, to);
	}

}
