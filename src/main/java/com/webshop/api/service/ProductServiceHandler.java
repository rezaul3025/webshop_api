package com.webshop.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.api.data.repository.ProductRepository;
import com.webshop.api.domain.Product;
import com.webshop.api.dto.ProductDTO;

@Service
public class ProductServiceHandler implements  ProductService {

	private final ProductRepository productRepo;
	
	@Autowired
	public ProductServiceHandler(final ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public Product create(ProductDTO productDTO) {
		
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product update(ProductDTO productDTO) {
		
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		
		return productRepo.save(product);
	}

	@Override
	public Product findById(Integer id) {
		return productRepo.findById(id).orElse(null);
	}

}
