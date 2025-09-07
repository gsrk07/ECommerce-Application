package com.sriramcode.EcommerceShoppingApp.orders.service;

import com.sriramcode.EcommerceShoppingApp.orders.dto.OrderDto;
import com.sriramcode.EcommerceShoppingApp.orders.models.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getOrdersByUserId(Long userId);

    OrderDto convertToDto(Order order);
}
