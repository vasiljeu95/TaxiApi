package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.car.CreateCarDto;
import com.github.vasiljeu95.taxiapi.dto.car.UpdateCarCoordinateDto;
import com.github.vasiljeu95.taxiapi.dto.car.UpdateCarStatusDto;
import com.github.vasiljeu95.taxiapi.entity.car.Car;

public interface DriverService {
    Car createCar (CreateCarDto createCarDto);
    void updateCarCoordinate (UpdateCarCoordinateDto updateCarCoordinateDto);
    void updateCarStatus (UpdateCarStatusDto updateCarStatusDto);
}
