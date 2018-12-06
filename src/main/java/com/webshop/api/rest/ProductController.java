package com.webshop.api.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.webshop.api.domain.Product;
import com.webshop.api.dto.ProductDTO;
import com.webshop.api.service.ProductService;

@RestController
public class ProductController implements ProductApi{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@Override
	public ResponseEntity<Product> create(@Valid ProductDTO productDTO) {
		logger.info("Creating product ");
		return new ResponseEntity<>(productService.create(productDTO), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Product>> getAll() {

		logger.info("Getting all products ");
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> update(@Valid ProductDTO productDTO) {
		
		logger.info("Updating product ");
		return new ResponseEntity<>(productService.update(productDTO), HttpStatus.OK);
	}
}
