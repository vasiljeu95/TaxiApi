package com.github.vasiljeu95.taxiapi.controller;

import com.github.vasiljeu95.taxiapi.dto.car.CarDto;
import com.github.vasiljeu95.taxiapi.dto.car.CreateCarDto;
import com.github.vasiljeu95.taxiapi.dto.car.UpdateCarCoordinateDto;
import com.github.vasiljeu95.taxiapi.dto.car.UpdateStatusDto;
import com.github.vasiljeu95.taxiapi.entity.car.Car;
import com.github.vasiljeu95.taxiapi.service.DriverServiceImpl;
import com.github.vasiljeu95.taxiapi.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DriverRestController
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Controller
@RequestMapping(value = "/api/drivers/")
public class DriverRestController {
    private final OrderServiceImpl orderService;
    private final DriverServiceImpl driverService;

    @Autowired
    public DriverRestController(OrderServiceImpl orderService, DriverServiceImpl driverService) {
        this.orderService = orderService;
        this.driverService = driverService;
    }

    @PostMapping("createCar")
    public ResponseEntity createCar (@RequestBody CreateCarDto createCarDto) {
        Car car = driverService.createCar(createCarDto);

        return new ResponseEntity<>(CarDto.fromCar(car), HttpStatus.CREATED);
    }

    @PostMapping("updateCarCoordinate")
    public ResponseEntity updateCarCoordinate (@RequestBody UpdateCarCoordinateDto updateCarCoordinateDto) {
        driverService.updateCarCoordinate(updateCarCoordinateDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("updateCarStatus")
    public ResponseEntity updateCarStatus (@RequestBody UpdateStatusDto updateStatusDto) {
        driverService.updateCarStatus(updateStatusDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("updateExecutionStatus")
    public ResponseEntity updateExecutionStatus (@RequestBody UpdateStatusDto updateStatusDto) {
        driverService.updateExecutionStatus(updateStatusDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
