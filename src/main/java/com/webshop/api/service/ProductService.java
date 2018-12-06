package com.webshop.api.service;

import java.util.List;

import com.webshop.api.domain.Product;
import com.webshop.api.dto.ProductDTO;

public interface ProductService {
	Product create(ProductDTO productDTO);
	
	List<Product> getAll();
	
	Product update(ProductDTO productDTO);
	
	Product findById(Integer id);
}
