package com.sriramcode.EcommerceShoppingApp.orders.repository;

import com.sriramcode.EcommerceShoppingApp.orders.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}