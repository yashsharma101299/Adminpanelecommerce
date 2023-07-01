package com.day8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day8.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAllById(int id);
}
