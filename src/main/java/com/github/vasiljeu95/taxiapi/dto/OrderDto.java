package com.github.vasiljeu95.taxiapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.order.Order;
import lombok.Data;

/**
 * OrderRequestDto
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderDto {
    public Long id;
    public Long carId;
    public Long orderTime;
    public double price;
    public String distance;
    public String startCoordinate;
    public String finishCoordinate;

    public Order toOrder () {
        Order order = new Order();
        order.setId(id);
        order.setCarId(carId);
        order.setOrderTime(orderTime);
        order.setPrice(price);
        order.setDistance(distance);
        order.setStartCoordinate(startCoordinate);
        order.setFinishCoordinate(finishCoordinate);

        return order;
    }

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCarId(order.getCarId());
        orderDto.setOrderTime(order.getOrderTime());
        orderDto.setPrice(order.getPrice());
        orderDto.setDistance(order.getDistance());
        orderDto.setStartCoordinate(order.getStartCoordinate());
        orderDto.setFinishCoordinate(order.getFinishCoordinate());

        return orderDto;
    }
}
