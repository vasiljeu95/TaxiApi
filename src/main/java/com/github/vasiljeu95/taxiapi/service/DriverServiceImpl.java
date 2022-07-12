package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.car.CreateCarDto;
import com.github.vasiljeu95.taxiapi.entity.car.Car;
import com.github.vasiljeu95.taxiapi.repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DriverServiceImpl
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Service
@Slf4j
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Car createCar(CreateCarDto createCarDto) {
        Car car = new Car();

        car.setUserId(createCarDto.getUserId());
        car.setCarStatusId(2L);
        car.setCarManufacturer(createCarDto.getCarManufacturer());
        car.setCarModel(createCarDto.getCarModel());
        car.setCarColor(createCarDto.getCarColor());
        car.setCarGovernmentNumber(createCarDto.getCarGovernmentNumber());
        car.setCarCoordinates(createCarDto.getCarCoordinates());

        Car registrationCar = driverRepository.save(car);

        log.info("IN info - car: {} successfully create", car);

        return registrationCar;
    }
}
