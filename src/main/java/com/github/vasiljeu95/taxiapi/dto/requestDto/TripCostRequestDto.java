package com.github.vasiljeu95.taxiapi.dto.requestDto;

import lombok.Data;

/**
 * CarTariffDto
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Data
public class TripCostRequestDto {
    private String startCoordinateLatitude;
    private String startCoordinateLongitude;
    private String finishCoordinateLatitude;
    private String finishCoordinateLongitude;
}
