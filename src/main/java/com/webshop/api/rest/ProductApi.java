package com.webshop.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webshop.api.domain.Product;
import com.webshop.api.dto.ProductDTO;

@RequestMapping(value="/api/v1")
public interface ProductApi {
	
	@PostMapping(value="/product")
	ResponseEntity<Product> create(@RequestBody ProductDTO productDTO);
	
	@GetMapping(value="/products")
	ResponseEntity<List<Product>> getAll();
	
	@PutMapping(value="/product")
	ResponseEntity<Product> update(@RequestBody ProductDTO productDTO);
	
}
