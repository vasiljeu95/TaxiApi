package com.github.vasiljeu95.taxiapi.entity.order;

import lombok.Data;

import javax.persistence.*;

/**
 * ExecutionStatus
 *
 * @author Stepan Vasilyeu
 * @since 11.07.2022
 */
@Entity
@Table(name = "execution_status")
@Data
public class ExecutionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private String status;
}
