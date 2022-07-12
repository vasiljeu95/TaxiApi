package com.github.vasiljeu95.taxiapi.dto.car;

import lombok.Data;

/**
 * UpdateCarStatusDto
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Data
public class UpdateCarStatusDto {
    private Long id;
    private Long carStatusId;
}
