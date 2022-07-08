package com.github.vasiljeu95.taxiapi.repository;

import com.github.vasiljeu95.taxiapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 *
 * @author Stepan Vasilyeu
 * @since 08.07.2022
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById (Long id);
}
