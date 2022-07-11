package com.github.vasiljeu95.taxiapi.entity.order;

import com.github.vasiljeu95.taxiapi.entity.BaseEntity;
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
    @Column(name = "order_time")
    public Long orderTime;
    @Column(name = "price")
    public double price;
    @Column(name = "distance")
    public double distance;
    @Column(name = "start_coordinate")
    public String startCoordinate;
    @Column(name = "finish_coordinate")
    public String finishCoordinate;
    @Column(name = "car_coordinates")
    public String carCoordinate;
    @Column(name = "car_id")
    public Long carId;
    @Column(name = "execution_status_id")
    public Long executionStatusId;
}
