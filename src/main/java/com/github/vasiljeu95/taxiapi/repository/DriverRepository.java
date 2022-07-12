package com.github.vasiljeu95.taxiapi.repository;

import com.github.vasiljeu95.taxiapi.entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DriverRepository
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
public interface DriverRepository extends JpaRepository<Car, Long> {

}
