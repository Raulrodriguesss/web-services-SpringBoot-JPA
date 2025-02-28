package com.rauldev.springservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.springservices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
