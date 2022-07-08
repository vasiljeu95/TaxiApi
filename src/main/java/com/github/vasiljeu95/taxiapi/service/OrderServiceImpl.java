package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.entity.Order;
import com.github.vasiljeu95.taxiapi.entity.Status;
import com.github.vasiljeu95.taxiapi.entity.User;
import com.github.vasiljeu95.taxiapi.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * OrderServiceImpl
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrderById(Long id) {
        Order result = orderRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public Order orderRegist(Order order) {
        Date now = new Date();

        order.setStatus(Status.ACTIVE);
        order.setCreated(now);
        order.setUpdated(now);
        Order orderRegistration = orderRepository.save(order);

        return orderRegistration;
    }
}
