package com.github.vasiljeu95.taxiapi.entity.car;

import lombok.Data;

import javax.persistence.*;

/**
 * CarStatus
 *
 * @author Stepan Vasilyeu
 * @since 12.07.2022
 */
@Entity
@Table(name = "car_status")
@Data
public class CarStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;
}
