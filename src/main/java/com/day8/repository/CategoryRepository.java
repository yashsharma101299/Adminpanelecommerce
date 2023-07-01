package com.day8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day8.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
