package com.spraedout.SpreadOut.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraedout.SpreadOut.modal.Product;
import com.spraedout.SpreadOut.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	@Override
	public Product save(@Valid Product product) {
		return productRepository.save(product);
	}
	@Override
	public Product getFindById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
		Product p =product.get();
		return p;
		}
		else
			return null;
	}

}
