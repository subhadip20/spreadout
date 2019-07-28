package com.spraedout.SpreadOut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spraedout.SpreadOut.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
