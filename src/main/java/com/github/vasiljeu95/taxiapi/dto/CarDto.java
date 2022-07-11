package com.github.vasiljeu95.taxiapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.vasiljeu95.taxiapi.entity.car.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CarTariffDto
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private String carManufacturer;
    private String carModel;
    private String carColor;
    private String carGovernmentNumber;
//    private String carType;

    public static CarDto fromCar (Car car) {
        CarDto carTariffDto = new CarDto();
        carTariffDto.setCarManufacturer(car.getCarManufacturer());
        carTariffDto.setCarModel(car.getCarModel());
        carTariffDto.setCarColor(car.getCarColor());
        carTariffDto.setCarGovernmentNumber(car.getCarGovernmentNumber());
//        carTariffDto.setCarType(car.getCarType().toString());

        return carTariffDto;
    }

    public Car toCar () {
        Car car = new Car();
        car.setCarManufacturer(carManufacturer);
        car.setCarModel(carModel);
        car.setCarColor(carColor);
        car.setCarGovernmentNumber(carGovernmentNumber);
//        car.setCarType(CarType.valueOf(carType));

        return car;
    }
}
