package com.github.vasiljeu95.taxiapi.dto.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.Status;
import com.github.vasiljeu95.taxiapi.entity.car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * CarTariffDto
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private long id;
    private long userId;
    private long carStatusId;
    private String carManufacturer;
    private String carModel;
    private String carColor;
    private String carGovernmentNumber;
    private String carCoordinates;

    public static CarDto fromCar (Car car) {
        CarDto carDto = new CarDto();

        carDto.setId(car.getId());
        carDto.setUserId(car.getUserId());
        carDto.setCarStatusId(car.getCarStatusId());
        carDto.setCarManufacturer(car.getCarManufacturer());
        carDto.setCarModel(car.getCarModel());
        carDto.setCarColor(car.getCarColor());
        carDto.setCarGovernmentNumber(car.getCarGovernmentNumber());
        carDto.setCarCoordinates(car.getCarCoordinates());

        return carDto;
    }
}
