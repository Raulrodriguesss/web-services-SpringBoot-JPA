package com.rauldev.springservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rauldev.springservices.entities.OrderItem;
import com.rauldev.springservices.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemPk>{

}
