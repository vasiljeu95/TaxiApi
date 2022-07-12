package com.github.vasiljeu95.taxiapi.entity.order;

import com.github.vasiljeu95.taxiapi.entity.BaseEntity;
import com.github.vasiljeu95.taxiapi.entity.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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
    private Long orderTime;
    @Column(name = "price")
    private double price;
    @Column(name = "distance")
    private double distance;
    @Column(name = "start_coordinate")
    private String startCoordinate;
    @Column(name = "finish_coordinate")
    private String finishCoordinate;
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "execution_status_id")
    private Long executionStatusId;
}
