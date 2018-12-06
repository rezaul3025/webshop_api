package com.webshop.api.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webshop.api.domain.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

}
