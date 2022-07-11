package com.github.vasiljeu95.taxiapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.Status;
import com.github.vasiljeu95.taxiapi.entity.order.Order;
import lombok.Data;

import java.util.Date;

/**
 * OrderRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderDto {
    private Long id;
    private Long orderTime;
    private double price;
    private double distance;
    private String startCoordinate;
    private String finishCoordinate;
    private String carCoordinate;
    private Long carId;
    private Long executionStatusId;
    private Date created;
    private Date updated;
    private Status status;

    public Order toOrder () {
        Order order = new Order();
        order.setId(id);
        order.setOrderTime(orderTime);
        order.setPrice(price);
        order.setDistance(distance);
        order.setStartCoordinate(startCoordinate);
        order.setFinishCoordinate(finishCoordinate);
        order.setCarCoordinate(carCoordinate);
        order.setCarId(carId);
        order.setExecutionStatusId(executionStatusId);
        order.setCreated(created);
        order.setUpdated(updated);
        order.setStatus(status);

        return order;
    }

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setOrderTime(order.getOrderTime());
        orderDto.setPrice(order.getPrice());
        orderDto.setDistance(order.getDistance());
        orderDto.setStartCoordinate(order.getStartCoordinate());
        orderDto.setFinishCoordinate(order.getFinishCoordinate());
        orderDto.setCarCoordinate(order.getCarCoordinate());
        orderDto.setCarId(order.getCarId());
        orderDto.setExecutionStatusId(order.getExecutionStatusId());
        orderDto.setCreated(order.getCreated());
        orderDto.setUpdated(order.getUpdated());
        orderDto.setStatus(order.getStatus());

        return orderDto;
    }
}
