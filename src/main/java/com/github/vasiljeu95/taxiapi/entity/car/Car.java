package com.github.vasiljeu95.taxiapi.entity.car;

import com.github.vasiljeu95.taxiapi.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Car
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "car_status_id")
    private Long carStatusId;

    @Column(name = "car_manufacturer")
    private String carManufacturer;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "car_government_number")
    private String carGovernmentNumber;

    @Column(name = "car_coordinates")
    private String carCoordinates;
}
