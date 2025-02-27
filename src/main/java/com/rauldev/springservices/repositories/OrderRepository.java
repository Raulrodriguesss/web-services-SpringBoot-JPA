package com.rauldev.springservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.springservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
