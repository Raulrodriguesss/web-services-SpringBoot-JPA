package com.rauldev.springservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.springservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
