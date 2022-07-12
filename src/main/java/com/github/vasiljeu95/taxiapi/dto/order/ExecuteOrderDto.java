package com.github.vasiljeu95.taxiapi.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.order.Order;
import lombok.Data;

/**
 * ExecuteOrderDto
 *
 * @author Stepan Vasilyeu
 * @since 11.07.2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ExecuteOrderDto {
    private Long id;
    private Long executionStatusId;
    private String  carCoordinate;

    public Order toOrder () {
        Order order = new Order();
        order.setId(id);
        order.setExecutionStatusId(executionStatusId);
        order.setCarCoordinate(carCoordinate);

        return order;
    }

    public static ExecuteOrderDto fromOrder(Order order) {
        ExecuteOrderDto executeOrderDto = new ExecuteOrderDto();
        executeOrderDto.setId(order.getId());
        executeOrderDto.setExecutionStatusId(order.getExecutionStatusId());
        executeOrderDto.setCarCoordinate(order.getCarCoordinate());

        return executeOrderDto;
    }
}
