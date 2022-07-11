package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.entity.order.Order;

public interface OrderService {
    Order orderRegist (Order order);
    Order findOrderById (Long id);
}
