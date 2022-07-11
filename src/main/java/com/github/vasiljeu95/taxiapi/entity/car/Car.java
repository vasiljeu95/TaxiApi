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
public class Car extends BaseEntity {
    @Column(name = "car_manufacturer")
    private String carManufacturer;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_color")
    private String carColor;
    @Column(name = "car_government_number")
    private String carGovernmentNumber;
//    @Column(name = "car_type")
//    @Enumerated(EnumType.STRING)
//    private CarType carType;

//    TODO - relationship with "users" table (where ROLE_DRIVER) and "cars" - in new table "driver_cars"
//    @ManyToMany(mappedBy = "carList", fetch = FetchType.LAZY)
//    private List<User> userCarList;
}
