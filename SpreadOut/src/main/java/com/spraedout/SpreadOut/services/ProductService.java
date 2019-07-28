package com.spraedout.SpreadOut.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spraedout.SpreadOut.modal.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product save(@Valid Product product);

	Product  getFindById(Long id);

}
