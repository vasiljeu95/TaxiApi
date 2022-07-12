package com.github.vasiljeu95.taxiapi.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.order.Order;
import lombok.Data;

/**
 * TripCostDto
 *
 * @author Stepan Vasilyeu
 * @since 11.07.2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TripCostDto {
    private Long orderTime;
    private double price;
    private double distance;
    private String startCoordinate;
    private String finishCoordinate;

    public static TripCostDto fromOrder (Order order) {
        TripCostDto tripCostDto = new TripCostDto();
        tripCostDto.setOrderTime(order.getOrderTime());
        tripCostDto.setPrice(order.getPrice());
        tripCostDto.setDistance(order.getDistance());
        tripCostDto.setStartCoordinate(order.getStartCoordinate());
        tripCostDto.setFinishCoordinate(order.getFinishCoordinate());

        return tripCostDto;
    }
}
