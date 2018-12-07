package com.webshop.api.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webshop.api.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(value="SELECT * FROM customer_order WHERE order_date>=:from AND order_date<=:to", nativeQuery = true)
    List<Order> findByOrderDateAfterAndOrderDateBefore(@Param("from") Date from, @Param("to") Date to);
}
