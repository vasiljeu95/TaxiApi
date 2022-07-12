package com.github.vasiljeu95.taxiapi.dto.car;

import lombok.Data;

/**
 * UpdateCarCoordinateDto
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Data
public class UpdateCarCoordinateDto {
    private Long id;
    private String carCoordinates;
}
