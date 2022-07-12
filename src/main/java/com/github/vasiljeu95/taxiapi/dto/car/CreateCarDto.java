package com.github.vasiljeu95.taxiapi.dto.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.car.Car;
import lombok.Data;

import javax.persistence.Column;

/**
 * CreateCarDto
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Data
public class CreateCarDto {
    private Long userId;
    private Long carStatusId;
    private String carManufacturer;
    private String carModel;
    private String carColor;
    private String carGovernmentNumber;
    private String carCoordinates;

//    public Car toCar () {
//        Car car = new Car();
//
//        car.setCarManufacturer(carManufacturer);
//        car.setCarModel(carModel);
//        car.setCarColor(carColor);
//        car.setCarGovernmentNumber(carGovernmentNumber);
//        car.setCarCoordinates(carCoordinates);
//
//        return car;
//    }
}
