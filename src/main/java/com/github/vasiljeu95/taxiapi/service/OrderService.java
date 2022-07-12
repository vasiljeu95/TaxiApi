package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.order.TripCostRequestDto;
import com.github.vasiljeu95.taxiapi.entity.order.Order;

public interface OrderService {
    Order createOrder(TripCostRequestDto tripCostRequestDto);
    Order findOrderById (Long id);

    Order tripCost (TripCostRequestDto tripCostRequestDto);
}
