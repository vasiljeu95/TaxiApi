package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.entity.order.Order;
import com.github.vasiljeu95.taxiapi.entity.Status;
import com.github.vasiljeu95.taxiapi.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrderById(Long id) {
        Order result = orderRepository.findById(id).orElse(null);
//        Order result = orderRepository.findOrderById(id);
        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

//    @Override
//    public Order findExecuteOrderById(Long id) {
//        Order order = orderRepository.findExecutionOrderById(id);
//        if (order == null) {
//            log.warn("IN findExecuteOrderById - no user found by id: {}", id);
//            return null;
//        }
//        log.info("IN findExecuteOrderById - user: {} found by id: {}", order, id);
//        return order;
//    }

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
