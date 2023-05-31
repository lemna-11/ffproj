package com.example.ffrestaurant.model.repositories;

import com.example.ffrestaurant.model.entities.Order;
import com.example.ffrestaurant.model.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByStatus(OrderStatus status);
}
