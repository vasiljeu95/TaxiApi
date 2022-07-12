package com.github.vasiljeu95.taxiapi.repository;

import com.github.vasiljeu95.taxiapi.entity.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * DriverRepository
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
public interface DriverRepository extends JpaRepository<Car, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE cars SET car_coordinates = :carCoordinates WHERE id = :id", nativeQuery = true)
    void updateCarCoordinate (@Param("id") Long id, @Param("carCoordinates") String carCoordinates);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cars SET car_status_id = :carStatusId WHERE id = :id", nativeQuery = true)
    void updateCarStatus (@Param("id") Long id, @Param("carStatusId") Long carStatusId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE orders SET execution_status_id = :executionStatusId WHERE id = :id", nativeQuery = true)
    void updateExecutionStatus (@Param("id") Long id, @Param("executionStatusId") Long executionStatusId);
}
