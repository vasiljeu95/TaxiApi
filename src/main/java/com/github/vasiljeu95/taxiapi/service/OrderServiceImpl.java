package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.user.TripCostDto;
import com.github.vasiljeu95.taxiapi.dto.order.TripCostRequestDto;
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
    private final MathService mathService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MathService mathService) {
        this.orderRepository = orderRepository;
        this.mathService = mathService;
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

    @Override
    public Order tripCost(TripCostRequestDto tripCostRequestDto) {
        Order order = new Order();
        TripCostDto tripCostDto = mathService.tripDistance(tripCostRequestDto);

        order.setOrderTime(tripCostDto.getOrderTime());
        order.setPrice(tripCostDto.getPrice());
        order.setDistance(tripCostDto.getDistance());
        order.setStartCoordinate(tripCostDto.getStartCoordinate());
        order.setFinishCoordinate(tripCostDto.getFinishCoordinate());

        log.info("IN info - trip cost: {} successfully matrix", order);

        return order;
    }

    @Override
    public Order createOrder (TripCostRequestDto tripCostRequestDto) {
        Order order = tripCost(tripCostRequestDto);
        Date date = new Date();

        order.setStatus(Status.ACTIVE);
        order.setCreated(date);
        order.setUpdated(date);

        order.setCarCoordinate("unknown");
        order.setCarId(1L);
        order.setExecutionStatusId(1L);

        log.info("IN info - order: {} successfully create", order);

        Order registrationOrder = orderRepository.save(order);

        return registrationOrder;
    }
}
