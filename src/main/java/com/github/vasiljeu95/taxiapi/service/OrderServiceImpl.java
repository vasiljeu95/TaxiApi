package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.TripCostDto;
import com.github.vasiljeu95.taxiapi.dto.requestDto.TripCostRequestDto;
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
//        double pointALatitude = Double.parseDouble(tripCostRequestDto.getStartCoordinateLatitude());
//        double pointALongitude = Double.parseDouble(tripCostRequestDto.getStartCoordinateLongitude());
//        double pointBLatitude = Double.parseDouble(tripCostRequestDto.getFinishCoordinateLatitude());
//        double pointBLongitude = Double.parseDouble(tripCostRequestDto.getFinishCoordinateLongitude());
//
//        double tripDistance = distance(pointALatitude, pointALongitude, pointBLatitude, pointBLongitude);
//        double carSpeed = 40.0;
//        double tariff = 5;
//
//        Order order = new Order();
//        Date now = new Date();
//
//        order.setStatus(Status.ACTIVE);
//        order.setCreated(now);
//        order.setUpdated(now);
//
//        order.setOrderTime((long) (tripDistance / carSpeed * 3600));
//        order.setPrice(tripDistance * tariff);
//        order.setDistance(String.valueOf(tripDistance));
//        order.setStartCoordinate(String.valueOf(pointALatitude) + ", " + String.valueOf(pointALongitude));
//        order.setFinishCoordinate(String.valueOf(pointBLatitude) + ", " + String.valueOf(pointBLongitude));
//
//        // TODO
//        order.setCarCoordinate("unknown");
//        order.setCarId(1L);
//        order.setExecutionStatusId(1L);
//
//        log.info("IN info - trip cost: {} successfully matrix", order);

        return null;
    }

    private double distance (double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        dist = dist * 1.609344;

        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
