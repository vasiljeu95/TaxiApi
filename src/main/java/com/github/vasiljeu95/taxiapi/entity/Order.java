package com.github.vasiljeu95.taxiapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Order
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {
    @Column(name = "car_id")
    public Long carId;
    @Column(name = "waiting_time")
    public Long waitingTime;
    @Column(name = "price")
    public double price;
    @Column(name = "distance")
    public String distance;
    @Column(name = "start_coordinate")
    public String startCoordinate;
    @Column(name = "finish_coordinate")
    public String finishCoordinate;
}
