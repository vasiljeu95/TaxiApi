package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.car.CreateCarDto;
import com.github.vasiljeu95.taxiapi.entity.car.Car;

public interface DriverService {
    Car createCar (CreateCarDto createCarDto);
}
